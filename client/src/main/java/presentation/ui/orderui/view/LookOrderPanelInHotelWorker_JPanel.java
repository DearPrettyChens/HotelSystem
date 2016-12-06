package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.tools.newclient_JLabel;
import util.OrderState;
import util.UserType;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 * 酒店工作人员我的订单选项中的浏览订单列表的面板
 * @author csy
 *
 */

public class LookOrderPanelInHotelWorker_JPanel extends JPanel {
	private ViewOrderToHotelWorker_JPanel viewOrderToHotelWorker_JPanel=new ViewOrderToHotelWorker_JPanel();//搜索框
	
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private HotelDistributionController hotelDistributionController=HotelDistributionController.getInstance();
	private static ArrayList<OrderListInfoToHotelWorker_JPanel> orderListInfoToHotelWorker_JPanels;
	private String hotelID;
	
	public LookOrderPanelInHotelWorker_JPanel(String hotelID) {
		
		this.hotelID=hotelID;
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		this.setLayout(null);
		addComp();
	}

	public void addComp() {
		//设置订单状态选择框
        viewOrderToHotelWorker_JPanel.setBounds(0, 0, 800, 100);
        this.add(viewOrderToHotelWorker_JPanel);
        
	     //设置列表
	    scrollPane.setBounds(0, 100, 800, 550);
	    scrollPane.setBackground(Color.WHITE);
	    scrollPane.setBorder(null);
	   
	    initOrderList();
	    this.add(scrollPane);
        
	}
	/**
	 * 界面初始化获得所有该酒店的订单信息
	 */
	public void initOrderList() {
		ArrayList<HotelOrderVO> orderListVOs=hotelDistributionController.getHotelOrderList(hotelID);
	    changeScrollPane(orderListVOs);
	}
    
	/**
	 * 由于检索，改变滚动条面板
	 */
	public void changeScrollPane(ArrayList<HotelOrderVO>orderListVOs) {
		searchResultPanel=new JPanel();
		searchResultPanel.setLayout(null);
		searchResultPanel.repaint();
//		scrollPane.repaint();
		searchResultPanel.setBackground(Color.WHITE);
		 orderListInfoToHotelWorker_JPanels=new ArrayList<OrderListInfoToHotelWorker_JPanel>();
		for(HotelOrderVO orderListVO:orderListVOs){
	    	OrderListInfoToHotelWorker_JPanel orderListInfoToHotelWorker_JPanel=new OrderListInfoToHotelWorker_JPanel(orderListVO);
	    	orderListInfoToHotelWorker_JPanels.add(orderListInfoToHotelWorker_JPanel);
	    }
	    for(int i=0;i<orderListInfoToHotelWorker_JPanels.size();i++){
	    	OrderListInfoToHotelWorker_JPanel orderListInfoToHotelWorker_JPanel=orderListInfoToHotelWorker_JPanels.get(i);
	    	orderListInfoToHotelWorker_JPanel.setBounds(100, 10+120*i, 800, 100);
	    	searchResultPanel.add(orderListInfoToHotelWorker_JPanel);
	    }
	    searchResultPanel.setPreferredSize(new Dimension(800, 120+120*orderListInfoToHotelWorker_JPanels.size()));
	    scrollPane.setViewportView(searchResultPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	    this.add(scrollPane);
	}

}
