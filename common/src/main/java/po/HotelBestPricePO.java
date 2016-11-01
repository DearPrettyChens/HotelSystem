package po;

import java.io.Serializable;
/**
 * 酒店最优价格的po
 * @author CYF
 * @version 1.0
 */

public class HotelBestPricePO implements Serializable{
	//酒店id
	private String hotelID;
	//最优价格
	private double bestPrice;
	//空方法
	public HotelBestPricePO(){
		
	}
	//酒店最优价格
	public HotelBestPricePO(String hotelID,double bestPrice){
		this.setBestPrice(bestPrice);
		this.setHotelID(hotelID);
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public double getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(double bestPrice) {
		this.bestPrice = bestPrice;
	}
}
