package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 单条的合作企业优惠
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelEnterpriseStr_JPanel  extends JPanel{
	private String enterprisename="";
	private int count;
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	
	private JLabel enterprisenamejl=new JLabel("合作企业:");
	private JTextField enterprisenamejtf=new JTextField();
	
	private JLabel countjl=new JLabel("折扣值:");
	private JTextField countjtf=new JTextField();
	
	public SingleHotelEnterpriseStr_JPanel(String enterprisename,int count){
		this.enterprisename=enterprisename;
		this.count=count;
		enterprisenamejtf.setText(enterprisename);
		countjtf.setText(count+"");
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
		
	}
	
	
	public SingleHotelEnterpriseStr_JPanel(){
		
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
		
	}
	
	
	
	public void addComp(){
		
		
		
		enterprisenamejl.setFont(font);
		enterprisenamejl.setBounds(50,10,200,30);
		this.add(enterprisenamejl);
		
		enterprisenamejtf.setFont(font);
		enterprisenamejtf.setBounds(150,10,200,30);
		this.add(enterprisenamejtf);
		
		
		countjl.setFont(font);
		countjl.setBounds(400,10,100,30);
		this.add(countjl);
		
		
		countjtf.setFont(font);
		countjtf.setBounds(500,10,100,30);
		this.add(countjtf);
		
	}
	
}
