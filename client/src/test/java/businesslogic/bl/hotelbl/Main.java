package businesslogic.bl.hotelbl;

import exception.NotFoundHotelException;
import vo.hotelvo.HotelBasicInfoVO;

public class Main {
	public static void main(String[] args){
		Hotel hotel=new Hotel();
		try {
			HotelBasicInfoVO vo=hotel.getHotelBasicInfo("000005");
			System.out.println(vo.getAddress());
		} catch (NotFoundHotelException e) {
			e.printStackTrace();
		}
	}
}
