package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Makewebstr_JPanel  extends JPanel{
	
	private  Webvipstr_JPanel  vipstr;
	private  Webclientlevelstr_Jpanel clientlevelstr;
	private Webspecialtimestr_JPanel specialtimestr;
	
	private JLabel vipstrjl=new JLabel("VIP会员特定商圈专属折扣策略");
	private JLabel clientlevelstrjl=new JLabel("会员等级折扣策略");
	private JLabel specialtimestrjl=new JLabel("特殊时期折扣策略");
	
	private JLabel lineback=new JLabel(new ImageIcon("image//lineback.png"));
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	private Color lightcolor=new Color(149,222,184);
	private Color dackcolor=new Color(146,182,163);
	    
	
	
	
	
	public Makewebstr_JPanel(){
		//TODO this.vipstr=new Webvipstr_JPanel();参数从distributecontroller到逻辑层拿list
		//TODO this.clientlevelstr=new Webclientlevelstr_Jpanel();
		//TODO this.specialtimestr=new Webspecialtimestr_JPanel();
		this.setBackground(Color.white);
		this.setSize(800,600);
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
	    	
	    	
	    	
	    	
	    	
	    	vipstr.setBounds(0,100,800,500);
	    	this.add(vipstr);
	    	
	    	clientlevelstr.setBounds(0,100,800,500);
	    	
	    	specialtimestr.setBounds(0,100,800,500);
	    	
	    	
	    	vipstrjl.setFont(font);
	    	vipstrjl.setForeground(dackcolor);
	    	vipstrjl.setBounds(25,30,250,40);
	    	this.add(vipstrjl);
	    	
	    	vipstrjl.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					vipstrjl.setForeground(dackcolor);
					clientlevelstrjl.setForeground(lightcolor);
					specialtimestrjl.setForeground(lightcolor);
					Makewebstr_JPanel.this.remove(clientlevelstr);
					Makewebstr_JPanel.this.remove(specialtimestr);
					Makewebstr_JPanel.this.add(vipstr);
					Makewebstr_JPanel.this.repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	    	
	    	});
	    	clientlevelstrjl.setFont(font);
	    	clientlevelstrjl.setForeground(dackcolor);
	    	clientlevelstrjl.setBounds(340,30,250,40);
	    	clientlevelstrjl.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					vipstrjl.setForeground(lightcolor);
					clientlevelstrjl.setForeground(dackcolor);
					specialtimestrjl.setForeground(lightcolor);
					Makewebstr_JPanel.this.remove(vipstr);
					Makewebstr_JPanel.this.remove(specialtimestr);
					Makewebstr_JPanel.this.add(clientlevelstr);
					Makewebstr_JPanel.this.repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	    	
	    	});
	    	this.add(clientlevelstrjl);
	    	
	    	specialtimestrjl.setFont(font);
	    	specialtimestrjl.setForeground(dackcolor);
	    	specialtimestrjl.setBounds(600,30,250,40);
	    	specialtimestrjl.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					vipstrjl.setForeground(lightcolor);
					clientlevelstrjl.setForeground(lightcolor);
					specialtimestrjl.setForeground(dackcolor);
					Makewebstr_JPanel.this.remove(clientlevelstr);
					Makewebstr_JPanel.this.remove(vipstr);
					Makewebstr_JPanel.this.add(specialtimestr);
					Makewebstr_JPanel.this.repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	    	
	    	});
	    	this.add(specialtimestrjl);
	    	
	    	lineback.setBounds(0,0,800,100);
	    	this.add(lineback);
	    }
	
	
	

}
