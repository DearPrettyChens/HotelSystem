package presentation.ui.personnelui.viewcontroller;

import util.UserType;

/**
 * 控制personnel界面的接口
 * @author CLL
 *
 */
public interface PersonnelControllerService {
	/**
	 * 打开查看或修改三种人员详细信息的窗口
	 */
	public void showHotelWorkerDetailInfo(String image,String id,String name,String tel,String type,String password,String hotelname);
	
	public void showWebMarketManDetailInfo(String id,String name,String tel,String type,String password);
	
	public void showCustomerDetailInfo(String id,String name,String tel,String type,String password);
	/**
	 * 增加人员的面板
	 */
	public void addUserView(UserType type,String id);
	/**
	 * 搜索人员的面板
	 */
	public void searchUserView(UserType type);
	/**
	 * 返回到更新后的列表界面
	 */
	public void jumpToUpdatedUserListView(UserType type);
	/**
	 * 关闭详细信息窗口
	 */
	public void closeDetailInfoFrame();
}
