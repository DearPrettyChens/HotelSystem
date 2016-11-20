package businesslogic.bl.personnelbl;

import java.rmi.RemoteException;

import dao.personneldao.PersonnelDao;
import init.RMIHelper;
import util.ResultMessage;
import util.TransHelper;
import vo.personnelvo.PersonDetailVO;

/**
 * 顾客详细信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Customer implements Person {
    private static Person customer;
	private PersonnelDao personnelDao;

    private Customer() {
        personnelDao=RMIHelper.getPersonnelDao();
	}
    public static Person getInstance() {
		if(customer==null){
			customer=new Customer();
		}
		return customer;
	}

	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		
		try {
			return personnelDao.addPerson(personDetailVO.toPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public PersonDetailVO getDetail(String customerID) {
		
		try {
			return new PersonDetailVO(personnelDao.getPersonDetail(TransHelper.idToInt(customerID)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		try {
			return personnelDao.setPerson(personDetailVO.toPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
