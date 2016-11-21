package datahelper.datafactory;

import data.datahelper.AvailableRoomDataHelper;
import data.datahelper.CheckInDataHelper;
import data.datahelper.CreditDataHelper;
import data.datahelper.HotelDataHelper;
import data.datahelper.HotelStrategyDataHelper;
import data.datahelper.OrderDataHelper;
import data.datahelper.PersonnelDataHelper;
import data.datahelper.SearchHotelDataHelper;
import data.datahelper.UserDataHelper;

public interface DataFactory {
	public UserDataHelper getUserDataHelper();

	public SearchHotelDataHelper getSearchHotelDataHelper();

	public AvailableRoomDataHelper getAvailableRoomDataHelper();

	public CheckInDataHelper getCheckInDataHelper();

	public CreditDataHelper getCreditDataHelper();

	public HotelDataHelper getHotelDataHelper();

	public HotelStrategyDataHelper getHotelStrategyDataHelper();

	public OrderDataHelper getOrderDataHelper();

	public PersonnelDataHelper getPersonnelDataHelper();

}
