package presentation.ui.creditui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.creditui.viewcontroller.DepositCreditViewControllerImpl;

/**
 * 
 * 信用充值总面板
 * 
 * @author csy
 *
 */
public class DepositPanel extends JPanel {
	private ClientDepositeSearch_JPanel clientDepositeSearch_JPanel;
	private Clientdeposite_JPanel clientdeposite_JPanel;
	private DepositCreditViewControllerImpl depositCreditViewControllerImpl=DepositCreditViewControllerImpl.getInstance(this);
	private static DepositPanel depositPanel;
	
	public static DepositPanel getInstance() {
		if(depositPanel==null){
			depositPanel=new DepositPanel();
		}
		return depositPanel;
	}
	
	private DepositPanel() {
		this.setLayout(null);
		this.setBackground(Color.white);
		changeToSearchPanel();
		this.setSize(800, 600);
	}

	/**
	 * 跳到信用充值检索界面
	 */
	public void changeToSearchPanel() {
        this.removeAll();
        clientDepositeSearch_JPanel=new ClientDepositeSearch_JPanel();
        this.add(clientDepositeSearch_JPanel);
        this.updateUI();
	}

	/**
	 * 跳到信用充值输入信用值界面
	 */
	public void changeToCreditPanel(String id) {
		this.removeAll();
		clientdeposite_JPanel=new Clientdeposite_JPanel(id);
        this.add(clientdeposite_JPanel) ;
		this.updateUI();
	}
}
