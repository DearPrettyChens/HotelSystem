package businesslogic.bl.webstrategybl;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import util.TradingArea;
import util.TransHelper;
import util.WebStrategyType;
import vo.webstrategyvo.WebProvidedVO;

/**
 * 
 * 用于取最佳策略时的遍历，可修改性好
 * @author CSY
 *
 * 运用组合，然后模仿iterator来写hasNext,next
 */
public class ProvidedInfoMap {
	private Map<WebStrategyType, String> map;
	private Iterator<Map.Entry<WebStrategyType, String>> entries = map.entrySet().iterator();
	private Map.Entry<WebStrategyType, String> entry;
	
	public ProvidedInfoMap(WebProvidedVO webProvidedVO){
		String credit=webProvidedVO.getCredit();
		TradingArea area=webProvidedVO.getArea();
		Date time=webProvidedVO.getTime();
		if(credit!=null){
			map.put(WebStrategyType.VIP, credit);
		}
		if(area!=null){
			String tempArea=TransHelper.areaToString(area);
			map.put(WebStrategyType.SPECIALAREA, tempArea);
		}
	    if(time!=null){
	    	String tempTime=TransHelper.dateToString(time);
		    map.put(WebStrategyType.SPECIALTIME, tempTime);
	    }
	}
	public boolean hasNext(){
		return entries.hasNext();
	}
	public void next() {
		entry=entries.next();
	}
	
	public WebStrategyType getWebStrategyType() {
	    WebStrategyType webStrategyType=entry.getKey();
		return webStrategyType;
	}
	
	public String getInfo() {
		String info=entry.getValue();
		return info;
	}
	
	public String get(WebStrategyType webStrategyType) {
		return map.get(webStrategyType);
	}
}
