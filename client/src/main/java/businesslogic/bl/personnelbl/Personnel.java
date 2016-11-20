package businesslogic.bl.personnelbl;

import java.util.ArrayList;

import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

/**
 * personnel模块的领域类
 * @author cy
 * @version 1.0
 * 
 */
public class Personnel {
	
	
	/**判断该用户名是否合法及是否被注册
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkUserName(String userName) {
		
		return null;
	}

	/**
	 * 增加用户
	 * @param personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 * 需接口：Person.addPerson
	 */
	public ResultMessage addPerson(PersonDetailVO personDetailVO){
		return null;
	}
	/**
	 * 得到用户详细信息
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 * 需接口：PersonList.getPerson
	 */
	public PersonDetailVO getPersonDetail(String personID){
		return null;
	}
	
	/**
	 * 修改用户信息
	 * @param PersonDetailVO personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 * 需接口：Person.setPerson
	 */
	public ResultMessage setPerson (PersonDetailVO personDetailVO){
		return null;
	}

	/**
	 * 得到用户列表信息
	 * @param userType,keyWord
	 * @return  ArrayList<PersonListVO>
	 * @throws 未定
	 * 检索用户名或者是ID
	 */
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}
}
