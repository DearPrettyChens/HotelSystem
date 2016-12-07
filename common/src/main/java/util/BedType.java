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
	
	public String toChinese() {
		String str = null;
		switch (this) {
		case BIGBED:
			str = "大床房";
			break;
		case TWOBEDS:
			str = "标间";
			break;
		case THREEBEDS:
			str = "三人间";
			break;
		case FOURBEDS:
			str = "四人间";
			break;
		}
		return str;
	}
	
	public static BedType toBedType(String str){
		BedType bedType=BedType.BIGBED;
		switch(str){
		case "大床房":
			bedType=BedType.BIGBED;
			break;
		case "标间":
			bedType=BedType.TWOBEDS;
			break;
		case "三人间":
			bedType=BedType.THREEBEDS;
			break;
		case "四人间":
			bedType=BedType.FAMILYBED;
			break;
		}
		return bedType;
	}
}
