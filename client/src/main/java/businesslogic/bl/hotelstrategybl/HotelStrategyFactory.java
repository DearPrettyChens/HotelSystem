package businesslogic.bl.hotelstrategybl;

/**
 * 
 * 酒店营销策略工厂
 * 
 * @author CSY
 *
 */
public class HotelStrategyFactory {
    private HotelStrategyInterface hotelStrategyInterface;
	private static HotelStrategyFactory hotelStrategyFactory;
	
	private HotelStrategyFactory() {

	}

	public static HotelStrategyFactory getInstance() {
		if (hotelStrategyFactory == null) {
			hotelStrategyFactory = new HotelStrategyFactory();
		}
		return hotelStrategyFactory;
	}

	public HotelStrategyInterface getHotelAmountStrategy() {
		hotelStrategyInterface=HotelAmountStrategy.getInstance();
		return hotelStrategyInterface;
	}
	
	public HotelStrategyInterface getHotelBirthStrategy(){
		hotelStrategyInterface=HotelBirthStrategy.getInstance();
		return hotelStrategyInterface;
	}
	
	public HotelStrategyInterface getHotelEnterpriseStrategy() {
		hotelStrategyInterface=HotelEnterpriseStrategy.getInstance();
		return hotelStrategyInterface;
	}
	
	public HotelStrategyInterface getHotelSpecialTimeStrategy(){
		hotelStrategyInterface=HotelSpecialTimeStrategy.getInstance();
		return hotelStrategyInterface;
	}
}
