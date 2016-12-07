package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyTextfield;

/**
 * 顾客填写订单的界面
 * @author cy
 * @version 1.0
 * 
 */
public class WriteOrdertoClient_JPanel  extends JPanel {
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	
	private String hotelname;
	private String roomtypes[]={"bui"};
	private String bedtypes[]={"bui"};
	
	private JComboBox roomtypecomboBox=new JComboBox();
	private JComboBox bedtypecomboBox=new JComboBox();
	
	
	private JPanel bgjp1=new JPanel();
	private JPanel bgjp2=new JPanel();
	private JPanel bgjp3=new JPanel();
	private JPanel bgjp4=new JPanel();
	
	
	private MyTextfield namejtf=new MyTextfield("2—8位汉字");
	private MyTextfield teljtf=new MyTextfield("11位手机号");
	
	private JTextField numberjtf=new JTextField();
	
	
	private MyTextfield fromtimejtf=new MyTextfield("请选择日期");
	private MyTextfield totimejtf=new MyTextfield("请选择日期");
	
	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy/MM/dd");  
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy/MM/dd");  
	
	
	private JLabel roommessagejl=new JLabel("客房信息");
    private JLabel clientmessagejl=new JLabel("入住人信息");
	
	private JLabel checkintimejl=new JLabel("入住时间：");
	
	private JLabel checkouttimejl=new JLabel("至");
	
	private JLabel hotelnamejl=new JLabel("入住酒店：");
	
	private JLabel roomtypejl=new JLabel("房间类型：");
	private JLabel bedtypejl=new JLabel("床型：");
	private JLabel roomnumberjl=new JLabel("房间数量：");
	private JLabel haschildjl=new JLabel("有无儿童：");
	private JLabel clientnamejl=new JLabel("姓名：");
	private JLabel clientteljl=new JLabel("联系方式：");
	
	
	private JRadioButton haschildjb= new JRadioButton("是");
	private JRadioButton hasnochildjb= new JRadioButton("否");
	
	private ButtonGroup group = new ButtonGroup();
    
	
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
    	
    	
    	fromtimejtf.setBounds(270,50,100,25);
       	
       	this.add(fromtimejtf);
       	//this.add(jp);
       	 p1.initCalendarPanel(); 
       	JLabel l1 = new JLabel("日历面板");  
         p1.add(l1);  
         this.add(p1);  
        // this.getContentPane().add(txt1);  
         
         
        totimejtf.setBounds(430,50,100,25);
       	
       	this.add(totimejtf);
       	//this.add(jp);
       	 p2.initCalendarPanel(); 
       	JLabel l2 = new JLabel("日历面板");  
         p2.add(l2);  
         this.add(p2);  
        // this.getContentPane().add(txt1);  
    	
    	
    	roommessagejl.setFont(font);
    	roommessagejl.setBounds(50,50,150,30);
    	this.add(roommessagejl);
    	
    	
    	checkintimejl.setFont(font);
    	checkintimejl.setBounds(200,50,100,25);
    	this.add(checkintimejl);
    	
    	checkouttimejl.setFont(font);
    	checkouttimejl.setBounds(400,50,100,25);
    	this.add(checkouttimejl);
    	
    	hotelnamejl.setFont(font);
    	hotelnamejl.setText("入住酒店："+hotelname);
    	hotelnamejl.setBounds(200,75,150,25);
    	this.add(hotelnamejl);
    	
    	roomtypejl.setFont(font);
    	roomtypejl.setBounds(200,100,150,25);
    	this.add(roomtypejl);
    	
    	
    	if(roomtypes.length!=0){
    	for(int i=0;i<roomtypes.length;i++){
    		
    		
    		
    		roomtypecomboBox.addItem(roomtypes[i]);
    		
    		
    		
    	}
    	}
    	
    	roomtypecomboBox.setBounds(300,100,150,25);
    	this.add(roomtypecomboBox);
    	
    	if(bedtypes.length!=0){
    	for(int i=0;i<bedtypes.length;i++){
    		
    		bedtypecomboBox.addItem(bedtypes[i]);
    		
    		
    	}
    	}
    	bedtypecomboBox.setBounds(300,125,150,25);
    	this.add(bedtypecomboBox);
    	
    	bedtypejl.setFont(font);
    	bedtypejl.setBounds(200,125,150,25);
    	this.add(bedtypejl);
    	
    	roomnumberjl.setFont(font);
    	roomnumberjl.setBounds(200,150,150,25);
    	this.add(roomnumberjl);
    	
    	numberjtf.setFont(font);
    	numberjtf.setBounds(300,150,100,25);
    	this.add(numberjtf);
    	
    	clientmessagejl.setFont(font);
    	clientmessagejl.setBounds(50,200,150,25);
    	this.add(clientmessagejl);
    	
    	haschildjl.setFont(font);
    	haschildjl.setBounds(200,200,150,25);
    	this.add(haschildjl);
    	
    	haschildjb.setBounds(300,200,100,25);
    	this.add(haschildjb);
    	
    	hasnochildjb.setBounds(350,200,100,25);
    	this.add(hasnochildjb);
    	
    	clientnamejl.setFont(font);
    	clientnamejl.setBounds(200,225,150,25);
    	this.add(clientnamejl);
    	
    	
    	
    	namejtf.setBounds(270,225,200,20);
    	this.add(namejtf);
    	
    	clientteljl.setFont(font);
    	clientteljl.setBounds(200,250,150,25);
    	this.add(clientteljl);
    	
    	teljtf.setBounds(270,250,200,20);
    	this.add(teljtf);
    	
    	
    	
    	bgjp1.setBackground(color);
    	bgjp1.setBounds(50,10,700,20);
    	this.add(bgjp1);
    	
    	bgjp2.setBackground(color);
    	bgjp2.setBounds(50,180,700,2);
    	this.add(bgjp2);
    	
    	bgjp3.setBackground(color);
    	bgjp3.setBounds(50,290,700,2);
    	this.add(bgjp3);
    	
    	bgjp4.setBackground(color);
    	bgjp4.setBounds(150,20,2,270);
    	this.add(bgjp4);
    	
    	
    	
    	group.add(haschildjb);
        group.add(hasnochildjb);
    	
    	
    	
    	
    }
	
	

}
	