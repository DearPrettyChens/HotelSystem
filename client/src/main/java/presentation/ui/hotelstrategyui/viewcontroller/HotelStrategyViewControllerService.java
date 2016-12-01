package presentation.ui.hotelstrategyui.viewcontroller;

import util.HotelStrategyType;

/**
 * 控制酒店工作人员制定酒店策略时界面的接口
 * @author CLL
 *
 */
public interface HotelStrategyViewControllerService {
	/**
	 * 选择制定策略类型
	 */
	public void selectStrategyType(HotelStrategyType type);
	
	/**
	 * 制定策略成功后更新策略列表
	 */
	public void addStrategySuccess(HotelStrategyType type);

	/**
	 * 返回主界面
	 */
	public void jumpToMainFrame();
	/**
	 * 返回选择策略类型界面
	 */
	public void backToselectStrategy();
}
