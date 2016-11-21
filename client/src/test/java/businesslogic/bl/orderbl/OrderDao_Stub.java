package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.orderdao.OrderDao;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import util.OrderState;
import util.ResultMessage;
/**
 * 模拟orderdao的实现
 * @author CLL
 *
 */
public class OrderDao_Stub implements OrderDao{
	OrderState state;
	@Override
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		OrderInfoPO po=new OrderInfoPO(null, orderID, null, null, null, null, null, null, null, null, 0, null, 0, null, false, null, null, null, null, null, 0, state, null);
		return po;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		state=po.getState();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
