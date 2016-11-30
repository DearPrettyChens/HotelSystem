package businesslogic.bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dao.personneldao.PersonnelDao;
import po.PersonDetailPO;
import po.PersonListPO;
import util.CustomerType;
import util.ResultMessage;
import util.UserType;

/**
 * 
 * 模拟PersonnelDao的实现
 * @author CSY
 *
 */
public class PersonnelDao_Stub implements PersonnelDao{

	@Override
	public ResultMessage checkUserName(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID)
			throws RemoteException {
		 ArrayList<PersonListPO> personListPOs=new ArrayList<PersonListPO>();
		PersonListPO personListPO=new PersonListPO(1, "小俐俐", null, "12345678901", "锦江之星大酒店", UserType.HotelWorker);
		personListPOs.add(personListPO);
		return personListPOs;
	}

	@Override
	public PersonDetailPO getPersonDetail(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return new PersonDetailPO(2, "小菲菲", null, "12345678901", 100, new Date(1997, 4, 14),null, CustomerType.INDIVIDUAL, "feifei", null, UserType.Customer);
	}

	@Override
	public ResultMessage setPerson(PersonDetailPO personDetailPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
