package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;

/**
 * 顾客评价酒店的面板
 * @author cy
 * @version 1.0
 * 
 */
public class RemarkHoteltoClient_JPanel  extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	private Color color=new Color(133, 196, 163);
	
	private String hotelname="";
	private String image="";
	
	private JPanel titlejp=new JPanel();
	private JPanel linejp=new JPanel();
	private JLabel titlejl=new JLabel("追加评论",JLabel.CENTER);
	private JLabel hotelnamejl=new JLabel();
	private JLabel imagejl=new JLabel();
	private JLabel scorejl=new JLabel("评分：");
	private JLabel remarkjl=new JLabel("评论:");
	private MyTextfield scorejtf=new MyTextfield("5.0");
	private JTextArea remarkjtf=new JTextArea ("来分享一下您的入住体验吧~");
	private MyButton confirmjb=new MyButton();
	private JLabel backjl=new JLabel("<返回已执行订单界面");
	
	
	
	public RemarkHoteltoClient_JPanel(String hotelname,String image){
		this.hotelname=hotelname;
		this.image=image;
		
		
		imagejl.setIcon(new ImageIcon(image));
		hotelnamejl.setText(hotelname);
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);
		addComp();
		
		
		
	}
	
    public RemarkHoteltoClient_JPanel(){
		
		
    	this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);
		addComp();
    	
    	
    	
	}
	
    
    
    public void addComp(){
    	
    	
    	
    	
    	titlejp.setBounds(50,50,200,50);
    	titlejp.setBackground(color);
    	this.add(titlejp);
    	
    	linejp.setBounds(50,98,700,2);
    	linejp.setBackground(color);
    	this.add(linejp);
    	
    	titlejl.setForeground(Color.white);
    	titlejl.setFont(font);
    	titlejl.setBounds(0,20,200,30);
    	titlejp.add(titlejl);
    	
    	
    	imagejl.setBounds(50,150,150,150);
    	this.add(imagejl);
    	
    	hotelnamejl.setBounds(50,350,150,30);
    	hotelnamejl.setFont(font);
    	this.add(hotelnamejl);
    	
    	
    	scorejl.setBounds(300,150,150,30);
    	scorejl.setFont(font);
    	this.add(scorejl);
    	
    	remarkjl.setBounds(300,200,150,30);
    	remarkjl.setFont(font);
    	this.add(remarkjl);
    	
    	
    	scorejtf.setBounds(350,150,150,30);
    	scorejtf.setFont(font);
    	this.add(scorejtf);
    	
    	remarkjtf.setBounds(350,200,300,200);
    	remarkjtf.setBorder(new LineBorder(Color.gray, 1, false));
    	remarkjtf.setForeground(Color.gray);
    	remarkjtf.setFont(font);
    	this.add(remarkjtf);
    	
    	
    	backjl.setForeground(color);
    	backjl.setBounds(50,500,200,30);
    	backjl.setFont(new Font("宋体",Font.BOLD, 15));
    	backjl.addMouseListener( new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				backjl.setFont(font);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				backjl.setFont(new Font("宋体",Font.BOLD, 15));
			}
    		
    	});
    	this.add(backjl);
    	
    	
    	confirmjb.setText("确认评价");
    	confirmjb.setBounds(400,500,200,30);
    	this.add(confirmjb);
    	
    }

}
