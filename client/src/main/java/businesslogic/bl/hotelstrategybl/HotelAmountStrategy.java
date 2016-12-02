package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;

import dao.hotelstrategydao.HotelStrategyDao;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
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
	private HotelStrPO hotelStrPO;
	private HotelStrategyDao hotelStrategyDao;
	private static HotelStrategyInterface hotelAmountStrategy;
    //构造方法
	private HotelAmountStrategy(){
		hotelStrategyDao=RMIHelper.getHotelStrategyDao();
//	    hotelStrategyDao=new HotelStrategyDao_Stub();
	}
	public static HotelStrategyInterface getInstance() {
		if(hotelAmountStrategy==null){
			hotelAmountStrategy=new HotelAmountStrategy();
		}
		return hotelAmountStrategy;
	}
	
	@Override
	public HotelStrVO getHotelStrategy(String hotelID) {
		try {
			hotelStrPO = hotelStrategyDao.getHotelStrategy(hotelID, HotelStrategyType.AMOUNT);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(hotelStrPO==null) return null;
		discount = hotelStrPO.getDiscount();
		amount = hotelStrPO.getAmount();
		return new HotelStrVO(hotelStrPO);
	}

	@Override
	public double getDiscount(String info, String hotelID) {
		if(getHotelStrategy(hotelID)==null){
			return 1;
		}
		
		if(info==null){
			return 1;
		}
		int roomAmount=Integer.parseInt(info);
		if(roomAmount>=amount){
			return discount;
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
