package presentation.ui.orderui.viewcontroller;

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
	public void showOrderDetailInfo(String ordernumber,String clientname,String clienttel,
			String ordertime,String latestcheckintime,String realcheckintime,String checkouttime,
			String orderstate,String hotelname, String hoteltel,String payment,
			String roomtype,String bedtype);
	/**
	 * 关闭订单详细信息窗口
	 */
	public void closeOrderDetail();
	/**
	 * 返回酒店工作人员主界面
	 */
	public void jumpToMainFrame();
}
