package util;

public enum OrderState {
	NOTEXECUTED, NOTREMARKED, HASREMARKED, UNUSUAL, HASCANCELED;
	public String getString() {
		String string = null;
		switch (this) {
		case NOTEXECUTED:
			string = "NOTEXECUTED";
			break;
		case NOTREMARKED:
			string = "NOTREMARKED";
			break;
		case HASREMARKED:
			string = "HASREMARKED";
			break;
		case UNUSUAL:
			string = "UNUSUAL";
			break;
		case HASCANCELED:
			string = "HASCANCELED";
			break;
		default:
			break;
		}
		return string;
	}
}
