package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 网站管理人员选择搜索或添加的面板
 * @author cy
 * @version 1.0
 * 
 */
public class Searchoradd_JPanel  extends JPanel{
	
	private JLabel searchjl=new JLabel("搜索");
	private JLabel addjl=new JLabel("添加");
	private JLabel backjl=new JLabel();
	
    private Font font=new Font("宋体",Font.BOLD, 16);
    private Color color =new Color(148,221,184);
	public Searchoradd_JPanel(){
		
		//this.setBackground(Color.white);
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
    	searchjl.setFont(font);
    	searchjl.setForeground(color);
    	searchjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				addjl.setForeground(Color.gray);
				searchjl.setForeground(color);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//searchjl.setFont(new Font("宋体",Font.BOLD, 16));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				searchjl.setFont(new Font("宋体",Font.BOLD, 18));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				searchjl.setFont(new Font("宋体",Font.BOLD, 16));
			}
    		
    	});
    	searchjl.setBounds(150,10,100,30);
    	this.add(searchjl);
    	
    	addjl.setFont(font);
    	addjl.setForeground(Color.gray);
    	addjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setForeground(color);
				searchjl.setForeground(Color.gray);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//addjl.setFont(new Font("宋体",Font.BOLD, 16));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setFont(new Font("宋体",Font.BOLD, 18));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setFont(new Font("宋体",Font.BOLD, 16));
			}
    		
    	});
    	addjl.setBounds(550,10,100,30);
    	this.add(addjl);
    	
    	ImageIcon icon=new ImageIcon("image//searchoradd.png");
    	backjl.setIcon(icon);
    	backjl.setBounds(0,0,800,50);
    	this.add(backjl);
    	
    	
    	
    }
	
	
	
	
	
	
	

}
