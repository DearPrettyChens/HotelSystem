package businesslogic.bl.webstrategybl;

import businesslogic.blservice.webstrategyblservice.WebStrategyBLService;
import util.ResultMessage;
import util.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;
/**
 * WebStrategyController类
 * @author CYF
 * @version 1.0
 */
public class WebStrategyController implements WebStrategyBLService{
    //网站策略
	private WebStrategy webStrategy;
	private WebGradeRule webGradeRule;
	private static WebStrategyBLService webStrategyController;
	
	public WebStrategyController(){
		webStrategy = WebStrategy.getInstance();
		webGradeRule=WebGradeRule.getInstance();
	}
	
	public static WebStrategyBLService getInstance() {
		if(webStrategyController==null){
			webStrategyController=new WebStrategyController();
		}
		return webStrategyController;
	}
	
	@Override
	public WebBestStrVO getWebBestStrategy(WebProvidedVO webProvidedVO) {
		return webStrategy.getWebBestStrategy(webProvidedVO);
	}

	@Override
	public GradeRuleVO getGradeRule() {
		return webGradeRule.getGradeRule();
	}

	@Override
	public WebStrVO getWebStrategy(WebStrategyType type) {
		return webStrategy.getWebStrategy(type);
	}
	@Override
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO) {
		return webGradeRule.setGradeRule(gradeRuleVO);
	}
	@Override
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO) {
		return webStrategy.confirmWebStrategy(webStrVO);
	}

}
