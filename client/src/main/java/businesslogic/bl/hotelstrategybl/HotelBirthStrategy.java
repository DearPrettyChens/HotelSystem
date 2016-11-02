package businesslogic.bl.hotelstrategybl;

import dao.hotelstrategydao.HotelStrategyDao;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;
/**
 * 酒店生日策略类
 * @author CYF
 * @version 1.0
 */
public class HotelBirthStrategy implements HotelStrategyInterface {
	//酒店生日策略折扣值
	private double discount;
	private HotelStrategyDao hotelStrategyDao;
    //构造方法
	public HotelBirthStrategy() {
		
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
	
	

}
