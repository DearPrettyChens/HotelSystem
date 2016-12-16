package presentation.ui.searchhotelui.distributecontroller;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.bl.orderbl.Order;
import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import po.HotelListPO;
import util.OrderState;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

public class SearchHotelBLService_Stub implements SearchHotelBLService{

	@Override
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO) {
		// TODO Auto-generated method stub
		ArrayList<HotelListVO> hotelListVOs= new ArrayList<HotelListVO>();
		ArrayList<OrderState> orderStates=new ArrayList<OrderState>();
		orderStates.add(OrderState.UNUSUAL);
		orderStates.add(OrderState.HASCANCELED);
		orderStates.add(OrderState.HASREMARKED);
		orderStates.add(OrderState.NOTEXECUTED);
		HotelListVO vo1=new HotelListVO(new ImageIcon("image//hotel.jpg"), "000001", "南京金鹰国际大酒店", "南京大学仙林校区163号", 4, 5.0, 546.5, "12345671234",null, orderStates);
		HotelListVO vo2=new HotelListVO(new ImageIcon("image//hotel.jpg"), "000001", "南京金鹰国际大酒店", "南京大学仙林校区163号", 4, 5.0, 546.5, "12345671234",null, orderStates);
		HotelListVO vo3=new HotelListVO(new ImageIcon("image//hotel.jpg"), "000001", "南京金鹰国际大酒店", "南京大学仙林校区163号", 4, 5.0, 546.5, "12345671234",null, orderStates);
		HotelListVO vo4=new HotelListVO(new ImageIcon("image//hotel.jpg"), "000001", "南京金鹰国际大酒店", "南京大学仙林校区163号", 4, 5.0, 546.5, "12345671234",null, orderStates);
		HotelListVO vo5=new HotelListVO(new ImageIcon("image//hotel.jpg"), "000001", "南京金鹰国际大酒店", "南京大学仙林校区163号", 4, 5.0, 546.5, "12345671234",null, orderStates);
		hotelListVOs.add(vo1);
		hotelListVOs.add(vo2);
		hotelListVOs.add(vo3);
		hotelListVOs.add(vo4);
		hotelListVOs.add(vo5);
		return hotelListVOs;
	}

	@Override
	public ArrayList<HotelListVO> getCustomerHotelList(String customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
