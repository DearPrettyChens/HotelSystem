
package util;

/**
 * 联系方式类
 * 
 * @author CYF
 * @version 1.0
 */
public class Telephone {
	// 联系方式
	private String telephone;

	// 构造方法
	public Telephone(String tel) {
		this.telephone = tel;
	}

	/**
	 * 检查是否有效
	 * 用正则表达式进行判断
	 * @return ResultMessage
	 */
	public ResultMessage checkValid() {
		String regex = "[0-9]{11}";
		if (telephone.matches(regex)) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

//	public static void main(String[] args) {
//		System.out.println(new Telephone("123").checkValid());
//		System.out.println(new Telephone("12310200022").checkValid());
//		System.out.println(new Telephone("zzzzzzzzzzz").checkValid());
//		System.out.println(new Telephone("111111111111").checkValid());
//	}
}
