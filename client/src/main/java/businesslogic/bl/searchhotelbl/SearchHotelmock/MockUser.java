package businesslogic.bl.searchhotelbl.SearchHotelmock;


import util.Password;
import util.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;
import businesslogic.blservice.orderblservice.*;
import businesslogic.bl.userbl.*;




/**
 * User的mock类
 * @author cy
 * @version 1.0
 * 
 */
public class MockUser extends UserSafetyController{
	
		public String getUserID(String name) {
			return "123";
		}

}
