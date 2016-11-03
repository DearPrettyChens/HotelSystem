package businesslogic.bl.hotelstrategybl.mock;

import java.util.ArrayList;

import businesslogic.bl.availableroombl.SingleAvailableRoomInfo;
import dao.availableroomdao.AvailableRoomDao;
import util.ResultMessage;
/**
 * availableroom的mock类
 * @author CLL
 * @version 1.0
 */
public class MockAvailableRoom {
	//可用住房信息列表
	private ArrayList<SingleAvailableRoomInfo> singleAvailableRoomInfoList;
	//数据层的引用
	private AvailableRoomDao availableRoomDao;
	public MockAvailableRoom(){
		
	}
	
	/**
	 * 更新各种房型的最低价格，遍历list，更新其中的房型价格
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage setBestPrice(String hotelID,double discount) {
		// TODO 
		return ResultMessage.SUCCESS;
	}
}
