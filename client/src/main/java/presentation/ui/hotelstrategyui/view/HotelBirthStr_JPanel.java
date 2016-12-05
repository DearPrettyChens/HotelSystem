package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.hotelstrategyui.distributecontroller.HotelStrategyDistributionController;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;
import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.tools.MyButton;
import util.HotelStrategyType;
import vo.hotelstrategyvo.HotelStrVO;

/**
 * 生日特惠策略
 * 
 * 未加确认按钮
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelBirthStr_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	private JLabel titlejl=new JLabel("会员生日特惠策略");
	private JLabel countjl=new JLabel("折扣值：");
	private JTextField countjtf=new  JTextField ();
	private double discount;
	
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();
	
	private String hotelID;
	private HotelStrategyDistributionController hotelStrategyDistributionController=HotelStrategyDistributionController.getInstance();
	private HotelStrategyViewControllerImpl hotelStrategyViewControllerImpl=HotelStrategyViewControllerImpl.getInstance(null);
	
	
	public  HotelBirthStr_JPanel (String hotelID){
		HotelStrVO hotelStrVO=hotelStrategyDistributionController.getHotelStrategy(hotelID, HotelStrategyType.BIRTH);
		discount=hotelStrVO.getDiscount();
		
		countjtf.setText(discount+"");
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		addComp();
		
		
		
	}
	
	public void  addComp(){
		
		
		canclejb.setText("取消");
		canclejb.setBounds(400,400,80,30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hotelStrategyViewControllerImpl.backToselectStrategy();
				
			}
		});
		
		confirmjb.setText("确定");
		confirmjb.setBounds(280,400,80,30);
		this.add(confirmjb);
		
		titlejl.setFont(font);
		titlejl.setBounds(300,80,200,30);
		this.add(titlejl);
		
		countjl.setFont(font);
		countjl.setBounds(220,200,100,50);
		this.add(countjl);
		
		countjtf.setText(discount+"");
		countjtf.setBounds(320,200,200,50);
		this.add(countjtf);
		
		
		
		
		
	}

}
