package data.personneldata;

import java.util.ArrayList;

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
public class PersonnelDataServiceMySqlImpl_Driver {

	public void drive(PersonnelDataService stub) {
		ArrayList<HotelWorkerListPO> hotelWorkerListPOs = stub.getHotelWorkerList();
		ArrayList<WebMarketManListPO> webMarketManListPOs = stub.getWebMarketManList();
		ArrayList<CustomerListPO> customerListPOs = stub.getCustomerList();
		HotelWorkerDetailPO hotelWorkerDetailPO = stub.getHotelWorkerDetail("0001");
		WebMarketManDetailPO webMarketManDetailPO = stub.getWebMarketManDetail("000001");
		CustomerDetailPO customerDetailPO = stub.getCustomerDetail("000001");
		System.out.println(stub.addCustomer(customerDetailPO));
		System.out.println(stub.addHotelworker(hotelWorkerDetailPO));
		System.out.println(stub.addWebMarketMan(webMarketManDetailPO));
		System.out.println(stub.setCustomer(customerDetailPO));
		System.out.println(stub.setHotelWorker(hotelWorkerDetailPO));
		System.out.println(stub.setWebMarketMan(webMarketManDetailPO));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PersonnelDataServiceMySqlImpl_Driver().drive(new PersonnelDataServiceMySqlImpl_Stub());
	}
}
