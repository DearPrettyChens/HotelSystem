package presentation.ui.loginui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.availableroomui.view.RoomInfo_JPanel;
import presentation.ui.hotelstrategyui.view.ChooseHotelStr_JPanel;
import presentation.ui.hotelui.view.ModifyHotelBasicInfo_JPanel;
import presentation.ui.orderui.view.Searchorder_JPanel;
import presentation.ui.orderui.view.ViewOrderToHotelWorker_JPanel;
import util.UserType;

/**
 * 控制酒店工作人员界面的跳转
 * @author CLL
 *
 */
public class HotelWorkerMainController {
	private JFrame frame;//发起界面跳转请求的界面对象
	private JPanel view;
	public HotelWorkerMainController(JFrame frame){
		this.frame=frame;
	}
	public void jumpToMaintainHotelInfoView(){
		frame.removeAll();
		view=new ModifyHotelBasicInfo_JPanel();
		frame.add(view);
	}
	
	public void jumpToAddRoomInfoView(){
		frame.removeAll();
		view=new RoomInfo_JPanel();
		frame.add(view);
	}
	
	public void jumpToOrderListView(){
		frame.removeAll();
		//TODO
		//view=new Searchorder_JPanel(UserType.HotelWorker);
		frame.add(view);
	}
	
	public void jumpToStrategyView(){
		frame.removeAll();
		view=new ChooseHotelStr_JPanel();
		frame.add(view);
	}
	
	public void jumpToOnlineCheckinView(){
		frame.removeAll();
		//TODO view=new 
		frame.add(view);
	}
	
	public void jumpToOnlineCheckoutView(){
		frame.removeAll();
		//TODO view=new 
		frame.add(view);
	}
	
	public void jumpToOfflineCheckinoutView(){
		frame.removeAll();
		//TODO view=new 
		frame.add(view);
	}
}
