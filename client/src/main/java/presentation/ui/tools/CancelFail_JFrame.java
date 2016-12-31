package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 撤销失败的提示消息
 * @author CLL
 *
 */
public class CancelFail_JFrame extends JFrame{
	private close_JButton close_jbutton = new close_JButton();
	private JPanel upjp=new JPanel();
	private Font font=new Font("宋体", Font.BOLD, 16);
	private Color color=new Color(148, 221, 184);
	private MyButton confirmjb=new MyButton ();
	
	
	private JLabel halfjl=new JLabel("撤销失败啦，再试一次啦~");
	
	
	public CancelFail_JFrame(){
		
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
		
		
		halfjl.setFont(font);
		halfjl.setForeground(Color.RED);
		halfjl.setBounds(100,100,200,50);
		this.add(halfjl);
		
		
		
		confirmjb.setText("好的吧");
		confirmjb.setBounds(150,150,100,30);
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CancelFail_JFrame.this.dispose();
			}
			
		});
		this.add(confirmjb);
		
	}
}
