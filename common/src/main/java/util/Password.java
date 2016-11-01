
package util;

/**
 * 密码类
 * @author CYF
 * @version 1.0
 */
public class Password {
	//密码
	private String password;
	//构造方法
	public Password(String password){
		this.password=password;
	}
	/**
	 * 检查有效
	 * @return ResultMessage
	 */
	public ResultMessage checkValid(){
		return ResultMessage.PASSWORDFORMATERROR;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}