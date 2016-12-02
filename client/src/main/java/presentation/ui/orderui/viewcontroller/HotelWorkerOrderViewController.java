package presentation.ui.orderui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.orderui.view.OrderDetailInfoToHotelWorker_JPanel;
import presentation.ui.orderui.view.Orderdetailinfo_JPanel;
/**
 * 酒店工作人员查看订单界面的控制器
 * @author CLL
 *
 */
public class HotelWorkerOrderViewController implements HotelWorkerOrderViewControllerService{
	private JPanel view;//发起界面跳转请求的界面（订单列表面板）
	public HotelWorkerOrderViewController(JPanel panel){
		this.view=panel;
	}
	
	@Override
	public void showOrderDetailInfo(String ordernumber,String clientnumber,String tel,
			String bedtype,String ordertime,String orderstate,String latestcheckintime
			,String checkouttime,double price, String checkintime,String isremarked) {
		view.removeAll();
		view.add(new OrderDetailInfoToHotelWorker_JPanel(ordernumber,clientnumber,tel,bedtype,
				ordertime,orderstate,latestcheckintime,checkouttime,price,checkintime,isremarked));
	}

	@Override
	public void closeOrderDetail() {
		view.removeAll();
	}
	
	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}

}
