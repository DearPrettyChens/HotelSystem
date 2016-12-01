package businesslogic.bl.hotelbl;

public class hotellooktest {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		System.out.println(hotel.getHotelOrderList("5").size());
	}
}
