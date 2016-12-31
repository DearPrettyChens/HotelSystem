package presentation.ui.creditui.view;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.view.SearchInterface;
import presentation.ui.personnelui.view.Searchperson_JPanel;
import presentation.ui.personnelui.view.client.Clientdetailinfo_JFrame;
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 进行信用充值搜索出来的顾客列表信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ClientDepositeSearch_JPanel extends JPanel implements SearchInterface{
	private Searchperson_JPanel searchperson_JPanel = new Searchperson_JPanel(UserType.Customer,this);
	
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();
	private static ArrayList<ClientDepositeList_JPanel> clientDepositeList_JPanels;
	
	public ClientDepositeSearch_JPanel() {
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setVisible(true);
	    addSearchComponent();
	}
	
	public void addSearchComponent() {
		
	     //设置搜索框
	    searchperson_JPanel.setBounds(0, 20, 800, 90); 
	    this.add( searchperson_JPanel);
		
	     //设置列表
	    scrollPane.setBounds(0, 110, 800, 550);
	    scrollPane.setBackground(Color.WHITE);
	    scrollPane.setBorder(null);
	   
	    initCustomerList();
	    this.add(scrollPane);
	    
	}
	
	
	/**
	 * 界面初始化获得所有顾客信息
	 */
	public void initCustomerList() {
		ArrayList<PersonListVO> personListVOs=personnelDistributionController.getPersonList(UserType.Customer, null);
	   changeScrollPane(personListVOs);
	}
    
	/**
	 * 进行检索后，更换滚动面板
	 */
	public void changeScrollPane(ArrayList<PersonListVO>personListVOs) {
		searchResultPanel=new JPanel();
		searchResultPanel.setLayout(null);
		searchResultPanel.repaint();

		searchResultPanel.setBackground(Color.WHITE);
		clientDepositeList_JPanels=new ArrayList<ClientDepositeList_JPanel>();
		if(personListVOs==null){
			SaveFail_JFrame frame=new SaveFail_JFrame();
			frame.setLableText("无该用户信息");
		}
		else{
		for(PersonListVO personListVO:personListVOs){
			ClientDepositeList_JPanel clientDepositeList_JPanel=new ClientDepositeList_JPanel(personListVO);
			clientDepositeList_JPanels.add(clientDepositeList_JPanel);
	    }
	    for(int i=0;i<clientDepositeList_JPanels.size();i++){
	    	ClientDepositeList_JPanel clientDepositeList_JPanel=clientDepositeList_JPanels.get(i);
	    	clientDepositeList_JPanel.setBounds(100, 10+120*i, 800, 100);
	    	searchResultPanel.add(clientDepositeList_JPanel);
	    }
	    searchResultPanel.setPreferredSize(new Dimension(800, 120+120*clientDepositeList_JPanels.size()));
	    scrollPane.setViewportView(searchResultPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    }

	}

}
