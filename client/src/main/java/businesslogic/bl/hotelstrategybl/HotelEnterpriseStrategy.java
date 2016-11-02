package businesslogic.bl.hotelstrategybl;

import java.util.ArrayList;

import dao.hotelstrategydao.HotelStrategyDao;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;
/**
 * 酒店合作企业策略类
 * @author CYF
 * @version 1.0
 */
public class HotelEnterpriseStrategy implements HotelStrategyInterface {
	//酒店合作企业
	private ArrayList <String> enterprise;
	//折扣值
	private double discount;
	private HotelStrategyDao hotelStrategyDao;
    //构造方法
	public HotelEnterpriseStrategy() {
		
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

	public ArrayList<String> getEnterprise() {
		return enterprise;
	}

}
