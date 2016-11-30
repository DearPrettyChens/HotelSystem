package presentation.ui.orderui.viewcontroller;
/**
 * 控制网站营销人员管理订单的界面的接口
 * @author CLL
 *
 */
public interface ManageOrderViewControllerService {
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
	 * 撤销订单后更新订单列表
	 */
	public void cancelOrder();
}
