package presentation.ui.hotelstrategyui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelEnterpriseStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelOverThreeStr_Jpanel;
import presentation.ui.hotelstrategyui.view.HotelSpecialTimeStr_JPanel;
import util.HotelStrategyType;

/**
 * 酒店工作人员制定酒店策略时界面跳转的控制器
 * @author CLL
 *
 */
public class HotelStrategyViewControllerImpl implements HotelStrategyViewControllerService {
	private JPanel view;//发起界面跳转请求的界面（选择策略类型界面）
	public HotelStrategyViewControllerImpl(JPanel panel){
		this.view=panel;
	}
	@Override
	public void selectStrategyType(HotelStrategyType type) {
		switch(type){
		case AMOUNT:
			view.add(new HotelOverThreeStr_Jpanel());
			break;
		case BIRTH:
			view.add(new HotelBirthStr_JPanel());
			break;
		case ENTERPRISE:
			view.add(new HotelEnterpriseStr_JPanel());
			break;
		case SPECIALTIME:
			view.add(new HotelSpecialTimeStr_JPanel());
			break;
		default:
			break;
		
		}
	}

	@Override
	public void addStrategySuccess(HotelStrategyType type) {
		switch(type){
		case AMOUNT:
			view.removeAll();
			view.add(new HotelOverThreeStr_Jpanel());
			break;
		case BIRTH:
			view.removeAll();
			view.add(new HotelBirthStr_JPanel());
			break;
		case ENTERPRISE:
			view.removeAll();
			view.add(new HotelEnterpriseStr_JPanel());
			break;
		case SPECIALTIME:
			view.removeAll();
			view.add(new HotelSpecialTimeStr_JPanel());
			break;
		default:
			break;
		}
	}

	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}
	
	@Override
	public void backToselectStrategy(){
		view.removeAll();
	}
}
