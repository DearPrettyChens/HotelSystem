package presentation.ui.creditui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.creditui.view.Clientdeposite_JPanel;
import presentation.ui.creditui.view.DepositPanel;
/**
 * 充值信用界面的控制器
 * @author CLL
 *
 */
public class DepositCreditViewControllerImpl {
	private DepositPanel view;
	private static DepositCreditViewControllerImpl depositCreditViewControllerImpl;
	
	
	private DepositCreditViewControllerImpl(DepositPanel panel){
		this.view=panel;
	}
	
	public static DepositCreditViewControllerImpl getInstance(DepositPanel panel) {
		if(depositCreditViewControllerImpl==null){
			depositCreditViewControllerImpl=new DepositCreditViewControllerImpl(panel);
		}
		return depositCreditViewControllerImpl;
	}
	
	public void jumpToCreditDepositePanel(String id) {
		view.changeToCreditPanel(id);
	}
	
	public void jumpToSearchPanel() {
		view.changeToSearchPanel();
		
	}

}
