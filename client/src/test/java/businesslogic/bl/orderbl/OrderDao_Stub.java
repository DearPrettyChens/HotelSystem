package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dao.orderdao.OrderDao;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import util.BedType;
import util.Children;
import util.OrderState;
import util.ResultMessage;
/**
 * 模拟orderdao的实现
 * @author CLL
 *
 */
public class OrderDao_Stub implements OrderDao{
	static OrderState state=OrderState.NOTEXECUTED;
	@Override
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
		OrderInfoPO po=new OrderInfoPO("000001", orderID, "chen", "chen", "12345678999", 
				"南京绿地洲际酒店", "000002", "12345678999", "商务间", BedType.BIGBED, 1,
				new Date(), 1, Children.EXIST, false, new Date(), new Date(), new Date(), new Date(), new Date(), 685, state, null);
		return po;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException {
		ArrayList<OrderListPO> pos=new ArrayList<OrderListPO>();
		OrderListPO po1=new OrderListPO("201611030001000001","000001","chen",new Date(),OrderState.NOTEXECUTED);
		pos.add(po1);
		return pos;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException {
		ArrayList<OrderListPO> pos=new ArrayList<OrderListPO>();
		OrderListPO po1=new OrderListPO("201611030001000001","000001","chen",new Date(),OrderState.NOTEXECUTED);
		pos.add(po1);
		return pos;
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
		state=po.getState();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

}
