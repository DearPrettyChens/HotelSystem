package datahelper.datafactory.impl;

import data.datahelper.AvailableRoomDataHelper;
import data.datahelper.CheckInDataHelper;
import data.datahelper.CreditDataHelper;
import data.datahelper.HotelDataHelper;
import data.datahelper.HotelStrategyDataHelper;
import data.datahelper.OrderDataHelper;
import data.datahelper.PersonnelDataHelper;
import data.datahelper.SearchHotelDataHelper;
import data.datahelper.UserDataHelper;
import data.datahelper.WebStrategyDataHelper;
import data.datahelperimpl.AvailableRoomDataHelperDatabaseImpl;
import data.datahelperimpl.CheckInDataHelperDatabaseImpl;
import data.datahelperimpl.CreditInDataHelperDatabaseImpl;
import data.datahelperimpl.HotelDataHelperDatabaseImpl;
import data.datahelperimpl.HotelStrategyDataHelperDatabaseImpl;
import data.datahelperimpl.OrderDataHelperDatabaseImpl;
import data.datahelperimpl.PersonnelDataHelperDatabaseImpl;
import data.datahelperimpl.SearchHotelDataHelperDatabaseImpl;
import data.datahelperimpl.UserDataHelperDatabaseImpl;
import datahelper.datafactory.DataFactory;

public class DataFactoryDatabaseImpl implements DataFactory {

	@Override
	public UserDataHelper getUserDataHelper() {
		UserDataHelper userDataHelper = new UserDataHelperDatabaseImpl();
		return userDataHelper;
	}

	@Override
	public SearchHotelDataHelper getSearchHotelDataHelper() {
		SearchHotelDataHelper searchHotelDataHelper = new SearchHotelDataHelperDatabaseImpl();
		return searchHotelDataHelper;
	}

	@Override
	public AvailableRoomDataHelper getAvailableRoomDataHelper() {
		AvailableRoomDataHelper availableRoomDataHelper = new AvailableRoomDataHelperDatabaseImpl();
		return availableRoomDataHelper;
	}

	@Override
	public CheckInDataHelper getCheckInDataHelper() {
		CheckInDataHelper checkInDataHelper = new CheckInDataHelperDatabaseImpl();
		return checkInDataHelper;
	}

	@Override
	public CreditDataHelper getCreditDataHelper() {
		CreditDataHelper creditDataHelper = new CreditInDataHelperDatabaseImpl();
		return creditDataHelper;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDataHelper = new HotelDataHelperDatabaseImpl();
		return hotelDataHelper;
	}

	@Override
	public HotelStrategyDataHelper getHotelStrategyDataHelper() {
		HotelStrategyDataHelper hotelStrategyDataHelper = new HotelStrategyDataHelperDatabaseImpl();
		return hotelStrategyDataHelper;
	}

	@Override
	public OrderDataHelper getOrderDataHelper() {
		OrderDataHelper orderDataHelper = new OrderDataHelperDatabaseImpl();
		return orderDataHelper;
	}

	@Override
	public PersonnelDataHelper getPersonnelDataHelper() {
		PersonnelDataHelper personnelDataHelper = new PersonnelDataHelperDatabaseImpl();
		return personnelDataHelper;
	}

	@Override
	public WebStrategyDataHelper getWebStrategyDataHelper() {
		// TODO Auto-generated method stub
		return null;
	}

}
