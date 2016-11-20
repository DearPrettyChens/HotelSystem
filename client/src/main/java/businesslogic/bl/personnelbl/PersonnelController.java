package businesslogic.bl.personnelbl;

import java.util.ArrayList;

import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.Password;
import util.ResultMessage;
import util.Telephone;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

/**
 * Personnel模块的控制类
 * @author cy
 * @version 1.0
 * 
 */
public class PersonnelController implements PersonnelBLService {
	private Personnel personnel;
	private static PersonnelBLService personnelController;
	
	private PersonnelController(){
	    this.personnel=Personnel.getInstance();
	}
	
	public static PersonnelBLService getInstance(){
		if(personnelController==null){
			personnelController=new PersonnelController();
		}
		return personnelController;
	}
    
	@Override
	public ResultMessage checkUserName(String userName) {
		return personnel.checkUserName(userName);
	}

	
	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		return personnel.addPerson(personDetailVO);
	}

	@Override
	public PersonDetailVO getPersonDetail(UserType userType,String personID) {
		return personnel.getPersonDetail(userType,personID);
	}
	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		return personnel.setPerson(personDetailVO);
	}

	@Override
	public ResultMessage checkTel(String userTel) {
		return new Telephone(userTel).checkValid();
	}

	@Override
	public ResultMessage checkPassword(String password) {
		return new Password(password).checkValid();
	}

	@Override
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord){
		return personnel.getPersonList(userType, keyWord);
	}

}
