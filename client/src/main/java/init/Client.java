package init;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import presentation.ui.loginui.view.login_JFrame;
import presentation.ui.tools.Logingif_JFrame;
import util.BedType;

public class Client {
	public static void main(String[] args) {
	     
		
	   
	   JFrame frame=new login_JFrame();
	   
	   RMIHelper.init();
	  
	}

}
