package businesslogic.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.availableroombl.HotelInfoAvailService;
import businesslogic.bl.hotelstrategybl.HotelAmountStrategy;
import businesslogic.bl.hotelstrategybl.HotelBirthStrategy;
import businesslogic.bl.hotelstrategybl.HotelEnterpriseStrategy;
import businesslogic.bl.hotelstrategybl.HotelSpecialTimeStrategy;
import businesslogic.bl.hotelstrategybl.HotelStrategy;
import businesslogic.bl.orderbl.HotelInfoOrderService;
import businesslogic.bl.orderbl.Order;
import businesslogic.bl.orderbl.OrderList;
import businesslogic.bl.orderbl.SingleOrder;
import dao.hoteldao.HotelDao;
import init.RMIHelper;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.OrderListPO;
import po.RemarkPO;
import util.City;
import util.ResultMessage;
import util.TradingArea;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.RemarkVO;

/**
 * Hotel模块的领域类
 * @author csy
 * @version 1.0
 */
public class Hotel implements HotelInfoAvailService,HotelInfoOrderService{
/*	private String hotelName;// 酒店名称
	private String hotelID;//酒店编号
	private String address;// 酒店地址
	private City city;//城市
	private TradingArea tradingArea;//商圈
	private ImageIcon hotelImage;//酒店图片
	private String telephone;// 联系方式
	private int star;// 星级
	private String introduce;// 酒店简介
	private String commonFacility;// 通用设施
	private String activityFacility;// 活动设施
	private String service;// 服务项目
	private String roomFacility;// 客房设施	
	private String enterprises;// 合作企业
	private double bestPrice;//最低价格
	private int remarkOrderNumber;//评价过的订单总数
	private double remarkNumber;//评分
	private ArrayList<String> remarkDetailInfo;//评论*/
	private HotelDao hotelDao;//数据层的应用
	private AvailableRoom availableRoom;//酒店可用客房信息
	private HotelStrategy hotelStrategy;//酒店策略信息
	private SingleOrder singleOrder;
	private OrderList orderList;
	
	//构造方法
	public Hotel() {
		hotelDao=RMIHelper.getHotelDao();
	}
	
	/**
	 * 获取酒店基本信息
	 * @param hotelID String型，传递酒店编号
	 * @return HotelBasicInfoVO ，将酒店基本信息返回给酒店工作人员看
	 *
	 */
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID){
		try {
			return new HotelBasicInfoVO(hotelDao.getHotelBasicInfo(hotelID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号？
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给顾客看
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID){
		//调用Availableroom.getAvailableRoomInfo获得酒店可用客房信息
		availableRoom=new AvailableRoom();
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo(hotelID);
		//调用HotelStrategy.getHotelStrategy获得酒店优惠策略
		ArrayList<HotelStrVO> hotelStrs=new ArrayList<HotelStrVO>();
		hotelStrs.add(hotelStrategy.getHotelStrategy(hotelID, new HotelAmountStrategy()));
		hotelStrs.add(hotelStrategy.getHotelStrategy(hotelID, new HotelBirthStrategy()));
		hotelStrs.add(hotelStrategy.getHotelStrategy(hotelID, new HotelEnterpriseStrategy()));
		hotelStrs.add(hotelStrategy.getHotelStrategy(hotelID, new HotelSpecialTimeStrategy()));
		//调用hotel.getHotelOrderList获得酒店订单列表
		ArrayList<HotelOrderVO> orders=this.getHotelOrderList(hotelID);
		//调用数据层获得酒店基本信息
		HotelBasicInfoPO basic;
		try {
			basic = hotelDao.getHotelBasicInfo(hotelID);
			//获得酒店评价信息
			ArrayList<RemarkPO> remarks=basic.getRemarks();
			ArrayList<String> remarkDetails=new ArrayList<String>();
			for(int i=0;i<remarks.size();i++){
				remarkDetails.add(remarks.get(i).getRemark());
			}
			//综合酒店细节信息
			HotelDetailInfoVO detail=new HotelDetailInfoVO(TransHelper.idToString(basic.getHotelID(),6),
					basic.getAddress(),basic.getHotelImage(),basic.getTradingArea(),
					basic.getTelephone(),basic.getStar(),basic.getIntroduce(),basic.getCommonFacility()
					,basic.getActivityFacility(),basic.getService(),basic.getRoomFacility(),basic.getEnterprises(),
					hotelStrs,roomInfo,orders,basic.getScore(),remarkDetails);
			return detail;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;

	    
	    //调用User.getUserID获得当前用户信息来调用订单？有疑惑？
	}
	
	
	/**
	 * 确认维护的酒店信息
	 * @param hotelBasicInfoVO HotelBasicInfoVO型，传递酒店基本信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 *
	 */
	public ResultMessage confirmModifyInfo(HotelBasicInfoVO hotelInfovo){
		try {
			hotelDao.setHotelBasicInfo(hotelInfovo.votopo());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
		
	}
	
	/**
	 * 获取酒店的订单列表
	 * @param hotelID String型，传递酒店编号
	 * @return ArrayList<HotelOrderVO>，返回酒店的订单列表
	 *
	 */
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID){
		//调用Order.getOrderList获得该酒店的订单列表信息
		orderList=new OrderList();
		ArrayList<OrderListVO> orders=orderList.getOrderList(hotelID);
		ArrayList<HotelOrderVO> hotelOrders=new ArrayList<HotelOrderVO>();
		for(int i=0;i<orders.size();i++){
			OrderListVO hotelOrder=orders.get(i);
			hotelOrders.add(new HotelOrderVO(hotelOrder.getOrderNumber(),hotelOrder.getCustomerName(),
					hotelOrder.getReserveTime(),hotelOrder.getState()));
		}
		return hotelOrders;
	}
	
	/**
	 * 获取酒店的订单详细信息
	 * @param orderID String型，传递订单编号
	 * @return HotelOrderInfoVO，返回酒店的订单详细信息
	 *
	 */
	public HotelOrderInfoVO getHotelOrderInfo(String orderID){
		//调用Order.getOrderInfo获得该酒店某一订单的详细信息
		//解决循环依赖
		singleOrder=new SingleOrder(this);
		OrderInfoVO vo=singleOrder.getOrderInfo(orderID);
		return new HotelOrderInfoVO(vo.getOrderID(),vo.getCustomerName(),vo.getPrice(),
				vo.getLiveinPersonName(),vo.getLiveinPersonTelephone(),vo.getExpectedCheckInTime()
				,vo.getExpectedCheckOutTime(),vo.getRoomType(),vo.getAmount(),vo.getNumberOfPeople()
				,vo.getHasChild(),vo.getActualCheckInTime(),vo.getActualCheckOutTime(),
				vo.getOrderTime(),vo.getState(),vo.getHotelName(),vo.getHotelTelephone(),
				vo.getLateCheckInTime());
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkVO vo) {
		try {
			//增加一条评价信息
			hotelDao.addRemarkInfo(new RemarkPO(TransHelper.idToInt(vo.getHotelId()),vo.getOrderId(),
					TransHelper.idToInt(vo.getCustomerID()),vo.getRemarkGrade(),vo.getRemarkInfo()));
			//增加酒店的评价过的订单总数是在数据层进行处理吗？
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) {
		//调用Availableroom.getAvailableRoomInfo获得酒店可用客房信息
		availableRoom=new AvailableRoom();
		return availableRoom.getAvailableRoomInfo(hotelID);
	}

	@Override
	public ResultMessage setBestPrice(int price, String hotelID) {
		try {
			hotelDao.setBestPrice(new HotelBestPricePO(TransHelper.idToInt(hotelID),price));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}


}
