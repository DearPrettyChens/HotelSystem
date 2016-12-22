package rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * RMI的配置，便于端口 的修改，避免在代码中重复出现url
 * @author csy
 *
 */
public class RMIconfig {
	private static int port;
	private static String url; 
    private static String ip;
    
	static {
        setUrl("rmi://127.0.0.1:8890/");
		try {
			//运用相对路径解决读取文件问题
			URL address=RMIconfig.class.getResource("RMIConfig.txt");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader( address.openStream()));
			
			ip = reader.readLine();
			port = Integer.parseInt(reader.readLine());
			setUrl("rmi://" + ip + ":" + port + "/");			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		RMIconfig.ip = ip;
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

	public static void main(String[] args) {
		System.out.println(RMIconfig.getUrl());
	}
}
