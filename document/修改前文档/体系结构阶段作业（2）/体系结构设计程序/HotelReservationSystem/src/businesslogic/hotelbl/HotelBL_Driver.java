package businesslogic.hotelbl;

import java.util.ArrayList;

import blservice.hotelblservice.HotelBLService;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * 模拟酒店模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 *
 */
public class HotelBL_Driver {
	
	public void drive(HotelBLService stub){
		HotelBasicInfoVO hotelBasicInfoVO=stub.getHotelBasicInfo("0001");
	    HotelDetailInfoVO hotelDetailInfoVO=stub.getHotelDetailInfo("0001", "000001");
	    System.out.println(stub.checkTel("12345678900"));
	    System.out.println(stub.confirmModifyInfo(hotelBasicInfoVO));
	    ArrayList<HotelOrderVO> hotelOrderVOs=stub.getHotelOrder("0001");
	    HotelOrderInfoVO hotelOrderInfoVO=stub.getHotelOrderInfo("201610120001000001");
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HotelBL_Driver().drive(new HotelBL_Stub());
	}

}
