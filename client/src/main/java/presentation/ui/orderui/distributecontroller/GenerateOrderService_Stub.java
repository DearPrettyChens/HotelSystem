package presentation.ui.orderui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.blservice.orderblservice.GenerateOrderService;
import exception.NotFoundHotelException;
import util.BedType;
import util.City;
import util.HotelStrategyType;
import util.ResultMessage;
import util.TradingArea;
import util.WebStrategyType;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.StrategyVO;
import vo.webstrategyvo.WebBestStrVO;

public class GenerateOrderService_Stub implements GenerateOrderService{

	@Override
	public ResultMessage checkUserCredit(String CustomerID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTelephone(String telNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTime(Date time) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public StrategyVO next(OrderInfoVO orderinfovo) {
		// TODO Auto-generated method stub
		HotelBestStrVO vo1=new HotelBestStrVO("000005",HotelStrategyType.AMOUNT,0.8);
		WebBestStrVO vo2=new WebBestStrVO(WebStrategyType.SPECIALAREA,0.6);
		StrategyVO vo=new StrategyVO(vo2,vo1,680);
		return vo;
	}

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID) throws NotFoundHotelException {
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		ArrayList<String> enterprises=new ArrayList<String>();
		enterprises.add("华为");
		
		ArrayList <HotelStrVO> list=new ArrayList<HotelStrVO>();
		list.add(new HotelStrVO("000005", 0.5,date));
		list.add(new HotelStrVO("000005",  0.5));
		list.add(new HotelStrVO("000005", 4, 0.5));
		list.add(new HotelStrVO("000005",0.8,enterprises));
		AvailableRoomInfoVO vo1=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10);
		AvailableRoomInfoVO vo2=new AvailableRoomInfoVO("000003"," 宿舍房",BedType. FOURBEDS,680,500,10);
		
		ArrayList<AvailableRoomInfoVO> roomlist=new ArrayList<AvailableRoomInfoVO>();
		roomlist.add(vo1);
		roomlist.add(vo2);
		HotelDetailInfoVO detailvo=new HotelDetailInfoVO("绿地洲际大酒店","南京市鼓楼区",null, TradingArea.XINJIEKOU,"12345678999"
				,5,"好","设施齐全",City.NANJING,"设施齐全","设施齐全","设施齐全","华为",list,roomlist,
				null,0,null,500);
		return detailvo;
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
