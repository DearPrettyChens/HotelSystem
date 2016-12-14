package businesslogic.bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.creditbl.Credit;
import dao.personneldao.PersonnelDao;
import init.RMIHelper;
import po.PersonDetailPO;
import util.ResultMessage;
import util.TransHelper;
import util.UserType;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

/**
 * personnel模块的领域类
 * @author cy
 * @version 1.0
 * 
 */
public class Personnel {
	private PersonList personList;
    private PersonDetailPO personDetailPO;
	private PersonnelDao personnelDao;
	private static Personnel personnel;
	
	private Personnel() {
		RMIHelper.init();
		personnelDao=RMIHelper.getPersonnelDao();
//	personnelDao=new PersonnelDao_Stub();
	
	}	
	public static Personnel getInstance() {
		if(personnel==null){
			personnel=new Personnel();
		}
		return personnel;
	}
	


	/**判断该用户名是否合法及是否被注册
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 * 
	 * 用户名是2-8位字母数字或中文
	 */
	public ResultMessage checkUserName(String userName) {
		String regex="[0-9A-Za-z\u4e00-\u9fa5]{2,8}";
		
		//检查输入的用户名是否为空
		if(userName==null){
			return ResultMessage.USERNOTNULL;
		}
		
		//检查用户名格式
		if(!userName.matches(regex)){
			return ResultMessage.USERFORMATERROR;
		}
		
		//检查用户名是否已存在
		try {
			return personnelDao.checkUserName(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.SUCCESS;
	}
	
//	public static void main(String[] args) {
//	System.out.println(new Personnel().checkUserName("1"));
//	System.out.println(new Personnel().checkUserName("小豆豆豆"));
//	System.out.println(new Personnel().checkUserName("0000000000000000"));
//	System.out.println(new Personnel().checkUserName("踩踩踩踩踩ddd"));
//}

	/**
	 * 增加用户
	 * @param personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 * 需接口：Person.addPerson
	 */
	public ResultMessage addPerson(PersonDetailVO personDetailVO){
		personDetailPO=personDetailVO.toPO();
		try {
			return personnelDao.addPerson(personDetailPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	/**
	 * 得到用户详细信息
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 * 需接口：PersonList.getPerson
	 */
	public PersonDetailVO getPersonDetail(String personID){
		try {
			personDetailPO=personnelDao.getPersonDetail(TransHelper.idToInt(personID));
		    Credit credit = new Credit(personID);
		    CreditInfoVO creditInfoVO=credit.getUserCreditInfoList();
		    ArrayList<CreditVO> creditVOs=creditInfoVO.getCreditinfo();
		    CreditVO creditVO=creditVOs.get(creditVOs.size()-1);
		    int creditNumber=creditVO.getCredit();
		    PersonDetailVO personDetailVO=new PersonDetailVO(personDetailPO);
		    personDetailVO.setCredit(creditNumber);
		    return personDetailVO;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		personDetailPO=personDetailVO.toPO();
		try {
			return personnelDao.setPerson(personDetailPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 得到用户列表信息
	 * @param userType,keyWord
	 * @return  ArrayList<PersonListVO>
	 * @throws 未定
	 * 检索用户名或者是ID
	 */
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord) {
		personList=PersonList.getInstance();
		return personList.getPersonList(userType, keyWord);
	}
	

}
