package businesslogic.bl.hotelstrategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.checkinbl.mock.MockAvailableRoom;
import businesslogic.bl.hotelbl.Hotel;
import dao.hotelstrategydao.HotelStrategyDao;
import exception.NotFoundHotelException;
import init.RMIHelper;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelBasicInfoVO;
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

		RMIHelper.init();
		hotelStrategyDao = RMIHelper.getHotelStrategyDao();
		hotelStrategyMap = new HotelStrategyMap();

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
		HotelStrategyType hotelStrategyType = HotelStrategyType.NULLTYPE; // 表示无酒店策略

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

		if (discount == 1) {// 该酒店没有任何酒店策略，没有折扣
			hotelStrategyType = HotelStrategyType.NULLTYPE;
		}

		if (hotelStrategyType == HotelStrategyType.NULLTYPE) {
			discount = 1;// 该酒店没有任何酒店策略，没有折扣
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
				double discount = getHotelLowestDiscount(hotelStrVO.getHotelID());

				if (hotelStrVO.getType() == HotelStrategyType.ENTERPRISE) {
					ArrayList<String> enterprises=hotelStrVO.getEnterprise();
					String tempEnterprises="";
					for(String enterprise:enterprises){
						tempEnterprises=tempEnterprises +enterprise+" ";
					}
					HotelBasicInfoVO hotelBasicInfoVO;
					String hotelID = hotelStrVO.getHotelID();
					try {
						Hotel hotel=new Hotel();
						hotelBasicInfoVO = hotel.getHotelBasicInfo(hotelID);
					    hotelBasicInfoVO.setEnterprises(tempEnterprises);
					    hotel.confirmModifyInfo(hotelBasicInfoVO);
					} catch (NotFoundHotelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				// 给酒店的可用客房设置最低价格
				AvailableRoom availableRoom = new AvailableRoom();
				availableRoom.setBestPrice(hotelStrVO.getHotelID(), discount);
				// MockAvailableRoom mockAvailableRoom=new MockAvailableRoom();
				// mockAvailableRoom.setBestPrice(hotelStrVO.getHotelID(),
				// discount);
			}
			return resultMessage;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 
	 * 获得酒店所有策略的最低折扣
	 * 
	 * @param hotelID
	 * @return
	 */
	public double getHotelLowestDiscount(String hotelID) {
		hotelStrategyMap = new HotelStrategyMap();
		double discount = 1;// 折扣值在0-1之间,没有折扣就是1
		while (hotelStrategyMap.hasNext()) {
			hotelStrategyMap.next();
			hotelStrategyInterface = hotelStrategyMap.getHotelStrategy();
			double tempDiscount = hotelStrategyInterface.getDiscount(hotelID);
			// 选取折扣最大的，即折扣值最小的。
			if (tempDiscount < discount) {
				discount = tempDiscount;
			}
			if(tempDiscount==0){
				discount=1;
			}
		}

		return discount;
	}

}
