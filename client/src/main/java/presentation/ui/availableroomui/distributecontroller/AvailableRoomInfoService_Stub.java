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
		AvailableRoomInfoVO vo1=new AvailableRoomInfoVO("000001","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo2=new AvailableRoomInfoVO("000002","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo3=new AvailableRoomInfoVO("000003","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo4=new AvailableRoomInfoVO("000004","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo5=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		
		ArrayList<AvailableRoomInfoVO> list=new ArrayList<AvailableRoomInfoVO>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
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
