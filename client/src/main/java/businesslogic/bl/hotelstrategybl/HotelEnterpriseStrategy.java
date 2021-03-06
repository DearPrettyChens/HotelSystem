package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.hotelstrategydao.HotelStrategyDao;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
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
	private HotelStrPO hotelStrPO;
	private static HotelStrategyInterface hotelEnterpriseStrategy;
	
    //构造方法
	private HotelEnterpriseStrategy() {
		hotelStrategyDao=RMIHelper.getHotelStrategyDao();
//	    hotelStrategyDao=new HotelStrategyDao_Stub();
	}

	public static HotelStrategyInterface getInstance() {
		if(hotelEnterpriseStrategy==null){
			hotelEnterpriseStrategy=new HotelEnterpriseStrategy();
		}
		return hotelEnterpriseStrategy;
	}
	@Override
	public HotelStrVO getHotelStrategy(String hotelID) {
		try {
			hotelStrPO=hotelStrategyDao.getHotelStrategy(hotelID, HotelStrategyType.ENTERPRISE);
			if(hotelStrPO==null){
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(hotelStrPO==null) return null;
		enterprise=hotelStrPO.getEnterprise();
		discount=hotelStrPO.getDiscount();
		return new HotelStrVO(hotelStrPO);
	}

	@Override
	public double getDiscount(String info, String hotelID) {
		if(getHotelStrategy(hotelID)==null){
			return 1;
		}
		for(String tempEnterprise:enterprise){
			if((info!=null)&&(tempEnterprise.equals(info))){
				return discount;
			}
		}
		return 1;
	}

	@Override
	public double getDiscount(String hotelID) {
		if(getHotelStrategy(hotelID)==null){
			return 1;
		}
		return discount;
	}

}
