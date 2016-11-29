package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 制定会员等级制度面板
 * @author cy
 * @version 1.0
 * 
 */
public class Clientlevelrule_JPanel extends JPanel {
	
	private int number;
	private int credit;
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private JLabel title=new JLabel(new ImageIcon("image//clientruletitle.png"));
	private JLabel numberjl=new JLabel("等级数量：");
	private JLabel creditjl=new JLabel("到达下一等级所需信用值：");
	private MyTextfield numberjtf;
	private MyTextfield creditjtf;
	
	
	private MyButton confirm=new MyButton();
	
	
	public Clientlevelrule_JPanel(int number,int credit){
		
		this.number=number;
		this.credit=credit;
		
		numberjtf=new MyTextfield(""+number);
		creditjtf=new MyTextfield(""+credit);
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		 addComp();
		 
	}
	
	

	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	title.setBounds(0,0,800,100);
    	this.add(title);
    	
    	numberjl.setFont(font);
    	numberjl.setBounds(200,200,200,50);
    	this.add(numberjl);
    	
    	
    	numberjtf.setBounds(400,200,200,50);
    	this.add(numberjtf);
    	
    	creditjl.setFont(font);
    	creditjl.setBounds(200,300,200,50);
    	this.add(creditjl);
    	
    	creditjtf.setBounds(400,300,200,50);
    	this.add(creditjtf);
    	
    	
    	confirm.setBounds(500,500,100,30);
    	confirm.setText("确认");
    	this.add(confirm);
    	
    }
    

}
