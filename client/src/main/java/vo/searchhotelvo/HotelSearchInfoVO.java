package vo.searchhotelvo;

import java.util.ArrayList;
import java.util.Date;

import util.BedType;
import util.City;
import util.HotelSortType;
import util.OrderState;
import util.TradingArea;

/**
 * 
 * 酒店搜索信息
 * @author CSY
 *
 */
public class HotelSearchInfoVO {
	
    private String hotelName;//酒店名字
    private City city;//城市
    private TradingArea tradingArea;//商圈
    private Date checkinTime;//入住时间
    private Date checkoutTime;//退房时间	
    private ArrayList<BedType> bedTypes;//床型
    private ArrayList<Integer> lowPrice;//最低价格
    private ArrayList<Integer> highPrice;//最高价格
    private ArrayList<Integer> stars;//星级
    private ArrayList<Double> lowRemarkNumbers;//最低评分
    private ArrayList<Double> highRemarkNumbers;//最高评分
    private ArrayList<OrderState> orderStates;//订单状态
    private HotelSortType hotelSortType;//排序方式
    private String customerID;//顾客ID
    
    public HotelSearchInfoVO(){
    	
    }
    
    //只有排序
    public HotelSearchInfoVO(HotelSortType hotelSortType) {
		this.setHotelSortType(hotelSortType);
	}
    
    //在查看预定过的酒店时，只有订单状态
    public HotelSearchInfoVO(OrderState orderState,String customerID) {
		this.orderStates=new ArrayList<OrderState>();
		orderStates.add(orderState);
		this.customerID=customerID;
	}
    


	public HotelSearchInfoVO(String hotelName, City city, TradingArea tradingArea, Date checkinTime, Date checkoutTime,
			ArrayList<BedType> bedTypes, ArrayList<Integer> lowPrice, ArrayList<Integer> highPrice,
			ArrayList<Integer> stars, ArrayList<Double> lowRemarkNumbers, ArrayList<Double> highRemarkNumbers,
			ArrayList<OrderState> orderStates, HotelSortType hotelSortType, String customerID) {
		super();
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea = tradingArea;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.bedTypes = bedTypes;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.stars = stars;
		this.lowRemarkNumbers = lowRemarkNumbers;
		this.highRemarkNumbers = highRemarkNumbers;
		this.orderStates = orderStates;
		this.hotelSortType = hotelSortType;
		this.customerID = customerID;
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public TradingArea getTradingArea() {
		return tradingArea;
	}
	public void setTradingArea(TradingArea tradingArea) {
		this.tradingArea = tradingArea;
	}
	public Date getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}
	public Date getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	public ArrayList<BedType> getBedTypes() {
		return bedTypes;
	}

	public void setBedTypes(ArrayList<BedType> bedTypes) {
		this.bedTypes = bedTypes;
	}

	public ArrayList<Integer> getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(ArrayList<Integer> lowPrice) {
		this.lowPrice = lowPrice;
	}

	public ArrayList<Integer> getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(ArrayList<Integer> highPrice) {
		this.highPrice = highPrice;
	}

	public ArrayList<Integer> getStars() {
		return stars;
	}

	public void setStars(ArrayList<Integer> stars) {
		this.stars = stars;
	}

	public ArrayList<Double> getLowRemarkNumbers() {
		return lowRemarkNumbers;
	}

	public void setLowRemarkNumbers(ArrayList<Double> lowRemarkNumbers) {
		this.lowRemarkNumbers = lowRemarkNumbers;
	}

	public ArrayList<Double> getHighRemarkNumbers() {
		return highRemarkNumbers;
	}

	public void setHighRemarkNumbers(ArrayList<Double> highRemarkNumbers) {
		this.highRemarkNumbers = highRemarkNumbers;
	}

	public ArrayList<OrderState> getOrderStates() {
		return orderStates;
	}

	public void setOrderStates(ArrayList<OrderState> orderStates) {
		this.orderStates = orderStates;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public HotelSortType getHotelSortType() {
		return hotelSortType;
	}

	public void setHotelSortType(HotelSortType hotelSortType) {
		this.hotelSortType = hotelSortType;
	}
    
}
