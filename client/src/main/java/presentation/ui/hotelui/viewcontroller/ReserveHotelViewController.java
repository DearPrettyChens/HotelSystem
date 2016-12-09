package presentation.ui.hotelui.viewcontroller;

import presentation.ui.hotelui.view.client.HotelPanetoClient_JPanel;
import presentation.ui.hotelui.view.client.ReserveHotelView;
import presentation.ui.hotelui.view.client.SearchHotelPane_JPanel;
import presentation.ui.orderui.view.client.MakeOrdertoClient_JPanel;
import util.ViewTag;
import vo.searchhotelvo.HotelSearchInfoVO;

public class ReserveHotelViewController {
	private ReserveHotelView reserveHotelView;
	private static ReserveHotelViewController reserveHotelViewController;

	public static ReserveHotelViewController getInstance(ReserveHotelView reserveHotelView) {
		if (reserveHotelViewController == null) {
			reserveHotelViewController = new ReserveHotelViewController(reserveHotelView);
		}
		return reserveHotelViewController;
	}

	private ReserveHotelViewController(ReserveHotelView reserveHotelView) {
		this.reserveHotelView = reserveHotelView;
	}

	public void generateNewHotelListView(HotelSearchInfoVO hotelSearchInfoVO) {
		reserveHotelView.generateNewHotelListView(hotelSearchInfoVO);
	}

	public void generateNewHotelDetailView(String hotelID) {
		reserveHotelView.generateNewHotelDetailView(hotelID);
	}

	public void generateNewOrder(String hotelID) {
		reserveHotelView.generateNewOrder(hotelID);
	}

	public void returnToHotelListView() {
		reserveHotelView.returnToHotelListView();
	}

	public void returnToHotelDetailView() {
		reserveHotelView.returnToHotelDetailView();
	}

}
