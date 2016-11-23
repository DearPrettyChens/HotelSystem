package businesslogic.bl.webstrategybl;

import java.util.EnumMap;

import util.WebStrategyType;

/**
 * 
 * 用于创建对象时避免switch,case的情况
 * @author CSY
 *
 */
public class WebStrategyMap {
     private WebStrategyInterface webStrategyInterface;
     private EnumMap<WebStrategyType, WebStrategyInterface> enumMap;
     private WebStrategyFactory webStrategyFactory;
     private static WebStrategyMap webStrategyMap;
 	 private WebStrategyMap() {
 		 webStrategyFactory=WebStrategyFactory.getInstance();
 		enumMap=new EnumMap<WebStrategyType, WebStrategyInterface>(WebStrategyType.class);
 	    enumMap.put(WebStrategyType.SPECIALTIME, webStrategyFactory.getWebSpecialTimeStrategy());
 	    enumMap.put(WebStrategyType.SPECIALAREA, webStrategyFactory.getWebSpecialAreaStrategy());
 	    enumMap.put(WebStrategyType.VIP, webStrategyFactory.getWebVIPStrategy());
 	      
 	}

 	public static WebStrategyMap getInstance(){
 		if(webStrategyMap==null){
 			webStrategyMap=new WebStrategyMap();
 		}
 		return webStrategyMap;
 	}
 	
 	/**
 	 * 返回对应的WebStrategy
 	 * @param webStrategyType
 	 * @return WebStrategyInterface
 	 */
 	public WebStrategyInterface get(WebStrategyType webStrategyType){
 		webStrategyInterface=enumMap.get(webStrategyType);
 		return webStrategyInterface;
 	}
	
}
