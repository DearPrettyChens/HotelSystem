package businesslogic.bl.userbl;

import java.rmi.RemoteException;

public class mytest3 {
public static void main(String [] args){
	User user = User.getInstance();
		System.out.println(user.login("小菲菲", "feifei"));
		System.out.println(user.logout());
		System.out.println(user.login("小菲菲", "feifei"));
}
}
