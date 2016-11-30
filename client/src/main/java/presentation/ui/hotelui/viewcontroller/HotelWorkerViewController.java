package presentation.ui.hotelui.viewcontroller;

import javax.swing.JPanel;
/**
 * 酒店管理人员相关的酒店界面的控制类
 * @author CLL
 *
 */
public class HotelWorkerViewController implements HotelWorkerViewControllerService{
	private JPanel view;//发起界面跳转请求的界面对象
	public HotelWorkerViewController(JPanel panel){
		this.view=panel;
	}
	@Override
	public void modifyHotelInfoSuccess() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addRoomInfoSuccess() {
		// TODO Auto-generated method stub
		
	}

}
