package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.searchhotelui.distributecontroller.SearchhotelDistributionController;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.NewClient_JLabel;
import util.City;
import util.TradingArea;
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
	private HotelSearchInfoVO hotelSearchInfoVO=new HotelSearchInfoVO();
	private String userID;
	private MyButton confirmjb=new MyButton();
	private JLabel bgjl=new JLabel(new ImageIcon(ChooseCityandEnterprise_JPanel.class.getResource("image/bgbg.png")));
	private JLabel logojl=new JLabel(ImageTool.getScaledImage(new ImageIcon(ChooseCityandEnterprise_JPanel.class.getResource("image/logo.png")), 120));
	
	private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
	
	public ChooseCityandEnterprise_JPanel (String userID){
		
		this.userID=userID;
		hotelSearchInfoVO.setCustomerID(userID);
		this.setLayout(null);
		this.setSize(800,600);
		this.setBackground(Color.white);
		addComp();
			
		
	}
	
	
	
	public void addComp(){
		
		
		
		cityjl.setBounds(350,220,200,30);
		cityjl.setFont(font);
		this.add(cityjl);
		
		tradingareajl.setBounds(350,300,200,30);
		tradingareajl.setFont(font);
		this.add(tradingareajl);
		
		citycomboBox.addItem("南京");
		citycomboBox.setBounds(400,220,200,30);
		this.add(citycomboBox);
		
		
		for(TradingArea e:TradingArea.values()){
			tradingareacomboBox.addItem(e.getChinese());
		}

	    tradingareacomboBox.setBounds(400,300,200,30);
	    this.add(tradingareacomboBox);
	    
	    confirmjb.setText("确认");
		confirmjb.setBounds(400, 400, 150, 30);
		confirmjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hotelSearchInfoVO.setCity(City.NANJING);
				hotelSearchInfoVO.setTradingArea(TradingArea.values()[tradingareacomboBox.getSelectedIndex()]);
				
				reserveHotelViewController.generateNewHotelListView(hotelSearchInfoVO);
			}
		});
		this.add(confirmjb);
		
		
		
		bgjl.setBounds(0,0,800,600);
		this.add(bgjl);
		
		logojl.setBounds(150,220,120,120);
		this.add(logojl);
		
		
	}

}
