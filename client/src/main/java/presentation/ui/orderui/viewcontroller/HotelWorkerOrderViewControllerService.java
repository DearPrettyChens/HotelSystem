package presentation.ui.orderui.viewcontroller;
/**
 * 控制酒店工作人员查看订单界面跳转的接口
 * @author CLL
 *
 */
public interface HotelWorkerOrderViewControllerService {
	/**
	 * 显示订单详细信息窗口
	 * @param ordernumber
	 * @param clientname
	 * @param clienttel
	 * @param ordertime
	 * @param latestcheckintime
	 * @param realcheckintime
	 * @param checkouttime
	 * @param orderstate
	 * @param hotelname
	 * @param hoteltel
	 * @param payment
	 * @param roomtype
	 * @param bedtype
	 */
	public void showOrderDetailInfo(String ordernumber,String clientnumber,String tel,
			String bedtype,String ordertime,String orderstate,String latestcheckintime
			,String checkouttime,double price, String checkintime,String isremarked);
	/**
	 * 关闭订单详细信息窗口
	 */
	public void closeOrderDetail();
	/**
	 * 返回酒店工作人员主界面
	 */
	public void jumpToMainFrame();
}
