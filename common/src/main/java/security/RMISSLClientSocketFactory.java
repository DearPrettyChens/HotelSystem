package security;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Socket;
import java.net.URL;
import java.rmi.server.RMIClientSocketFactory;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

import rmi.RMIconfig;

/**
 * 实现 RMIClientSocketFactory来创建自己的客户端套接字工厂， 使用自己的证书来创建socket，实现双向验证。
 * 在通信协议上附加SSL协议，确保通信的内容是加密的
 * 
 * 模拟场景：Server端和Client端通信，需要进行授权和身份的验证，即Client只能接受Server的消息，Server只能接受Client的消息。
 * 
 * 实现技术：JSSE（Java Security Socket Extension）是Sun为了解决在Internet上的安全通讯而推出的解决方案。它实现了SSL和TSL（传输层安全）协议。在JSSE中包含了数据加密，
 * 服务器验证，消息完整性和客户端验证等技术。通过使用JSSE，开发人员可以在客户机和服务器之间通过TCP/IP协议安全地传输数据。
 
 * 为了实现消息认证： 
 * Server需要： 1）KeyStore: 其中保存服务端的私钥 2）Trust KeyStore:其中保存客户端的授权证书
 * 同样，Client需要： 1）KeyStore：其中保存客户端的私钥 2）Trust KeyStore：其中保存服务端的授权证书
 * 
 * @author CSY
 *
 */
public class RMISSLClientSocketFactory implements RMIClientSocketFactory, Serializable {

	private char[] password;

	public RMISSLClientSocketFactory() {
		password = SSLConfig.getPassword();
	}

	public Socket createSocket(String host, int port) {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");// 获得context实例
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");// 创建了秘钥管理工厂
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");// 建立了信任证书工厂
			KeyStore keyStore = KeyStore.getInstance("JKS");// 使用JKS的keyStore
			KeyStore trustKeyStore = KeyStore.getInstance("JKS");

			URL tclient = RMISSLClientSocketFactory.class.getResource("keys/tclient.keystore"); // 客户端信任的证书
			URL kclient = RMISSLClientSocketFactory.class.getResource("keys/kclient.keystore");// 客户端的秘钥地址
			keyStore.load(kclient.openStream(), password);// 加载客户端的密钥
			trustKeyStore.load(tclient.openStream(), password);// 加载客户端信任的证书

//			InputStream tis=RMIconfig.class.getResourceAsStream("config/keys/tclient.keystore");   
//			InputStream kis=RMIconfig.class.getResourceAsStream("config/keys/kclient.keystore");   
//			 keyStore.load(kis, password);// 加载客户端的密钥
//			trustKeyStore.load(tis, password);// 加载客户端信任的证书

//			URL tclient = new URL("../config/keys/tclient.keystore"); // 客户端信任的证书
//			URL kclient = new URL("../config/keys/kclient.keystore");// 客户端的秘钥地址
//			keyStore.load(kclient.openStream(), password);// 加载客户端的密钥
//			trustKeyStore.load(tclient.openStream(), password);// 加载客户端信任的证书
			
//			InputStream tis=new FileInputStream("config/keys/tclient.keystore");   
//			InputStream kis=new FileInputStream("config/keys/kclient.keystore");   
//			 keyStore.load(kis, password);// 加载客户端的密钥
//			trustKeyStore.load(tis, password);// 加载客户端信任的证书
			
			kmf.init(keyStore, password);// 用客户端的秘钥来初始化秘钥工厂
			tmf.init(trustKeyStore);// 用客户端信任的证书来初始化
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);// 初始化context
			SSLSocket socket = (SSLSocket) ctx.getSocketFactory().createSocket(host, port);// 通过ctx获得socketFactory来建立socket
			return socket;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return null;
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