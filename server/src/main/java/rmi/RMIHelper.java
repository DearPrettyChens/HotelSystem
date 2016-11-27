package rmi;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;

/**
 * RMI配置
 * 
 * @author csy
 *
 */
public class RMIHelper {
	private static String url = RMIconfig.getUrl();
	private static int port = RMIconfig.getPort();
	private static RMIMap rmiMap = RMIMap.getInstance();
	private static Registry registry;

	/**
	 * 遍历每个dao，配置rmi
	 */
	public static void connect() {

		try {
			registry = LocateRegistry.createRegistry(RMIconfig.getPort(), new RMISSLClientSocketFactory(),
					new RMISSLServerSocketFactory());
			relate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void relate() {
		// try {
		// while (rmiMap.hasNext()) {
		// rmiMap.next();
		// Naming.bind(url + rmiMap.getDaoName(), rmiMap.getDao());
		// }
		// } catch (MalformedURLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (AlreadyBoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		while (rmiMap.hasNext()) {
			rmiMap.next();
			try {
				// Remote remote=rmiMap.getDao();
				registry.bind(rmiMap.getDaoName(), rmiMap.getDao());
//				registry.bind(DaoName.AvailableRoomDao.name(), AvailableRoomDaoImpl.getInstance());
			} catch (AccessException e) {
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

	}


	// /**
	// * 断开服务器端的连接
	// */
	// public static void release() {
	// if(remote==null){
	// return;
	// }
	// try {
	// PortableRemoteObject.unexportObject(remote);
	// } catch (NoSuchObjectException e) {
	// e.printStackTrace();
	// }
	//
	// }
}
