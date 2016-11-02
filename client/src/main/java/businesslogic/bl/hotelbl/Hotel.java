package businesslogic.bl.hotelbl;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.availableroombl.HotelInfoAvailService;
import businesslogic.bl.orderbl.HotelInfoOrderService;
import dao.hoteldao.HotelDao;
import util.City;
import util.ResultMessage;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;

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
	private ImageIcon hotelImage;// 酒店图片
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
	
	//构造方法
	public Hotel() {
		
	} 
	
	/**
	 * 获取酒店基本信息
	 * @param hotelID String型，传递酒店编号
	 * @return HotelBasicInfoVO ，将酒店基本信息返回给酒店工作人员看
	 *
	 */
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID){
		return null;
		
	}
	
	/**
	 * 获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给顾客看
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID){
		return null;
		//调用Availableroom.getAvailableRoomInfo获得酒店可用客房信息
	    //调用HotelStrategy.getHotelStrategy获得酒店优惠策略
	    //调用User.getUserID获得当前用户信息来调用订单？有疑惑？
	}
	
	
	/**
	 * 确认维护的酒店信息
	 * @param hotelBasicInfoVO HotelBasicInfoVO型，传递酒店基本信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 *
	 */
	public ResultMessage confirmModifyInfo(HotelBasicInfoVO hotelInfovo){
		return null;
		
	}
	
	/**
	 * 获取酒店的订单列表
	 * @param hotelID String型，传递酒店编号
	 * @return ArrayList<HotelOrderVO>，返回酒店的订单列表
	 *
	 */
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID){
		return null;	
		//调用Order.getOrderList获得该酒店的订单列表信息
	}
	
	/**
	 * 获取酒店的订单详细信息
	 * @param orderID String型，传递订单编号
	 * @return HotelOrderInfoVO，返回酒店的订单详细信息
	 *
	 */
	public HotelOrderInfoVO getHotelOrderInfo(String orderID){
		return null;
		//调用Order.getOrderInfo获得该酒店某一订单的详细信息
	}

	@Override
	public ResultMessage addRemarkInfo(String hotelID, int remarkNumber, String remarkInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		//调用Availableroom.getAvailableRoomInfo获得酒店可用客房信息
		return null;
	}

	@Override
	public ResultMessage setBestPrice(int price, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
