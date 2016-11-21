package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import data.datahelper.AvailableRoomDataHelper;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;

public class AvailableRoomDataHelperDatabaseImpl implements AvailableRoomDataHelper {

	@Override
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException {
		return null;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException {
		return 0;
	}

	@Override
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type)
			throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException {
		return null;
	}

}
