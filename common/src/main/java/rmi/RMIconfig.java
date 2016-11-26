package rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * RMI的配置，便于端口 的修改，避免在代码中重复出现url
 * @author csy
 *
 */
public class RMIconfig {
	private static int port;
	private static String url; // = "rmi://127.0.0.1:" + port + "/";

	static {
//        setUrl("rmi://127.0.0.1:8888/");
		try {
			//运用相对路径解决读取文件问题
			URL address=RMIconfig.class.getResource("RMIConfig.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader( address.openStream()));
			String IP = reader.readLine();
			port = Integer.parseInt(reader.readLine());
			setUrl("rmi://" + IP + ":" + port + "/");			
			reader.close();
		} catch (IOException e) {
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

//	public static void main(String[] args) {
//		System.out.println(RMIconfig.getUrl());
//	}
}
