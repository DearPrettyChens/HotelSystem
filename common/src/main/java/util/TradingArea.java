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
	
	public static TradingArea toArea(String str){
		TradingArea area=TradingArea.XINJIEKOU;
		switch(str){
		case "新街口":
			area=TradingArea.XINJIEKOU;
			break;
		case "湖南路":
			area=TradingArea.HUNANLU;
			break;
		}
		return area;
	}
}
