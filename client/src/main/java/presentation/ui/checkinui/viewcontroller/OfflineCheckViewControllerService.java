package presentation.ui.checkinui.viewcontroller;
/**
 * 控制线下入住退房界面跳转的接口
 * @author CLL
 *
 */
public interface OfflineCheckViewControllerService {
	/**
	 * 跳转到手动更改可用房间数界面
	 */
	public void setRoomNumberView();
	/**
	 * 返回主界面
	 */
	public void jumpToMainFrame();
}
