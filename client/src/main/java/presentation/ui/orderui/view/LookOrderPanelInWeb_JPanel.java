package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
import presentation.ui.tools.NewClient_JLabel;
import util.OrderState;
import util.UserType;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;
import vo.personnelvo.PersonListVO;

/**
 * 网站营销人员管理订单选项中的浏览订单列表的面板
 * @author csy
 *
 */
public class LookOrderPanelInWeb_JPanel extends JPanel {
	
	private Searchorder_JPanel searchorder_JPanel=new Searchorder_JPanel(UserType.WebMarketMan,this);//搜索框
	
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private OrderDistributionController orderDistributionController=OrderDistributionController.getInstance();
	private static ArrayList<Orderlistinfo_JPanel> orderlistinfo_JPanels;
	
	
	public LookOrderPanelInWeb_JPanel() {
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		this.setLayout(null);
		addComp();
	}

	public void addComp() {
		//设置订单状态选择框
        searchorder_JPanel.setBounds(0, 0, 800, 100);
        this.add(searchorder_JPanel);
        
	     //设置列表
	    scrollPane.setBounds(0, 100, 800, 550);
	    scrollPane.setBackground(Color.WHITE);
	    scrollPane.setBorder(null);
	   
	    initOrderList(OrderState.UNUSUAL);
	    
	    this.add(scrollPane);
        
	}
	/**
	 * 界面初始化获得异常订单信息
	 */
	public void initOrderList(OrderState state) {
		ArrayList<OrderListVO> orderListVOs =new ArrayList<OrderListVO>() ;
		if(state==OrderState.EXECUTED){
			TypeInfoVO typeInfoVO=new TypeInfoVO(UserType.WebMarketMan, OrderState.HASREMARKED, null );
			orderListVOs.addAll(orderDistributionController.getOrderList(typeInfoVO));
			typeInfoVO.setOrderState(OrderState.NOTREMARKED);
			orderListVOs.addAll(orderDistributionController.getOrderList(typeInfoVO));
		}else{
		    TypeInfoVO typeInfoVO=new TypeInfoVO(UserType.WebMarketMan, state, null );
		    orderListVOs=orderDistributionController.getOrderList(typeInfoVO);
		}
	    changeScrollPane(orderListVOs);
	}
    
	
	
	/**
	 * 由于检索，改变滚动条面板
	 */
	public void changeScrollPane(ArrayList<OrderListVO>orderListVOs) {
		searchResultPanel=new JPanel();
		searchResultPanel.setLayout(null);
		searchResultPanel.repaint();
//		scrollPane.repaint();
		searchResultPanel.setBackground(Color.WHITE);
		orderlistinfo_JPanels=new ArrayList<Orderlistinfo_JPanel>();
		for(OrderListVO orderListVO:orderListVOs){
	    	Orderlistinfo_JPanel orderlistinfo_JPanel=new Orderlistinfo_JPanel(orderListVO);
	    	orderlistinfo_JPanels.add(orderlistinfo_JPanel);
	    }
//		System.out.println(orderlistinfo_JPanels.size());
	    for(int i=0;i<orderlistinfo_JPanels.size();i++){
	    	Orderlistinfo_JPanel orderlistinfo_JPanel=orderlistinfo_JPanels.get(i);
	    	orderlistinfo_JPanel.setBounds(100, 10+120*i, 800, 100);
	    	searchResultPanel.add(orderlistinfo_JPanel);
	    }
	    searchResultPanel.setPreferredSize(new Dimension(800, 120+120*orderlistinfo_JPanels.size()));
	    scrollPane.setViewportView(searchResultPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	    this.add(scrollPane);
	    scrollPane.repaint();
	}

}
