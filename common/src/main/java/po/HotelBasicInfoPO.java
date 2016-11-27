package po;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

import util.City;
import util.TradingArea;

/**
 * 酒店基本信息
 * 
 * @author CYF
 * @version 1.0
 */
@Entity
@Table(name = "t_hotel")
public class HotelBasicInfoPO implements Serializable {
	// 酒店id
	@Id
	@Column(name = "id")
	private int hotelID;
	// 酒店名
	@Column(name = "name")
	private String name;
	// 酒店图片
	@Column(name = "hotel_image")
	private String hotelImagePath;
	@Transient
	private ImageIcon hotelImage;
	// 城市
	@Column(name = "city")
	private String city;
	// 商圈
	@Column(name = "trading_area")
	private String tradingArea;
	// 地址
	@Column(name = "address")
	private String address;
	// 联系方式
	@Column(name = "telephone")
	private String telephone;
	// 星级
	@Column(name = "star")
	private int star;
	// 评分
	@Column(name = "score")
	private double score;
	// 最低价格
	@Column(name = "lowest_price")
	private double lowestPrice;
	// 预定记录？
	// private String reserveRecords;
	// 酒店简介
	@Column(name = "introduce")
	private String introduce;
	// 通用设施
	@Column(name = "common_facility")
	private String commonFacility;
	// 活动设施
	@Column(name = "activity_facility")
	private String activityFacility;
	// 服务项目
	@Column(name = "service")
	private String service;
	// 客房设施
	@Column(name = "room_facility")
	private String roomFacility;
	// 住户点评
	// @OneToMany(mappedBy="")
	@Transient
	private ArrayList<RemarkPO> remarks;
	// 评价过的订单总数
	@Column(name = "remark_number")
	private int remarkOrderNumber;
	// 合作企业
	@Column(name = "enterprises")
	private String enterprises;
	// 空方法

	public void setEnterprises(String enterprises) {
		this.enterprises = enterprises;
	}

	public HotelBasicInfoPO() {

	}

	// public HotelBasicInfoPO( String hotelName) {
	// this.setName(hotelName);
	// }

	// 酒店基本信息，所有人的
	public HotelBasicInfoPO(int hotelID, String name, ImageIcon hotelImage, String address, String telephone, int star,
			double score, double lowestPrice, String introduce, String commonFacility, String activityFacility,
			String service, String roomFacility, ArrayList<RemarkPO> remarks, City city, TradingArea tradingArea) {
		this.setHotelID(hotelID);
		this.setName(name);
		this.setAddress(address);
		this.setTelephone(telephone);
		this.setStar(star);
		this.setScore(score);
		this.setLowestPrice(lowestPrice);
		this.setIntroduce(introduce);
		this.setCommonFacility(commonFacility);
		this.setActivityFacility(activityFacility);
		this.setService(service);
		this.setRoomFacility(roomFacility);
		this.setRemarks(remarks);
		this.setCity(city);
		this.setTradingArea(tradingArea);
		this.setEnterprises(roomFacility);
		this.setHotelImage(hotelImage);
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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

	public ImageIcon getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(ImageIcon hotelImage) {
		this.hotelImage = hotelImage;
	}

	public City getCity() {
		City ret = null;
		switch (city) {
		case "NANJING":
			ret = City.NANJING;
			break;
		default:
			break;
		}
		return ret;
	}

	public void setCity(City city) {
		if (city != null)
			this.city = city.getString();
	}

	public TradingArea getTradingArea() {
		TradingArea ret = null;
		switch (tradingArea) {
		case "XINJIEKOU":
			ret = TradingArea.XINJIEKOU;
			break;
		case "HUNANLU":
			ret = TradingArea.HUNANLU;
		default:
			break;
		}
		return ret;
	}

	public void setTradingArea(TradingArea tradingArea) {
		if (tradingArea != null)
			this.tradingArea = tradingArea.getString();
	}

	public int getRemarkOrderNumber() {
		return remarkOrderNumber;
	}

	public void setRemarkOrderNumber(int remarkOrderNumber) {
		this.remarkOrderNumber = remarkOrderNumber;
	}

	public String getEnterprises() {
		return enterprises;
	}

	public HotelBasicInfoPO copy() {
		return new HotelBasicInfoPO(getHotelID(), getName(), getHotelImage(), getAddress(), getTelephone(), getStar(),
				getScore(), getLowestPrice(), getIntroduce(), getCommonFacility(), getActivityFacility(), getService(),
				getRoomFacility(), getRemarks(), getCity(), getTradingArea());
	}

	public String getHotelImagePath() {
		return hotelImagePath;
	}

	public void setHotelImagePath(String hotelImagePath) {
		this.hotelImagePath = hotelImagePath;
	}

}
