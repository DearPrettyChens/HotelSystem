package presentation.ui.creditui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.creditui.view.Clientdeposite_JPanel;
/**
 * 充值信用界面的控制器
 * @author CLL
 *
 */
public class DepositCreditViewControllerImpl implements DepositCreditViewControllerService{
	private JPanel view;
	public DepositCreditViewControllerImpl(JPanel panel){
		this.view=panel;
	}
	@Override
	public void depositCreditSuccess() {
		view=new Clientdeposite_JPanel();
	}
	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}

}
