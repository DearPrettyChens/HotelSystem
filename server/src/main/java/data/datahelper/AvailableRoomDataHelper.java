package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;

public interface AvailableRoomDataHelper {
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException;

	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException;

	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException;

	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException;

	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException;

	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type) throws RemoteException;

	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException;

}
