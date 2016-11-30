package presentation.ui.orderui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.orderui.view.Orderdetailinfo_JPanel;
import presentation.ui.orderui.view.Searchorder_JPanel;
import util.UserType;

/**
 * 网站营销人员管理订单的控制器
 * @author CLL
 *
 */
public class ManageOrderViewController implements ManageOrderViewControllerService{
	private JPanel view;
	public ManageOrderViewController(JPanel panel){
		this.view=panel;
	}
	@Override
	public void showOrderDetailInfo(String ordernumber, String clientname, String clienttel, String ordertime,
			String latestcheckintime, String realcheckintime, String checkouttime, String orderstate, String hotelname,
			String hoteltel, String payment, String roomtype, String bedtype) {
		view.removeAll();
		view.add(new Orderdetailinfo_JPanel(ordernumber,clientname,clienttel,ordertime,
				latestcheckintime,realcheckintime,checkouttime,orderstate,hotelname,
				hoteltel,payment,roomtype,bedtype));
		
	}

	@Override
	public void closeOrderDetail() {
		view.removeAll();	
	}

	@Override
	public void cancelOrder() {
		view=new Searchorder_JPanel(UserType.WebMarketMan);
	}

}
