package businesslogic.bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.personneldao.PersonnelDao;
import init.RMIHelper;
import po.PersonListPO;
import util.TransHelper;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 
 * 人员列表
 * @author CSY
 *
 */
public class PersonList {
	private ArrayList<PersonListPO> personListPOs;
	private PersonnelDao personnelDao;

	private static PersonList personList;

	private PersonList() {
		RMIHelper.init();
		personnelDao = RMIHelper.getPersonnelDao();
//		personnelDao=new PersonnelDao_Stub();
		
	}

	public static PersonList getInstance() {
		if (personList == null) {
			personList = new PersonList();
		}
		return personList;
	}

	/**
	 * 得到用户列表信息
	 * 
	 * @param userType,keyWord
	 * @return ArrayList<PersonListVO>
	 * @throws 未定
	 * 检索用户名或者是ID(限定输入必须是6位)
	 */
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord) {
		String regex = "[0-9]{6}";
		String userName = null;
		String userID = null;
        ArrayList<PersonListVO> personListVOs=new ArrayList<PersonListVO>();
		
        if ((keyWord!=null)&&(keyWord.matches(regex)) ){
			userID=keyWord;
		}else{
			userName=keyWord;
		}
		
		try {
			personListPOs=personnelDao.getPersonList(userType, userName, TransHelper.idToInt(userID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		for(PersonListPO personListPO:personListPOs){
			personListVOs.add(new PersonListVO(personListPO));
		}
		
		return personListVOs;
	}
}
