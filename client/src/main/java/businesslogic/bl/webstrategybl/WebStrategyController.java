package businesslogic.bl.webstrategybl;

import java.util.Date;

import businesslogic.blservice.webstrategyblservice.WebStrategyBLService;
import util.ResultMessage;
import util.TradingArea;
import util.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebStrVO;
/**
 * WebStrategyController类
 * @author CYF
 * @version 1.0
 */
public class WebStrategyController implements WebStrategyBLService{
    //网站策略
	private WebStrategy webStrategy;
	private static WebStrategyBLService webStrategyController;
	
	public WebStrategyController(){
		webStrategy = new WebStrategy();
	}
	
	public static WebStrategyBLService getInstance() {
		if(webStrategyController==null){
			webStrategyController=new WebStrategyController();
		}
		return webStrategyController;
	}
	
	@Override
	public WebBestStrVO getWebBestStrategy(String credit, TradingArea area, Date time) {
		return webStrategy.getWebBestStrategy(credit, area, time);
	}

	@Override
	public GradeRuleVO getGradeRule() {
		return webStrategy.getGradeRule(new WebGradeRule());
	}

	@Override
	public WebStrVO getWebStrategy(WebStrategyType type) {
		//按照上课讲的应该是用factory构建对象webStrategyInterface，暂时只能这么写
		switch(type){
		case VIP : return webStrategy.getWebStrategy(new WebVIPStrategy());
		case SPECIALTIME:return webStrategy.getWebStrategy(new WebSpecialTimeStrategy());
		case SPECIALAREA:return webStrategy.getWebStrategy(new WebSpecialAreaStrategy());
		default: return null;
		}
	}
	@Override
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO) {
		return webStrategy.confirmGradeRule(new WebGradeRule(),gradeRuleVO);
	}
	@Override
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO) {
		//return webStrategy.confirmWebStrategy(webStrVO);
		//解包 根据vo内容 再用factory构建对象webStrategyInterface 在参数传递中构建对应WebStrategy
		return null;
	}

}
