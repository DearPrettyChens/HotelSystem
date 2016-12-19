package data.datafactory;

import data.hoteldata.HotelDataServiceMySqlImpl_Stub;
import dataservice.availableroomdataservice.AvailableRoomDataService;
import dataservice.checkindataservice.CheckinDataService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.hotelstrategydataservice.HotelStrategyDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import dataservice.searchhoteldataservice.SearchHotelDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.webstrategydataservice.WebStrategyDataService;

public class DataFactory_Driver {

	public void drive(DataFactoryService stub) {
		// TODO Auto-generated constructor stub
		UserDataService userDataService=stub.getUserDataImpl();
		PersonnelDataService personnelDataService=stub.getPersonnelDataImpl();
		OrderDataService orderDataService=stub.getOrderDataImpl();
		CreditDataService creditDataService=stub.getCreditDataImpl();
		HotelDataService hotelDataService=stub.getHotelDataImpl();
		HotelStrategyDataService hotelStrategyDataService=stub.getHotelStrategyDataImpl();
		WebStrategyDataService webStrategyDataService=stub.getWebStrategyDataImpl();
		AvailableRoomDataService availableRoomDataService=stub.getAvailableroomDataImpl();
	    CheckinDataService checkinDataService=stub.getCheckinDataImpl();
	    SearchHotelDataService searchHotelDataService=stub.getSearchHotelDataImpl();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new DataFactory_Driver().drive(new DataFactory_Stub());
	}

}
