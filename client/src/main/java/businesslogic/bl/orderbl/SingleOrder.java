package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.creditbl.Credit;
import businesslogic.bl.hotelbl.Hotel;
import dao.orderdao.OrderDao;
import exception.NullCustomerIDException;
import exception.NullOrderIDException;
import init.RMIHelper;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderStatePO;
import po.RemarkPO;
import util.OrderState;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.RemarkVO;

/**
 * Order模块的领域类
 * 
 * @author CLL
 * @version 1.0
 */
public class SingleOrder {

	OrderDao orderDao;
	private HotelInfoOrderService hotelInfoOrderService;// 解决循环依赖
	private Credit credit;
	private AvailableRoom availableRoom;

	public SingleOrder() {
		RMIHelper.init();
		orderDao = RMIHelper.getOrderDao();
		// orderDao=new OrderDao_Stub();
	}

	public SingleOrder(Hotel hotel) {
		RMIHelper.init();
		orderDao = RMIHelper.getOrderDao();
		// orderDao=new OrderDao_Stub();
		this.hotelInfoOrderService = hotel;
	}

	/**
	 * 获取订单详细信息
	 * 
	 * @param orderID
	 *            String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws NullOrderIDException
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		try {
			OrderInfoPO po = orderDao.getOrderInfo(orderID);
			if (po != null) {
				return new OrderInfoVO(po);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 添加订单
	 * 
	 * @param vo
	 *            OrderInfoVO型，用来传递新增订单信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws NullOrderIDException,NullCustomerIDException
	 */
	public ResultMessage addOrder(OrderInfoVO orderInfoVO) throws NullOrderIDException, NullCustomerIDException {
		if (orderInfoVO.getCustomerID() == null) {
			throw new NullCustomerIDException();
		}
		try {
			// 顾客下订单时订单信息的po
			Date orderTime = new Date();
			orderInfoVO.setOrderTime(orderTime);
			// 设置最晚入住时间为当天的18点
			orderInfoVO.setLateCheckInTime(new Date(orderInfoVO.getExpectedCheckInTime().getYear(),
					orderInfoVO.getExpectedCheckInTime().getMonth(), orderInfoVO.getExpectedCheckInTime().getDate(), 18,
					0, 0));
			String orderID = "";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			orderID = simpleDateFormat.format(orderTime);
			orderID = orderID + orderInfoVO.getHotelID().substring(2) + orderInfoVO.getCustomerID();
			orderInfoVO.setOrderID(orderID);
			orderDao.addOrder(orderInfoVO.toMakeOrderPO());
			// 获得当前可用房间数
			int preRoomNum = 0;
			availableRoom = new AvailableRoom();
			ArrayList<AvailableRoomInfoVO> roomInfo = availableRoom.getAvailableRoomInfo(orderInfoVO.getHotelID());
			for (int i = 0; i < roomInfo.size(); i++) {
				if (orderInfoVO.getBedType() == roomInfo.get(i).getBedType()) {
					preRoomNum = roomInfo.get(i).getCurrentNumber();
				}
			}
			int nowNumber = preRoomNum - orderInfoVO.getAmount();
			// 调用Availableroom.setAvailableRoomNumber更新可用房间数
			availableRoom.setAvailableRoomNumber(new AvailableRoomNumberVO(nowNumber, orderInfoVO.getBedType(),
					orderInfoVO.getExpectedCheckInTime(), orderInfoVO.getHotelID()));
			// 调用SingleOrder.addOrderState 更新订单状态
			return this.addOrderState(OrderState.NOTEXECUTED, orderInfoVO.getOrderID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 添加订单状态
	 * 
	 * @param orderstate
	 *            OrderState型，用来传递订单状态
	 * @return ResultMessage，如果添加成功返回SUCCESS,否则返回FAIL
	 * @throws NullOrderIDException
	 */
	public ResultMessage addOrderState(OrderState orderState, String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		try {
			orderDao.addOrderState(new OrderStatePO(orderID, orderState));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;

	}

	/**
	 * 异常订单撤销，返还相应的信用值
	 * 
	 * @param orderID
	 *            String型，界面传递过来的订单号 CreditNum String型
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws NullOrderIDException
	 *
	 */
	public ResultMessage setReturnCredit(String orderID, int creditNum) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		try {
			OrderInfoPO orderInfo = orderDao.getOrderInfo(orderID);
			String customerID = orderInfo.getCustomerID();
			credit = new Credit(customerID);
			CreditInfoVO creditInfo = credit.getUserCreditInfoList();
			int preCredit = creditInfo.getCredit();
			// 增加订单状态
			this.addOrderState(OrderState.HASCANCELED, orderID);
			// 调用Credit.addCredit异常订单撤销时，恢复顾客的信用值
			return credit.addCredit(
					new CreditVO(orderInfo.getCustomerName(), customerID, preCredit, creditNum, "异常订单撤销", new Date()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 未执行订单撤销，扣除相应的信用值(与最晚执行时间距离6小时之内扣除一半）
	 * 
	 * @param orderID
	 *            String型，界面传递过来的订单号 CreditNum String型
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws NullOrderIDException
	 *
	 */
	public ResultMessage cancelOrderConfirm(String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		OrderInfoPO orderInfo;
		try {
			orderInfo = orderDao.getOrderInfo(orderID);
			String customerID = orderInfo.getCustomerID();
			credit = new Credit(customerID);
			CreditInfoVO creditInfo = credit.getUserCreditInfoList();
			int preCredit = 0;
			// 在没有信用记录的情况下，信用值为0
			if (creditInfo != null) {
				preCredit = creditInfo.getCredit();
			}
			// 调用Credit.cutCredit扣除顾客信用值
			double hourGap = 0.0;
			Date latestCheckTime = orderInfo.getLateCheckInTime();
			Date cancelTime = new Date();
			hourGap = latestCheckTime.getTime() / (60 * 60 * 1000) - cancelTime.getTime() / (60 * 60 * 1000);
			if (hourGap < 6) {
				credit.cutCredit(new CreditVO(orderInfo.getCustomerName(), customerID, preCredit,
						(int) orderInfo.getPrice() / 2, "撤销时间与最晚执行时间距离不足6小时", cancelTime));
			}
			// 增加订单状态
			return this.addOrderState(OrderState.HASCANCELED, orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 保存订单实际入住时间
	 * 
	 * @param time
	 *            Date型，orderID string型，界面传递过来的实际入住时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws NullOrderIDException
	 *
	 */

	public ResultMessage setCheckinTime(Date time, String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}

		try {
			// orderDao更新订单的checkin时间
			CheckTimePO checkTime = new CheckTimePO(orderID, time, "checkin");
			orderDao.setCheckintime(checkTime);

			OrderInfoPO orderInfo = orderDao.getOrderInfo(orderID);
			// 调credit.getCreditInfoList获得顾客信用信息
			credit = new Credit(orderInfo.getCustomerID());
			int creditNum = credit.getUserCreditInfoList().getCredit();
			// 增加订单状态
			this.addOrderState(OrderState.NOTREMARKED, orderID);
			// 调用Credit.addCredit为顾客增加信用值
			return credit.addCredit(new CreditVO(orderInfo.getCustomerName(), orderInfo.getCustomerID(), creditNum,
					(int) orderInfo.getPrice(), "订单正常执行", new Date()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	/**
	 * 保存订单实际退房时间
	 * 
	 * @param time
	 *            Date型，orderID string型界面传递过来的实际退房时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws NullOrderIDException
	 *
	 */
	public ResultMessage setCheckoutTime(Date time, String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}

		try {
			CheckTimePO checkTime = new CheckTimePO(orderID, time, "checkout");
			return orderDao.setCheckouttime(checkTime);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;

	}

	/**
	 * 评价酒店
	 * 
	 * @param remarkVO
	 *            RemarkVO型，界面传递过来的评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws NullOrderIDException
	 *
	 */
	public ResultMessage remarkOrder(RemarkVO vo) throws NullOrderIDException {
		if (vo.getOrderId() == null) {
			throw new NullOrderIDException();
		}
		// 增加订单状态
		this.addOrderState(OrderState.HASREMARKED, vo.getOrderId());
		// 调用HotelInfoOrderService里面的addRemarkInfo方法
		try {
			orderDao.setOrderRemark(new RemarkPO(vo.getHotelId(), vo.getOrderId(), vo.getCustomerID(),
					vo.getRemarkGrade(), vo.getRemarkInfo()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoOrderService.addRemarkInfo(vo);

	}
}
