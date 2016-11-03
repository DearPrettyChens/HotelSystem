package vo.searchhotelvo;

import java.awt.Image;

import javax.swing.ImageIcon;

import po.HotelListPO;

/**
 * 酒店列表信息vo
 * 
 * @author CYF
 * @version 1.0
 */
public class HotelListVO {
	// 酒店图片
    private ImageIcon hotelImage;
	// 酒店id
	private String hotelID;
	// 酒店名字
	private String hotelName;
	// 酒店地址
	private String hotelAddress;
	// 酒店星级
	private int star;
	// 酒店评分
	private double remark;
	// 酒店最低价格
	private double lowestPrice;

	public HotelListVO(){
	}
	public HotelListVO(HotelListPO po){
		this.setHotelAddress(po.getLocation());
		this.setHotelID(po.getId());
		this.setHotelName(po.getName());
		this.setHotelImage(po.getImage());
		this.setStar(po.getStar());
		this.setRemark(po.getRemark());
		this.setLowestPrice(po.getLowestprice());
	}
	public HotelListVO(String hotelID, String hotelName, String hotelAddress, int star, double remark,
			double lowestPrice) {
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setHotelAddress(hotelAddress);
		this.setStar(star);
		this.setRemark(remark);
		this.setLowestPrice(lowestPrice);
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

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int d) {
		this.star = d;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public double getRemark() {
		return remark;
	}

	public void setRemark(double remark) {
		this.remark = remark;
	}
	public ImageIcon getHotelImage() {
		return hotelImage;
	}
	public void setHotelImage(ImageIcon imageIcon) {
		this.hotelImage = imageIcon;
	}

}
