package exception;

public class NullCityandTradingArea extends RuntimeException{
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
