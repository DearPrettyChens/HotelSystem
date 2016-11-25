package util;

public enum UserType {
	HotelWorker, Customer, WebMarketMan, Manager;
	public String getString() {
		String string = null;
		switch (this) {
		case HotelWorker:
			string = "HotelWorker";
			break;
		case Customer:
			string = "Customer";
			break;
		case WebMarketMan:
			string = "WebMarketMan";
			break;
		case Manager:
			string = "Manager";
			break;
		default:
			break;
		}
		return string;
	}
}
