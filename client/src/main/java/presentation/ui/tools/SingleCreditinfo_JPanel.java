package presentation.ui.tools;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 每条信用记录的现实
 * @author cy
 * @version 1.0
 * 
 */
public class SingleCreditinfo_JPanel extends JPanel {
	private JLabel datejl=new JLabel("时 间：");
	private JLabel ordernumberjl=new JLabel("订单号：");
	private JLabel reasonjl=new JLabel("原 因：");
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
    	
    	
    	
    	ImageIcon icon=new ImageIcon("image//rec.png");
    	background.setIcon(icon);
    	background.setBounds(0,0,400,300);
    	this.add(background);
    	
    	
    	
    	
    	
    	
    	
    	
	
    }

}
