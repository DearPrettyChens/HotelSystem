package security;

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

public class RMISSLClientSocketFactory implements RMIClientSocketFactory, Serializable {

	public RMISSLClientSocketFactory() {
	}

	public Socket createSocket(String host, int port) {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			KeyStore ks = KeyStore.getInstance("JKS");
			KeyStore tks = KeyStore.getInstance("JKS");
			// ks.load(new FileInputStream(client_crt), this.password
			// .toCharArray());
			// tks.load(new FileInputStream(server_crt), this.password
			// .toCharArray());

			URL tclient = RMIconfig.class.getResource("../config/keys/tclient.keystore");
			URL kclient = RMIconfig.class.getResource("../config/keys/kclient.keystore");
			ks.load(kclient.openStream(), "123456".toCharArray());
			tks.load(tclient.openStream(), "123456".toCharArray());

			kmf.init(ks, "123456".toCharArray());
			tmf.init(tks);
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			SSLSocket socket = (SSLSocket) ctx.getSocketFactory().createSocket(host, port);
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