package util;

public enum Children {
	EXIST, NOTEXIST;
	public String getString() {
		String string = null;
		switch (this) {
		case EXIST:
			string = "EXIST";
			break;
		case NOTEXIST:
			string = "NOTEXIST";
			break;
		default:
			break;
		}
		return string;
	}
	
	public String toChinese() {
		String string = null;
		switch (this) {
		case EXIST:
			string = "有";
			break;
		case NOTEXIST:
			string = "无";
			break;
		default:
			break;
		}
		return string;
	}
}
