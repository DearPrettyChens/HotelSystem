package presentation.ui.webstrategyui.distributecontroller;

import java.util.Date;

import businesslogic.bl.webstrategybl.WebStrategyController;
import businesslogic.blservice.webstrategyblservice.WebStrategyBLService;
import util.ResultMessage;
import util.TradingArea;
import util.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebStrVO;
import vo.webstrategyvo.WebProvidedVO;

/**
 * 
 * @author CLL
 *
 */
public class WebstrategyDistributionController {
	private static WebstrategyDistributionController controller=null;
	private WebStrategyBLService webStrategyBLService;
	private WebstrategyDistributionController(){
//		webStrategyBLService=WebStrategyController.getInstance();
	    webStrategyBLService=new WebStrategyBLService_Stub();
	}
	public static WebstrategyDistributionController getInstance(){
		if(controller==null){
			controller=new WebstrategyDistributionController();
		}
		return controller;
	}
	
	/**
	 * 获取最佳网站策略
	 * @param credit String型,area TradingArea型,time Date型，传递策略所需的信用值商圈和时间
	 * @return WebBestStrVO ，将最佳网站策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public WebBestStrVO getWebBestStrategy(String credit,TradingArea area,Date time){
		return webStrategyBLService.getWebBestStrategy(new WebProvidedVO(credit, area, time));
	}
	
	/**
	 * 获取会员等级规则
	 * @param 无
	 * @return GradeRuleVO，将会员等级规则返回给界面
	 * @throws 未定
	 *
	 */
	public GradeRuleVO getGradeRule(){
		return webStrategyBLService.getGradeRule();
	}
	
	/**
	 * 获取网站策略
	 * @param type WebStrategyType型，传递策略类型
	 * @return WebStrVO ，将网站策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public WebStrVO getWebStrategy(WebStrategyType type){
		return webStrategyBLService.getWebStrategy(type);
	}
	
	
	/**
	 * 保存网站会员等级规则信息
	 * @param gradeRuleVO GradeRuleVO型，界面传递过来的会员等级规则信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 *注意点：方法里面要有检测：checkDiscountRank：（折扣范围）
	 *checkTime：（保证从小到大）checkPositiveNum：（保证输入正数）
	 */
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO){
		return webStrategyBLService.confirmGradeRule(gradeRuleVO);
	}
	
	/**
	 * 保存网站策略信息
	 * @param webStrVO WebStrVO型，界面传递过来的网站策略信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO){
		return webStrategyBLService.confirmWebStrategy(webStrVO);
	}
}
