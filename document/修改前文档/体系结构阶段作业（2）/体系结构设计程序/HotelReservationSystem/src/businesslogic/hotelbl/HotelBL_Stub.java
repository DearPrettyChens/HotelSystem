package businesslogic.hotelbl;

import java.util.ArrayList;



import blservice.hotelblservice.HotelBLService;
import common.ResultMessage;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;


/**
 * 模拟酒店模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class HotelBL_Stub implements HotelBLService{

	@Override
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID) {
		// TODO Auto-generated method stub
		return new HotelBasicInfoVO();
	}

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID, String customerID) {
		// TODO Auto-generated method stub
		return new HotelDetailInfoVO();
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

	@Override
	public ArrayList<HotelOrderVO> getHotelOrder(String hotelID) {
		// TODO Auto-generated method stub
		return new ArrayList<HotelOrderVO>();
	}

	@Override
	public HotelOrderInfoVO getHotelOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return new HotelOrderInfoVO();
	}

}
