package presentation.ui.creditui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
import presentation.ui.tools.close_JButton;
import util.ResultMessage;
import vo.creditvo.CreditInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * 
 * 网站营销人员 选择返回一半或全部的信用值
 * @author cy
 * @version 1.0
 * 
 */
public class ReturnHalforAll_JFrame  extends JFrame{ 
	

	private JPanel upjp=new JPanel();
	private Font font=new Font("宋体", Font.BOLD, 16);
	private Color color=new Color(148, 221, 184);
	private OrderDistributionController orderDistributionController=OrderDistributionController.getInstance();
	private ManageOrderViewController manageOrderViewController = ManageOrderViewController.getInstance(null);
	
	private JLabel halfjl=new JLabel("返回一半信用值");
	private JLabel alljl=new JLabel("返回全部信用值");
	
	private String orderID;
	
	public ReturnHalforAll_JFrame(String orderID){
		
		this.orderID = orderID;
		
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
		
		

		
		halfjl.setFont(font);
		halfjl.setBounds(150,100,200,50);
		halfjl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				OrderInfoVO orderInfoVO = orderDistributionController.getOrderInfo(orderID);
				int returnCredit = (int)(orderInfoVO.getPrice()*0.5);
				ResultMessage resultMessage = orderDistributionController.setReturnCredit(orderID, returnCredit);
				//成功要加上 跳出提示框
				if(resultMessage==ResultMessage.SUCCESS){
					manageOrderViewController.closeReturnCreditFrame();
					manageOrderViewController.jumpToMainFrame();
				}else{
					
				}				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				halfjl.setForeground(color);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				halfjl.setForeground(Color.BLACK);
			}
			
		});
		this.add(halfjl);
		
		
		alljl.setFont(font);
		alljl.setBounds(150,150,200,50);
		alljl.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				OrderInfoVO orderInfoVO = orderDistributionController.getOrderInfo(orderID);
				int returnCredit = (int)(orderInfoVO.getPrice());
				ResultMessage resultMessage = orderDistributionController.setReturnCredit(orderID, returnCredit);
				//成功 要加上 跳出提示框
				if(resultMessage==ResultMessage.SUCCESS){
					manageOrderViewController.closeReturnCreditFrame();
					manageOrderViewController.jumpToMainFrame();
				}else{
					
				}	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				alljl.setForeground(color);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				alljl.setForeground(Color.BLACK);
			}
			
		});
		this.add(alljl);
		
		
	}
	



}
