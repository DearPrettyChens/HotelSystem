package businesslogic.bl.hotelstrategybl;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import util.HotelStrategyType;
import util.TransHelper;
import vo.ordervo.OrderProvidedVO;

/**
 * 
 * 用于取最佳策略时的遍历，可修改性好
 * @author CSY
 *
 * 运用组合，然后模仿iterator来写hasNext,next
 */
public class ProvidedInfoMap {
	private Map<HotelStrategyType, String> map;	private Iterator<Map.Entry<HotelStrategyType, String>> entries = map.entrySet().iterator();
	private Map.Entry<HotelStrategyType, String> entry;
	
	public ProvidedInfoMap(OrderProvidedVO orderProvidedVO){
		 String customerID=orderProvidedVO.getCustomerID();
	     int amount=orderProvidedVO.getAmount();
	     String enterpriceName=orderProvidedVO.getEnterpriceName();
	     Date time=orderProvidedVO.getTime();
		if(customerID!=null){
			map.put(HotelStrategyType.BIRTH,customerID);
		}
		if(amount!=0){
			String tempAmount=String.valueOf(amount);
			map.put(HotelStrategyType.AMOUNT,tempAmount);
		}
		if(enterpriceName!=null){
			map.put(HotelStrategyType.ENTERPRISE, enterpriceName);
		}
	    if(time!=null){
	    	String tempTime=TransHelper.dateToString(time);
		    map.put(HotelStrategyType.SPECIALTIME, tempTime);
	    }
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
	
	public String getInfo() {
		String info=entry.getValue();
		return info;
	}
	
	public String get(HotelStrategyType hotelStrategyType) {
		return map.get(hotelStrategyType);
	}

}
