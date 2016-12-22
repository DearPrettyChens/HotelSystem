package presentation.ui.webstrategyui.distributecontroller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import businesslogic.blservice.webstrategyblservice.WebStrategyBLService;
import po.WebStrPO;
import util.ResultMessage;
import util.TradingArea;
import util.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;

public class WebStrategyBLService_Stub implements WebStrategyBLService{

	@Override
	public WebBestStrVO getWebBestStrategy(WebProvidedVO webProvidedVO) {
		WebBestStrVO vo=new WebBestStrVO(WebStrategyType.SPECIALAREA,0.6);
		return vo;
	}

	@Override
	public GradeRuleVO getGradeRule() {
		GradeRuleVO vo=new GradeRuleVO(200);
		return vo;
	}

	@Override
	public WebStrVO getWebStrategy(WebStrategyType type) {
		Calendar calendar1=Calendar.getInstance();
		calendar1.set(2016, 5, 20);
		Calendar calendar2=Calendar.getInstance();
		calendar2.set(2016, 12, 4);
		
		Date[] date=new Date[]{calendar1.getTime(),calendar2.getTime()};
		Map<Integer, Double> area=new HashMap<Integer, Double>();
		area.put(TradingArea.XINJIEKOU.ordinal(), 0.5);
		area.put(TradingArea.HUNANLU.ordinal(), 0.8);
		Map<Integer, Double> vip=new HashMap<Integer, Double>();
		vip.put(10, 0.9);
		vip.put(20, 0.8);
		vip.put(30, 0.7);
		switch(type){
		case SPECIALAREA:
			return new WebStrVO(area , 0.5, WebStrategyType.SPECIALAREA);
		case SPECIALTIME:
			return new WebStrVO(date, 0.75, WebStrategyType.SPECIALTIME);
		case VIP:
			return new WebStrVO(vip, 0.5, WebStrategyType.VIP);
		default:
			break;
			
		}
		return null;
	}

	@Override
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO) {
		return ResultMessage.SUCCESS;
	}

}
