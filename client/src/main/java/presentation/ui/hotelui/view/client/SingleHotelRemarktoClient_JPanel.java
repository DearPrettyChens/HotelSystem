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
//	private double score=5.0;
	private String remark="";
	
	
	private JLabel namejl=new JLabel();
//	private JLabel scorejl=new JLabel("评分：");
//	private JLabel scorejl1=new JLabel();
	private JTextArea remarkjta=new JTextArea ();
	
	
	
	private JLabel bg=new JLabel(new ImageIcon("image/listback.png"));
	
	public SingleHotelRemarktoClient_JPanel (String remark){
		
		this.remark=remark;
		
		
		this.setLayout(null);
    	this.setSize(800,100);
    	this.setBackground(Color.white);
    	addComp();
    	setback();
	}

    
    
    public void addComp(){
    	
//    	namejl.setText(clientname);
//    	scorejl1.setText(score+"");
    	remarkjta.setText(remark);
    	
//    	namejl.setBounds(100,20,150,30);
//    	namejl.setForeground(color1);
//    	namejl.setFont(font);
//    	this.add(namejl);
    	
//    	scorejl.setBounds(100,50,100,30);
//    	scorejl.setFont(font);
//    	this.add(scorejl);
//    	
//    	scorejl1.setBounds(150,50,50,30);
//    	scorejl1.setFont(font);
//    	scorejl1.setForeground(color);
//    	this.add(scorejl1);
    
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
