package exception;

public class NullOrderIDException extends RuntimeException{
	private String msgDes;
	
	public NullOrderIDException(){
		super();
	}
	
	public NullOrderIDException(String message){
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
