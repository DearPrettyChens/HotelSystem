package businesslogic.bl.availableroombl.mock;

/**
 * user的mock类
 * @author CYF
 *
 */
public class MockUser {
	// 不变的属性 ID
	private String userID;

	public MockUser() {
		super();
	}

	/**
	 * 获得用户ID 实现的时候先判断ID是否为空
	 * 
	 * @param name
	 * @return String
	 */
	public String getUserID() {
		return "0001";
	}

}
