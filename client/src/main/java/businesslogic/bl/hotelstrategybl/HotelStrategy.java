package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;

import businesslogic.bl.availableroombl.AvailableRoom;
import dao.hotelstrategydao.HotelStrategyDao;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;

/**
 * HotelStrategy类
 * 
 * @author CYF
 * @version 1.0
 */
public class HotelStrategy {
	private HotelStrategyMap hotelStrategyMap;
	private HotelStrategyInterface hotelStrategyInterface;
	private HotelStrategyDao hotelStrategyDao;
	private static HotelStrategy hotelStrategy;

	private HotelStrategy() {

//		hotelStrategyDao = RMIHelper.getHotelStrategyDao();
		hotelStrategyDao =new HotelStrategyDao_Stub();
		hotelStrategyMap = HotelStrategyMap.getInstance();

		RMIHelper.init();
		hotelStrategyDao = RMIHelper.getHotelStrategyDao();
hotelStrategyMap=HotelStrategyMap.getInstance();

	}

	public static HotelStrategy getInstance() {
		if (hotelStrategy == null) {
			hotelStrategy = new HotelStrategy();
		}
		return hotelStrategy;
	}

	/**
	 * 获得酒店最佳策略
	 * 
	 * @param orderProvidedVO
	 * @return HotelBestStrVO
	 */
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO) {
		String hotelID = orderProvidedVO.getHotelID();

		// 用providedInfoMap来组织传过来用于获得最佳策略的信息
		ProvidedInfoMap providedInfoMap = new ProvidedInfoMap(orderProvidedVO);
		double discount = 1;// 折扣值在0-1之间,没有折扣就是1
		HotelStrategyType hotelStrategyType = HotelStrategyType.AMOUNT;// 暂时初始化为AMOUNT

		// 遍历各个策略的信息
		while (providedInfoMap.hasNext()) {

			// 获得策略种类和提供的相关折扣信息
			providedInfoMap.next();
			HotelStrategyType type = providedInfoMap.getHotelStrategyType();
			String info = providedInfoMap.getInfo();

			// 委托给每个策略去计算折扣值
			hotelStrategyInterface = hotelStrategyMap.get(type);
			double tempDiscount = hotelStrategyInterface.getDiscount(info, hotelID);

			// 选取折扣最大的，即折扣值最小的。
			if (tempDiscount < discount) {
				discount = tempDiscount;
				hotelStrategyType = type;
			}
		}
		return new HotelBestStrVO(hotelID, hotelStrategyType, discount);

	}

	/**
	 * 获取酒店某类型的策略 委托给hotelStrategyInterface
	 * 
	 * @param hotelID
	 * @param HotelStrategyType
	 * @return HotelStrVO
	 */
	public HotelStrVO getHotelStrategy(String hotelID, HotelStrategyType hotelStrategyType) {
		hotelStrategyInterface = hotelStrategyMap.get(hotelStrategyType);
		return hotelStrategyInterface.getHotelStrategy(hotelID);
	}

	/**
	 * 修改酒店某类型的策略 ，酒店房间的最低价格也发生改变
	 * 
	 * @param hotelStrVO
	 *            HotelStrVO型
	 * @return ResultMessage
	 */
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO) {
		HotelStrPO hotelStrPO = hotelStrVO.toPO();
		try {
			ResultMessage resultMessage = hotelStrategyDao.setHotelStrategy(hotelStrPO);
			if (resultMessage == ResultMessage.SUCCESS) {
				double discount = hotelStrVO.getDiscount();

				// 给酒店的可用客房设置最低价格
				AvailableRoom availableRoom = new AvailableRoom();
				availableRoom.setBestPrice(hotelStrVO.getHotelID(), discount);
			}
			return resultMessage;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
}
