package businesslogic.bl.webstrategybl;

/**
 * 
 * 网站营销策略工厂
 * @author CSY
 *
 */
public class WebStrategyFactory {
	private WebStrategyInterface webStrategyInterface;
	private static WebStrategyFactory webStrategyFactory;
	private WebStrategyFactory(){
		
	}
	public static WebStrategyFactory getInstance() {
		if(webStrategyFactory==null){
			webStrategyFactory=new WebStrategyFactory();
		}
		return webStrategyFactory;
	}
	
    public WebStrategyInterface getWebSpecialTimeStrategy() {
    	webStrategyInterface=WebSpecialTimeStrategy.getInstance();
		return webStrategyInterface;
	}
    public WebStrategyInterface getWebSpecialAreaStrategy() {
    	webStrategyInterface=WebSpecialAreaStrategy.getInstance();
		return webStrategyInterface;
	}
    public WebStrategyInterface getWebVIPStrategy() {
    	webStrategyInterface=WebVIPStrategy.getInstance();
		return webStrategyInterface;
	}
    
}
