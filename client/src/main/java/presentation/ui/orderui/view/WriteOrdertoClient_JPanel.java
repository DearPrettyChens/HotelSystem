package presentation.ui.orderui.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 顾客填写订单的界面
 * @author cy
 * @version 1.0
 * 
 */
public class WriteOrdertoClient_JPanel  extends JPanel {
	
	
	private String hotelname;
	private String roomtypes[];
	private String bedtypes[];
	
	
	
	private JLabel roommessagejl=new JLabel("客房信息");
    private JLabel clientmessagejl=new JLabel("入住人信息");
	
	private JLabel checkintimejl=new JLabel();
	private JLabel checkouttimejl=new JLabel();
	private JLabel roomtypejl=new JLabel();
	private JLabel bebtypejl=new JLabel();
	private JLabel roomnumberjl=new JLabel();
	private JLabel haschildjl=new JLabel();
	private JLabel clientnamejl=new JLabel();
	private JLabel clientteljl=new JLabel();
	
	
	
	
	public  WriteOrdertoClient_JPanel(){
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,300);
		addComp();
		
		
		
		
	}
	
    public  WriteOrdertoClient_JPanel(String hotelname,String[] roomtypes,String[] bedtypes){
    	
    	
    	
    	
    	this.hotelname=hotelname;
    	this.roomtypes=roomtypes;
    	this.bedtypes=bedtypes;
    	
    	this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,300);
		addComp();
    	
		
		
	}
	
	
    
    public void addComp(){
    	
    	
    	
    	
    	
    	
    	
    }
	
	

}
	