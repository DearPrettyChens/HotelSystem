package businesslogic.bl.availableroombl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
/**
 * 模拟availableroomdao的实现
 * @author CLL
 *
 */
public class AvailableRoomDao_Stub implements AvailableRoomDao{
	double price=100;
	@Override
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		AvailableRoomInfoPO po=new AvailableRoomInfoPO(000002,"商务间",BedType.BIGBED,100,price,10,8);
		ArrayList<AvailableRoomInfoPO> roomInfo=new ArrayList<AvailableRoomInfoPO>();
		roomInfo.add(po);
		return roomInfo;
	}

	@Override
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		AvailableRoomNumberPO po=new AvailableRoomNumberPO(8,type,date,TransHelper.idToInt(hotelID));
		return po;
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException {
		// TODO Auto-generated method stub
		return 80;
	}

	@Override
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException {
		// TODO Auto-generated method stub
		price=po.get(0).getLowestPrice();
		return ResultMessage.SUCCESS;
	}

}
