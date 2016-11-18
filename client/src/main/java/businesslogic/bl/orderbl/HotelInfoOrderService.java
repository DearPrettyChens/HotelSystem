package businesslogic.bl.orderbl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelvo.HotelDetailInfoVO;

/**
 * Order模块的依赖倒置，将hotel的接口放在order中
 * @author csy
 * @version 1.0
 */
public interface HotelInfoOrderService {
       
	/**
	 * 订单模块添加酒店评价信息
	 * @param hotelID String型,remarkNumber int型 , remarkInfo String型，传递评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 *
	 */
	public ResultMessage addRemarkInfo(String hotelID,int remarkNumber,String remarkInfo);
	
	/**
	 * 订单模块获得可用客房信息
	 * @param hotelID String型，传递酒店编号
	 * @return AvailableRoomInfoVO，返回可用客房信息
	 *
	 */
    public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID);

    /**
	 * 订单模块获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给顾客看
	 *
	 */
    public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID);
}
