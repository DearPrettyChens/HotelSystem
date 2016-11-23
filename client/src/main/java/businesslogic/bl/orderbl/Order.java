package businesslogic.bl.orderbl;

import java.util.Date;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.creditbl.Credit;
import businesslogic.bl.hotelbl.Hotel;
import businesslogic.bl.hotelstrategybl.HotelStrategy;
import businesslogic.bl.personnelbl.Personnel;
import businesslogic.bl.webstrategybl.WebStrategy;
import util.ResultMessage;
import util.Telephone;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderProvidedVO;
import vo.ordervo.StrategyVO;
import vo.personnelvo.PersonDetailVO;
/**
 * Order模块的领域类
 * @author CLL
 * @version 1.0
 */
public class Order {
	private Credit credit;
	private Personnel person;
	private AvailableRoom availableRoom;
	private WebStrategy webStrategy;
	private HotelStrategy hotelStrategy;
	private HotelInfoOrderService hotelInfoOrderService;//解决循环依赖
	
	public Order(){
		
	}
	public Order(Hotel hotel){
		this.hotelInfoOrderService=hotel;
	}

	/**
	 * 检测是否有大于0的信用值可生成订单
	 * @param CustomerID String型，传递顾客编号
	 * @return ResultMessage，如果信用值大于0返回SUCCESS,否则返回LACKOFCREDIT
	 *
	 */
	public ResultMessage checkUserCredit(String customerID){
		//调credit.getCreditInfoList获得顾客信用信息
		//person=new Customer();
		//PersonDetailVO detail=person.getDetail(orderInfo.getCustomerID());
		credit=new Credit(customerID);
		int creditNum=credit.getUserCreditInfoList().getCredit();
		if(creditNum>=0){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.LACKOFCREDIT;
		
	}
	
	/**
	 * 检查输入的入住日期的格式
	 * @param time Date型，传递入住日期
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回daoFORMATERROR,
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTime(Date time){
		//日期在今天或今天之后
		if(time.after(new Date())||time.equals(new Date())){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.daoFORMATERROR;
		
	}
	
	/**
     * 检查联系方式格式 委托给telephone
     * @param tel
     * @return ResultMessage
     */
  	public ResultMessage checkTel(Telephone tel) {
		return tel.checkValid();
	}
	
	
	/**
	 * 产生优惠信息
	 * @param orderInfoVO OrderInfoVO型，界面传递过来的订单信息
	 * @return 返回策略信息和优惠价格
	 * @throws 未定
	 *
	 */
	public StrategyVO next(OrderInfoVO orderInfoVO){
//调用WebStrategy.getWebBestStrategy获得最大折扣的网站优惠策略和HotelStrategy.getBestHotelStrategy获得最大折扣的酒店优惠策略
		String customerID=orderInfoVO.getCustomerID();
		//调person.getDetail获得顾客信息
		person=Personnel.getInstance();
		PersonDetailVO detail=person.getPersonDetail(customerID);
		int credit=detail.getCredit();
		String hotelID=orderInfoVO.getHotelID();
		HotelDetailInfoVO hotelDetail=hotelInfoOrderService.getHotelDetailInfo(hotelID, customerID);
		TradingArea area=hotelDetail.getArea();
		webStrategy=new WebStrategy();
//		WebBestStrVO webStrVO=webStrategy.getWebBestStrategy(String.valueOf(credit), area, new Date());
		hotelStrategy=new HotelStrategy();
		OrderProvidedVO orderProvidedVO=new OrderProvidedVO(customerID,orderInfoVO.getAmount(),detail.getEnterpriseName());
		HotelBestStrVO hotelStrVO=hotelStrategy.getBestHotelStrategy(orderProvidedVO);
		
//调用Availableroom.getRoomPrice	获得酒店房间价格
		availableRoom=new AvailableRoom();
		double price=availableRoom.getRoomPrice(hotelID, orderInfoVO.getBedType());
		
		return new StrategyVO(webStrVO,hotelStrVO,price);
	}
	
	/**
	 * 新增订单信息
	 * @param 
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO){
		//调用SingleOrder.addOrder向数据库中新增订单
		return new SingleOrder().addOrder(orderInfoVO);
		
	}
	
	/**
	 * 生成订单的界面上需要酒店的信息（可用客房+酒店地址电话）
	 * @param hotelID string 型，界面传递过来的酒店编号
	 * @return HotelDetailInfoVO，返回酒店详细信息
	 * @throws 未定
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID){
		//调用HotelInfoOrderService里面的方法getHotelDetailInfo
		return hotelInfoOrderService.getHotelDetailInfo(hotelID, null);
		
	}
	
	/**
	 * 检查订单上可用客房是否数量足够
	 * @param vo AvailableRoomNumberVO型，传递可用客房数量信息
	 * @return ResultMessage，数量足够返回SUCCESS,数量不够返回NOTENOUGHAVAILABLEROOM,
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber (AvailableRoomNumberVO vo){
		//调用Availableroom.checkAvailableRoomNumber检查可用房间数
		availableRoom=new AvailableRoom();
		return availableRoom.checkAvailableRoomNumber(vo);
	}
	
	
	
	
}
