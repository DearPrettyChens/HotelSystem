package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.availableroomui.view.RoomInfo_JPanel;
import presentation.ui.checkinui.view.CheckInPanel;
import presentation.ui.checkinui.view.CheckOutPanel;
import presentation.ui.checkinui.view.OfflineCheckIn_JPanel;
import presentation.ui.creditui.view.ClientCreditInfos_JPanel;
import presentation.ui.creditui.view.DepositPanel;
import presentation.ui.hotelstrategyui.view.HotelStrategyPanel;
import presentation.ui.hotelui.view.MaintainHotelBasicInfoPanel;
import presentation.ui.hotelui.view.client.MyFootView;
import presentation.ui.hotelui.view.client.ReserveHotelView;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.orderui.view.OrderPanelViewInHotelWorker;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.personnelui.view.client.ManageCustomerPanel;
import presentation.ui.personnelui.view.hotelworker.ManageHotelWorkerPanel;
import presentation.ui.personnelui.view.webmarketman.ManageWebMarketManPanel;
import presentation.ui.userui.view.Changemessage_JPanel;
import presentation.ui.userui.view.Changepassword_JPanel;
import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import util.LeftChoosePanel;
import util.UserType;

/**
 * 酒店工作人员左边的选择栏
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworker_JLabel  extends JLabel{
	private RightContainerPanel rightContainerPanel;
	private LeftChooseMap leftChooseMap;
	private String name;
	int tab;
	ArrayList<Hotelworker_JLabel> alllabels;
	 public Hotelworker_JLabel (String s,int tab,ArrayList<Hotelworker_JLabel> alllabels,RightContainerPanel rightContainerPanel,String userName,String userID,UserType userType){
		 this.leftChooseMap=LeftChooseMap.getInstance(userName,userID,userType);
		 this.setText(s);
		 this.rightContainerPanel=rightContainerPanel;
		 name=s;
		 this.tab=tab;
		 this.alllabels=alllabels;
		 Hotelworker_JLabel.this.setForeground(Color.GRAY);
		 Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 16));
		 this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Hotelworker_JLabel.this.setForeground(Color.BLACK);
            	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
				String info =Hotelworker_JLabel.this.name;
				LeftChoosePanel panel = leftChooseMap.get(info);
				JPanel jpanel=new JPanel();
				switch(panel){
				case Changemessage_JPanel:
					jpanel=new Changemessage_JPanel(userID);
					break;
				case Changepassword_JPanel:
					jpanel=new Changepassword_JPanel(UserType.Customer,userID,userName);
					break;
				case CheckInPanel:
					jpanel=CheckInPanel.getInstance(leftChooseMap.hotelID);
					break;
				case CheckOutPanel:
					jpanel=CheckOutPanel.getInstance(leftChooseMap.hotelID);
					break;
				case ChooseOrderTypetoClient_JPanel:
					jpanel=new ChooseOrderTypetoClient_JPanel(userID, leftChooseMap.hotelID);
					break;
				case ClientCreditInfos_JPanel:
					jpanel=new ClientCreditInfos_JPanel(userID);
					break;
				case Clientlevelrule_JPanel:
					jpanel=new Clientlevelrule_JPanel();
					break;
				case DepositPanel:
					jpanel=DepositPanel.getInstance();
					break;
				case HotelStrategyPanel:
					jpanel=HotelStrategyPanel.getInstance(leftChooseMap.hotelID);
					break;
				case MaintainHotelBasicInfoPanel:
					jpanel=new MaintainHotelBasicInfoPanel(leftChooseMap.hotelID);
					break;
				case Makewebstr_JPanel:
					jpanel= new Makewebstr_JPanel();
					break;
				case ManageCustomerPanel:
					jpanel=ManageCustomerPanel.getInstance();
					break;
				case ManageHotelWorkerPanel:
					jpanel=ManageHotelWorkerPanel.getInstance();
					break;
				case ManageWebMarketManPanel:
					jpanel= ManageWebMarketManPanel.getInstance();
					break;
				case MyFootView:
					jpanel=MyFootView.getInstance(userID);
					break;
				case OfflineCheckIn_JPanel:
					jpanel=new OfflineCheckIn_JPanel(leftChooseMap.hotelID);
					break;
				case OrderPanelInWebMarketMan:
					jpanel=OrderPanelInWebMarketMan.getInstance();
					break;
				case OrderPanelViewInHotelWorker:
					jpanel=OrderPanelViewInHotelWorker.getInstance(leftChooseMap.hotelID);
					break;
				case ReserveHotelView:
					jpanel=ReserveHotelView.getInstance(userID,userName);
					break;
				case RoomInfo_JPanel:
					jpanel=new RoomInfo_JPanel(leftChooseMap.hotelID);
					break;
				default:
					break;
				
				}
				rightContainerPanel.removeAll();
				rightContainerPanel.repaint();
				rightContainerPanel.add(jpanel);
				
				for (int i = 0; i < alllabels.size(); i++) {
					if (i != Hotelworker_JLabel.this.tab) {
						alllabels.get(i).setForeground(Color.GRAY);
//		            	 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
		            	 alllabels.get(i).setFont(new Font("宋体",Font.BOLD, 16));

					}

				}
				
				
			}
	            @Override
	             public void mouseEntered(MouseEvent e) {
	            	
	             }
	 
	             @Override
	          public void mouseExited(MouseEvent e) {

	             }
	         });
	    }
		 
		 
	 /**
		 * 用于初始化左边栏第一项
		 */
		public void init() {
			Hotelworker_JLabel.this.setForeground(Color.BLACK);
        	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
		}
		 
	 }
	
	


