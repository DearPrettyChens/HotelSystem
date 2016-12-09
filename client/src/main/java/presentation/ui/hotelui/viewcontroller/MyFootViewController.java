package presentation.ui.hotelui.viewcontroller;

import presentation.ui.hotelui.view.client.MyFootView;
import presentation.ui.hotelui.view.client.ReserveHotelView;
import vo.searchhotelvo.HotelSearchInfoVO;

public class MyFootViewController {
	private MyFootView myFootView;
	private static MyFootViewController myFootViewController;

	public static MyFootViewController getInstance(MyFootView myFootView) {
		if (myFootViewController == null) {
			myFootViewController = new MyFootViewController(myFootView);
		}
		return myFootViewController;
	}

	private  MyFootViewController(MyFootView myFootView) {
		this.myFootView = myFootView;
	}

	public void generateNewHotelListView(HotelSearchInfoVO hotelSearchInfoVO) {
		myFootView.generateNewHotelListView(hotelSearchInfoVO);
	}

	public void generateNewHotelDetailView(String hotelID) {
		myFootView.generateNewHotelDetailView(hotelID);
	}

	public void generateNewOrder(String hotelID) {
		myFootView.generateNewOrder(hotelID);
	}

	public void returnToHotelListView() {
		myFootView.returnToHotelListView();
	}

	public void returnToHotelDetailView() {
		myFootView.returnToHotelDetailView();
	}

}
