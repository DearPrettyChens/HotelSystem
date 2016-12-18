package businesslogic.hotelstrategybl;

import blservice.hotelstrategyblservice.HotelStrategyBLService;
import common.HotelStrategyType;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelstrategyvo.OrderProvidedVO;

/**
<<<<<<< HEAD
=======
 * 模拟酒店策略模块界面层和逻辑层交互的实现
>>>>>>> refs/remotes/origin/cyfBranch
 * @author csy
 * @version 1.0
 * 
 */
public class HotelStrategyBL_Driver {
	public void drive(HotelStrategyBLService stub){
		HotelBestStrVO hotelBestStrVO=stub.getBestHotelStrategy(new OrderProvidedVO());
	    HotelStrVO hotelStrVO=stub.getHotelStrategy("0001", HotelStrategyType.AMOUNT);
	    System.out.println(stub.confirmHotelStrategy(hotelStrVO));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HotelStrategyBL_Driver().drive(new HotelStrategyBL_Stub());
	}

}
