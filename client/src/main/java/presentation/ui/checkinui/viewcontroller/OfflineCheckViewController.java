package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;
/**
 * 线下入住退房界面跳转的控制器
 * @author CLL
 *
 */
public class OfflineCheckViewController implements OfflineCheckViewControllerService{
	private JPanel view;//发起界面跳转请求的panel
	public OfflineCheckViewController(JPanel panel){
		this.view=panel;
	}
	@Override
	public void setRoomNumberView() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void jumpToMainFrame() {
		// TODO Auto-generated method stub
		
	}

}
