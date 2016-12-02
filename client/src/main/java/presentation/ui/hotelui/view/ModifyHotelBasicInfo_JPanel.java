package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;

/**
 * 酒店工作人员维护酒店信息界面
 * @author cy
 * @version 1.0
 * 
 */
public class ModifyHotelBasicInfo_JPanel  extends JPanel{
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	private MyButton confirm=new MyButton();
	private MyButton cancle=new MyButton();
	
	private String number;
	
    private String hotelname;
    int star;
    private String location;
    private String area;
    private String tel;
    private String service;
    private String introduction;
    
    
    private JLabel hotelnamejl;
    private JLabel starjl=new JLabel("星级：");
    private JLabel locationjl=new JLabel("联系方式：");
    private JLabel areajl=new JLabel("设施服务：");
    private JLabel teljl=new JLabel("电话：");
    private JLabel servicejl=new JLabel("设施服务：");
    private JLabel introductionjl=new JLabel("简介：");
    
    private JTextField starjtf;
    private JTextField locationjtf;
    private JTextField areajtf;
    private JTextField teljtf;
    private JTextArea servicejtf;
    private JTextArea introductionjtf;
    
    
    public ModifyHotelBasicInfo_JPanel(){
    	/*this.number=number;
    	this.area=area;
    	this.hotelname=hotelname;
    	this.location=location;
    	this.tel=tel;
    	this.service=service;
    	this.introduction=introduction;*///去逻辑层取...
    	
    	
    	hotelnamejl=new JLabel(hotelname+"酒店");
    	starjtf=new JTextField(star+"");
    	locationjtf=new JTextField(location);
    	areajtf=new JTextField(area);
    	teljtf=new JTextField(tel);
    	servicejtf=new JTextArea(service);
    	introductionjtf=new JTextArea(introduction);
    		
    	this.setSize(800,600);
    	this.setLayout(null);
    	this.setBackground(Color.white);
    	
    	
    	
    	addComp();
    	
    	
    	
    	
    }
    
    
	
	void addComp(){
		
		
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(50,50,100,30);
		this.add(hotelnamejl);
		
		starjl.setFont(font);
		starjl.setBounds(50,100,100,30);
		this.add(starjl);
		
		starjtf.setFont(font);
		starjtf.setBounds(150,100,100,30);
		this.add(starjtf);
		
		locationjl.setFont(font);
		locationjl.setBounds(50,150,100,30);
		this.add(locationjl);
		
		locationjtf.setFont(font);
		locationjtf.setBounds(150,150,100,30);
		this.add(locationjtf);
		
		areajl.setFont(font);
		areajl.setBounds(50,200,100,30);
		this.add(areajl);
		
		areajtf.setFont(font);
		areajtf.setBounds(150,200,100,30);
		this.add(areajtf);
		
		teljl.setFont(font);
		teljl.setBounds(50,250,100,30);
		this.add(teljl);
		
		teljtf.setFont(font);
		teljtf.setBounds(150,250,100,30);
		this.add(teljtf);
		
		servicejl.setFont(font);
		servicejl.setBounds(50,300,100,30);
		this.add(servicejl);
		
		servicejtf.setFont(font);
		servicejtf.setBounds(150,300,300,100);
		this.add(servicejtf);
		
		introductionjl.setFont(font);
		introductionjl.setBounds(50,450,100,30);
		this.add(introductionjl);
		
		introductionjtf.setFont(font);
		introductionjtf.setBounds(50,450,300,100);
		this.add(introductionjtf);
		
		
		
		
		confirm.setText("确认");
		confirm.setBounds(500,550,100,30);
		this.add(confirm);
		
		
		cancle.setText("取消");
		cancle.setBounds(650,550,100,30);
		this.add(cancle);
		
		
		
		
		
		
	}
	
	

}
