package businesslogic.bl.hotelstrategybl;

/**
 * 
 * 酒店营销策略工厂
 * 
 * @author CSY
 *
 */
public class HotelStrategyFactory {

	private static HotelStrategyFactory hotelStrategyFactory;

	private HotelStrategyFactory() {

	}

	public static HotelStrategyFactory getInstance() {
		if (hotelStrategyFactory == null) {
			hotelStrategyFactory = new HotelStrategyFactory();
		}
		return hotelStrategyFactory;
	}

}
