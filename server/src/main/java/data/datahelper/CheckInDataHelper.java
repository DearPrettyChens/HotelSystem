package data.datahelper;

import java.rmi.RemoteException;

import po.CheckinInfoPO;
import util.ResultMessage;

public interface CheckInDataHelper {
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException;

	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException;

	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException;
}
