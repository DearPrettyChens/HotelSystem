package util;

public enum HotelStrategyType {
	SPECIALTIME, BIRTH, ENTERPRISE, AMOUNT, NULLTYPE;//最后一个表示没有酒店策略
	public String getString() {
		String string = null;
		switch (this) {
		case SPECIALTIME:
			string = "SPECIALTIME";
			break;
		case BIRTH:
			string = "BIRTH";
			break;
		case ENTERPRISE:
			string = "ENTERPRISE";
			break;
		case AMOUNT:
			string = "AMOUNT";
			break;

		default:
			break;
		}
		return string;
	}
	public String toChinese() {
		String string = null;
		switch (this) {
		case SPECIALTIME:
			string = "今天是个好日子，大量优惠回馈给您！";
			break;
		case BIRTH:
			string = "我们酒店祝您生日快乐！大量优惠送给您！";
			break;
		case ENTERPRISE:
			string = "您好，我们的合作伙伴！小小优惠，以表诚意！";
			break;
		case AMOUNT:
			string = "您好，我们诚挚的感谢您预订了如此多的房间！";
			break;

		default:
			break;
		}
		return string;
	}
	
	public String getChinese() {
		String string = null;
		switch (this) {
		case SPECIALTIME:
			string = "特惠时期优惠";
			break;
		case BIRTH:
			string = "会员生日优惠";
			break;
		case ENTERPRISE:
			string = "合作企业优惠";
			break;
		case AMOUNT:
			string = "房间数量优惠";
			break;

		default:
			break;
		}
		return string;
	}
}
