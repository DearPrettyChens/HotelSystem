package presentation.ui.loginui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.CustomerType;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;

public class PersonnelBLService_Stub implements PersonnelBLService{

	@Override
	public ResultMessage checkUserName(String userName) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTel(String userTel) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkPassword(String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonListVO> getPersonList(UserType userType, String keyWord) {
		// TODO Auto-generated method stub
		ArrayList<PersonListVO> list=new ArrayList<PersonListVO>();
		PersonListVO vo=new PersonListVO("000001","chen",null,"12345678999",null,UserType.Customer);
		PersonListVO vo2=new PersonListVO("000005","lily",null,"12345678999","绿地洲际酒店",UserType.HotelWorker);
		list.add(vo);
		list.add(vo2);
		return list;
	}

	@Override
	public PersonDetailVO getPersonDetail(String personID) {
		// TODO Auto-generated method stub
		PersonDetailVO vo=new PersonDetailVO("000001", "chen", "12345678", null, "12345678999",
			100, new Date(1997,8,20), "南京大学", CustomerType.INDIVIDUAL,null,
			UserType.Customer);
		return vo;
	}

	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
