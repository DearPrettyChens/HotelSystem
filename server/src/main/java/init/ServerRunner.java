package init;

import rmi.RMIHelper;

public class ServerRunner {

	public static void main(String[] args) {
		RMIHelper.connect();
        System.out.println("服务器端RMI连接OK");
	}

}
