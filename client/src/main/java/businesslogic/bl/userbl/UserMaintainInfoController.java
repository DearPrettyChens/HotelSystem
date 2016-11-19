package businesslogic.bl.userbl;

import businesslogic.blservice.userblservice.UserMaintainInfoService;
import util.ResultMessage;
import util.Telephone;
import vo.uservo.DetailInfoVO;

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
		customer = new Customer();
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
	public DetailInfoVO getDetailInfo(String name) {
		return customer.getDetailInfo(name);
	}

	@Override
	public ResultMessage confirmUserInfo(DetailInfoVO detailInfoVO) {
		return customer.modifyDetailInfo(detailInfoVO);
	}

	@Override
	public int getGrade(String name) {
		return customer.getGrade(name);
	}
	

}
