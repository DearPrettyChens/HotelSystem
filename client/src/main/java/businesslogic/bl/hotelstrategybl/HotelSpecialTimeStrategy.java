package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;
import java.util.Date;

import dao.hotelstrategydao.HotelStrategyDao;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.TransHelper;
import vo.hotelstrategyvo.HotelStrVO;

/**
 * 酒店特殊时期优惠策略类
 * 
 * @author CYF
 * @version 1.0
 */
public class HotelSpecialTimeStrategy implements HotelStrategyInterface {
	// 特殊时期酒店策略数组 两个元素记录开始时间和结束时间
	private Date[] date;
	// 折扣值
	private double discount;
	private HotelStrategyDao hotelStrategyDao;
	private HotelStrPO hotelStrPO;
	private static HotelStrategyInterface hotelSpecialTimeStrategy;

	// 构造方法
	private HotelSpecialTimeStrategy() {
//		hotelStrategyDao = RMIHelper.getHotelStrategyDao();
	    hotelStrategyDao =new HotelStrategyDao_Stub();
	
	}

	public static HotelStrategyInterface getInstance() {
		if (hotelSpecialTimeStrategy == null) {
			hotelSpecialTimeStrategy = new HotelSpecialTimeStrategy();
		}
		return hotelSpecialTimeStrategy;
	}

	@Override
	public HotelStrVO getHotelStrategy(String hotelID) {
		try {
			hotelStrPO = hotelStrategyDao.getHotelStrategy(hotelID, HotelStrategyType.SPECIALTIME);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(hotelStrPO==null) return null;
		discount = hotelStrPO.getDiscount();
		date = hotelStrPO.getDate();
		return new HotelStrVO(hotelStrPO);
	}

	@Override
	public double getDiscount(String info, String hotelID) {
		if(getHotelStrategy(hotelID)==null){
			return 1;
		}
		long dateInfo=TransHelper.stringToDate(info);		
		long startTime=date[0].getTime();
		long endTime=date[1].getTime();
         
		//如果在特惠时间内，就返回折扣值
		if((dateInfo>=startTime)&&(dateInfo<=endTime)){
			return discount;
		}
		return 1;
	}

}
