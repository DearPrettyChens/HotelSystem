package presentation.ui.availableroomui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.availableroomui.view.RoomInfo_JPanel;

/**
 * 客房信息界面跳转的控制器
 * @author CLL
 *
 */
public class AvailableRoomViewControllerImpl implements AvailableRoomViewControllerService{
	private JPanel view;//发起界面跳转请求的界面对象
	public AvailableRoomViewControllerImpl(JPanel panel){
		this.view=panel;
	}
	@Override
	public void addRoomInfoSuccess() {
		view=new RoomInfo_JPanel();
	}

	@Override
	public void jumpToMainFrame() {
		view=null;
	}

}
