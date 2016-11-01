package businesslogic.bl.userbl;

import businesslogic.blservice.userblservice.UserMaintainPersonalInformationService;
import util.ResultMessage;
import util.Telephone;
import vo.uservo.DetailInfoVO;

public class UserMaintainPersonnalInformationController implements UserMaintainPersonalInformationService {
	// user对象
	private Customer customer;

	// 构造方法
	public UserMaintainPersonnalInformationController() {
		customer = new Customer();
	}
	@Override
	public ResultMessage checkTel(String tel) {
		return customer.checkTel(new Telephone(tel));
	}
	@Override
	public DetailInfoVO getDetailInfo(String name) {
		return customer.getDetailInfo(name);
	}

	@Override
	public ResultMessage confirmUserInfo(DetailInfoVO detailInfoVO) {
		return customer.modifyDetailInfo(detailInfoVO);
	}

	@Override
	public int getGrade(String name) {
		return 0;
	}

}
