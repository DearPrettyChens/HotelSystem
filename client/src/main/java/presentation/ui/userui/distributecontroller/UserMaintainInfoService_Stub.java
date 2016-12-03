package presentation.ui.userui.distributecontroller;

import java.util.Date;

import businesslogic.blservice.userblservice.UserMaintainInfoService;
import util.CustomerType;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

public class UserMaintainInfoService_Stub implements UserMaintainInfoService{

	@Override
	public PersonDetailVO getDetailInfo(String userID) {
		// TODO Auto-generated method stub
		PersonDetailVO vo=new PersonDetailVO("000001", "chen", "12345678", null, 
				"12345678999",100, new Date(1997,8,20), "南京大学", CustomerType.INDIVIDUAL,
				null,UserType.Customer);
		return vo;
	}

	@Override
	public ResultMessage confirmUserInfo(PersonDetailVO detailInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTel(String tel) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getGrade(String userID) {
		// TODO Auto-generated method stub
		return 2;
	}

}
