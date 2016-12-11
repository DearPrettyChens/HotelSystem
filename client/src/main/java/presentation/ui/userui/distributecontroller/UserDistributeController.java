package presentation.ui.userui.distributecontroller;

import businesslogic.bl.userbl.UserMaintainInfoController;
import businesslogic.blservice.userblservice.UserMaintainInfoService;
import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;

public class UserDistributeController {
	private static UserDistributeController controller=null;
	private UserMaintainInfoService userMaintainInfoService;
	private UserDistributeController(){
		userMaintainInfoService=UserMaintainInfoController.getInstance();
//		userMaintainInfoService=new UserMaintainInfoService_Stub();
	}
	public static UserDistributeController getInstance(){
		if(controller==null){
			controller=new UserDistributeController();
		}
		return controller;
	}
	
	/**
	 * 获取用户详细信息
	 * 
	 * @param name String型，传递用户名
	 * @return DetailInfoVO ，将用户详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public PersonDetailVO getDetailInfo(String userID){
		return userMaintainInfoService.getDetailInfo(userID);
	}

	/**
	 * 保存用户详细信息
	 * 
	 * @param detailInfoVO
	 *            DetailInfoVO型，界面传递过来的用户详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmUserInfo(PersonDetailVO detailInfoVO){
		return userMaintainInfoService.confirmUserInfo(detailInfoVO);
	}

	/**
	 * 检查电话格式
	 * @param tel String型，传递联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTel(String tel){
		return userMaintainInfoService.checkTel(tel);
	}
	/**
	 * 获取顾客会员等级
	 * 
	 * @param name
	 *            String型，传递用户名
	 * @return int，将顾客会员等级返回给界面
	 * @throws 未定
	 *
	 */
	public int getGrade(String userID){
		return userMaintainInfoService.getGrade(userID);
	}
	

}
