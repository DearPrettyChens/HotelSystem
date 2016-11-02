package businesslogic.bl.hotelstrategybl;

import dao.hotelstrategydao.HotelStrategyDao;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;
/**
 * 酒店预订数量策略类
 * @author CYF
 * @version 1.0
 */
public class HotelAmountStrategy implements HotelStrategyInterface{
	//数量
	private int amount;
	//酒店预订数量策略折扣
	private double discount;
	private HotelStrategyDao hotelStrategyDao;
    //构造方法
	public HotelAmountStrategy(){
		
	}
	@Override
	public HotelStrVO getHotelStrategy(String hotelID) {
		return null;
	}
	@Override
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO) {
		return null;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public int getAmount() {
		return amount;
	}
	
}
