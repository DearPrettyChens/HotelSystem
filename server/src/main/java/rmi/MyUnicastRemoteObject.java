package rmi;

import java.rmi.server.UnicastRemoteObject;

import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;

public class MyUnicastRemoteObject extends UnicastRemoteObject{

	public MyUnicastRemoteObject() throws Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(),new RMISSLServerSocketFactory());
	}

	
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2273454086080951304L;
//	public MyUnicastRemoteObject() throws RemoteException, IllegalArgumentException, Exception  {
//		  /** 
//         * 这个构造方法需要细细的说道一下了 
//         * 先说super 
//         *  
//         * 第一个参数指明了这个remoteObject接受请求的端口，我就设置成了0； 
//         *  
//         * 第二个参数设置客户端要使用的套接字工厂，我设置了自己实现的MySslRMIClientSocketFactory，这个具体是什么，后面介绍 
//         *  
//         * 第三个参数设置了服务端要是用的套接字工场，我是用了SslRMIServerSocketFactory；其中getContext在后面说， 
//         * new String[] { "SSL_RSA_WITH_RC4_128_MD5" }是加密算法，new String[] { "TLSv1" }使用的协议。 
//         *  
//         * 第四个参数是是否开启对客户端的验证，要做双向验证必然是true了 
//         *  
//         * */  
//        super(0, new MySSLRMIClientSocketFactory(),  
//                new SslRMIServerSocketFactory(getContext(),  
//                        new String[] { "SSL_RSA_WITH_RC4_128_MD5" },  
//                        new String[] { "TLSv1" }, true));  
//		
//	}
//	 public static SSLContext getContext() throws Exception {  
//		    URL key=RMIconfig.class.getResource("../config/keys/kserver.jks");
//	    	URL trust=RMIconfig.class.getResource("../config/keys/trustclient.jks");
//
////	        String key = "d:/keys/m.jks";//服务器端的秘钥  
////	        String trust = "d:keys/trustclient.jks";//服务器端信任的证书  
//	        KeyStore keyStore = KeyStore.getInstance("JKS");//使用JKS的keyStore  
//	        /*加载服务器的秘钥开始*/  
////	        keyStore.load(new FileInputStream(key), "123456".toCharArray());  
//	        keyStore.load(key.openStream(), "123456".toCharArray());
//	        KeyStore trustStore = KeyStore.getInstance("JKS");  
//	        /*加载服务器的秘钥结束*/  
//	        
//	        /*加载服务器信任的证书开始*/  
////	        trustStore.load(new FileInputStream(trust), "123456".toCharArray());  
//	        trustStore.load(trust.openStream(), "123456".toCharArray());
//	        /*加载服务器信任的证书结束*/  
//	          
//	        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory  
//	                .getDefaultAlgorithm());//创建了秘钥管理工厂  
//	        kmf.init(keyStore, "123456".toCharArray());//用服务器的秘钥来初始化秘钥工厂  
//	        TrustManagerFactory tmf = TrustManagerFactory  
//	                .getInstance(TrustManagerFactory.getDefaultAlgorithm());//建立了信任证书工厂  
//	        tmf.init(trustStore);//用服务器信任的证书来初始化  
//	        SSLContext sslc = SSLContext.getInstance("TLSv1");//获得context实例  
//	        sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),  
//	                new SecureRandom());//初始化context  
//	        return sslc;  
//	    }  
//	 public static void main(String[] args) {
//			try {
//				MyUnicastRemoteObject myUnicastRemoteObject=new MyUnicastRemoteObject();
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        System.out.println("服务器端RMI连接OK");
//		}

}
