package exception;
/**
 * 没有城市和商圈不能进行检索
 * @author CSY
 *
 */
public class NullCityandTradingArea extends Exception {
	private String msgDes;
	
	public NullCityandTradingArea(){
		super();
	}
	
	public NullCityandTradingArea(String message){
		super(message);
		this.setMsgDes(message);
	}

	public String getMsgDes() {
		return msgDes;
	}

	public void setMsgDes(String msgDes) {
		this.msgDes = msgDes;
	}
}
