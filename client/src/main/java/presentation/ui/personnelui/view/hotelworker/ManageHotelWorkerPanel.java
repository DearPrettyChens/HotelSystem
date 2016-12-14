package presentation.ui.personnelui.view.hotelworker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.view.ManagePanel;
import presentation.ui.personnelui.view.SearchInterface;
import presentation.ui.personnelui.view.Searchoradd_JPanel;
import presentation.ui.personnelui.view.Searchperson_JPanel;
import presentation.ui.tools.newclient_JLabel;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 右边的面板，这个是管理酒店人员的总面板
 * 
 * @author csy
 *
 */
public class ManageHotelWorkerPanel extends JPanel implements SearchInterface, ManagePanel {
	private Searchperson_JPanel searchperson_JPanel = new Searchperson_JPanel(UserType.HotelWorker, this);
	private Searchoradd_JPanel searchoradd_JPanel = new Searchoradd_JPanel(this);
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel searchResultPanel = new JPanel();
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();
	private static ArrayList<Hotelworkerlistinfo_JPanel> hotelworkerlistinfo_JPanels;
	private Hotelworkeradd_JPanel hotelworkeradd_JPanel;

	private static ManageHotelWorkerPanel manageHotelWorkerPanel;
	
	public static ManageHotelWorkerPanel getInstance() {
		if(manageHotelWorkerPanel==null){
			manageHotelWorkerPanel=new ManageHotelWorkerPanel();
		}
		return manageHotelWorkerPanel;
	}
	
	private ManageHotelWorkerPanel() {
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setVisible(true);
		addSearchComponent();
	}

	public void addSearchComponent() {
		// 设置最上面的搜索和添加选项panel
		searchoradd_JPanel.setBounds(0, 0, 800, 50);
		this.add(searchoradd_JPanel);

		// 设置搜索框
		searchperson_JPanel.setBounds(0, 50, 800, 90);
		this.add(searchperson_JPanel);

		// 设置列表
		scrollPane.setBounds(0, 140, 800, 500);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		initHotelWorkerList();
		this.add(scrollPane);

	}

	public void addAddComponent() {
		// 设置最上面的搜索和添加选项panel
		searchoradd_JPanel.setBounds(0, 0, 800, 50);
		this.add(searchoradd_JPanel);

		// 设置添加人的panel
		hotelworkeradd_JPanel = new Hotelworkeradd_JPanel();
		hotelworkeradd_JPanel.setBounds(0, 50, 800, 550);
		this.add(hotelworkeradd_JPanel);

	}

	/**
	 * 界面初始化获得所有酒店工作人员信息
	 */
	public void initHotelWorkerList() {
		ArrayList<PersonListVO> personListVOs = personnelDistributionController.getPersonList(UserType.HotelWorker,
				null);
		changeScrollPane(personListVOs);
	}

	public void changeScrollPane(ArrayList<PersonListVO> personListVOs) {
		if(personListVOs==null){

			  scrollPane.setLayout(null);
			  JLabel jLabel=new JLabel("该酒店工作人员不存在！",JLabel.CENTER);
			  jLabel.setBounds(300,0,200,30);
			  jLabel.setFont(new Font("宋体", Font.BOLD, 19));
			  jLabel.setForeground(Color.red);
			  
			  scrollPane.setViewportView(jLabel);
		  }else{
		searchResultPanel = new JPanel();
		searchResultPanel.setLayout(null);
		searchResultPanel.repaint();
		// scrollPane.repaint();
		searchResultPanel.setBackground(Color.WHITE);
		hotelworkerlistinfo_JPanels = new ArrayList<Hotelworkerlistinfo_JPanel>();
		for (PersonListVO personListVO : personListVOs) {
			Hotelworkerlistinfo_JPanel hotelworkerlistinfo_JPanel = new Hotelworkerlistinfo_JPanel(personListVO);
			hotelworkerlistinfo_JPanels.add(hotelworkerlistinfo_JPanel);
		}
		for (int i = 0; i < hotelworkerlistinfo_JPanels.size(); i++) {
			Hotelworkerlistinfo_JPanel hotelworkerlistinfo_JPanel = hotelworkerlistinfo_JPanels.get(i);
			hotelworkerlistinfo_JPanel.setBounds(100, 10 + 120 * i, 800, 100);
			searchResultPanel.add(hotelworkerlistinfo_JPanel);
		}
		searchResultPanel.setPreferredSize(new Dimension(800, 120 + 120 * hotelworkerlistinfo_JPanels.size()));
		scrollPane.setViewportView(searchResultPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);}
		// this.add(scrollPane);
	}

	@Override
	public void changeToSearchPanel() {
		this.removeAll();
		addSearchComponent();
		this.updateUI();

	}

	@Override
	public void changeToAddPanel() {
		this.removeAll();
		addAddComponent();
		searchoradd_JPanel.addjl.setForeground(searchoradd_JPanel.color);
		searchoradd_JPanel.searchjl.setForeground(Color.gray);
		this.updateUI();
	}

}
