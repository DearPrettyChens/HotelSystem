package util;

public enum City {
	NANJING;
	public String getString() {
		return "NANJING";
	}
	
	public String toChinese() {
		return "南京";
	}
	
	public static City toCity(String str){
		City city= City.NANJING;
		switch(str){
		case "南京":
			city=City.NANJING;
			break;
		}
		return city;
	}
	
}
