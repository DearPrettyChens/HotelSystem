package businesslogic.bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

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
//		RMIHelper.init();
//		personnelDao = RMIHelper.getPersonnelDao();
		personnelDao=new PersonnelDao_Stub();
		
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
			if(userName!=null){
				personListVOs=getListByUserName(userType, userName);
			}
			if(userID!=null){
				personListVOs=getListByUserID(userType,  TransHelper.idToInt(userID));
			}
			
			personListPOs=personnelDao.getPersonList(userType, null, -1);
			if(personListPOs==null) return null;
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		for(PersonListPO personListPO:personListPOs){
			personListVOs.add(new PersonListVO(personListPO));
		}
		
		if(personListVOs.isEmpty()) return null;		
		return personListVOs;
	}
	
	/**
	 * 根据用户名进行检索
	 * @param userType
	 * @param userName
	 * @return
	 */
	private ArrayList<PersonListVO> getListByUserName(UserType userType,String userName) {
		  ArrayList<PersonListVO> personListVOs=new ArrayList<PersonListVO>();
		try {
			
				personListPOs=personnelDao.getPersonList(null, userName, -1);
				if (personListPOs==null) return null;
				for(PersonListPO personListPO:personListPOs){
					if(personListPO.getUserType()==userType){
						personListVOs.add(new PersonListVO(personListPO));
					}			
				}
				if(personListVOs.isEmpty()) return null;
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return personListVOs;
	}

	/**
	 * 根据用户编号进行检索
	 * @param userType
	 * @param userid
	 * @return
	 */
    private ArrayList<PersonListVO> getListByUserID(UserType userType,int userID){
    	  ArrayList<PersonListVO> personListVOs=new ArrayList<PersonListVO>();
  		try {
  				personListPOs=personnelDao.getPersonList(null, null, userID);
  				if (personListPOs==null) return null;
  				for(PersonListPO personListPO:personListPOs){
  					if(personListPO.getUserType()==userType){
  						personListVOs.add(new PersonListVO(personListPO));
  					}			
  				}
               if (personListVOs.isEmpty()) return null;//便于界面判断
  			
  		} catch (RemoteException e) {
  			e.printStackTrace();
  		}
  		return personListVOs;
    }



}
