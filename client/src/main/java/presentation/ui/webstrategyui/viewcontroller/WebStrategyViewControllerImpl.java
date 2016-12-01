package presentation.ui.webstrategyui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import presentation.ui.webstrategyui.view.WebSpecialAreaStr_JPanel;
import presentation.ui.webstrategyui.view.Webclientlevelstr_Jpanel;
import presentation.ui.webstrategyui.view.Webspecialtimestr_JPanel;
import util.WebStrategyType;
/**
 * 制定网站营销策略界面的控制器
 * @author CLL
 *
 */
public class WebStrategyViewControllerImpl implements  WebStrategyViewControllerService{
	private JPanel view;//发起界面跳转的界面对象
	public WebStrategyViewControllerImpl(JPanel view){
		this.view=view;
	}
	
	@Override
	public void addStrategySuccess(WebStrategyType type) {
		view.removeAll();
		switch(type){
		case SPECIALAREA:
			view.add(new WebSpecialAreaStr_JPanel());
			break;
		case SPECIALTIME:
			view.add(new Webspecialtimestr_JPanel());
			break;
		case VIP:
			view.add(new Webclientlevelstr_Jpanel());
			break;
		default:
			break;
		}
	}

	@Override
	public void modifyVIPRuleSuccess() {
		view.removeAll();
		view=new Clientlevelrule_JPanel();
	}
	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}

	@Override
	public void selectStrategyType(WebStrategyType type) {
		switch(type){
		case SPECIALAREA:
			view.add(new WebSpecialAreaStr_JPanel());
			break;
		case SPECIALTIME:
			view.add(new Webspecialtimestr_JPanel());
			break;
		case VIP:
			view.add(new Webclientlevelstr_Jpanel());
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void backToselectStrategy() {
		view.removeAll();
	}

}
