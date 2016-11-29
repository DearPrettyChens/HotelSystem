package exception;

public class NullCustomerIDException extends RuntimeException{
	private String msgDes;
	
	public NullCustomerIDException(){
		super();
	}
	
	public NullCustomerIDException(String message){
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
