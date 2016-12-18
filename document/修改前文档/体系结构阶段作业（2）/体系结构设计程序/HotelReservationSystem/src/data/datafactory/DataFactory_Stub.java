package data.datafactory;

import data.availableroomdata.AvailableRoomDataServiceMySqlImpl_Stub;
import data.checkindata.CheckinDataServiceMySqlImpl_Stub;
import data.creditdata.CreditDataServiceMySqlImpl_Stub;
import data.hoteldata.HotelDataServiceMySqlImpl_Stub;
import data.hotelstrategydata.HotelStrategyDataServiceMySqlImpl_Stub;
import data.orderdata.OrderDataServiceMySqlImpl_Stub;
import data.personneldata.PersonnelDataServiceMySqlImpl_Stub;
import data.searchhoteldata.SearchHotelDataServiceMySqlImpl_Stub;
import data.userdata.UserDataServiceMySqlImpl_Stub;
import data.webstrategydata.WebStrategyDataServiceMySqlImpl_Stub;
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

/**
 * 模拟datafactory模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class DataFactory_Stub implements DataFactoryService{

	@Override
	public UserDataService getUserDataImpl() {
		// TODO Auto-generated method stub
		return new UserDataServiceMySqlImpl_Stub();
	}

	@Override
	public PersonnelDataService getPersonnelDataImpl() {
		// TODO Auto-generated method stub
		return new PersonnelDataServiceMySqlImpl_Stub();
	}

	@Override
	public OrderDataService getOrderDataImpl() {
		// TODO Auto-generated method stub
		return new OrderDataServiceMySqlImpl_Stub();
	}

	@Override
	public CreditDataService getCreditDataImpl() {
		// TODO Auto-generated method stub
		return new CreditDataServiceMySqlImpl_Stub();
	}

	@Override
	public HotelDataService getHotelDataImpl() {
		// TODO Auto-generated method stub
		return new HotelDataServiceMySqlImpl_Stub();
	}

	@Override
	public AvailableRoomDataService getAvailableroomDataImpl() {
		// TODO Auto-generated method stub
		return new AvailableRoomDataServiceMySqlImpl_Stub();
	}

	@Override
	public CheckinDataService getCheckinDataImpl() {
		// TODO Auto-generated method stub
		return new CheckinDataServiceMySqlImpl_Stub();
	}

	@Override
	public WebStrategyDataService getWebStrategyDataImpl() {
		// TODO Auto-generated method stub
		return new WebStrategyDataServiceMySqlImpl_Stub();
	}

	@Override
	public HotelStrategyDataService getHotelStrategyDataImpl() {
		// TODO Auto-generated method stub
		return new HotelStrategyDataServiceMySqlImpl_Stub();
	}

	@Override
	public SearchHotelDataService getSearchHotelDataImpl() {
		// TODO Auto-generated method stub
		return new SearchHotelDataServiceMySqlImpl_Stub();
	}

	

}
