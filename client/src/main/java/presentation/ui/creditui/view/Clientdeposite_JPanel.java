package presentation.ui.creditui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;

/**
 * 进行信用充值的界面
 * @author cy
 * @version 1.0
 * 
 */
public class Clientdeposite_JPanel extends JPanel {
   private Font font=new Font("宋体",Font.BOLD, 20);
	
	private  JLabel idjl=new JLabel();
	private  JLabel namejl=new JLabel();
	private  JLabel teljl=new JLabel();
	private  JLabel creditjl=new JLabel();
	private  JLabel depositjl=new JLabel("充值信用值");
	private  JLabel depositinfojl=new JLabel("充值信用值为金额*100");
	
	
	
	private JTextField depositenumberjtf=new JTextField();
			
	
	/**
	 * 应该设置控件往里面填吧，通过监听获取
	 */
	private  String id;
	private  String name;
	private  String tel;
	private  String credit;
	
	
	private  MyButton confirmjb=new MyButton();
	private  MyButton canclejb=new MyButton();
	
	
	
	public Clientdeposite_JPanel(){
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		this.setSize(800,600);
		
	}
	
	
	
	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	idjl.setText("I   D:   "+id);
		idjl.setFont(font);
		idjl.setBounds(150,110,200,30);
		this.add(idjl);
		
		namejl.setText("姓名:   "+name);
		namejl.setFont(font);
		namejl.setBounds(150,150,200,30);
		this.add(namejl);
		
		teljl.setText("电话:   "+tel);
		teljl.setFont(font);
		teljl.setBounds(150,190,200,30);
		this.add(teljl);
		
		
		creditjl.setText("当前信用值："+credit);
		creditjl.setFont(font);
		creditjl.setBounds(150,230,200,30);
		this.add(creditjl);
		
		
    	
		
		depositjl.setFont(font);
		depositjl.setBounds(200,300,200,30);
		this.add(depositjl);
		
		
		
		depositenumberjtf.setBounds(300,300,100,30);
		
		this.add(depositenumberjtf);
		
		depositinfojl.setFont(font);
		depositinfojl.setBounds(400,300,400,30);
		this.add(depositinfojl);
		
		confirmjb.setText("确认");
		confirmjb.setBounds(600,500,80,30);
		this.add(confirmjb);
		canclejb.setText("取消");
		canclejb.setBounds(500,500,80,30);
		this.add(canclejb);
		
		
    	
    }
	
}
