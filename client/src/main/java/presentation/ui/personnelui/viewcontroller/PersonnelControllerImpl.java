package presentation.ui.personnelui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.ManagePanel;
import presentation.ui.personnelui.view.Searchoradd_JPanel;
import presentation.ui.personnelui.view.client.Clientdetailinfo_JFrame;
import presentation.ui.personnelui.view.client.ManageCustomerPanel;
import presentation.ui.personnelui.view.hotelworker.Hotelworkeradd_JPanel;
import presentation.ui.personnelui.view.hotelworker.Hotelworkerdetailinfo_JFrame;
import presentation.ui.personnelui.view.hotelworker.ManageHotelWorkerPanel;
import presentation.ui.personnelui.view.webmarketman.ManageWebMarketManPanel;
import presentation.ui.personnelui.view.webmarketman.WebMarketManAdd_JPanel;
import presentation.ui.personnelui.view.webmarketman.Webmarketmandetailinfo_JFrame;
import util.UserType;

/**
 * personnel界面的控制器
 * 
 * @author CLL
 *
 */
public class PersonnelControllerImpl {
	private JPanel view;// 发起界面跳转的界面对象

	/**
	 * 将要作为参数传进来
	 * 
	 * @param view
	 */
	public PersonnelControllerImpl(JPanel view) {
		this.view = view;
	}

	/**
	 * 跳出各种人员的详细信息
	 * 
	 * @param personID
	 */
	public void showHotelWorkerDetailInfo(String personID) {
		JFrame frame = new Hotelworkerdetailinfo_JFrame(personID);
		frame.setVisible(true);
	}

	/**
	 * 跳出各种人员的详细信息
	 * 
	 * @param personID
	 */
	public void showWebMarketManDetailInfo(String id) {

		JFrame frame = new Webmarketmandetailinfo_JFrame(id);
		frame.setVisible(true);
	}

	/**
	 * 跳出各种人员的详细信息
	 * 
	 * @param personID
	 */
	public void showCustomerDetailInfo(String id) {
		JFrame frame = new Clientdetailinfo_JFrame(id);
		frame.setVisible(true);
	}

	/**
	 * 跳到搜索人员界面
	 * 
	 * @param managePanel
	 */
	public void jumpToSearchPanel(ManagePanel managePanel) {
		managePanel.changeToSearchPanel();
	}

	/**
	 * 跳到添加人员界面
	 * 
	 * @param managePanel
	 */
	public void jumpToAddPanel(ManagePanel managePanel) {
		managePanel.changeToAddPanel();
	}

	
	
	// 以下部分都是还未用到的跳转
	public void jumpToUpdatedUserListView(UserType type) {
		// view=new Searchoradd_JPanel(type);
	}

	public void closeDetailInfoFrame() {
		view.removeAll();
	}

	public void jumpToMainFrame() {
		view = null;

	}

}
