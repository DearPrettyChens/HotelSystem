package presentation.ui.personnelui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.personnelui.view.Clientdetailinfo_JFrame;
import presentation.ui.personnelui.view.Hotelworkeradd_JPanel;
import presentation.ui.personnelui.view.Hotelworkerdetailinfo_JFrame;
import presentation.ui.personnelui.view.Searchoradd_JPanel;
import presentation.ui.personnelui.view.WebMarketManAdd_JPanel;
import presentation.ui.personnelui.view.Webmarketmandetailinfo_JFrame;
import util.UserType;

/**
 * personnel界面的控制器
 * @author CLL
 *
 */
public class PersonnelControllerImpl implements PersonnelControllerService{
	private JPanel view;//发起界面跳转的界面对象
	/**
	 * 将searchoraddpanel作为参数传进来
	 * @param view
	 */
	public PersonnelControllerImpl(JPanel view){
		this.view=view;
	}

	@Override
	public void showHotelWorkerDetailInfo(String image, String id, String name, String tel, String type, String password,
			String hotelname) {
		view.add(new Hotelworkerdetailinfo_JFrame(image,id,name,tel,type,password,hotelname));
	}
	@Override
	public void addUserView(UserType type,String id) {
		switch(type){
		case HotelWorker:
			view.add(new Hotelworkeradd_JPanel(id));
			break;
		case WebMarketMan:
			view.add(new WebMarketManAdd_JPanel(id));
			break;
		default:
			break;
		
		}
		
	}
	@Override
	public void searchUserView(UserType type) {
		view.add(new Searchoradd_JPanel(type));
		
	}

	@Override
	public void showWebMarketManDetailInfo(String id, String name, String tel, String type, String password) {
		view.add(new Webmarketmandetailinfo_JFrame(id,name,tel,type,password));
		
	}

	@Override
	public void showCustomerDetailInfo(String id, String name, String tel, String type, String password) {
		view.add(new Clientdetailinfo_JFrame(id,name,tel,type,password));
		
	}

	@Override
	public void jumpToUpdatedUserListView(UserType type) {
		view=new Searchoradd_JPanel(type);
	}

	@Override
	public void closeDetailInfoFrame() {
		view.removeAll();
	}

	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}

}
