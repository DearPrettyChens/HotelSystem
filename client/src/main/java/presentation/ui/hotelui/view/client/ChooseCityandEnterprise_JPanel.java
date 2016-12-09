package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.searchhotelui.distributecontroller.SearchhotelDistributionController;
import presentation.ui.tools.newclient_JLabel;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 
 * 顾客一开始选择的商圈和城市
 * 
 * 未实现下拉框选择的监听
 * 
 *  
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ChooseCityandEnterprise_JPanel  extends JPanel {
	
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	private JLabel cityjl=new JLabel("城市");
	private JLabel tradingareajl=new JLabel("商圈");
	private JComboBox citycomboBox=new JComboBox();
	private JComboBox tradingareacomboBox=new JComboBox();
	private HotelSearchInfoVO hotelSearchInfoVO;
	private String userID;
	private JButton confirmjb=new JButton("确认");
	
	public ChooseCityandEnterprise_JPanel (String userID){
		
		this.userID=userID;
		hotelSearchInfoVO.setCustomerID(userID);
		this.setLayout(null);
		this.setSize(800,600);
		this.setBackground(Color.white);
		addComp();
			
		
	}
	
	
	
	public void addComp(){
		
		cityjl.setBounds(300,200,200,30);
		cityjl.setFont(font);
		this.add(cityjl);
		
		tradingareajl.setBounds(300,250,200,30);
		tradingareajl.setFont(font);
		this.add(tradingareajl);
		
		citycomboBox.addItem("南京");
		citycomboBox.setBounds(350,200,200,30);
		this.add(citycomboBox);
		
		tradingareacomboBox.addItem("新街口");
	    tradingareacomboBox.addItem("湖南路");
	    tradingareacomboBox.setBounds(350,250,200,30);
	    this.add(tradingareacomboBox);
	    
	    confirmjb.setText("确认");
		confirmjb.setBounds(450, 350, 80, 30);
		confirmjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}

}
