package rmi;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

import security.MySSLRMIClientSocketFactory;  
  
public class RMIRegistry {  
    public static void main(String[] args) throws Exception { 
    	int port=RMIconfig.getPort();
    	 URL key=RMIconfig.class.getResource("../config/keys/kserver.jks");
    	 URL trust=RMIconfig.class.getResource("../config/keys/trustclient.jks");
//        String key = "d:/keys/m.jks";  
//        String trust = "d:keys/trustclient.jks";  
        KeyStore keyStore = KeyStore.getInstance("JKS");  
//        keyStore.load(new FileInputStream(key), "123456".toCharArray());  
        keyStore.load(key.openStream(), "123456".toCharArray());
        KeyStore trustStore = KeyStore.getInstance("JKS");  
//        trustStore.load(new FileInputStream(trust), "123456".toCharArray());
        trustStore.load(trust.openStream(), "123456".toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory  
                .getDefaultAlgorithm());  
        kmf.init(keyStore, "123456".toCharArray());  
        TrustManagerFactory tmf = TrustManagerFactory  
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());  
        tmf.init(trustStore);  
        SSLContext sslc = SSLContext.getInstance("TLSv1");  
        sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),  
                new SecureRandom());  
        /*上面的一套代码就是生成一个指定了秘钥和信任证书的context，就不多说了*/  
          
        /*下面我们在300端口创建一个registry，并且指定了客户端套接字和服务端套接字，和HelloImpl_1中的很像*/  
        LocateRegistry.createRegistry(port, new MySSLRMIClientSocketFactory(),  
                new SslRMIServerSocketFactory(sslc,  
                        new String[] { "SSL_RSA_WITH_RC4_128_MD5" },  
                        new String[] { "TLSv1" }, true));  
        System.out.println("RMI Registry running on port 3000");  
        Object object = new Object();  
        synchronized (object) {  
            object.wait();  
        }  
  
    }  
}  
