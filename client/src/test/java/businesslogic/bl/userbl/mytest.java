package businesslogic.bl.userbl;

import java.rmi.RemoteException;

public class mytest {
	public static void main(String[] args) {
		User user = User.getInstance();
		System.out.println(user.login("小菲菲", "feifei"));
//		try {
////			user.logout();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
