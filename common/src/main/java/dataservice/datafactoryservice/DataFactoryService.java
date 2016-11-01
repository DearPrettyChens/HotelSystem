package dataservice.datafactoryservice;

import dataservice.availableroomdataservice.AvailableRoomDataService;
import dataservice.checkindataservice.CheckinDataService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.hotelstrategydataservice.HotelStrategyDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import dataservice.searchhoteldataservice.SearchHotelDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.webstrategydataservice.WebStrategyDataService;


/**
 * 数据工厂，负责提供各种数据接口的实现对象
 * @author csy
 * @version 1.0
 * 
 */

public interface DataFactoryService {
	
	/**
	 * 获取UserDataService接口实现对象
	 * @param  无
	 * @return UserDataService
	 * @throws 无
	 *
	 */
	public UserDataService getUserDataImpl();
	
	/**
	 * 获取PersonnelDataService接口实现对象
	 * @param  无
	 * @return PersonnelDataService
	 * @throws 无
	 *
	 */
	public PersonnelDataService getPersonnelDataImpl();
	
	/**
	 * 获取OrderDataService接口实现对象
	 * @param  无
	 * @return OrderDataService
	 * @throws 无
	 *
	 */
	public OrderDataService getOrderDataImpl();
	
	/**
	 * 获取CreditDataService接口实现对象
	 * @param  无
	 * @return CreditDataService
	 * @throws 无
	 *
	 */
	public CreditDataService getCreditDataImpl();
	
	/**
	 * 获取HotelDataService接口实现对象
	 * @param  无
	 * @return HotelDataService
	 * @throws 无
	 *
	 */
	public HotelDataService getHotelDataImpl();
	
	/**
	 * 获取AvailableRoomDataService接口实现对象
	 * @param  无
	 * @return AvailableRoomDataService
	 * @throws 无
	 *
	 */
	public AvailableRoomDataService getAvailableroomDataImpl();
	
	/**
	 * 获取CheckinDataService接口实现对象
	 * @param  无
	 * @return CheckinDataService
	 * @throws 无
	 *
	 */
	public CheckinDataService getCheckinDataImpl();
	
	/**
	 * 获取WebStrategyDataService接口实现对象
	 * @param  无
	 * @return WebStrategyDataService
	 * @throws 无
	 *
	 */
	public WebStrategyDataService getWebStrategyDataImpl();
	
	/**
	 * 获取HotelStrategyDataService接口实现对象
	 * @param  无
	 * @return HotelStrategyDataService
	 * @throws 无
	 *
	 */
	public HotelStrategyDataService getHotelStrategyDataImpl();
	
	/**
	 * 获取SearchHotelDataService接口实现对象
	 * @param  无
	 * @return SearchHotelDataService
	 * @throws 无
	 *
	 */
	public SearchHotelDataService getSearchHotelDataImpl();
}
