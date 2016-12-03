package rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.context.support.StaticApplicationContext;

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

	private static InetAddress inetAddress;
	private static String hostAddress;
	private static boolean isStart = false;

	// private String
	public static void connect() {

		try {
			// 设置客户端和服务器端的套接字工厂，进行双向验证
			registry = LocateRegistry.createRegistry(RMIconfig.getPort(), new RMISSLClientSocketFactory(),
					new RMISSLServerSocketFactory());
			relate();
			isStart = true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 遍历每个dao，配置rmi
	 */
	private static void relate() {
		while (rmiMap.hasNext()) {
			rmiMap.next();
			try {
				// 不使用Naming，直接使用registry来绑定，此处不用指定url
				registry.bind(rmiMap.getDaoName(), rmiMap.getDao());
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

	/**
	 * 断开服务器端的连接
	 */
	public static void stop() {

		try {
			UnicastRemoteObject.unexportObject(registry, true);
			isStart = false;
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}

	}

	public static String getHostAddress() {
		if (inetAddress == null) {
			try {
				inetAddress = InetAddress.getLocalHost();
				hostAddress = inetAddress.getHostAddress();
			} catch (UnknownHostException e) {
				hostAddress = "cannot find host address";
				e.printStackTrace();
			}
		}
		return hostAddress;
	}

	public static boolean isStart() {
		return isStart;
	}

}
