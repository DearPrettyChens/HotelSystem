package dao.personneldao;

import java.util.ArrayList;
import po.CustomerDetailPO;
import po.CustomerListPO;
import po.HotelWorkerDetailPO;
import po.HotelWorkerListPO;
import po.WebMarketManDetailPO;
import po.WebMarketManListPO;
import util.ResultMessage;

/**
 * PersonnelDao提供借口，用来进行对账户数据的一系列操作，包括注册、添加、获取、设置网站用户的信息
 * @author CYF
 * @version 1.0
 *
 */


public interface PersonnelDao {
	/**
	 * 
	 */
	public void initial();
	/**
	 * 注册顾客信息
	 * @param customerDetailPO CustomerDetailPO型，用来传递顾客注册时的详细信息
	 * @return ResultMessage，如果注册成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 * 
	 */
	public ResultMessage addCustomer(CustomerDetailPO customerDetailPO);
	/**
	 * 添加酒店工作人员信息
	 * @param hotelWorkerDetailPO HotelWorkerDetailPO型，用来传递添加酒店工作人员时的详细信息
	 * @return ResultMessage，如果添加成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 * 
	 */
	public ResultMessage addHotelworker(HotelWorkerDetailPO hotelWorkerDetailPO);
	/**
	 * 添加网站营销人员信息
	 * @param webMarketManDetailPO WebMarketManDetailPO型，用来传递添加网站营销人员详细信息
	 * @return ResultMessage，如果添加成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 * 
	 */
	public ResultMessage addWebMarketMan(WebMarketManDetailPO webMarketManDetailPO);
	/**
	 * 获得酒店酒店工作人员列表信息
	 * @param 无
	 * @return ArrayList<HotelWorkerListPO> 用来获取酒店工作人员列表信息
	 * @throws 未定
	 */
	public ArrayList<HotelWorkerListPO>  getHotelWorkerList();
	/**
	 * 获得网站营销人员列表信息
	 * @param 无
	 * @return ArrayList<WebMarketManListPO> 用来获取网站营销人员列表信息
	 * @throws 未定
	 */
	public ArrayList<WebMarketManListPO>  getWebMarketManList();
	/**
	 * 获得顾客列表信息
	 * @param 无
	 * @return ArrayList<CustomerListPO> 用来获取顾客列表信息
	 * @throws 未定
	 */
	public ArrayList<CustomerListPO>  getCustomerList();
	/**
	 * 获得酒店工作人员详细信息
	 * @param hotelID String型，用来传递酒店ID
	 * @return HotelWorkerDetailPO 用来获取酒店工作人员详细信息
	 * @throws 未定
	 */
	public HotelWorkerDetailPO  getHotelWorkerDetail(String hotelID);
	/**
	 * 获得网站营销人员详细信息
	 * @param webWorkerManID String型 用来传递网站人员ID
	 * @return WebMarketManDetailPO 用来获取网站营销人员详细信息
	 * @throws 未定
	 */
	public WebMarketManDetailPO  getWebMarketManDetail(String webMarketManID);
	/**
	 * 获得顾客详细信息
	 * @param customerID String型 用来传递顾客ID
	 * @return CustomerDetailPO 用来获取顾客详细信息
	 * @throws 未定
	 */
	public CustomerDetailPO  getCustomerDetail(String customerID);
	/**
	 * 设置酒店工作人员信息
	 * @param hotelWorkerDetailPO HotelWorkerDetailPO型 用来传递酒店工作人员信息
	 * @return ResultMessage，如果修改成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setHotelWorker (HotelWorkerDetailPO hotelWorkerDetailPO);
	/**
	 * 设置网站营销人员信息
	 * @param webMarketManDetailPO WebMarketManDetailPO型 用来传递网站营销人员信息
	 * @return ResultMessage，如果修改成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setWebMarketMan (WebMarketManDetailPO webMarketManDetailPO);
	/**
	 * 未定设置顾客信息
	 * @param customerDetailPO CustomerDetailPO型 用来传递顾客信息
	 * @return ResultMessage，如果修改成功则返回SUCCESS，如果失败则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setCustomer (CustomerDetailPO customerDetailPO);
}
