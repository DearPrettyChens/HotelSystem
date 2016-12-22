package presentation.ui.orderui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.creditui.view.ClientDepositeSearch_JPanel;
import presentation.ui.creditui.view.Clientdeposite_JPanel;
import presentation.ui.creditui.view.ReturnHalforAll_JFrame;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;

/**
 * 
 * 网站营销人员管理订单选项的总界面
 * 
 * @author csy
 *
 */
public class OrderPanelInWebMarketMan extends JPanel {
	private LookOrderPanelInWeb_JPanel lookOrderPanelInWeb_JPanel;
	private Orderdetailinfo_JPanel orderdetailinfo_JPanel;
	private ReturnHalforAll_JFrame returnHalforAll_JFrame;
	private static OrderPanelInWebMarketMan orderPanelInWebMarketMan;
	private ManageOrderViewController manageOrderViewController=ManageOrderViewController.getInstance(this);
	
	public static OrderPanelInWebMarketMan getInstance() {
		if(orderPanelInWebMarketMan==null){
			orderPanelInWebMarketMan=new OrderPanelInWebMarketMan();
		}
		return orderPanelInWebMarketMan;
	}
	
	
	private OrderPanelInWebMarketMan() {
		this.setBackground(Color.white);
		this.setBounds(0, 0,800, 600);
		this.setLayout(null);
		changeToLookPanel();
	}

	public void changeToLookPanel() {
        this.removeAll();
        lookOrderPanelInWeb_JPanel=new LookOrderPanelInWeb_JPanel();
        this.add(lookOrderPanelInWeb_JPanel);
        this.updateUI();
	}

	public void changeToDetailPanel(String id) {
		this.removeAll();
		orderdetailinfo_JPanel=new Orderdetailinfo_JPanel(id);
		this.add(orderdetailinfo_JPanel);
		this.updateUI();
	}
	
	public void changeToReturnCreditPanel(String orderID) {
		this.removeAll();
		returnHalforAll_JFrame = new ReturnHalforAll_JFrame(orderID);

	}
	
	public void closeReturnCreditFrame(){
		if(returnHalforAll_JFrame!=null){
			returnHalforAll_JFrame.dispose();
		}
	}
	
}
