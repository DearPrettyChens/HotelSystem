package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 顾客一开始选择的商圈和城市
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
	
	
	
	public ChooseCityandEnterprise_JPanel (){
		
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
	    
		
		
	}

}
