package exception;
/**
 * 两个对应数组大小未能正常匹配的异常类
 * @author csy
 *
 */
public class SizeNotEqualException extends Exception {
private String msgDes;
	
	public SizeNotEqualException(){
		super();
	}
	
	public SizeNotEqualException(String message){
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
