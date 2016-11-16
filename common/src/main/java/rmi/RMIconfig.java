package rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * RMI的配置，便于端口 的修改，避免在代码中重复出现url
 * @author csy
 *
 */
public class RMIconfig {
	private static int port;
	

	private static String url;// = "rmi://127.0.0.1:" + port + "/";

	static {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("common\\RMIConfig.txt")));
			String IP = reader.readLine();
			port = Integer.parseInt(reader.readLine());
			setUrl("rmi://" + IP + ":" + port + "/");
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		RMIconfig.url = url;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		RMIconfig.port = port;
	}
}
