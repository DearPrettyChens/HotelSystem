package businesslogic.blservice.personnelblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

/**
 * PersonnelBLService提供接口，用来对用户信息的增改查的管理，注册会员
 * @author csy
 * @version 1.0
 * 
 */
public interface PersonnelBLService {
	
	/**判断该用户名是否合法及是否被注册
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkUserName(String userName); 
	

	/**判断该电话是否符合格式正确
	 * @param userTel
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkTel(String userTel) ;

	

	/**判断密码是否符合格式
	 * @param password
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkPassword(String password);

	/**
	 * 增加用户
	 * @param personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage addPerson(PersonDetailVO personDetailVO);

	/**
	 * 得到用户列表信息
	 * @param userType,keyWord
	 * @return  ArrayList<PersonListVO>
	 * @throws 未定
	 * 检索用户名或者是ID
	 */
	public ArrayList<PersonListVO> getPersonList(UserType userType,String keyWord);
	/**
	 * 得到用户详细信息
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 */
	public PersonDetailVO getPersonDetail(String personID);
	/**
	 * 修改用户信息
	 * @param PersonDetailVO personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage setPerson (PersonDetailVO personDetailVO);
}
