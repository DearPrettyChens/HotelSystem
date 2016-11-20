package businesslogic.bl.userbl;

import businesslogic.blservice.userblservice.UserMaintainInfoService;
import util.ResultMessage;
import util.Telephone;
import vo.personnelvo.PersonDetailVO;

/**
 * 
 * 负责维护个人信息的控制部分
 * @author csy
 *
 */
public class UserMaintainInfoController implements UserMaintainInfoService {
	// user对象
	private Customer customer;
	private static UserMaintainInfoService userMaintainInfoController;

	// 构造方法
	private UserMaintainInfoController() {
		customer = Customer.getInstance();
	}
	
	public static UserMaintainInfoService getInstance() {
		if (userMaintainInfoController==null){
			userMaintainInfoController=new UserMaintainInfoController();
		}
		return userMaintainInfoController;
	}
	
	@Override
	public ResultMessage checkTel(String tel) {
		return customer.checkTel(new Telephone(tel));
	}
	@Override
	public PersonDetailVO getDetailInfo(String userID) {
		return customer.getDetailInfo(userID);
	}

	@Override
	public ResultMessage confirmUserInfo(PersonDetailVO detailInfoVO) {
		return customer.modifyDetailInfo(detailInfoVO);
	}

	@Override
	public int getGrade(String userID) {
		return customer.getGrade(userID);
	}
	

}
