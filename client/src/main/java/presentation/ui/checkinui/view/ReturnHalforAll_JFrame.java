package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.close_JButton;

/**
 * 
 * 网站营销人员 选择返回一半或全部的信用值
 * @author cy
 * @version 1.0
 * 
 */
public class ReturnHalforAll_JFrame  extends JFrame{ 
	
	private close_JButton close_jbutton = new close_JButton();
	private JPanel upjp=new JPanel();
	private Font font=new Font("宋体", Font.BOLD, 16);
	private Color color=new Color(148, 221, 184);
	
	
	private JLabel halfjl=new JLabel("返回一半信用值");
	private JLabel alljl=new JLabel("返回全部信用值");
	
	
	public ReturnHalforAll_JFrame(){
		
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300) / 2); // 定位框架位置
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		
		this.getContentPane().setBackground(Color.white);
		addComp();
		
		
		
		this.setVisible(true);
		
	}
	
	
	
	public void addComp(){
		
		upjp.setBackground(new Color(148, 221, 184));
		upjp.setBounds(0,0,400,50);
		upjp.setLayout(null);
		this.add(upjp);
		
		
		close_jbutton.setBounds(350, 10, 24, 24);
		upjp.add(close_jbutton);
		
		
		halfjl.setFont(font);
		halfjl.setBounds(150,100,200,50);
		halfjl.addMouseListener(new MouseListener(){

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
				halfjl.setForeground(color);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				halfjl.setForeground(Color.BLACK);
			}
			
		});
		this.add(halfjl);
		
		
		alljl.setFont(font);
		alljl.setBounds(150,150,200,50);
		alljl.addMouseListener(new MouseListener(){

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
				alljl.setForeground(color);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				alljl.setForeground(Color.BLACK);
			}
			
		});
		this.add(alljl);
		
		
	}
	

	public static void main(String[] args){
		
		  
		new ReturnHalforAll_JFrame ();
		
		
		
		
		
	}
	
	
}
