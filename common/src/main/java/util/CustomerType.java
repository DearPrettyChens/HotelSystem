package util;

public enum CustomerType {
	ENTERPRISE, INDIVIDUAL;
	public String getString() {
		String string = null;
		switch (this) {
		case ENTERPRISE:
			string = "ENTERPRISE";
			break;
		case INDIVIDUAL:
			string = "INDIVIDUAL";
		default:
			break;
		}
		return string;
	}
}
