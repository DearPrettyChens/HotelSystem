package util;

public enum TradingArea {
	XINJIEKOU, HUNANLU;
	public String getString() {
		String str = null;
		switch (this) {
		case XINJIEKOU:
			str = "XINJIEKOU";
			break;
		case HUNANLU:
			str = "HUNANLU";
			break;
		}
		return str;
	}
	
	public String getChinese() {
		String str = null;
		switch (this) {
		case XINJIEKOU:
			str = "新街口";
			break;
		case HUNANLU:
			str = "湖南路";
			break;
		}
		return str;
	}
	
}
