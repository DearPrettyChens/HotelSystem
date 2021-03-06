package vo.hotelvo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import po.HotelBasicInfoPO;
import po.RemarkPO;
import util.City;
import util.TradingArea;
import util.TransHelper;
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
	//城市
	private City city;
	// 商圈
	private TradingArea tradingArea;
	// 联系方式
	private String telephone;
	// 星级
	private int star;
	//评分
	private double score;
	//最低价格
	private double lowestPrice;
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
	// 住户点评
	private ArrayList<RemarkPO> remarks;
    //空方法
	public HotelBasicInfoVO(){
		
	}
     public HotelBasicInfoVO(HotelBasicInfoPO po){
    	
    	 this.hotelID=TransHelper.idToString(po.getHotelID(),6);
    	 // 酒店名
    	this.hotelName=po.getName();
    		//酒店照片
    	this.hotelImage=po.getHotelImage();
    		// 地址
    	this.address=po.getAddress();
    		//城市
    	this.city=po.getCity();
    		// 商圈
    	this.tradingArea=po.getTradingArea();
    		// 联系方式
    	this.telephone=po.getTelephone();
    		// 星级
    	this.star=po.getStar();
    		// 酒店简介
    	this.introduce=po.getIntroduce();
    		// 通用设施
    	this.commonFacility=po.getCommonFacility();
    		// 活动设施
    	this.activityFacility=po.getActivityFacility();
    		// 服务项目
    	this.service=po.getService();
    		// 客房设施
    	this.roomFacility=po.getRoomFacility();
    		// 合作企业
    	this.enterprises=po.getEnterprises();
    	
    	 
		
	}
	//酒店基本信息
	public HotelBasicInfoVO(String hotelID,String hotelName,ImageIcon hotelImage, String address,City city, TradingArea tradingArea, String telephone,
			int star, String introduce, String commonFacility, String activityFacility, String service,
			String roomFacility, String enterprises) {
	    this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setHotelImage(hotelImage);
		this.setAddress(address);
		this.setCity(city);
		this.setTradingArea(tradingArea);
		this.setTelephone(telephone);
		this.setStar(star);
		this.setIntroduce(introduce);
		this.setCommonFacility(commonFacility);
		this.setActivityFacility(activityFacility);
		this.setService(service);
		this.setRoomFacility(roomFacility);
		this.setEnterprises(enterprises);
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

	public String getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(String enterprises) {
		this.enterprises = enterprises;
	}

	public ImageIcon getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(ImageIcon hotelImage) {
		this.hotelImage = hotelImage;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public HotelBasicInfoPO votopo(){
		return new HotelBasicInfoPO(TransHelper.idToInt(this.hotelID), this.hotelName, this.hotelImage, 
				this.address, this.telephone,this.star,this.score, this.lowestPrice, this.introduce, this.commonFacility,
				this.activityFacility, this.service, this.roomFacility,this.remarks,this.city,this.tradingArea,this.enterprises);
	
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public ArrayList<RemarkPO> getRemarks() {
		return remarks;
	}
	public void setRemarks(ArrayList<RemarkPO> remarks) {
		this.remarks = remarks;
	}

}
