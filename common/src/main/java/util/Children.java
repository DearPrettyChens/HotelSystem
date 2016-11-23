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

}
