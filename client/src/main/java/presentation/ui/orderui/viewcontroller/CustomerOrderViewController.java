package presentation.ui.orderui.viewcontroller;

import presentation.ui.orderui.view.client.CancleOrdertoClient_JFrame;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import vo.ordervo.OrderListVO;

public class CustomerOrderViewController {
	private ChooseOrderTypetoClient_JPanel view;
	private static CustomerOrderViewController controller;

	public static CustomerOrderViewController getInstance(ChooseOrderTypetoClient_JPanel panel) {
		if(controller==null){
			controller=new CustomerOrderViewController(panel);
		}
		return controller;
	}
	
	private CustomerOrderViewController(ChooseOrderTypetoClient_JPanel panel) {
		this.view = panel;
	}
	
	public void returnToOrderListFromRemark() {
		view.returnToOrderListPanelFromRemark();
	}
	
	public void returnToOrderListFromDetail(){
		view.returnToOrderListPanelFromDetail();
	}
	
	public void changeToDetailPanel(String orderID) {
		view.changeToDetailPanel(orderID);
	}

	public void changeToRemarkPanel(OrderListVO orderListVO) {

		view.changeToRemarkPanel(orderListVO);
	}
	
	public void jumpCancleJFrame(String orderID){
		new CancleOrdertoClient_JFrame(orderID);
	}
}
