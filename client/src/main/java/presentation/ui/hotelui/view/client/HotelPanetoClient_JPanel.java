package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.orderui.view.client.SingleOrderListInfotoClient;
import util.ViewTag;

/**
 * 酒店详细信息总面板
 * @author cy
 * @version 1.0
 *
 * 
 */
public class HotelPanetoClient_JPanel  extends JPanel{
	
	private HotelGeneralInfotoClient_JPanel hotelGeneralInfotoClient_JPanel;
	private String hotelID;
	private String userID;
	private ViewTag tag;
	private JLabel returnjl = new JLabel("< 返回酒店列表");
	 private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
	    private MyFootViewController myFootViewController=MyFootViewController.getInstance(null);
		
	
    public  HotelPanetoClient_JPanel(String hotelID,String userID,ViewTag ViewTag){
		this.hotelID=hotelID;
		this.userID=userID;
		this.tag=ViewTag;
    	hotelGeneralInfotoClient_JPanel=new HotelGeneralInfotoClient_JPanel(hotelID, userID,ViewTag);
    	
    	this.setSize(800,600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
    
    public void addComp(){
    	hotelGeneralInfotoClient_JPanel.setBounds(0, 0, 800, 550);
    	this.add(hotelGeneralInfotoClient_JPanel);
		
		

	returnjl.setFont(new Font("宋体", Font.BOLD, 14));
	returnjl.setForeground(new Color(148, 221, 184));
	returnjl.setBounds(40, 550, 100, 30);
	this.add(returnjl);
	returnjl.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (tag) {
			case HOTELRESERVERSION:
				reserveHotelViewController.returnToHotelListView();;
				break;
			case MYHOTEL:
				myFootViewController.returnToHotelListView();
				break;
			default:
				break;
			
			}

		}

	});
		
	}
	
}

