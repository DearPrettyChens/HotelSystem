package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 酒店工作人员左边的选择栏
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworker_JLabel  extends JLabel{
	private RightContainerPanel rightContainerPanel;
	private LeftChooseMap leftChooseMap = LeftChooseMap.getInstance();
	private String name;
	int tab;
	ArrayList<Hotelworker_JLabel> alllabels;
	 public Hotelworker_JLabel (String s,int tab,ArrayList<Hotelworker_JLabel> alllabels,RightContainerPanel rightContainerPanel){
		 this.setText(s);
		 this.rightContainerPanel=rightContainerPanel;
		 name=s;
		 this.tab=tab;
		 this.alllabels=alllabels;
//		 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
		 Hotelworker_JLabel.this.setForeground(Color.GRAY);
		 Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 16));
		 this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Hotelworker_JLabel.this.setForeground(Color.BLACK);
            	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
				String info =Hotelworker_JLabel.this.name;
            	JPanel panel = leftChooseMap.get(info);
				rightContainerPanel.removeAll();
				rightContainerPanel.repaint();
				rightContainerPanel.add(panel);
				
				for (int i = 0; i < alllabels.size(); i++) {
					if (i != Hotelworker_JLabel.this.tab) {
						alllabels.get(i).setForeground(Color.GRAY);
//		            	 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
		            	 alllabels.get(i).setFont(new Font("宋体",Font.BOLD, 16));

					}

				}
				
				
			}
	            @Override
	             public void mouseEntered(MouseEvent e) {
//	            	Hotelworker_JLabel.this.setForeground(Color.GRAY);
//	            	Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
//	            	 Hotelworker_JLabel.this.setForeground(Color.BLACK);
//	            	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
	            	
	             }
	 
	             @Override
	          public void mouseExited(MouseEvent e) {
//	            	 Hotelworker_JLabel.this.setForeground(Color.GRAY);
////	            	 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
//	            	 Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 16));
	             }
	         });
	    }
		 
		 
	 /**
		 * 用于初始化左边栏第一项
		 */
		public void init() {
			Hotelworker_JLabel.this.setForeground(Color.BLACK);
        	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
		}
		 
	 }
	
	


