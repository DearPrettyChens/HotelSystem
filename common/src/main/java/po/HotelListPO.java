package po;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

@Entity
@Table(name = "t_hotel")
public class HotelListPO implements Serializable {

	/**
	 * 记录酒店列表信息
	 * 
	 * @author Cy
	 * @version 1.0
	 */
	@Id
	@Column(name = "id", unique = true)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Transient
	private ImageIcon image;
	@Column(name = "hotel_image")
	private String hotelImage;
	@Column(name = "lowest_price")
	private double lowestPrice;
	@Column(name = "star")
	private int star;
	@Column(name = "score")
	private double remark;

	public HotelListPO() {

	}

	public HotelListPO(String name, String location, ImageIcon image, double lowestPrice, int star, int id,
			double remark) {
		this.name = name;
		this.address = location;
		this.image = image;
		this.lowestPrice = lowestPrice;
		this.star = star;
		this.id = id;
		this.remark = remark;

	}

	public double getRemark() {
		return remark;
	}

	public void setRemark(double remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return address;
	}

	public void setLocation(String location) {
		this.address = location;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public double getLowestprice() {
		return lowestPrice;
	}

	public void setLowestprice(double lowestprice) {
		this.lowestPrice = lowestPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public HotelListPO copy() {
		return new HotelListPO(this.name, this.address, this.image, this.lowestPrice, this.star, this.id, this.remark);
	}

}
