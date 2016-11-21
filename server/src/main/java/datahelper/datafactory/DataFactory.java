package datahelper.datafactory;

import data.datahelper.SearchHotelDataHelper;
import data.datahelper.UserDataHelper;

public interface DataFactory {
	public UserDataHelper getUserDataHelper();

	public SearchHotelDataHelper getSearchHotelDataHelper();
}
