package presentation.ui.hotelstrategyui.distributecontroller;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.blservice.hotelstrategyblservice.HotelStrategyBLService;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;

public class HotelStrategyBLService_Stub implements HotelStrategyBLService {

	@Override
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO) {
		// TODO Auto-generated method stub
		HotelBestStrVO vo = new HotelBestStrVO("000005", HotelStrategyType.AMOUNT, 0.8);
		return vo;
	}

	@Override
	public HotelStrVO getHotelStrategy(String hotelID, HotelStrategyType type) {
		// TODO Auto-generated method stub
		Date[] date = new Date[] { new Date(2016, 5, 20), new Date(2016, 11, 30) };
		switch (type) {
		case AMOUNT:
			return new HotelStrVO("000005", 4, 0.5);
		case SPECIALTIME:
			return new HotelStrVO("000005", 0.5, date);
		case BIRTH:
			return new HotelStrVO("000005", 0.5);

		case ENTERPRISE:
			ArrayList<String> enterprises = new ArrayList<String>();
			enterprises.add("华为");
			enterprises.add("小米");
			enterprises.add("魅族");
			enterprises.add("三星");
			enterprises.add("万达");
			return new HotelStrVO("000005", 0.8, enterprises);
		default:
			break;
		}
		return null;
	}

	@Override
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
