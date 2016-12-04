package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 顾客选择订单类型的面板，在下面放订单列表信息
 * @author cy
 * @version 1.0
 * 
 */
public class ChooseOrderTypetoClient_JPanel extends JPanel{
	
	
	private ArrayList <SingleOrderListInfotoClient> singleinfos=new ArrayList<SingleOrderListInfotoClient>();
	
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	private Color color=new Color(148, 221, 184);
	
	private JPanel backgroundjp=new JPanel();
	
	
	private JLabel allorderjl=new JLabel("所有订单",JLabel.CENTER);
	private JLabel excutedoderjl=new JLabel("已执行订单",JLabel.CENTER);
	private JLabel unexcutedjl=new JLabel("未执行订单",JLabel.CENTER);
	private JLabel cancledjl=new JLabel("已撤销订单",JLabel.CENTER);
	private JLabel unusualjl=new JLabel("异常订单",JLabel.CENTER);
	
	
	private JLabel hoteljl=new JLabel("入住酒店",JLabel.CENTER);
	private JLabel ordernumberjl=new JLabel("订单号",JLabel.CENTER);
	private JLabel ordertimejl=new JLabel("下单时间",JLabel.CENTER);
	private JLabel orderstatejl=new JLabel("订单状态",JLabel.CENTER);
	private JLabel operationjl=new JLabel("订单操作",JLabel.CENTER);
	
	
	
	public ChooseOrderTypetoClient_JPanel(){
		
		this.setSize(800,600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
	}

    public ChooseOrderTypetoClient_JPanel(ArrayList <SingleOrderListInfotoClient> singleinfos){
    	
		this.singleinfos=singleinfos;
	    this.setSize(800,600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
	}
	
	
	
	public void addComp(){
		
		backgroundjp.setLayout(null);
		
		
		
		hoteljl.setForeground(Color.white);
		hoteljl.setFont(font);
		hoteljl.setBounds(0,10,140,30);
		backgroundjp.add(hoteljl);
		
		ordernumberjl.setForeground(Color.white);
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(140,10,140,30);
		backgroundjp.add(ordernumberjl);
		
		ordertimejl.setForeground(Color.white);
		ordertimejl.setFont(font);
		ordertimejl.setBounds(280,10,140,30);
		backgroundjp.add(ordertimejl);
		
		orderstatejl.setForeground(Color.white);
		orderstatejl.setFont(font);
		orderstatejl.setBounds(420,10,140,30);
		backgroundjp.add(orderstatejl);
		
		operationjl.setForeground(Color.white);
		operationjl.setFont(font);
		operationjl.setBounds(560,10,140,30);
		backgroundjp.add(operationjl);
		
		backgroundjp.setBackground(color);
		backgroundjp.setBounds(50, 50, 700, 50);
		this.add(backgroundjp);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		allorderjl.setFont(font);
		allorderjl.setBounds(50,10,140,30);
		allorderjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				allorderjl.setForeground(color);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
			
		});
		this.add(allorderjl);
		
		excutedoderjl.setFont(font);
		excutedoderjl.setBounds(190,10,140,30);
		excutedoderjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(color);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
			
		});
		this.add(excutedoderjl);
		
		unexcutedjl.setFont(font);
		unexcutedjl.setBounds(330,10,140,30);
		unexcutedjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(color);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
			
		});
		this.add(unexcutedjl);
		
		cancledjl.setFont(font);
		cancledjl.setBounds(470,10,140,30);
		cancledjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(color);
				unusualjl.setForeground(Color.black);
				
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
			
		});
		this.add(cancledjl);
		
		unusualjl.setFont(font);
		unusualjl.setBounds(610,10,140,30);
		unusualjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(color);
				
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
			
		});
		this.add(unusualjl);
		
		
		
		
	}
}
