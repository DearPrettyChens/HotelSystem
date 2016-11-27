package security;

import java.io.IOException;
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

public class RMISSLServerSocketFactory implements RMIServerSocketFactory {
	private SSLServerSocketFactory ssf = null;

	public RMISSLServerSocketFactory() throws Exception {
		try {
			RMIconfig.getPort();

			SSLContext ctx = SSLContext.getInstance("SSL");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			KeyStore ks = KeyStore.getInstance("JKS");
			KeyStore tks = KeyStore.getInstance("JKS");
			// ks.load(new FileInputStream(new File(server_crt)),
			// password.toCharArray());
			// tks.load(new FileInputStream(new File(client_crt)),
			// password.toCharArray());

			URL tserver = RMIconfig.class.getResource("../config/keys/tserver.keystore");
			URL kserver = RMIconfig.class.getResource("../config/keys/kserver.keystore");
			ks.load(kserver.openStream(), "123456".toCharArray());
			tks.load(tserver.openStream(), "123456".toCharArray());

			kmf.init(ks, "123456".toCharArray());
			tmf.init(tks);
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			ssf = ctx.getServerSocketFactory();

		} catch (Exception err) {
			err.printStackTrace();
		}
	}

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

	// public static void main(String args[]) {
	// try {
	// File file=new File("1.txt");
	// new FileInputStream(file);
	// new FileInputStream("kclient.keystore");
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
