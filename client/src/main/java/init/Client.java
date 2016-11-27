package init;

import java.rmi.RemoteException;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import util.BedType;

public class Client {
	public static void main(String[] args) {
	     RMIHelper.init();
	     System.out.println("客户端连接成功");
	     AvailableRoomDao availableRoomDao=RMIHelper.getAvailableRoomDao();
	     try {
			System.out.println(availableRoomDao.addAvailableRoomInfo(new AvailableRoomInfoPO(13, "hhhh", BedType.BIGBED, 444, 333, 5,3)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
