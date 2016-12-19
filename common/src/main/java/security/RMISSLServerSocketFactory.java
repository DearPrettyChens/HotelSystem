package security;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.rmi.server.RMIServerSocketFactory;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import rmi.RMIconfig;


/**
 * 实现RMIServerSocketFactory来创建自己的服务器端套接字工厂，
 * 使用自己的证书来创建socket，实现双向验证。
 * 
 * @author CSY
 *
 */
public class RMISSLServerSocketFactory implements RMIServerSocketFactory {
	private SSLServerSocketFactory ssf = null;
    private char[] password=SSLConfig.getPassword();
	public RMISSLServerSocketFactory() throws Exception {
		try {
			RMIconfig.getPort();

			SSLContext ctx = SSLContext.getInstance("SSL");//获得context实例 
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");//创建了秘钥管理工厂
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");//建立了信任证书工厂  
			KeyStore keyStore = KeyStore.getInstance("JKS");//使用JKS的keyStore  
			KeyStore trustKeyStore = KeyStore.getInstance("JKS");

//			URL tserver = RMIconfig.class.getResource("../config/keys/tserver.keystore");//服务器端信任的证书 地址
//			URL kserver = RMIconfig.class.getResource("../config/keys/kserver.keystore");//服务器端的秘钥地址
//			keyStore.load(kserver.openStream(), password);//加载服务器的秘钥
//			trustKeyStore.load(tserver.openStream(), password);//加载服务器信任的证书

			InputStream tis=RMIconfig.class.getResourceAsStream("../config/keys/tserver.keystore");   
			InputStream kis=RMIconfig.class.getResourceAsStream("../config/keys/kserver.keystore");   
			 keyStore.load(kis, password);//加载服务器的秘钥
			trustKeyStore.load(tis, password);;//加载服务器信任的证书
 
			
			kmf.init(keyStore, password);//用服务器的秘钥来初始化秘钥工厂
			tmf.init(trustKeyStore);//用服务器信任的证书来初始化  
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);//初始化context  
			ssf = ctx.getServerSocketFactory();//通过ctx获得socketFactory

		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/* 
	 * socketFactory来建立socket
	 */
	public ServerSocket createServerSocket(int port) throws IOException {
		SSLServerSocket mysslsocket = (SSLServerSocket) ssf.createServerSocket(port);
		mysslsocket.setNeedClientAuth(true);
		return mysslsocket;
	}

	public int hashCode() {
		return getClass().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

}
