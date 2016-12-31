package businesslogic.bl.webstrategybl;

import java.util.Date;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import util.TradingArea;
import util.TransHelper;
import util.WebStrategyType;
import vo.webstrategyvo.WebProvidedVO;

/**
 * 
 * 用于取最佳策略时的遍历，可修改性好
 * 每种策略种类对应相关的界面提供的策略信息
 * 运用组合，然后模仿iterator来写hasNext,next
 * 
 * @author CSY
 */
public class ProvidedInfoMap {
	private Map<WebStrategyType, String> map;
	private Iterator<Map.Entry<WebStrategyType, String>> entries;
	private Map.Entry<WebStrategyType, String> entry;
	
	public ProvidedInfoMap(WebProvidedVO webProvidedVO){
		map=new EnumMap<WebStrategyType, String>(WebStrategyType.class);
		init(webProvidedVO);
	    entries = map.entrySet().iterator();
	}
	
	private void init(WebProvidedVO webProvidedVO) {
		String credit=webProvidedVO.getCredit();
		TradingArea area=webProvidedVO.getArea();
		Date time=webProvidedVO.getTime();
		
		//根据界面提供的策略信息（信用值，商圈，时间）进行初始化
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
	
	
	/**
	 * 根据策略种类获取相关的界面提供的策略信息
	 * @param webStrategyType
	 * @return
	 */
	public String get(WebStrategyType webStrategyType) {
		return map.get(webStrategyType);
	}
}
