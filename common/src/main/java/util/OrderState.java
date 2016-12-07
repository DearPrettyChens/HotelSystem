package util;

public enum OrderState {
	NOTEXECUTED, NOTREMARKED, HASREMARKED, UNUSUAL, HASCANCELED,EXECUTED;
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
	
	public String toChinese() {
		String string = null;
		switch (this) {
		case NOTEXECUTED:
			string = "未执行订单";
			break;
		case NOTREMARKED:
			string = "已执行订单";
			break;
		case HASREMARKED:
			string = "已执行订单";
			break;
		case UNUSUAL:
			string = "异常订单";
			break;
		case HASCANCELED:
			string = "撤销订单";
			break;
		default:
			break;
		}
		return string;
	}
	
	public String getOperation() {
		String string = null;
		switch (this) {
		case NOTEXECUTED:
			string = "撤     销";
			break;
		case NOTREMARKED:
			string = "追加评价";
			break;
		case HASREMARKED:
			string = "";
			break;
		case UNUSUAL:
			string = "";
			break;
		case HASCANCELED:
			string = "";
			break;
		default:
			break;
		}
		return string;
	}
}
