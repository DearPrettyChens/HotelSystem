package dao.personneldao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PersonDetailPO;
import po.PersonListPO;
import util.ResultMessage;
import util.UserType;

/**
 * PersonnelDao提供借口，用来进行对账户数据的一系列操作，包括注册、添加、获取、设置网站用户的信息
 * @author CYF
 * @version 1.0
 *
 */


public interface PersonnelDao extends Remote {

	/**判断该用户名是否被注册
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkUserName(String userName)throws RemoteException;
	
	/**
	 *新增人员信息
	 * @param personDetailPO PersonDetailPO型，用来新增人员的详细信息
	 * @return ResultMessage，如果注册成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 * 
	 */
	public ResultMessage addPerson(PersonDetailPO personDetailPO)throws RemoteException;

	/**
	 * 获得人员列表信息
	 * @param 无
	 * @return ArrayList<PersonListPO> 用来获取酒店工作人员列表信息
	 * @throws 未定
	 * usertype限定当前搜索的是哪种人，可根据用户编号查询，也可根据用户名查询。当根据用户名查询时，只要用户名中包含有传递进来的userName的关键词，就进行返回
	 * 如果编号和名字都为null，就返回该种人的全部列表信息
	 * 
	 */
	public ArrayList<PersonListPO>  getPersonList(UserType userType,String userName,int userID)throws RemoteException;
	
	/**
	 * 获得人员详细信息
	 * @param customerID String型 用来传递顾客ID
	 * @return CustomerDetailPO 用来获取顾客详细信息
	 * @throws 未定
	 */
	public PersonDetailPO  getPersonDetail(int userID)throws RemoteException;
	/**
	 * 设置酒店工作人员信息
	 * @param hotelWorkerDetailPO HotelWorkerDetailPO型 用来传递酒店工作人员信息
	 * @return ResultMessage，如果修改成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setPerson (PersonDetailPO personDetailPO)throws RemoteException;
	
}
