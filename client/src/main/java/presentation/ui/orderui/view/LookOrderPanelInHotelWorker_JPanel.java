package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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

	private JLabel titlejl = new JLabel("浏览订单列表");
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private HotelDistributionController hotelDistributionController=HotelDistributionController.getInstance();
	private static ArrayList<OrderListInfoToHotelWorker_JPanel> orderListInfoToHotelWorker_JPanels;
	private String hotelID;
	private JComboBox stateJCombo;
	
	public LookOrderPanelInHotelWorker_JPanel(String hotelID) {
		
		this.hotelID=hotelID;
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		this.setLayout(null);
		addComp();
	}

	public void addComp() {
		titlejl.setFont( new Font("宋体", Font.BOLD, 20));
		titlejl.setBounds(40, 30, 800, 50);
		this.add(titlejl);
		
		//设置订单状态选择框
        viewOrderToHotelWorker_JPanel.setBounds(0, 50, 800, 100);
        this.add(viewOrderToHotelWorker_JPanel);
        stateJCombo=viewOrderToHotelWorker_JPanel.getStateSelect();
        
	     //设置列表
	    scrollPane.setBounds(0, 150, 800, 550);
	    scrollPane.setBackground(Color.WHITE);
	    scrollPane.setBorder(null);
	   
	    initOrderList();
	    this.add(scrollPane);
	    
	    /**
	     * 根据所选订单类型更新列表
	     */
	    stateJCombo.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				ArrayList<HotelOrderVO> orderListVOs=hotelDistributionController.getHotelOrderList(hotelID);
				ArrayList<HotelOrderVO> orders=new ArrayList<HotelOrderVO>();
				switch((String)stateJCombo.getSelectedItem()){
				case "已撤销":
					for(int i=0;i<orderListVOs.size();i++){
						if(orderListVOs.get(i).getState()==OrderState.HASCANCELED){
							orders.add(orderListVOs.get(i));
						}
					}
					break;
				case "已执行":
					for(int i=0;i<orderListVOs.size();i++){
						if(orderListVOs.get(i).getState()==OrderState.HASREMARKED){
							orders.add(orderListVOs.get(i));
						}
					}
					for(int i=0;i<orderListVOs.size();i++){
						if(orderListVOs.get(i).getState()==OrderState.NOTREMARKED){
							orders.add(orderListVOs.get(i));
						}
					}
					break;
				case "未执行":
					for(int i=0;i<orderListVOs.size();i++){
						if(orderListVOs.get(i).getState()==OrderState.NOTEXECUTED){
							orders.add(orderListVOs.get(i));
						}
					}
					break;
				case "异常订单":
					for(int i=0;i<orderListVOs.size();i++){
						if(orderListVOs.get(i).getState()==OrderState.UNUSUAL){
							orders.add(orderListVOs.get(i));
						}
					}
					break;
				default:
					for(int i=0;i<orderListVOs.size();i++){
							orders.add(orderListVOs.get(i));
						
					}
					break;
				
				}
				changeScrollPane(orders);
			}
			
	    });
        
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
