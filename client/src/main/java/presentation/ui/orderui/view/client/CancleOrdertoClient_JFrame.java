package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import presentation.ui.tools.CancelFail_JFrame;
import presentation.ui.tools.MyButton;
import util.ResultMessage;

/**
 * 撤销订单时弹出来的对顾客的提醒
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CancleOrdertoClient_JFrame  extends JFrame{
	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color backgroundcolor = new Color(148, 221, 184); 
	private JPanel backgroundjp=new JPanel();
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();
	private CustomerOrderViewController customerOrderViewController=CustomerOrderViewController.getInstance(null);
	
	private OrderDistributionController orderDistributionController=OrderDistributionController.getInstance();
    private JLabel messagejl1=new JLabel("客官，您撤销的订单最晚执行时间已不足");
    private JLabel messagejl2=new JLabel("6小时，若继续撤销订单，将扣除订单价");
    private JLabel messagejl3=new JLabel("值一半的信用值！");
	
    private String orderID;
    
	public CancleOrdertoClient_JFrame(String orderID){
		this.orderID=orderID;
		
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300) / 2); // 定位框架位置
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(true);
		addComp();
		
		
	}
	
	public void addComp(){
		
		backgroundjp.setLayout(null);
		backgroundjp.setBounds(0, 0, 400, 300);
		backgroundjp.setBackground(Color.white);
		this.add(backgroundjp);
		
		
		this.setTitle("友情提示");
		
		messagejl1.setBounds(50,50,300,50);
		messagejl1.setFont(font);
		backgroundjp.add(messagejl1);
		
		messagejl2.setBounds(50,70,300,50);
		messagejl2.setFont(font);
		backgroundjp.add(messagejl2);
		
		messagejl3.setBounds(50,90,300,50);
		messagejl3.setFont(font);
		backgroundjp.add(messagejl3);
		
		canclejb.setText("取消");
		canclejb.setBounds(50,200,80,30);
		backgroundjp.add(canclejb);
		
		confirmjb.setText("撤销！我有的是信用！");
		confirmjb.setBounds(150,200,230,30);
		backgroundjp.add(confirmjb);
		
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(orderDistributionController.cancelOrderConfirm(orderID)==ResultMessage.SUCCESS){
					CancleOrdertoClient_JFrame.this.setVisible(false);
					//刷新订单信息
					customerOrderViewController.returnToOrderListFromCancel();
				}
				else{
					//撤销失败
					new CancelFail_JFrame();
				}
				
			}
			
		});
		
		canclejb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CancleOrdertoClient_JFrame.this.setVisible(false);
			}
			
		});
	}

	
}
