package businesslogic.personnelbl;

import java.util.ArrayList;

import blservice.personnelblservice.PersonnelBLService;
import vo.personnelvo.CustomerDetailVO;
import vo.personnelvo.CustomerListVO;
import vo.personnelvo.HotelWorkerDetailVO;
import vo.personnelvo.HotelWorkerListVO;
import vo.personnelvo.WebMarketManDetailVO;
import vo.personnelvo.WebMarketManListVO;

/**
 * 模拟管理人员模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class PersonnelBL_Driver {
    
	public void drive(PersonnelBLService stub) {
		HotelWorkerDetailVO hotelWorkerDetailVO=stub.getHotelWorkerDetail("0001");
	    WebMarketManDetailVO webMarketManDetailVO=stub.getWebWorkerManDetail("000001");
	    CustomerDetailVO customerDetailVO=stub.getCustomerDetail("000001");
	    ArrayList<HotelWorkerListVO> hotelWorkerListVOs=stub.getHotelWorkerList();
	    ArrayList<WebMarketManListVO> webMarketManListVOs=stub.getWebMarketManList();
	    ArrayList<CustomerListVO> customerListVOs=stub.getCustomerList();
	    System.out.println(stub.modifyCustomer(customerDetailVO));
	    System.out.println(stub.modifyHotelworker(hotelWorkerDetailVO));
	    System.out.println(stub.modifyWebMarketMan(webMarketManDetailVO));
	    System.out.println(stub.checkUserName("csy"));
	    System.out.println(stub.checkUserTel("12345678900"));
	    System.out.println(stub.checkHotelTel("12345678"));
	    System.out.println(stub.checkPassword("123456"));
	    System.out.println(stub.confirmRegister(customerDetailVO));
	    System.out.println(stub.addHotelWorker(hotelWorkerDetailVO));
	    System.out.println(stub.addWebMarketMan(webMarketManDetailVO));
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new PersonnelBL_Driver().drive(new PersonnelBL_Stub());
	}

}
