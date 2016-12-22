
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
		String regex="[0-9A-Za-z]{4,10}";//检查是否是4-10位的数字或字母
		if(password==null){
			return ResultMessage.PASSWORDNOTNULL;
		}
		if(!password.matches(regex)){
			return ResultMessage.PASSWORDFORMATERROR;
		}
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 每次返回密码前都需判断密码格式是否正确
	 * @return password
	 */
	public String getPassword() {
		if(checkValid()==ResultMessage.SUCCESS){
			return password;
		}
		return null;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}