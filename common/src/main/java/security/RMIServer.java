package security;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;


public class RMIServer extends UnicastRemoteObject {
 private static final int PORT = 8891;
 public RMIServer() throws Exception {
  super(PORT, new RMISSLClientSocketFactory(),new RMISSLServerSocketFactory());
 }
 public static void main(String args[]) {
  if (System.getSecurityManager() == null) {
   System.setSecurityManager(new RMISecurityManager());
  }
  try {
   Registry registry = LocateRegistry.createRegistry(PORT,
     new RMISSLClientSocketFactory(),
     new RMISSLServerSocketFactory());
   RMIServer obj = new RMIServer();
   registry.bind("HelloWorld", obj);
   System.out.println("HelloWorld bound in registry");
  } catch (Exception err) {
   err.printStackTrace();
  }
 }
 
 
 //这个可用于服务器端知道是哪个IP连接上来了
 public String execute() {
  String clientaddr = null;
  try {
   clientaddr = RemoteServer.getClientHost();
   System.out.println("connect from " + clientaddr);
   return "hello client " + clientaddr;
  } catch (Exception err) {
   err.printStackTrace();
  }
  return "hello client ";
 }
}
