package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PersonDetailPO;
import po.PersonListPO;
import util.ResultMessage;
import util.UserType;

public interface PersonnelDataHelper {
	public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException;

	public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID) throws RemoteException;

	public PersonDetailPO getPersonDetail(int userID) throws RemoteException;

	public ResultMessage setPerson(PersonDetailPO personDetailPO) throws RemoteException;

	public ResultMessage checkUserName(String userName) throws RemoteException;

}
