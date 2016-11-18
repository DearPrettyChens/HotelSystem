package businesslogic.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.availableroombl.HotelInfoAvailService;
import businesslogic.bl.hotelstrategybl.HotelStrategy;
import businesslogic.bl.orderbl.HotelInfoOrderService;
import businesslogic.bl.orderbl.Order;
import businesslogic.bl.orderbl.SingleOrder;
import dao.hoteldao.HotelDao;
import init.RMIHelper;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.City;
import util.ResultMessage;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderInfoVO;

/**
 * Hotel模块的领域类
 * @author csy
 * @version 1.0
 */
public class Hotel implements HotelInfoAvailService,HotelInfoOrderService{
	private HotelDao hotelDao;//数据层的应用
	private String hotelName;// 酒店名称
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
	private ArrayList<String> remarkDetailInfo;//评论
	private AvailableRoom availableRoom;//酒店可用客房信息
	private HotelStrategy hotelStrategy;//酒店策略信息
	private SingleOrder singleOrder;
	
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
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给顾客看
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID){
		//TODO
		//调用Availableroom.getAvailableRoomInfo获得酒店可用客房信息
		availableRoom=new AvailableRoom();
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo(hotelID);
		//调用HotelStrategy.getHotelStrategy获得酒店优惠策略
		//hotelStrategy.getHotelStrategy(hotelID, hotelStrategyInterface);
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
		//TODO
		//调用Order.getOrderList获得该酒店的订单列表信息
		return null;
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
	public ResultMessage addRemarkInfo(String hotelID, int remarkNumber, String remarkInfo) {
		try {
			//TODO
			//少orderid,customerid参数
			hotelDao.addRemarkInfo(new RemarkPO(idToInt(hotelID),null,0,(double)remarkNumber,remarkInfo));
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
			hotelDao.setBestPrice(new HotelBestPricePO(idToInt(hotelID),price));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		String temp="";
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				temp=temp+id.charAt(i);
			}
		}
		return Integer.parseInt(temp);
	}
	/**
	 * id to string
	 */
	private static String idToString(int id){
		String result=String.valueOf(id);
		while(result.length()<6){
			result="0"+result;
		}
		return result;
	}

}
