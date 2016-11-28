package exception;
/**
 * 未找到该编号订单的异常类
 * @author CLL
 *
 */
public class NotFoundOrderException extends RuntimeException{
	private String msgDes;  //异常对应的描述信息
	
	public NotFoundOrderException(){
		super();
	}
	
	public NotFoundOrderException(String message) {
		super(message);
		setMsgDes(message);
	}

	public String getMsgDes() {
		return msgDes;
	}

	public void setMsgDes(String msgDes) {
		this.msgDes = msgDes;
	}
	
}
