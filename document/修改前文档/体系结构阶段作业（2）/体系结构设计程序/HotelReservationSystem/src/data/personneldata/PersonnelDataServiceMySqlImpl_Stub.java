package data.personneldata;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import common.ResultMessage;
import dataservice.personneldataservice.PersonnelDataService;
import po.CustomerDetailPO;
import po.CustomerListPO;
import po.HotelWorkerDetailPO;
import po.HotelWorkerListPO;
import po.WebMarketManDetailPO;
import po.WebMarketManListPO;

/**
 * 模拟personnel模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class PersonnelDataServiceMySqlImpl_Stub implements PersonnelDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage addCustomer(CustomerDetailPO customerDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelworker(HotelWorkerDetailPO hotelWorkerDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addWebMarketMan(WebMarketManDetailPO webMarketManDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HotelWorkerListPO> getHotelWorkerList() {
		// TODO Auto-generated method stub
		return new ArrayList<HotelWorkerListPO>();
	}

	@Override
	public ArrayList<WebMarketManListPO> getWebMarketManList() {
		// TODO Auto-generated method stub
		return new ArrayList<WebMarketManListPO>() ;
	}

	@Override
	public ArrayList<CustomerListPO> getCustomerList() {
		// TODO Auto-generated method stub
		return new ArrayList<CustomerListPO>();
	}

	@Override
	public HotelWorkerDetailPO getHotelWorkerDetail(String hotelID) {
		// TODO Auto-generated method stub
		return new HotelWorkerDetailPO();
	}

	@Override
	public WebMarketManDetailPO getWebMarketManDetail(String webWorkerManID) {
		// TODO Auto-generated method stub
		return new WebMarketManDetailPO();
	}

	@Override
	public CustomerDetailPO getCustomerDetail(String customerID) {
		// TODO Auto-generated method stub
		return new CustomerDetailPO();
	}

	@Override
	public ResultMessage setHotelWorker(HotelWorkerDetailPO hotelWorkerDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setWebMarketMan(WebMarketManDetailPO webMarketManDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCustomer(CustomerDetailPO customerDetailPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}


}
