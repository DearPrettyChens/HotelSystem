package presentation.ui.personnelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.view.SearchInterface;
import presentation.ui.personnelui.view.Searchperson_JPanel;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 右边的面板，这个是管理顾客的总面板
 * @author csy
 *
 */
public class ManageCustomerPanel extends JPanel implements SearchInterface{
	private Searchperson_JPanel searchperson_JPanel = new Searchperson_JPanel(UserType.HotelWorker,this);
	
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();
	private static ArrayList<Clientlistinfo_JPanel> clientlistinfo_JPanels;
	
	public ManageCustomerPanel() {
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
	   
	    initHotelWorkerList();
	    this.add(scrollPane);
	    
	}
	
	
	/**
	 * 界面初始化获得所有顾客信息
	 */
	public void initHotelWorkerList() {
		ArrayList<PersonListVO> personListVOs=personnelDistributionController.getPersonList(UserType.Customer, null);
	   changeScrollPane(personListVOs);
	}
    
	public void changeScrollPane(ArrayList<PersonListVO>personListVOs) {
		searchResultPanel=new JPanel();
		searchResultPanel.setLayout(null);
		searchResultPanel.repaint();
//		scrollPane.repaint();
		searchResultPanel.setBackground(Color.WHITE);
		 clientlistinfo_JPanels=new ArrayList<Clientlistinfo_JPanel>();
		for(PersonListVO personListVO:personListVOs){
	    	Clientlistinfo_JPanel clientlistinfo_JPanel=new Clientlistinfo_JPanel(personListVO);
	    	clientlistinfo_JPanels.add(clientlistinfo_JPanel);
	    }
	    for(int i=0;i<clientlistinfo_JPanels.size();i++){
	    	Clientlistinfo_JPanel clientlistinfo_JPanel=clientlistinfo_JPanels.get(i);
	    	clientlistinfo_JPanel.setBounds(100, 10+120*i, 800, 100);
	    	searchResultPanel.add(clientlistinfo_JPanel);
	    }
	    searchResultPanel.setPreferredSize(new Dimension(800, 120+120*clientlistinfo_JPanels.size()));
	    scrollPane.setViewportView(searchResultPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	    this.add(scrollPane);
	}

	
	
}

