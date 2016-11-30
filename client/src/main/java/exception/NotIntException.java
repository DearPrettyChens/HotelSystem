package exception;
/**
 * string 变量不是 数值
 * @author CSY
 *
 */
public class NotIntException extends Exception{
	private String msgDes;
	
	public NotIntException(){
		super();
	}
	
	public NotIntException(String message){
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
