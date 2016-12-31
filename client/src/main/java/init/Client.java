package init;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import presentation.ui.loginui.view.Login_JFrame;
import presentation.ui.tools.Logingif_JFrame;
import util.BedType;

public class Client {
	public static void main(String[] args) {
<<<<<<< HEAD
	     
		
	   
	   JFrame frame=new Login_JFrame();
	   
	   RMIHelper.init();
	  
=======

		JFrame frame = new login_JFrame();

		RMIHelper.init();

>>>>>>> origin/master
	}

}
