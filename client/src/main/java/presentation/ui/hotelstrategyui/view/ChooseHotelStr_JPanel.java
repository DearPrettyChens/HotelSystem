package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 选择策略类型
 * @author cy
 * @version 1.0
 * 
 */
public class ChooseHotelStr_JPanel extends JPanel {
	private JLabel titlejl=new JLabel("策略类型选择：",JLabel.CENTER);
	private JLabel birthjl=new JLabel("生日特惠策略",JLabel.CENTER);
	private JLabel overthreejl=new JLabel("三间及以上预订优惠策略",JLabel.CENTER);
	private JLabel enterprisejl=new JLabel("合作企业顾客折扣策略",JLabel.CENTER);
	private JLabel specialtimejl=new JLabel("特定节日优惠策略",JLabel.CENTER);
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	public ChooseHotelStr_JPanel(){
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		addComp();
		
		
		
		
		
		
	}
	
	
	
	
	public void addComp(){
		 
		
		
		titlejl.setFont(font);
		titlejl.setBounds(20,50,200,50);
		this.add(titlejl);
		
		
		birthjl.setFont(font);
		birthjl.setBorder(BorderFactory.createLineBorder(Color.gray));
		birthjl.setBounds(300,100,200,70);
		this.add(birthjl);
		
		overthreejl.setFont(font);
		overthreejl.setBorder(BorderFactory.createLineBorder(Color.gray));
		overthreejl.setBounds(300,200,200,70);
		this.add(overthreejl);
		
		enterprisejl.setFont(font);
		enterprisejl.setBorder(BorderFactory.createLineBorder(Color.gray));
		enterprisejl.setBounds(300,300,200,70);
		this.add(enterprisejl);
		
		specialtimejl.setFont(font);
		specialtimejl.setBorder(BorderFactory.createLineBorder(Color.gray));
		specialtimejl.setBounds(300,400,200,70);
		this.add(specialtimejl);
		
		
		
		
		
		
	}

}
