package businesslogic.bl.hotelbl.mock;

import businesslogic.bl.userbl.User;

/**
 * user的mock类
 * @author Csy
 * @version 1.0
 */
public class MockUser extends User {
	private String userID;
	    /**
	     * 获得用户ID 
	     * 实现的时候先判断ID是否为空
	     * @param name
	     * @return String
	     */
		public String getUserID(String name) {
			return "000001";
		}

}
