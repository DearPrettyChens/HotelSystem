package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.bl.webstrategybl.WebStrategyInterface;
import presentation.ui.availableroomui.view.RoomInfo_JPanel;
import presentation.ui.checkinui.view.CheckInInfo_JPanel;
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
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
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
 * 左边的选择栏
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Basic_JPanel extends JPanel {

	private JLabel jl4 = new JLabel();
	private RightContainerPanel rightContainerPanel;
	private LeftChooseMap leftChooseMap;
	private String labelName;

	ArrayList<Basic_JPanel> allpanel;
	int tab;

	public Basic_JPanel(String s, String image, int tab, ArrayList<Basic_JPanel> allpanel,
			RightContainerPanel rightContainerPanel,String userName,String userID,UserType userType) {
		this.leftChooseMap=LeftChooseMap.getInstance(userName,userID,userType);
		this.labelName = s;
		this.rightContainerPanel = rightContainerPanel;

		this.tab = tab;
		this.allpanel = allpanel;
		JLabel jl1 = new JLabel();
		jl1.setText(s);
		jl1.setFont(new Font("宋体", Font.BOLD, 16));
		jl1.setForeground(Color.white);

		ImageIcon icon = new ImageIcon(Basic_JPanel.class.getResource(image));
		JLabel jl2 = new JLabel(icon);
		jl2.setBounds(30, 24, 30, 34);
		this.add(jl2);

		ImageIcon icon1 = new ImageIcon(Basic_JPanel.class.getResource("image/triangle.png"));
		jl4.setIcon(icon1);
		jl4.setBounds(185, 16, 20, 50);
		this.add(jl4);
		jl4.setVisible(false);

		jl1.setBounds(80, 6, 120, 69);
		// jl1.setOpaque(true);

		this.setBackground(new Color(148, 221, 184));

		this.setLayout(null);
		this.add(jl1);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				// TODO Auto-generated method stub
				Basic_JPanel.this.setBackground(new Color(133, 196, 163));
				Basic_JPanel.this.jl4.setVisible(true);
				String info = Basic_JPanel.this.labelName;
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
					ChooseOrderTypetoClient_JPanel c=new ChooseOrderTypetoClient_JPanel(userID,null);
					c.changeToOrderListPanel(null);
					jpanel=c;
					break;
				case ClientCreditInfos_JPanel:
					jpanel=new ClientCreditInfos_JPanel(userID);
					break;
				case Clientlevelrule_JPanel:
					jpanel=new Clientlevelrule_JPanel();
					break;
				case DepositPanel:
					DepositPanel.destory();
					jpanel=DepositPanel.getInstance();
					break;
				case HotelStrategyPanel:
					HotelStrategyPanel hotelStrategyPanel=HotelStrategyPanel.getInstance(leftChooseMap.hotelID);
					hotelStrategyPanel.changeToChooseHotelStrPanel();
					jpanel=hotelStrategyPanel;
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
					MyFootView.destory();
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
					//ReserveHotelView.destory();
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

				for (int i = 0; i < allpanel.size(); i++) {
					if (i != Basic_JPanel.this.tab) {

						allpanel.get(i).setBackground(new Color(148, 221, 184));

						allpanel.get(i).jl4.setVisible(false);

					}

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

				jl1.setForeground(new Color(225, 255, 255));
				jl1.setFont(new Font("宋体", Font.BOLD, 18));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jl1.setForeground(Color.WHITE);
				jl1.setFont(new Font("宋体", Font.BOLD, 16));
			}

		});

	}

	/**
	 * 用于初始化左边栏第一项
	 */
	public void init() {
		// TODO Auto-generated method stub
		Basic_JPanel.this.setBackground(new Color(133, 196, 163));
		Basic_JPanel.this.jl4.setVisible(true);

		for (int i = 0; i < allpanel.size(); i++) {
			if (i != Basic_JPanel.this.tab) {

				allpanel.get(i).setBackground(new Color(148, 221, 184));

				allpanel.get(i).jl4.setVisible(false);

			}

		}
	}

}
