package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.bl.userbl.Customer;
import dao.hotelstrategydao.HotelStrategyDao;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.TransHelper;
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
    private static HotelStrategyInterface hotelBirthStrategy;
    private HotelStrPO hotelStrPO;
	//构造方法
	private HotelBirthStrategy() {
//		hotelStrategyDao=RMIHelper.getHotelStrategyDao();
	    hotelStrategyDao=new HotelStrategyDao_Stub();
	}

	public static HotelStrategyInterface getInstance() {
		if(hotelBirthStrategy==null){
			hotelBirthStrategy=new HotelBirthStrategy();
		}
		return hotelBirthStrategy;
	}
	
	@Override
	public HotelStrVO getHotelStrategy(String hotelID) {
		try {
			hotelStrPO=hotelStrategyDao.getHotelStrategy(hotelID, HotelStrategyType.BIRTH);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		discount=hotelStrPO.getDiscount();
		return new HotelStrVO(hotelStrPO);
	}


	@Override
	public double getDiscount(String info, String hotelID) {
		getHotelStrategy(hotelID);
		
		//通过user模块的customer类来获取顾客生日
		Customer customer=Customer.getInstance();
		String birth=customer.getBirthDay(info);
		
		//和今天的日期进行比较
		String today=TransHelper.dateToString(new Date());
		if(birth.equals(today)){
			return discount;
		}
		return 1;
	}
	
	

}
