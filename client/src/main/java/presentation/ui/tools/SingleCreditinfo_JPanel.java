package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 每条信用记录的面板
 * @author cy
 * @version 1.0
 * 
 */
public class SingleCreditinfo_JPanel extends JPanel {
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel datejl=new JLabel("时   间：");
	private JLabel ordernumberjl=new JLabel("订单号：");
	private JLabel reasonjl=new JLabel("原   因：");
	private JLabel creditjl=new JLabel("信用值：");
	
	
	
	
	private JLabel background =new JLabel();
	
	private JLabel dateinfo=new JLabel("");
	private JLabel ordernumberinfo=new JLabel("");
	private JLabel reasoninfo=new JLabel("");
	private JLabel creditinfo=new JLabel("");

	private String date;
	private String ordernumber;
	private String reason;
	private String credit;
	private String change;
	
	private JLabel changeinfo=new JLabel();
	
	public SingleCreditinfo_JPanel(String date,String ordernumber,String reason,String credit,String change){
		
	this.date=date;
	this.ordernumber=ordernumber;
	this.reason=reason;
	this.credit=credit;
	this.change=change;
	
	dateinfo.setText(date);
	ordernumberinfo.setText(ordernumber);
	reasoninfo.setText(reason);
	creditinfo.setText(credit);
	changeinfo.setText(change);
		
		
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
    	
    	datejl.setFont(font);
    	datejl.setBounds(100,120,100,30);
    	this.add(datejl);
    	
 
    	ordernumberjl.setFont(font);
    	ordernumberjl.setBounds(100,150,100,30);
    	this.add(ordernumberjl);
    	
    
    	
    	reasonjl.setFont(font);
    	reasonjl.setBounds(100,180,100,30);
    	this.add(reasonjl);
    	
    	creditjl.setFont(font);
    	creditjl.setBounds(100,210,100,30);
    	this.add(creditjl);
    	
    	changeinfo.setFont(font);
    	changeinfo.setForeground(new Color(234,114,93));
    	changeinfo.setBounds(170,60,100,30);
    	this.add(changeinfo);
    	
    	ImageIcon icon=new ImageIcon("image//rec.png");
    	background.setIcon(icon);
    	background.setBounds(0,0,400,300);
    	this.add(background);
    	
    	dateinfo.setFont(font);
    	dateinfo.setBounds(180,120,100,30);
    	this.add(dateinfo);
    	
 
    	ordernumberinfo.setFont(font);
    	ordernumberinfo.setBounds(180,150,100,30);
    	this.add(ordernumberinfo);
    	
    
    	
    	reasoninfo.setFont(font);
    	reasoninfo.setBounds(180,180,100,30);
    	this.add(reasoninfo);
    	
    	creditinfo.setFont(font);
    	creditinfo.setBounds(180,210,100,30);
    	this.add(creditinfo);
    	
    	
    	
    	
    	
    	
	
    }

}
