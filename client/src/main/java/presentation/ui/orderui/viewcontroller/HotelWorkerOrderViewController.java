package presentation.ui.orderui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.orderui.view.OrderDetailInfoToHotelWorker_JPanel;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.orderui.view.OrderPanelViewInHotelWorker;
import presentation.ui.orderui.view.Orderdetailinfo_JPanel;
/**
 * 酒店工作人员查看订单界面的控制器
 * @author CLL
 *
 */
public class HotelWorkerOrderViewController {
	private OrderPanelViewInHotelWorker view;
	private static HotelWorkerOrderViewController hotelWorkerOrderViewController;
	
	public static HotelWorkerOrderViewController getInstance(OrderPanelViewInHotelWorker orderPanelViewInHotelWorker) {
		if(hotelWorkerOrderViewController==null){
			hotelWorkerOrderViewController=new HotelWorkerOrderViewController(orderPanelViewInHotelWorker);
		}
		return hotelWorkerOrderViewController;
	}
	
	private HotelWorkerOrderViewController(OrderPanelViewInHotelWorker panel){
		this.view=panel;
	}
	public void showOrderDetailInfo(String orderID) {
		view.changeToDetailPanel(orderID);
	
	}

	
	public void closeOrderDetail() {
		view.removeAll();
	}
	
	
	public void jumpToMainFrame() {
		view.changeToLookPanel();
		
	}

}
