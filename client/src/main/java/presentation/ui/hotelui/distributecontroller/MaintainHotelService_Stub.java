package presentation.ui.hotelui.distributecontroller;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.blservice.hotelblservice.MaintainHotelService;
import exception.NotFoundHotelException;
import util.City;
import util.ResultMessage;
import util.TradingArea;
import vo.hotelvo.HotelBasicInfoVO;

public class MaintainHotelService_Stub implements MaintainHotelService{

	@Override
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID) throws NotFoundHotelException {
		// TODO Auto-generated method stub
		ArrayList<String> enterprises=new ArrayList<String>();
		enterprises.add("华为");
		HotelBasicInfoVO basic=new HotelBasicInfoVO("000001","绿地洲际酒店",new ImageIcon("image//hotel.jpg"),"南京市鼓楼区",City.NANJING,
				TradingArea.XINJIEKOU,"12345678999",5,"好","设施齐全","设施齐全","设施齐全","设施齐全",
				"华为");
		return basic;
	}

	@Override
	public ResultMessage checkTel(String telNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmModifyInfo(HotelBasicInfoVO hotelBasicInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
