package businesslogic.blservice.hotelblservice;

import util.ResultMessage;
import vo.hotelvo.HotelBasicInfoVO;

/**
 * MaintainHotelService提供接口，用来对酒店基本信息的维护
 * @author csy
 * @version 1.0
 * 
 */
public interface MaintainHotelService {
	/**
	 * 获取酒店基本信息
	 * @param hotelID String型，传递酒店编号
	 * @return HotelBasicInfoVO ，将酒店基本信息返回给界面，给工作人员看
	 * @throws 未定
	 *
	 */
	public HotelBasicInfoVO getHotelBasicInfo(String hotelID);
	
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
}
