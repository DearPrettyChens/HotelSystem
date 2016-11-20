package businesslogic.blservice.userblservice;

import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;
/**
 * UserMaintainPersonalInformationService负责维护个人信息部分
 * @author CYF
 *
 */
public interface UserMaintainInfoService {

	/**
	 * 获取用户详细信息
	 * 
	 * @param name String型，传递用户名
	 * @return DetailInfoVO ，将用户详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public PersonDetailVO getDetailInfo(String userID);

	/**
	 * 保存用户详细信息
	 * 
	 * @param detailInfoVO
	 *            DetailInfoVO型，界面传递过来的用户详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmUserInfo(PersonDetailVO detailInfoVO);

	/**
	 * 检查电话格式
	 * @param tel String型，传递联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTel(String tel);
	/**
	 * 获取顾客会员等级
	 * 
	 * @param name
	 *            String型，传递用户名
	 * @return int，将顾客会员等级返回给界面
	 * @throws 未定
	 *
	 */
	public int getGrade(String userID);
	

}
