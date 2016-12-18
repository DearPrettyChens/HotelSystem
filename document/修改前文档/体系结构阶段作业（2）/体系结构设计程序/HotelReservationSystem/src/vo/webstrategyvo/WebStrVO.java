package vo.webstrategyvo;

import common.Strategy;
/**
 * 网站所有的营销策略
 * @author CYF
 * @version
 */
public class WebStrVO {

	//网站策略
	private Strategy strategy;
    public WebStrVO(){
    }
	public WebStrVO(Strategy strategy) {
		this.setStrategy(strategy);
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

}
