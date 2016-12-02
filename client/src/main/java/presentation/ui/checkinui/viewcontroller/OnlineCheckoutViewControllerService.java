package presentation.ui.checkinui.viewcontroller;
/**
 * 控制线上退房界面跳转的接口
 * @author CLL
 *
 */
public interface OnlineCheckoutViewControllerService {
	/**
	 * 转至填写酒店住房信息界面
	 */
	public void jumpToHotelCheckInfoView();
	/**
	 * 无订单提示
	 */
	public void showNotFoundOrder();
	/**
	 * 未入住提示
	 */
	public void showNotCheckin();
	/**
	 * 返回主界面
	 */
	public void jumpToMainFrame();
}
