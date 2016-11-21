package businesslogic.bl.checkinbl;

import java.rmi.RemoteException;
import java.util.Date;

import dao.checkindao.CheckinDao;
import po.CheckinInfoPO;
import util.BedType;
import util.ResultMessage;
/**
 * 模拟checkindao的实现
 * @author CLL
 *
 */
public class CheckinDao_Stub implements CheckinDao{

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		CheckinInfoPO po=new CheckinInfoPO("chen","123456789123456789","12345678999","商务间",
				BedType.BIGBED,"201",new Date(),null,000002,"20161119000002000001");
		return po;
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
