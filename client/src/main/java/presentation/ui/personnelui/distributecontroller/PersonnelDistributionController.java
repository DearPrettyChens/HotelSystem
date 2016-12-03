package presentation.ui.personnelui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.personnelbl.PersonnelController;
import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

/**
 * personnel界面调用逻辑层的控制类
 * 
 * @author CLL
 *
 */
public class PersonnelDistributionController {
	private static PersonnelDistributionController controller = null;
	private PersonnelBLService personnelBLService;

	private PersonnelDistributionController() {
		// personnelBLService=PersonnelController.getInstance();
		personnelBLService = new PersonnelBLService_Stub();
	}

	public static PersonnelDistributionController getInstance() {
		if (controller == null) {
			controller = new PersonnelDistributionController();
		}
		return controller;
	}

	/**
	 * 得到用户列表信息
	 * 
	 * @param userType,keyWord
	 * @return ArrayList<PersonListVO>
	 * @throws 未定
	 *             检索用户名或者是ID
	 */
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord) {
		return personnelBLService.getPersonList(userType, keyWord);
	}

	/**
	 * 得到用户详细信息
	 * 
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 */
	public PersonDetailVO getPersonDetail(String personID) {
		return personnelBLService.getPersonDetail(personID);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param PersonDetailVO
	 *            personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		return personnelBLService.setPerson(personDetailVO);
	}
}
