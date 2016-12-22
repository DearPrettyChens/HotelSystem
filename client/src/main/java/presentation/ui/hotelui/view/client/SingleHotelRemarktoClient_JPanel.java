package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 顾客所看到的单条的酒店评论
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelRemarktoClient_JPanel  extends JPanel{
	
	private Color color=new Color(234,119,93);
	private Color color1=new Color(148,208,169);
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private String clientname="";

	private String remark="";
	
	
	private JLabel namejl=new JLabel();

	private JTextArea remarkjta=new JTextArea ();
	
	
	
	private JLabel bg=new JLabel(new ImageIcon(SingleHotelRemarktoClient_JPanel.class.getResource("image/listback.png")));
	
	public SingleHotelRemarktoClient_JPanel (String remark){
		
		this.remark=remark;
		
		
		this.setLayout(null);
    	this.setSize(800,100);
    	this.setBackground(Color.white);
    	addComp();
    	setback();
	}

    
    
    public void addComp(){
    	

    	remarkjta.setText(remark);
    	

    
    	remarkjta.setBounds(150,20,500,60);
    	remarkjta.setEditable(false);
    	remarkjta.setBackground(Color.white);
    	remarkjta.setBorder(null);
    	remarkjta.setLineWrap(true);
    	remarkjta.setFont(font);
    	this.add(remarkjta);
    }
    
    public void setback(){
    	bg.setBounds(0,0,800,100);
    	this.add(bg);
    	
    }
    
	
}
