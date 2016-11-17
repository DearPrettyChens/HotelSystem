package datahelper.datafactory.impl;

import data.datahelper.UserDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.impl.UserDataHelperDatabaseImpl;

public class DataFactoryImpl implements DataFactory{

	@Override
	public UserDataHelper getUserDataHelper() {
		UserDataHelper userDataDao = new UserDataHelperDatabaseImpl();
		return userDataDao;
	}

	
}
