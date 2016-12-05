package presentation.ui.personnelui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.CustomerType;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

public class PersonnelBLService_Stub implements PersonnelBLService {

	/**
	 * 判断该用户名是否合法及是否被注册
	 * 
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkUserName(String userName) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 判断该电话是否符合格式正确
	 * 
	 * @param userTel
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkTel(String userTel) {
		if(userTel.length()==11){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 判断密码是否符合格式
	 * 
	 * @param password
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkPassword(String password) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 增加用户
	 * 
	 * @param personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		return ResultMessage.SUCCESS;
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
		ArrayList<PersonListVO> personListVOs = new ArrayList<PersonListVO>();
		switch (userType) {
		case Customer:
			personListVOs = getCustomerList(keyWord);
			break;
		case HotelWorker:
			personListVOs = getHotelWorkerList(keyWord);
			break;

		case WebMarketMan:
			personListVOs = getWebList(keyWord);
			break;

		}

		return personListVOs;
	}

	private ArrayList<PersonListVO> getHotelWorkerList(String keyWord) {
		ArrayList<PersonListVO> personListVOs = new ArrayList<PersonListVO>();

		PersonListVO personListVO1 = new PersonListVO("000001", "豆豆", new ImageIcon("image//hotel.jpg"), "12345678901",
				"锦江之星大酒店", UserType.HotelWorker);
		PersonListVO personListVO2 = new PersonListVO("000002", "豆豆", new ImageIcon("image//hotel.jpg"), "12345678901",
				"锦江之星大酒店", UserType.HotelWorker);
		PersonListVO personListVO3 = new PersonListVO("000003", "豆豆", new ImageIcon("image//hotel.jpg"), "12345678901",
				"锦江之星大酒店", UserType.HotelWorker);
		PersonListVO personListVO4 = new PersonListVO("000004", "豆豆", new ImageIcon("image//hotel.jpg"), "12345678901",
				"锦江之星大酒店", UserType.HotelWorker);
		PersonListVO personListVO5 = new PersonListVO("000005", "豆豆", new ImageIcon("image//hotel.jpg"), "12345678901",
				"锦江之星大酒店", UserType.HotelWorker);
		personListVOs.add(personListVO1);
		personListVOs.add(personListVO2);
		personListVOs.add(personListVO3);
		personListVOs.add(personListVO4);
		personListVOs.add(personListVO5);

		if (keyWord == null) {
			return personListVOs;
		}
		switch (keyWord) {
		case "000001":
			personListVOs.clear();
			personListVOs.add(personListVO1);
			break;
		case "000002":
			personListVOs.clear();
			personListVOs.add(personListVO2);
			break;
		case "000003":
			personListVOs.clear();
			personListVOs.add(personListVO3);
			break;
		case "000004":
			personListVOs.clear();
			personListVOs.add(personListVO4);
			break;
		case "000005":
			personListVOs.clear();
			personListVOs.add(personListVO5);
			break;
		}
		return personListVOs;
	}

	private ArrayList<PersonListVO> getWebList(String keyWord) {
		ArrayList<PersonListVO> personListVOs = new ArrayList<PersonListVO>();

		PersonListVO personListVO1 = new PersonListVO("000001", "俐俐", new ImageIcon("image//logo.png"), "12345678901",
				"锦江之星大酒店", UserType.WebMarketMan);
		PersonListVO personListVO2 = new PersonListVO("000002", "俐俐", new ImageIcon("image//logo.png"), "12345678901",
				"锦江之星大酒店", UserType.WebMarketMan);
		PersonListVO personListVO3 = new PersonListVO("000003", "俐俐", new ImageIcon("image//logo.png"), "12345678901",
				"锦江之星大酒店", UserType.WebMarketMan);
		PersonListVO personListVO4 = new PersonListVO("000004", "俐俐", new ImageIcon("image//logo.png"), "12345678901",
				"锦江之星大酒店", UserType.WebMarketMan);
		PersonListVO personListVO5 = new PersonListVO("000005", "俐俐", new ImageIcon("image//logo.png"), "12345678901",
				"锦江之星大酒店", UserType.WebMarketMan);
		personListVOs.add(personListVO1);
		personListVOs.add(personListVO2);
		personListVOs.add(personListVO3);
		personListVOs.add(personListVO4);
		personListVOs.add(personListVO5);

		if (keyWord == null) {
			return personListVOs;
		}
		switch (keyWord) {
		case "000001":
			personListVOs.clear();
			personListVOs.add(personListVO1);
			break;
		case "000002":
			personListVOs.clear();
			personListVOs.add(personListVO2);
			break;
		case "000003":
			personListVOs.clear();
			personListVOs.add(personListVO3);
			break;
		case "000004":
			personListVOs.clear();
			personListVOs.add(personListVO4);
			break;
		case "000005":
			personListVOs.clear();
			personListVOs.add(personListVO5);
			break;
		}
		return personListVOs;
	}

	private ArrayList<PersonListVO> getCustomerList(String keyWord) {
		ArrayList<PersonListVO> personListVOs = new ArrayList<PersonListVO>();

		PersonListVO personListVO1 = new PersonListVO("000001", "豆豆", new ImageIcon("image//customer.png"),
				"12345678901", "锦江之星大酒店", UserType.Customer);
		PersonListVO personListVO2 = new PersonListVO("000002", "豆豆", new ImageIcon("image//customer.png"),
				"12345678901", "锦江之星大酒店", UserType.Customer);
		PersonListVO personListVO3 = new PersonListVO("000003", "豆豆", new ImageIcon("image//customer.png"),
				"12345678901", "锦江之星大酒店", UserType.Customer);
		PersonListVO personListVO4 = new PersonListVO("000004", "豆豆", new ImageIcon("image//customer.png"),
				"12345678901", "锦江之星大酒店", UserType.Customer);
		PersonListVO personListVO5 = new PersonListVO("000005", "豆豆", new ImageIcon("image//customer.png"),
				"12345678901", "锦江之星大酒店", UserType.Customer);
		personListVOs.add(personListVO1);
		personListVOs.add(personListVO2);
		personListVOs.add(personListVO3);
		personListVOs.add(personListVO4);
		personListVOs.add(personListVO5);

		if (keyWord == null) {
			return personListVOs;
		}
		switch (keyWord) {
		case "000001":
			personListVOs.clear();
			personListVOs.add(personListVO1);
			break;
		case "000002":
			personListVOs.clear();
			personListVOs.add(personListVO2);
			break;
		case "000003":
			personListVOs.clear();
			personListVOs.add(personListVO3);
			break;
		case "000004":
			personListVOs.clear();
			personListVOs.add(personListVO4);
			break;
		case "000005":
			personListVOs.clear();
			personListVOs.add(personListVO5);
			break;
		}
		return personListVOs;
	}

	/**
	 * 得到用户详细信息
	 * 
	 * @param personID
	 * @return PersonDetailVO
	 * @throws 未定
	 */
	public PersonDetailVO getPersonDetail(String personID) {
		PersonDetailVO personDetailVO = null;
		switch (personID) {
		case "000001":
			personDetailVO = new PersonDetailVO("000001", "豆豆", "123456", new ImageIcon("image//hotel.jpg"),
					"12345678901", 20, new Date(), "南京大学", CustomerType.ENTERPRISE, "锦江之星大酒店", UserType.HotelWorker);
			break;

		case "000002":
			personDetailVO = new PersonDetailVO("000002", "豆豆", "123456", new ImageIcon("image//hotel.jpg"),
					"12345678901", 20, new Date(), null, CustomerType.INDIVIDUAL, "锦江之星大酒店", UserType.HotelWorker);
			break;

		case "000003":
			personDetailVO = new PersonDetailVO("000003", "豆豆", "123456", new ImageIcon("image//hotel.jpg"),
					"12345678901", 20, new Date(), "南京大学", CustomerType.ENTERPRISE, "锦江之星大酒店", UserType.HotelWorker);
			break;

		case "000004":
			personDetailVO = new PersonDetailVO("000004", "豆豆", "123456", new ImageIcon("image//hotel.jpg"),
					"12345678901", 20, new Date(), "南京大学", CustomerType.ENTERPRISE, "锦江之星大酒店", UserType.HotelWorker);
			break;

		case "000005":
			personDetailVO = new PersonDetailVO("000005", "豆豆", "123456", new ImageIcon("image//hotel.jpg"),
					"12345678901", 20, new Date(), "南京大学", CustomerType.ENTERPRISE, "锦江之星大酒店", UserType.HotelWorker);
			break;

		}
		return personDetailVO;
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
		return ResultMessage.SUCCESS;
	}

}
