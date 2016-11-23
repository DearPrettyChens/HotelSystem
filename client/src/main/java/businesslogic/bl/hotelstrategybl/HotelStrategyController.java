package businesslogic.bl.hotelstrategybl;

import businesslogic.blservice.hotelstrategyblservice.HotelStrategyBLService;
import util.HotelStrategyType;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;
/**
 * 酒店策略Controller类
 * @author CYF
 * @version 1.0
 */
public class HotelStrategyController implements HotelStrategyBLService {
    //酒店策略
	private HotelStrategy hotelStrategy;
    private static HotelStrategyBLService hotelStrategyController;
	
	private HotelStrategyController(){
		hotelStrategy =HotelStrategy.getInstance();
	}

	public static HotelStrategyBLService getInstance() {
		if(hotelStrategyController==null){
			hotelStrategyController=new HotelStrategyController();
		}
		return hotelStrategyController;
	}
	
	@Override
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO) {
		return hotelStrategy.getBestHotelStrategy(orderProvidedVO);
	}

	@Override
	public HotelStrVO getHotelStrategy(String hotelID, HotelStrategyType hotelStrategyType) {
		return hotelStrategy.getHotelStrategy(hotelID, hotelStrategyType);
	}

	@Override
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO) {
		
		return hotelStrategy.confirmHotelStrategy( hotelStrVO);
	}

}
