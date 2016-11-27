package security;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.rmi.ssl.SslRMIClientSocketFactory;

import rmi.RMIconfig;  
  
public class MySSLRMIClientSocketFactory extends SslRMIClientSocketFactory {  
  
    /** 
     *  
     * 这个类继承了SslRMIClientSocketFactory，我也是看文档的， 
     * 那个什么什么说SslRMIClientSocketFactory为了避免各种各种的问题 
     * 都是使用默认的jre中配置的证书来创建socket，要是你自己的客户端能验证服务器 
     * ，服务器验证你的客户端，而且是使用自己的证书，就重写一下createSocket这个方法。。。云云 那就重写吧 
     */  
    private static final long serialVersionUID = 1L;  
  
    public MySSLRMIClientSocketFactory() {  
        super();  
    }  
  
    @Override  
    public Socket createSocket(String host, int port) throws IOException {  
    	
    	URL key=RMIconfig.class.getResource("../config/keys/trustserver.jks");
    	URL client=RMIconfig.class.getResource("../config/keys/client.jks");

//        String key = "d:/keys/trustm.jks";  
//        String client = "d:/keys/client.jks";  
        try {  
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());  
//            keyStore.load(new FileInputStream(key), "123456".toCharArray());  
            keyStore.load(key.openStream(), "123456".toCharArray());
            KeyStore clientStore = KeyStore.getInstance(KeyStore  
                    .getDefaultType());  
//            clientStore.load(new FileInputStream(client),  "123456".toCharArray());  
            clientStore.load(client.openStream(),  "123456".toCharArray());  
            TrustManagerFactory tmf = TrustManagerFactory  
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());  
            tmf.init(keyStore);  
            KeyManagerFactory kmf = KeyManagerFactory  
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());  
            kmf.init(clientStore, "123456".toCharArray());  
            SSLContext sslc = SSLContext.getInstance("TLSv1");  
            sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),  
                    new SecureRandom());  
            /*上面的没什么好说的了。。。就是要说说，证书换成了客户端要信任的证书和客户端的秘钥*/  
              
            SSLSocketFactory sslSocketFactory = sslc.getSocketFactory();//通过sslc获得socketFactory  
            SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(host, port);//建立socket  
            return socket;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
  
    }  
  
    @Override  
    public int hashCode() {  
        return super.hashCode();  
    }  
  
    @Override  
    public boolean equals(Object obj) {  
        return super.equals(obj);  
    }  
    public static void main(String[] args) {
		
			MySSLRMIClientSocketFactory mySSLRMIClientSocketFactory=new MySSLRMIClientSocketFactory();
	
			try {
				mySSLRMIClientSocketFactory.createSocket("localhost", RMIconfig.getPort());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        System.out.println("服务器端RMI连接OK");
	}
  
}  