package init;

public class Client {
	public static void main(String[] args) {
	     RMIHelper.init();
	     System.out.println("客户端连接成功");
//	     AvailableRoomDao availableRoomDao=RMIHelper.getAvailableRoomDao();
//	     try {
//			System.out.println(availableRoomDao.addAvailableRoomInfo(new AvailableRoomInfoPO()));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
