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
}
