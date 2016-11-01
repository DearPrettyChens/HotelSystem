package businesslogic.bl.personnelbl;

import java.util.ArrayList;

import util.Password;
import util.ResultMessage;
import util.Telephone;
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

	/**判断该电话是否符合格式正确
	 * @param userTel
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkTel(Telephone userTel) {
		
		return null;
	}

	

	/**判断密码是否符合格式
	 * @param password
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkPassword(Password password) {
		
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
	 * 得到用户列表信息
	 * @param keyWord
	 * @return  ArrayList<PersonListVO>
	 * @throws 未定
	 * 需接口：PersonList.init
	 */
	public ArrayList<PersonListVO> getPersonList(String keyWord){
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

}
