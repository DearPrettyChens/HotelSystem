package businesslogic.webstrategybl;

import java.util.Date;

import blservice.webstrategyblservice.WebStrategyBLService;
import common.TradingArea;
import common.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 模拟网站营销策略模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class WebStrategyBL_Driver {
    public void drive(WebStrategyBLService stub) {
		WebBestStrVO webBestStrVO=stub.getWebBestStrategy("123", TradingArea.XINJIEKOU, new Date());
	    GradeRuleVO gradeRuleVO=stub.getGradeRule();
        WebStrVO webStrVO=stub.getWebStrategy(WebStrategyType.SPECIALAREA);
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new WebStrategyBL_Driver().drive(new WebStrategyBL_Stub());
	}

}
