package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 网站营销人员搜索订单的搜索栏面板
 * @author cy
 * @version 1.0
 * 
 */
public class Searchorder_JPanel extends JPanel{
	 private Font font=new Font("宋体",Font.BOLD, 20);
	 private JLabel ordertypejl=new JLabel("订单类型");
	 private JLabel begintimejl=new JLabel("时间：  从");
	 private JLabel endtimejl=new JLabel("到");
	 private JComboBox comboBox=new JComboBox();
    
	
	
	
	 public Searchorder_JPanel(){
		 
		 
	 this.setBackground(Color.white);
	 this.setSize(800,50);
	 this.setLayout(null);
	 addComp();
	
		comboBox.addItem("");
		comboBox.addItem("驾驶证");
		comboBox.addItem("军官证");
		
	
	 }
	 
	 
	 /**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	
	    	
	    	
	    }
	    
	    

}
