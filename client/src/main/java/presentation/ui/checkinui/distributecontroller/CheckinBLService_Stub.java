package presentation.ui.checkinui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.blservice.checkinblservice.CheckinBLService;
import po.CheckinInfoPO;
import po.OrderInfoPO;
import util.BedType;
import util.Children;
import util.OrderState;
import util.Remark;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;
import vo.ordervo.OrderInfoVO;

public class CheckinBLService_Stub implements CheckinBLService{

	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		OrderInfoVO vo=new OrderInfoVO( orderID, "chen", "chen", "12345678999", 
				"南京绿地洲际酒店", "000002", "12345678999", "商务间", BedType.BIGBED, 1,
				new Date(), 1, Children.EXIST, Remark.NO, new Date(), new Date(), new Date(), null,null, 685, OrderState.NOTEXECUTED, null);
		return vo;
	}

	@Override
	public CheckinInfoVO getCheckinInfo(String orderID) {
		// TODO Auto-generated method stub
		CheckinInfoVO vo=new CheckinInfoVO("chen","123456789123456789","12345678999","201","商务间",
				BedType.BIGBED,null,null,"000002","20161119000002000001");
		
		return vo;
	}

	@Override
	public ResultMessage checkIDLength(String ID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, BedType bedType, int number) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) {
		// TODO Auto-generated method stub
		AvailableRoomInfoVO vo=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10);
		ArrayList<AvailableRoomInfoVO> list=new ArrayList<AvailableRoomInfoVO>();
		list.add(vo);
		return list;
	}

}
