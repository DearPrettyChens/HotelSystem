package vo.searchhotelvo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import po.HotelListPO;
import util.OrderState;
import util.TransHelper;
import vo.hotelstrategyvo.HotelStrVO;

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
	// 酒店电话
	private String telephone;
	// 酒店策略
	private ArrayList<HotelStrVO> hotelStrVO;
	// 顾客在该酒店的订单
	private ArrayList<OrderState> orderStates;
	
	public HotelListVO(HotelListPO po){
		this.setHotelAddress(po.getLocation());
		this.setHotelID(TransHelper.idToString(po.getId(),6));
		this.setHotelName(po.getName());
		this.setHotelImage(po.getImage());
		this.setStar(po.getStar());
		this.setRemark(po.getRemark());
		this.setLowestPrice(po.getLowestprice());
		this.setTelephone(po.getTelephone());
	}


	public HotelListVO(ImageIcon hotelImage, String hotelID, String hotelName, String hotelAddress, int star,
			double remark, double lowestPrice, String telephone, ArrayList<HotelStrVO> hotelStrVO,
			ArrayList<OrderState> orderStates) {
		super();
		this.hotelImage = hotelImage;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.star = star;
		this.remark = remark;
		this.lowestPrice = lowestPrice;
		this.setTelephone(telephone);
		this.setHotelStrVO(hotelStrVO);
		this.setOrderStates(orderStates);
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public ArrayList<HotelStrVO> getHotelStrVO() {
		return hotelStrVO;
	}
	public void setHotelStrVO(ArrayList<HotelStrVO> hotelStrVO) {
		this.hotelStrVO = hotelStrVO;
	}


	public ArrayList<OrderState> getOrderStates() {
		return orderStates;
	}


	public void setOrderStates(ArrayList<OrderState> orderStates) {
		this.orderStates = orderStates;
	}

}
