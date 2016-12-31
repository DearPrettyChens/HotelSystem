package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import dao.hotelstrategydao.HotelStrategyDao;
import po.HotelStrPO;
import po.WebStrPO;
import util.HotelStrategyType;
import util.ResultMessage;
import util.TradingArea;
import util.WebStrategyType;

/**
 * 
 * 模拟HotelStrategyDao的实现
 * @author CSY
 *
 */
public class HotelStrategyDao_Stub implements HotelStrategyDao{

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		Map<Integer, Double> area=new HashMap<Integer, Double>();
		area.put(TradingArea.XINJIEKOU.ordinal(), 0.5);
		Map<Integer, Double> vip=new HashMap<Integer, Double>();
		area.put(1, 0.5);
		switch (type) {
		case SPECIALTIME:
			return new HotelStrPO(1, 0.5, date);
		case BIRTH:
			return new HotelStrPO(1, 0, HotelStrategyType.BIRTH, 0.5, null, null);
		case AMOUNT:
			return new HotelStrPO(1, 4, 0.5) ;

		} 
		return null;
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

}
