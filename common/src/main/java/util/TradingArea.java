package util;

public enum TradingArea {
	XINJIEKOU, HUNANLU, LIUHE, QIAOBEI, PUKOU, QIXIA, XIAGUAN, LONGJIANG, HEXI, ZHONGYANGMEN, GULOU, ZHUJIANGLU, FUZIMIAO, NANZHAN, JIANGNING, XIANLIN, TANGSHAN;
	public String getString() {
		String str = null;
		switch (this) {
		case XINJIEKOU:
			str = "XINJIEKOU";
			break;
		case HUNANLU:
			str = "HUNANLU";
			break;
		case FUZIMIAO:
			str = "FUZIMIAO";
			break;
		case GULOU:
			str = "GULOU";
			break;
		case HEXI:
			str = "HEXI";
			break;
		case JIANGNING:
			str = "JIANGNING";
			break;
		case LIUHE:
			str = "LIUHE";
			break;
		case LONGJIANG:
			str = "LONGJIANG";
			break;
		case NANZHAN:
			str = "NANZHAN";
			break;
		case PUKOU:
			str = "PUKOU";
			break;
		case QIAOBEI:
			str = "QIAOBEI";
			break;
		case QIXIA:
			str = "QIXIA";
			break;
		case TANGSHAN:
			str = "TANGSHAN";
			break;
		case XIAGUAN:
			str = "XIAGUAN";
			break;
		case XIANLIN:
			str = "XIANLIN";
			break;
		case ZHONGYANGMEN:
			str = "ZHONGYANGMEN";
			break;
		case ZHUJIANGLU:
			str = "ZHUJIANGLU";
			break;
		default:
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
		case FUZIMIAO:
			str = "夫子庙";
			break;
		case GULOU:
			str = "鼓楼";
			break;
		case HEXI:
			str = "河西";
			break;
		case JIANGNING:
			str = "江宁";
			break;
		case LIUHE:
			str = "六合";
			break;
		case LONGJIANG:
			str = "龙江";
			break;
		case NANZHAN:
			str = "南站";
			break;
		case PUKOU:
			str = "浦口";
			break;
		case QIAOBEI:
			str = "桥北";
			break;
		case QIXIA:
			str = "栖霞";
			break;
		case TANGSHAN:
			str = "汤山";
			break;
		case XIAGUAN:
			str = "下关";
			break;
		case XIANLIN:
			str = "仙林";
			break;
		case ZHONGYANGMEN:
			str = "中央门";
			break;
		case ZHUJIANGLU:
			str = "珠江路";
			break;
		default:
			break;
		}
		return str;
	}

	public static TradingArea toArea(String str) {
		TradingArea area = TradingArea.XINJIEKOU;
		switch (str) {
		case "新街口":
			area = TradingArea.XINJIEKOU;
			break;
		case "湖南路":
			area = TradingArea.HUNANLU;
			break;
		case "夫子庙":
			area = TradingArea.FUZIMIAO;
			break;
		case "鼓楼":
			area = TradingArea.GULOU;
			break;
		case "河西":
			area = TradingArea.HEXI;
			break;
		case "江宁":
			area = TradingArea.JIANGNING;
			break;
		case "六合":
			area = TradingArea.LIUHE;
			break;
		case "龙江":
			area = TradingArea.LONGJIANG;
			break;
		case "南站":
			area = TradingArea.NANZHAN;
			break;
		case "浦口":
			area = TradingArea.PUKOU;
			break;
		case "桥北":
			area = TradingArea.QIAOBEI;
			break;
		case "栖霞":
			area = TradingArea.QIXIA;
			break;
		case "汤山":
			area = TradingArea.TANGSHAN;
			break;
		case "下关":
			area = TradingArea.XIAGUAN;
			break;
		case "仙林":
			area = TradingArea.XIANLIN;
			break;
		case "中央门":
			area = TradingArea.ZHONGYANGMEN;
			break;
		case "珠江路":
			area = TradingArea.ZHUJIANGLU;
			break;
		}
		return area;
	}
}
