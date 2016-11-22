package util;

public enum HotelStrategyType {
	SPECIALTIME, BIRTH, ENTERPRISE, AMOUNT;
	public String getString() {
		String string = null;
		switch (this) {
		case SPECIALTIME:
			string = "SPECIALTIME";
			break;
		case BIRTH:
			string = "BIRTH";
			break;
		case ENTERPRISE:
			string = "ENTERPRISE";
			break;
		case AMOUNT:
			string = "AMOUNT";
			break;

		default:
			break;
		}
		return string;
	}
}
