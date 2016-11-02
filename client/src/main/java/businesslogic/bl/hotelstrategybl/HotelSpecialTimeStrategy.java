package businesslogic.bl.hotelstrategybl;

import java.util.Date;

import dao.hotelstrategydao.HotelStrategyDao;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;
/**
 * 酒店特殊时期优惠策略类
 * @author CYF
 * @version 1.0
 */
public class HotelSpecialTimeStrategy implements HotelStrategyInterface{
	//特殊时期酒店策略数组 两个元素记录开始时间和结束时间
    private Date[] date;
    //折扣值
    private double discount;
    private HotelStrategyDao hotelStrategyDao;
    //构造方法
    public HotelSpecialTimeStrategy(){
    
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
	public Date[] getDate() {
		return date;
	}

	
}
