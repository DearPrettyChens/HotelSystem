package presentation.ui.availableroomui.viewcontroller;
/**
 * 控制客房信息界面的接口
 * @author CLL
 *
 */
public interface AvailableRoomViewControllerService {
	/**
	 * 成功录入客房信息更新客房信息列表
	 */
	public void addRoomInfoSuccess();
	/**
	 * 取消录入客房信息,跳转到酒店工作人员主界面
	 */
	public void jumpToMainFrame();
}
