package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;

/**
 * 
 * 用户入住或退房时，显示出来的酒店入住信息
 * @author cy
 * @version 1.0
 * 
 */
public class CheckInInfo_Info extends JPanel {
	
	private Font font=new Font("宋体",Font.BOLD, 20);
	
	private String name="";
	private String idnumber="";
	private String tel="";
	private String roomnumber="";
	private String roomtype="";
	private String realcheckintime="";
	private String realcheckouttime="";
	
	
	private JLabel titlejl=new JLabel("酒店住房记录");
	private JLabel clientjl=new JLabel("●入住人登记");
	private JLabel roomjl=new JLabel("●房间信息登记");
	private JLabel timejl=new JLabel("●时间信息登记");

	private MyButton confirmjb=new MyButton();
	private MyButton canclejb=new MyButton();
	
	
	
	
	
	private JLabel namejl=new JLabel();
	private JLabel idnumberjl=new JLabel();
	private JLabel teljl=new JLabel();
	private JLabel roomnumberjl=new JLabel();
	private JLabel roomtypejl=new JLabel();
	private JLabel realcheckintimejl=new JLabel();
	private JLabel realcheckouttimejl=new JLabel();
	
	
	private JTextField namejtf=new JTextField(name);
	private JTextField idnumberjtf=new JTextField(idnumber);
	private JTextField teljtf=new JTextField(tel);
	private JTextField roomnumberjtf=new JTextField(roomnumber);
    private JTextField roomtypejtf=new JTextField(roomtype);
    private JTextField realcheckintimejtf=new JTextField(realcheckintime);
    private JTextField realcheckouttimejtf=new JTextField(realcheckouttime);


	
	
	
	
	
	
	public CheckInInfo_Info(String name,String idnumber,String tel,String roomnuber,String roomtype,String realcheckintime,String realcheckouttime){
		
		this.name=name;
		this.idnumber=idnumber;
		this.roomnumber=roomnumber;
		this.roomtype=roomtype;
		this.realcheckintime=realcheckintime;
		this.realcheckouttime=realcheckouttime;
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
	    addComp();
		
		
		this.setSize(800,600);
	}
	
	
	
	public CheckInInfo_Info(){
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
	    addComp();
		this.setSize(800,600);
		
		
	}
	
	
	
	public void addComp(){
		
		titlejl.setFont(font);
		
		titlejl.setBounds(50,30,300,30);
		this.add(titlejl);
		
		clientjl.setFont(font);
		
		clientjl.setBounds(50,100,300,30);
		this.add(clientjl);
		
		namejl.setFont(font);
		namejl.setText("姓名："+name);
		namejl.setBounds(50,150,100,30);
		this.add(namejl);
		
		namejtf.setFont(font);
		namejtf.setBounds(120,150,100,30);
		this.add(namejtf);
		
		idnumberjl.setFont(font);
		idnumberjl.setText("身份证号："+idnumber);
		idnumberjl.setBounds(300,150,100,30);
		this.add(idnumberjl);
		
		idnumberjtf.setFont(font);
		idnumberjtf.setBounds(400,150,100,30);
		this.add(idnumberjtf);
		
		teljl.setFont(font);
		teljl.setText("联系方式："+tel);
		teljl.setBounds(550,150,100,30);
		this.add(teljl);
		
		teljtf.setFont(font);
		teljtf.setBounds(650,150,100,30);
		this.add(teljtf);
		
		roomjl.setFont(font);
		
		roomjl.setBounds(50,250,300,30);
		this.add(roomjl);
		
		
		
		roomnumberjl.setFont(font);
		roomnumberjl.setText("房间号："+roomnumber);
		roomnumberjl.setBounds(50,300,100,30);
		this.add(roomnumberjl);
		
		roomnumberjtf.setFont(font);
		roomnumberjtf.setBounds(150,300,100,30);
		this.add(roomnumberjtf);
		
		roomtypejl.setFont(font);
		roomtypejl.setText("房间类型："+roomtype);
		roomtypejl.setBounds(350,300,100,30);
		this.add(roomtypejl);
		
		roomtypejtf.setFont(font);
		roomtypejtf.setBounds(450,300,100,30);
		this.add(roomtypejtf);
		
		timejl.setFont(font);
		timejl.setBounds(50,400,300,30);
		this.add(timejl);
		
		realcheckintimejl.setFont(font);
		realcheckintimejl.setText("实际入住时间："+realcheckintime);
		realcheckintimejl.setBounds(50,450,200,30);
		this.add(realcheckintimejl);
		
		realcheckintimejtf.setFont(font);
		realcheckintimejtf.setBounds(200,450,150,30);
		this.add(realcheckintimejtf);
		
		realcheckouttimejl.setFont(font);
		realcheckouttimejl.setText("实际退房时间："+realcheckouttime);
		realcheckouttimejl.setBounds(450,450,200,30);
		this.add(realcheckouttimejl);
		
		realcheckouttimejtf.setFont(font);
		realcheckouttimejtf.setBounds(600,450,150,30);
		this.add(realcheckouttimejtf);
		
		
		confirmjb.setText("确认");
		confirmjb.setBounds(600,550,80,30);
		this.add(confirmjb);
		
		canclejb.setText("返回");
		canclejb.setBounds(500,550,80,30);
		this.add(canclejb);
		
		
		
		
	}
	
	
	

}
