package businesslogic.bl.personnelbl;

import java.util.ArrayList;

import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.Password;
import util.ResultMessage;
import util.Telephone;
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
	    this.personnel=new Personnel();
	}
	
	public static PersonnelBLService getInstance(){
		if(personnelController==null){
			personnelController=new PersonnelController();
		}
		return personnelController;
	}
    
	@Override
	public ResultMessage checkUserName(String userName) {
		// TODO Auto-generated method stub
		//调用Personnel.checkUserName
		return null;
	}

	
	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		//调用Personnel.addPerson
		return null;
	}
	@Override
	public ArrayList<PersonListVO> getPersonList(String keyWord) {
		// TODO Auto-generated method stub
		//调用 Personnel.getList
		return null;
	}
	@Override
	public PersonDetailVO getPersonDetail(String personID) {
		// TODO Auto-generated method stub
		//调用Personnel.getPersonDetail
		return null;
	}
	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		//调用Personnel.setPerson
		return null;
	}

	@Override
	public ResultMessage checkTel(Telephone userTel) {
		// TODO Auto-generated method stub
		
	//调用Personnel.checkTel
		return null;
	}

	@Override
	public ResultMessage checkPassword(Password password) {
		// TODO Auto-generated method stub
		//调用Personnel.checkPassword
		return null;
	}

}
