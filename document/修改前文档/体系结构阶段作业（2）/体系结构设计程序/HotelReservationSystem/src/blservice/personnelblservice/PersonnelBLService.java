package blservice.personnelblservice;

import java.util.ArrayList;
import common.ResultMessage;
import vo.personnelvo.CustomerDetailVO;
import vo.personnelvo.CustomerListVO;
import vo.personnelvo.HotelWorkerDetailVO;
import vo.personnelvo.HotelWorkerListVO;
import vo.personnelvo.HotelWorkerVO;
import vo.personnelvo.WebMarketManDetailVO;
import vo.personnelvo.WebMarketManListVO;
import vo.personnelvo.WebMarketManVO;

/**
 * PersonnelBLService提供接口，用来对用户信息的增改查的管理，注册会员
 * @author csy
 * @version 1.0
 * 
 */
public interface PersonnelBLService {
	
	/**
	 * 验证用户名是否正确以及已存在
	 * @param userName String型，传递用户名
	 * @return ResultMessage，用户名唯一且正确返回SUCCESS,用户名格式错误返回USERFORMATERROR，用户名已存在返回USEREXISTED
	 * @throws 未定
	 *
	 */
	public ResultMessage checkUserName(String userName);
	
	/**
	 * 检查电话格式
	 * @param tel String型，传递联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkUserTel(String userTel);
	
	/**
	 * 检查酒店电话格式
	 * @param telNum String型，传递酒店电话
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回HOTELTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkHotelTel(String hotelTel);
	
	/**
	 * 检查密码格式
	 * @param password String型，传递密码
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回PASSWORDFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkPassword(String password);
	
	/**
	 * 注册会员，保存顾客信息
	 * @param CustomerDetailVO customerDetailVO型，界面传递过来的顾客详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmRegister (CustomerDetailVO customerDetailVO);
	
	/**
	 * 增加酒店及其工作人员信息
	 * @param HotelWorkerDetailVO hotelWorkerDetailVO型，界面传递过来的酒店工作人员详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage addHotelWorker (HotelWorkerDetailVO hotelWorkerDetailVO);
	
	/**
	 * 增加网站营销人员信息
	 * @param WebMarketManDetailVO webMarketManDetailVO型，界面传递过来的酒店工作人员详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage addWebMarketMan  (WebMarketManDetailVO webMarketManDetailVO);
	
	/**
	 * 获取酒店工作人员列表信息
	 * @param 无
	 * @return ArrayList<HotelWorkerListVO>，将酒店工作人员列表信息返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelWorkerListVO> getHotelWorkerList();
	
	/**
	 * 获取网站营销人员列表信息
	 * @param 无
	 * @return ArrayList<WebMarketManListVO>，将网站营销人员列表信息返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<WebMarketManListVO> getWebMarketManList();
	
	/**
	 * 获取顾客列表信息
	 * @param 无
	 * @return ArrayList<CustomerListVO>，将顾客列表信息返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<CustomerListVO> getCustomerList();
	
	/**
	 * 获取酒店工作人员详细信息
	 * @param hotelID String型，传递酒店编号
	 * @return HotelWorkerDetailVO ，将酒店工作人员详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public HotelWorkerDetailVO getHotelWorkerDetail(String hotelID);
	
	/**
	 * 获取网站营销人员详细信息
	 * @param webWorkerManID String型，传递网站营销人员编号
	 * @return WebMarketManDetailVO ，将网站营销人员详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public WebMarketManDetailVO getWebWorkerManDetail(String webWorkerManID);
	
	/**
	 * 获取顾客详细信息
	 * @param CustomerID String型，传递顾客编号
	 * @return CustomerDetailVO ，将顾客详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public CustomerDetailVO getCustomerDetail(String customerID);
	
	/**
	 * 修改酒店及其工作人员信息
	 * @param HotelWorkerDetailVO hotelWorkerDetailVO型，界面传递过来的酒店工作人员详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage modifyHotelworker(HotelWorkerDetailVO hotelWorkerDetailVO);
	
	/**
	 * 修改网站营销人员信息
	 * @param WebMarketManDetailVO webMarketManDetailVO型，界面传递过来的酒店工作人员详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage modifyWebMarketMan(WebMarketManDetailVO webMarketManDetailVO);
	
	/**
	 * 修改顾客信息
	 * @param CustomerDetailVO customerDetailVO型，界面传递过来的顾客详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage modifyCustomer(CustomerDetailVO customerDetailVO);
	
}
