package businesslogic.hotelstrategybl;

import blservice.hotelstrategyblservice.HotelStrategyBLService;
import common.HotelStrategyType;
import common.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelstrategyvo.OrderProvidedVO;

/**
 * 模拟酒店策略模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> refs/remotes/origin/cyfBranch
 */
public class HotelStrategyBL_Stub implements HotelStrategyBLService{

	@Override
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO) {
		// TODO Auto-generated method stub
		return new HotelBestStrVO();
	}

	@Override
	public HotelStrVO getHotelStrategy(String hotelID, HotelStrategyType type) {
		// TODO Auto-generated method stub
		return new HotelStrVO();
	}

	@Override
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
