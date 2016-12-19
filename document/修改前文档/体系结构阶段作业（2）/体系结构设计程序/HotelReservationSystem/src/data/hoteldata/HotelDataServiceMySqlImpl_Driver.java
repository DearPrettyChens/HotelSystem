package data.hoteldata;

import dataservice.hoteldataservice.HotelDataService;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;

/**
 * 模拟hotel模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class HotelDataServiceMySqlImpl_Driver {

	public void drive(HotelDataService stub) {
         HotelBasicInfoPO hotelBasicInfoPO=stub.getHotelBasicInfo("0001");
         System.out.println(stub.addHotelBasicInfo(hotelBasicInfoPO));
         System.out.println(stub.addRemarkInfo(new RemarkPO()));
         System.out.println(stub.setHotelBasicInfo(hotelBasicInfoPO));
         System.out.println(stub.setBestPrice(new HotelBestPricePO()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HotelDataServiceMySqlImpl_Driver().drive(new HotelDataServiceMySqlImpl_Stub());
	}
}
