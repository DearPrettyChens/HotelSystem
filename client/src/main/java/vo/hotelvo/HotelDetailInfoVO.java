package vo.hotelvo;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderListVO;
/**
 * 酒店详细信息vo 给顾客看的
 * @author CYF
 * @version 1.0
 */
public class HotelDetailInfoVO {
	// 酒店id
		private String hotelID;
	// 酒店名称
	private String hotelName;
	// 酒店地址
	private String address;
	//酒店图片
	private ImageIcon hotelImage;
	//商圈
	private TradingArea area;
	// 联系方式
	private String telephone;
	// 星级
	private int star;
	// 酒店简介
	private String introduce;
	// 通用设施
	private String commonFacility;
	// 活动设施
	private String activityFacility;
	// 服务项目
	private String service;
	// 客房设施
	private String roomFacility;
	// 合作企业
	private String enterprises;
	// 酒店策略
	private HotelStrVO hotelStrVO;
	// 可用房间信息
	private AvailableRoomInfoVO availableRoomInfoVO;
	//评分
	private double remarkNumber;
	//评论
	private ArrayList<String> remarkDetailInfo;
	// 订单记录
	private OrderListVO[] orderRecordVO;

	//空方法
	public HotelDetailInfoVO(){
		
	}
	//酒店细节信息 都可以看到
	public HotelDetailInfoVO(String hotelName, String address, ImageIcon hotelImage,TradingArea area,String telephone, int star, String introduce,
			String commonFacility, String activityFacility, String service, String roomFacility, String enterprises,
			HotelStrVO hotelStrVO, AvailableRoomInfoVO availableRoomInfoVO, OrderListVO[] orderRecordVO,double remarkNumber,ArrayList<String> remarkDetailInfo) {
		this.setHotelName(hotelName);
		this.setAddress(address);
		this.setHotelImage(hotelImage);
		this.setTelephone(telephone);
		this.setStar(star);
		this.setIntroduce(introduce);
		this.setCommonFacility(commonFacility);
		this.setActivityFacility(activityFacility);
		this.setService(service);
		this.setRoomFacility(roomFacility);
		this.setEnterprises(enterprises);
		this.setHotelStrVO(hotelStrVO);
		this.setAvailableRoomInfoVo(availableRoomInfoVO);
		this.setOrderRecordVO(orderRecordVO);
	    this.setRemarkDetailInfo(remarkDetailInfo);
	    this.setRemarkNumber(remarkNumber);
	    this.area=area;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCommonFacility() {
		return commonFacility;
	}

	public void setCommonFacility(String commonFacility) {
		this.commonFacility = commonFacility;
	}

	public String getActivityFacility() {
		return activityFacility;
	}

	public void setActivityFacility(String activityFacility) {
		this.activityFacility = activityFacility;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getRoomFacility() {
		return roomFacility;
	}

	public void setRoomFacility(String roomFacility) {
		this.roomFacility = roomFacility;
	}

	public String getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(String enterprises) {
		this.enterprises = enterprises;
	}

	public HotelStrVO getHotelStrVO() {
		return hotelStrVO;
	}

	public void setHotelStrVO(HotelStrVO hotelStrVO) {
		this.hotelStrVO = hotelStrVO;
	}

	public AvailableRoomInfoVO getAvailableRoomInfoVO() {
		return availableRoomInfoVO;
	}

	public void setAvailableRoomInfoVo(AvailableRoomInfoVO availableRoomInfoVO) {
		this.availableRoomInfoVO = availableRoomInfoVO;
	}

	public OrderListVO[] getOrderRecordVO() {
		return orderRecordVO;
	}

	public void setOrderRecordVO(OrderListVO[] orderRecordVO) {
		this.orderRecordVO = orderRecordVO;
	}

	public ImageIcon getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(ImageIcon hotelImage) {
		this.hotelImage = hotelImage;
	}
	public double getRemarkNumber() {
		return remarkNumber;
	}
	public void setRemarkNumber(double remarkNumber) {
		this.remarkNumber = remarkNumber;
	}
	public ArrayList<String> getRemarkDetailInfo() {
		return remarkDetailInfo;
	}
	public void setRemarkDetailInfo(ArrayList<String> remarkDetailInfo) {
		this.remarkDetailInfo = remarkDetailInfo;
	}
	public TradingArea getArea() {
		return area;
	}
	public void setArea(TradingArea area) {
		this.area = area;
	}

}
