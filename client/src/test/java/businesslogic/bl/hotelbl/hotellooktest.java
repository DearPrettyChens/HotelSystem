package businesslogic.bl.hotelbl;

import exception.NotFoundHotelException;

public class hotellooktest {
	public static void main(String[] args) throws NotFoundHotelException {
		Hotel hotel = new Hotel();
//		System.out.println(hotel.getHotelOrderList("5"));
//		System.out.println(hotel.getHotelOrderInfo("20161120000002000001").getHasChild());
//		System.out.println(hotel.getHotelDetailInfo("000005", "000001").getCity());
		System.out.println(hotel.getHotelDetailInfo("000005", "000001").getCity());
	}
}
