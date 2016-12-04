package presentation.ui.availableroomui.distributecontroller;

import java.util.ArrayList;

import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 
 * @author CLL
 *
 */
public class AvailableRoomInfoService_Stub implements AvailableRoomInfoService{

	@Override
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) {
		AvailableRoomInfoVO vo=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10);
		ArrayList<AvailableRoomInfoVO> list=new ArrayList<AvailableRoomInfoVO>();
		list.add(vo);
		return list;
	}

	@Override
	public ResultMessage confirmAvailableRoomInfo(String hotelID, AvailableRoomInfoVO availableRoomInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
