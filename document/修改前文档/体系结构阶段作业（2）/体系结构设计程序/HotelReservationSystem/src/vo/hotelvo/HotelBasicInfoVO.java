package vo.hotelvo;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import common.TradingArea;
/**
 * 酒店基本信息vo 给酒店工作人员看的
 * @author CYF
 * @version 1.0
 */

public class HotelBasicInfoVO {
	// 酒店id
	private String hotelID;
	// 酒店名
	private String hotelName;
	//酒店照片
	private ImageIcon hotelImage;
	// 地址
	private String address;
	// 商圈
	private TradingArea tradingArea;
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
	private String[] enterprises;
    //空方法
	public HotelBasicInfoVO(){
		
	}
	//酒店基本信息
	public HotelBasicInfoVO(String hotelID, String hotelName,ImageIcon hotelImage, String address, TradingArea tradingArea, String telephone,
			int star, String introduce, String commonFacility, String activityFacility, String service,
			String roomFacility, String[] enterprises) {
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setHotelImage(hotelImage);
		this.setAddress(address);
		this.setTradingArea(tradingArea);
		this.setTelephone(telephone);
		this.setStar(star);
		this.setIntroduce(introduce);
		this.setCommonFacility(commonFacility);
		this.setService(service);
		this.setRoomFacility(roomFacility);
		this.setEnterprises(enterprises);
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

	public TradingArea getTradingArea() {
		return tradingArea;
	}

	public void setTradingArea(TradingArea tradingArea) {
		this.tradingArea = tradingArea;
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

	public String[] getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(String[] enterprises) {
		this.enterprises = enterprises;
	}

	public ImageIcon getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(ImageIcon hotelImage) {
		this.hotelImage = hotelImage;
	}

}
