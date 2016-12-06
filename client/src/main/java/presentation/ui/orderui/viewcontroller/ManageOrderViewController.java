package presentation.ui.orderui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.orderui.view.Orderdetailinfo_JPanel;
import presentation.ui.orderui.view.Searchorder_JPanel;
import util.UserType;

/**
 * 网站营销人员管理订单的控制器
 * @author CLL
 *
 */
public class ManageOrderViewController {
	private OrderPanelInWebMarketMan view;
	private static ManageOrderViewController manageOrderViewController;
	
	public static ManageOrderViewController getInstance(OrderPanelInWebMarketMan orderPanelInWebMarketMan) {
		if(manageOrderViewController==null){
			manageOrderViewController=new ManageOrderViewController(orderPanelInWebMarketMan);
		}
		return manageOrderViewController;
	}
	
	private ManageOrderViewController(OrderPanelInWebMarketMan panel){
		this.view=panel;
	}

	public void showOrderDetailInfo(String orderID) {
		view.changeToDetailPanel(orderID);
	}

//?
	public void closeOrderDetail() {
		view.removeAll();	
	}

	public void closeReturnCreditFrame(){
		view.closeReturnCreditFrame();
	}
	
	public void cancelOrder(String orderID) {
		view.changeToReturnCreditPanel(orderID);
	}

	public void jumpToMainFrame() {
		view.changeToLookPanel();
	}

}
