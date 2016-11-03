package businesslogic.bl.userbl.mock;

import java.util.Date;

import javax.swing.ImageIcon;

import businesslogic.bl.personnelbl.Personnel;
import vo.personnelvo.PersonDetailVO;
/**
 * personnel的mock类
 * @author Csy
 * @version 1.0
 */
public class MockPersonnel extends Personnel{
	/**
	 * 得到用户详细信息
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 * 需接口：PersonList.getPerson
	 */
	public PersonDetailVO getPersonDetail(String personID){
		return new PersonDetailVO("000001", "小豆", new ImageIcon(), "12345678901", 100, new Date(), 23, "123456", "汉庭");
	}
}
