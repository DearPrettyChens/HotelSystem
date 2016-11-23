package businesslogic.bl.hotelstrategybl;

import java.util.EnumMap;

import util.HotelStrategyType;
/**
 * 
 * 用于创建对象时避免switch,case的情况
 * @author CSY
 *
 */
public class HotelStrategyMap {
	  private HotelStrategyInterface hotelStrategyInterface;
	     private EnumMap<HotelStrategyType, HotelStrategyInterface> enumMap;
	     private HotelStrategyFactory hotelStrategyFactory;
	     private static HotelStrategyMap hotelStrategyMap;
	 	 private HotelStrategyMap() {
	 		hotelStrategyFactory=HotelStrategyFactory.getInstance();
	 		enumMap=new EnumMap<HotelStrategyType, HotelStrategyInterface>(HotelStrategyType.class);
	 	    enumMap.put(HotelStrategyType.SPECIALTIME, hotelStrategyFactory.getHotelSpecialTimeStrategy());
	 	    enumMap.put(HotelStrategyType.AMOUNT, hotelStrategyFactory.getHotelAmountStrategy());
	 	    enumMap.put(HotelStrategyType.BIRTH, hotelStrategyFactory.getHotelBirthStrategy());
	 	    enumMap.put(HotelStrategyType.ENTERPRISE, hotelStrategyFactory.getHotelEnterpriseStrategy());	      
	 	}

	 	public static HotelStrategyMap getInstance(){
	 		if(hotelStrategyMap==null){
	 			hotelStrategyMap=new HotelStrategyMap();
	 		}
	 		return hotelStrategyMap;
	 	}
	 	
	 	/**
	 	 * 返回对应的hotelStrategy
	 	 * @param hoteltrategyType
	 	 * @return hotelStrategyInterface
	 	 */
	 	public HotelStrategyInterface get(HotelStrategyType hotelStrategyType){
	 		hotelStrategyInterface=enumMap.get(hotelStrategyType);
	 		return hotelStrategyInterface;
	 	}
}
