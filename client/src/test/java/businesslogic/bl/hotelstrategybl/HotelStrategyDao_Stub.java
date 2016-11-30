package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;

import dao.hotelstrategydao.HotelStrategyDao;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;

/**
 * 
 * 模拟HotelStrategyDao的实现
 * @author CSY
 *
 */
public class HotelStrategyDao_Stub implements HotelStrategyDao{

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
		// TODO Auto-generated method stub
		return new HotelStrPO(1, 4, 0.5);
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
