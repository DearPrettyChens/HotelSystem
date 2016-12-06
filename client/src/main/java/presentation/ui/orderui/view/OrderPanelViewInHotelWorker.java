package presentation.ui.orderui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.orderui.viewcontroller.HotelWorkerOrderViewController;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
/**
 * 
 * 酒店工作人员管理订单选项的总界面
 * 
 * @author csy
 *
 */
public class OrderPanelViewInHotelWorker extends JPanel{
	private LookOrderPanelInHotelWorker_JPanel lookOrderPanelInHotelWorker_JPanel;
	private OrderDetailInfoToHotelWorker_JPanel orderDetailInfoToHotelWorker_JPanel;
	private static OrderPanelViewInHotelWorker orderPanelViewInHotelWorker;
	private HotelWorkerOrderViewController hotelWorkerOrderViewController=HotelWorkerOrderViewController.getInstance(this);
	private String hotelID;
	
	public static OrderPanelViewInHotelWorker getInstance(String hotelID) {
		if(orderPanelViewInHotelWorker==null){
			orderPanelViewInHotelWorker=new OrderPanelViewInHotelWorker(hotelID);
		}
		return orderPanelViewInHotelWorker;
	}
	
	
	private OrderPanelViewInHotelWorker(String hotelID) {
		this.hotelID=hotelID;
		this.setBackground(Color.white);
		this.setBounds(0, 0,800, 600);
		this.setLayout(null);
		changeToLookPanel();
	}

	public void changeToLookPanel() {
        this.removeAll();
        lookOrderPanelInHotelWorker_JPanel=new LookOrderPanelInHotelWorker_JPanel(hotelID);
        this.add(lookOrderPanelInHotelWorker_JPanel);
        this.updateUI();
	}

	public void changeToDetailPanel(String orderID) {
		this.removeAll();
		orderDetailInfoToHotelWorker_JPanel=new OrderDetailInfoToHotelWorker_JPanel(orderID);
		this.add(orderDetailInfoToHotelWorker_JPanel);
		this.updateUI();
	}
}
