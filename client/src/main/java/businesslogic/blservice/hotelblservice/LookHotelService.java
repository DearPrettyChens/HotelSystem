package businesslogic.blservice.hotelblservice;

import exception.NotFoundHotelException;
import vo.hotelvo.HotelDetailInfoVO;

/**
 * LookHotelService提供接口，用来对酒店基本信息的维护
 * @author csy
 * @version 1.0
 * 
 */
public interface LookHotelService {
	/**
	 * 获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给界面，给顾客看
	 * @throws NotFoundHotelException 
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID) throws NotFoundHotelException;
}
