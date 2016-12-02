package presentation.ui.hotelui.distributecontroller;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.blservice.hotelblservice.LookHotelService;
import exception.NotFoundHotelException;
import util.BedType;
import util.City;
import util.TradingArea;
import vo.hotelvo.HotelDetailInfoVO;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.*;

public class LookHotelService_Stub implements LookHotelService{

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID, String customerID) throws NotFoundHotelException {
		// TODO Auto-generated method stub
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
		AvailableRoomInfoVO vo=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10);
		ArrayList<AvailableRoomInfoVO> roomlist=new ArrayList<AvailableRoomInfoVO>();
		roomlist.add(vo);
		HotelDetailInfoVO detailvo=new HotelDetailInfoVO("绿地洲际大酒店","南京市鼓楼区",null, TradingArea.XINJIEKOU,"12345678999"
				,5,"好","设施齐全",City.NANJING,"设施齐全","设施齐全","设施齐全","华为",list,roomlist,
				null,0,null,500);
		return detailvo;
	}

}
