package businesslogic.bl.hotelbl;

import businesslogic.blservice.hotelblservice.LookHotelService;
import vo.hotelvo.HotelDetailInfoVO;


public class LookHotelController implements LookHotelService {

	// 持有hotel的引用
	private Hotel hotel;
	private static LookHotelController controller=null;

	private LookHotelController() {
			hotel=new Hotel();
	}

	public static LookHotelController getInstance(){
		if(controller==null){
			controller=new LookHotelController();
		}
		return controller;
	}
	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID, String customerID) {
		return hotel.getHotelDetailInfo(hotelID, customerID);
	}



}
