package businesslogic.bl.hotelstrategybl;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

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
	     private Iterator<EnumMap.Entry<HotelStrategyType, HotelStrategyInterface>> entries ;
	 	private EnumMap.Entry<HotelStrategyType, HotelStrategyInterface> entry;
	     
	     
	 	 public HotelStrategyMap() {
	 		hotelStrategyFactory=HotelStrategyFactory.getInstance();
	 		enumMap=new EnumMap<HotelStrategyType, HotelStrategyInterface>(HotelStrategyType.class);
	 		enumMap.put(HotelStrategyType.SPECIALTIME, hotelStrategyFactory.getHotelSpecialTimeStrategy());
	 	    enumMap.put(HotelStrategyType.AMOUNT, hotelStrategyFactory.getHotelAmountStrategy());
	 	    enumMap.put(HotelStrategyType.BIRTH, hotelStrategyFactory.getHotelBirthStrategy());
	 	    enumMap.put(HotelStrategyType.ENTERPRISE, hotelStrategyFactory.getHotelEnterpriseStrategy());	      
	 	
	 	   entries = enumMap.entrySet().iterator();
	 	 }

	 	
	 	
	 	public boolean hasNext(){
			return entries.hasNext();
		}
		public void next() {
			entry=entries.next();
		}
		
		public HotelStrategyType getHotelStrategyType() {
			HotelStrategyType hotelStrategyType=entry.getKey();
			return hotelStrategyType;
		}
		
		public HotelStrategyInterface getHotelStrategy() {
			HotelStrategyInterface info=entry.getValue();
			return info;
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
