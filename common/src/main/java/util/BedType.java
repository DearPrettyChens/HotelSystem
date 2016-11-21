package util;

import org.hibernate.loader.custom.Return;

public enum BedType {
	BIGBED, TWOBEDS, THREEBEDS, FOURBEDS, FAMILYBED;
	public String getString() {
		String str = null;
		switch (this) {
		case BIGBED:
			str = "BIGBED";
			break;
		case TWOBEDS:
			str = "TWOBEDS";
			break;
		case THREEBEDS:
			str = "THREEBEDS";
			break;
		case FOURBEDS:
			str = "FOURBEDS";
			break;
		}
		return str;
	}
}
