package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;

/**
 * 网站管理人员添加酒店工作人员的面板
 * @author cy
 * @version 1.0
 * 
 */
public class WebMarketManAdd_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private  String id;
	private  String name;
	private  String tel;
	//private  String type;
	private  String password;
	
	
	//private JLabel typejl=new JLabel("职务：   ");
	private JLabel idjl=new JLabel("I   D:   ");
	private JLabel namejl=new JLabel("姓名：   ");
	
	private JLabel teljl=new JLabel("电话：   ");
	private JLabel passwordjl=new JLabel("密码：   ");
	
	
	private JTextField idjtx=new JTextField("");
	private MyTextfield namejtx=new MyTextfield("请输入姓名");
	
	private MyTextfield teljtx=new MyTextfield("请输入联系方式");
	//private JTextField typejtx=new JTextField();
	private MyTextfield passwordjtx=new MyTextfield("请输入密码");
	
	
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();
	

	public WebMarketManAdd_JPanel(String id){
		this.id=id;
		this.setBackground(Color.white);
		
		this.setLayout(null);
		
		
		addComp();
		
	}
	
	
	
	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	idjl.setFont(font);
    	idjl.setBounds(300,110,100,50);
    	idjtx.setText(id);
    	idjtx.setEditable(false);
    	this.add(idjl);
    	idjtx.setFont(font);
    	idjtx.setBounds(350,110,200,50);
    	this.add(idjtx);
    	
    	
    	namejl.setFont(font);
    	namejl.setBounds(300,180,100,50);
    	this.add(namejl);
    	namejtx.setBounds(350,180,200,50);
    	this.add(namejtx);
    	
    	
    	
    	teljl.setFont(font);
    	teljl.setBounds(300,250,100,50);
    	this.add(teljl);
    	teljtx.setBounds(350,250,200,50);
    	this.add(teljtx);
    	
    	passwordjl.setFont(font);
    	passwordjl.setBounds(300,320,100,50);
    	this.add(passwordjl);
    	passwordjtx.setBounds(350,320,200,50);
    	this.add(passwordjtx);
    	
        canclejb.setText("取消");
        canclejb.setBounds(300,390,100,30);
        this.add(canclejb);
        
        confirmjb.setText("确定");
        confirmjb.setBounds(450,390,100,30);
        this.add(confirmjb);
        
    	
    	
    }
	
	
}
