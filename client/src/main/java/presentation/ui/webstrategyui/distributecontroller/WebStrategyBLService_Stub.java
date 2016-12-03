package presentation.ui.webstrategyui.distributecontroller;

import java.sql.Date;
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
		// TODO Auto-generated method stub
		WebBestStrVO vo=new WebBestStrVO(WebStrategyType.SPECIALAREA,0.6);
		return vo;
	}

	@Override
	public GradeRuleVO getGradeRule() {
		// TODO Auto-generated method stub
		GradeRuleVO vo=new GradeRuleVO(200);
		return vo;
	}

	@Override
	public WebStrVO getWebStrategy(WebStrategyType type) {
		// TODO Auto-generated method stub
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		Map<Integer, Double> area=new HashMap<Integer, Double>();
		area.put(TradingArea.XINJIEKOU.ordinal(), 0.5);
		Map<Integer, Double> vip=new HashMap<Integer, Double>();
		area.put(1, 0.5);
		switch(type){
		case SPECIALAREA:
			return new WebStrVO(area , 0.5, WebStrategyType.SPECIALAREA);
		case SPECIALTIME:
			return new WebStrVO(date, 0.5,WebStrategyType.SPECIALTIME);
		case VIP:
			return new WebStrVO(vip, 0.5, WebStrategyType.VIP);
		default:
			break;
			
		}
		return null;
	}

	@Override
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
