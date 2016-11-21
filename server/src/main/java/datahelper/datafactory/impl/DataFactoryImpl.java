package datahelper.datafactory.impl;

import data.datahelper.SearchHotelDataHelper;
import data.datahelper.UserDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.impl.SearchHotelDataHelperDatabaseImpl;
import datahelper.impl.UserDataHelperDatabaseImpl;

public class DataFactoryImpl implements DataFactory {

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

}
