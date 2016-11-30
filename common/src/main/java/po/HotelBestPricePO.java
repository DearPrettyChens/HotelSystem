package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
/**
 * 酒店最优价格的po
 * @author CYF
 * @version 1.0
 */
@Entity
@Table(name="t_hotel")
public class HotelBestPricePO implements Serializable{
	//酒店id
	@Id
	@Column(name="id")
	private int hotelID;
	//最优价格
	@Column(name="lowest_price")
	private double bestPrice;
	//空方法
	@Version
	@Column(name = "version")
	private int version;
	public HotelBestPricePO(){
		
	}
	//酒店最优价格
	public HotelBestPricePO(int hotelID,double bestPrice){
		this.setBestPrice(bestPrice);
		this.setHotelID(hotelID);
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public double getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(double bestPrice) {
		this.bestPrice = bestPrice;
	}
}
