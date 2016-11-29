package exception;

public class NullHotelIDException extends RuntimeException{
	private String msgDes;
	
	public NullHotelIDException(){
		super();
	}
	
	public NullHotelIDException(String message){
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
