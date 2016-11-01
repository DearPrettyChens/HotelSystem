package businesslogic.blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.hotelvo.HotelBasicInfoVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
/**
 * HotelBLService提供接口，用来对酒店基本信息的维护
 * @author csy
 * @version 1.0
 * 
 */
public interface HotelBLService {
	/**
	 * 获取酒店基本信息
	 * @param hotelID String型，传递酒店编号
	 * @return HotelBasicInfoVO ，将酒店基本信息返回给界面，给工作人员看
	 * @throws 未定
	 *
	 */
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID);
	
	/**
	 * 获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给界面，给顾客看
	 * @throws 未定
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID);
	
	/**
	 * 检查酒店工作人员输入的酒店电话格式
	 * @param telNum String型，传递酒店电话
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回HOTELTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTel(String telNum);
	
	/**
	 * 保存维护的酒店信息
	 * @param hotelBasicInfoVO HotelBasicInfoVO型，界面传递过来的酒店基本信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmModifyInfo(HotelBasicInfoVO hotelBasicInfoVO);
	
	/**
	 * 获取酒店的订单列表
	 * @param hotelID String型，传递酒店编号
	 * @return ArrayList<HotelOrderVO>，返回酒店的订单列表给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID);
	
	/**
	 * 获取酒店的订单详细信息
	 * @param orderID String型，传递订单编号
	 * @return HotelOrderInfoVO，返回酒店的订单详细信息
	 * @throws 未定
	 *
	 */
	public HotelOrderInfoVO getHotelOrderInfo(String orderID);
	
}
