package rmi;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
/**
 * RMI配置
 * @author csy
 *
 */
public class RMIHelper {
	private static String url = RMIconfig.getUrl();
	private static int port = RMIconfig.getPort();
    private static RMIMap rmiMap=RMIMap.getInstance();
	private static Remote remote;
	/**
	 * 遍历每个dao，配置rmi
	 */
	private static void relate() {
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
		remote=null;
		try {            
			remote=LocateRegistry.createRegistry(port);
			relate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void release() {
		if(remote==null){
			return;
		}
		try {
			UnicastRemoteObject.unexportObject(remote, true);
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}
		remote=null;
	}
}
