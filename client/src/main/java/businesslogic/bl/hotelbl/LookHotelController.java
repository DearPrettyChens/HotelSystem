package businesslogic.bl.hotelbl;

import businesslogic.blservice.hotelblservice.LookHotelService;
import vo.hotelvo.HotelDetailInfoVO;


public class LookHotelController implements LookHotelService {

	// 持有hotel的引用
	private Hotel hotel;

	public LookHotelController() {
			hotel=new Hotel();
	}

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID, String customerID) {
		// TODO Auto-generated method stub
		return null;
	}



}
