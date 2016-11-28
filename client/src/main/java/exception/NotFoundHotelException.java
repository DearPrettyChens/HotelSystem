package exception;
/**
 * 未找到该编号酒店的异常类
 * @author CLL
 *
 */
public class NotFoundHotelException extends RuntimeException{
	private String msgDes;
	
	public NotFoundHotelException(){
		super();
	}
	
	public NotFoundHotelException(String message){
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
