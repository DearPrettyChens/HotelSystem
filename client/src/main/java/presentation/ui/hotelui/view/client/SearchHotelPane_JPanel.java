package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.tools.newclient_JLabel;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 顾客的搜索酒店界面
 * 
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotelPane_JPanel extends JPanel {
	private SearchHoteltoClient_JPanel searchHoteltoClient_JPanel;
    private HotelListPane_JPanel hotelListPane_JPanel ;
	private JScrollPane scrollPane=new JScrollPane();
	private JPanel panel=new JPanel();
    
	public SearchHotelPane_JPanel(HotelSearchInfoVO hotelSearchInfoVO) {
		this.setLayout(null);
		this.setBounds(200,100, 800, 600);
		searchHoteltoClient_JPanel=new SearchHoteltoClient_JPanel(hotelSearchInfoVO);
		hotelListPane_JPanel=new HotelListPane_JPanel(hotelSearchInfoVO);
		addScrollpane();
	}
	public void addScrollpane() {
		scrollPane.setBounds(0, 0, 800, 600);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		searchHoteltoClient_JPanel.setBounds(0, 0, 780, 300);
		hotelListPane_JPanel.setBounds(0, 300, 800, hotelListPane_JPanel.getHeight());
		
		panel.add(searchHoteltoClient_JPanel);
		panel.add(hotelListPane_JPanel);
		panel.setPreferredSize(new Dimension(780, 300+hotelListPane_JPanel.getHeight()));

		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}
}
