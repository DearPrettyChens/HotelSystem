package presentation.ui.checkinui.viewcontroller;
/**
 * 控制线上入住界面跳转的接口
 * @author CLL
 *
 */
public interface OnlineCheckinViewControllerService {
	/**
	 * 转至填写酒店住房信息界面
	 */
	public void jumpToHotelCheckInfoView();
	/**
	 * 无订单提示
	 */
	public void showNotFoundOrder();
	/**
	 * 输入错误提示
	 */
	public void showMistakeInfo();
	/**
	 * 显示订单信息
	 */
	public void showOrderInfo();
	/**
	 * 返回主界面
	 */
	public void jumpToMainFrame();
}
