package po;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class HotelListPO  implements Serializable{
	
	/**
	 * 记录酒店列表信息
	 * @author Cy
	 * @version 1.0
	 */
		
	private String name;
	private String location;
	private ImageIcon image;
	private double lowestPrice;
	private double star;
	
	public HotelListPO(){
		
	}
	
    public HotelListPO(String name,String location,ImageIcon image,double lowestPrice
    		,double star){
    	this.name=name;
    	this.location=location;
    	this.image=image;
    	this.lowestPrice=lowestPrice;
    	this.star=star;
		
	}
	
	
	public double getRemark() {
		return star;
	}
	public void setRemark(double remark) {
		this.star = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
	
	
}
