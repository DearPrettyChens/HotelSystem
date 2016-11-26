package rmi;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 * RMI配置
 * @author csy
 *
 */
public class RMIHelper {
	private static String url = RMIconfig.getUrl();
	private static int port = RMIconfig.getPort();
    private static RMIMap rmiMap=RMIMap.getInstance();
	
	/**
	 * 遍历每个dao，配置rmi
	 */
	public static void relate() {
		try {
			while (rmiMap.hasNext()) {
				rmiMap.next();
				Naming.bind(url + rmiMap.getDaoName(), rmiMap.getDao());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void connect() {
		try {            
			LocateRegistry.createRegistry(port);
			relate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
