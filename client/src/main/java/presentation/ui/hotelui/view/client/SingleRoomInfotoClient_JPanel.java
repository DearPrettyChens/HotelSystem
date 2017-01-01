package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.tools.MyButton;
import util.ViewTag;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * 顾客查看酒店信息时的单条房型信息
 * @author cy
 * @version 1.0
 * 
 */
public class SingleRoomInfotoClient_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	private  String roomtype="";
	private String bedtype="";
	private double price=0;
	
	private JLabel roomtypejl=new JLabel();
	private JLabel bedtypejl=new JLabel();
	private JLabel pricejl=new JLabel();
	
	private JLabel checkinjl=new JLabel("入住");
	private JLabel checkoutjl=new JLabel("退房");
	
	
	
	
	private JLabel bgjl=new JLabel(new ImageIcon(SingleRoomInfotoClient_JPanel.class.getResource("image/longxuxian.png")));
	
	
	private MyButton searchjb=new MyButton();
	private MyButton makeorderjb=new MyButton();
	
	private String hotelID;
	private String userID;
	private ViewTag viewTag;
	
	 private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
	    private MyFootViewController myFootViewController=MyFootViewController.getInstance(null);
		
	public SingleRoomInfotoClient_JPanel(AvailableRoomInfoVO availableRoomInfoVO,ViewTag tag){
		
		this.viewTag=tag;
		this.hotelID=availableRoomInfoVO.getHotelNumber();
		this.roomtype=availableRoomInfoVO.getRoomType();
		this.bedtype=availableRoomInfoVO.getBedType().toChinese();
		this.price=availableRoomInfoVO.getOriginalPrice();
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,60);
		setBack();
		addComp();
		
	}
	
	public void setBack(){
		
		
		bgjl.setBounds(50,55,700,10);
		this.add(bgjl);
		
		
	}
	
	
    public void addComp(){
		
    	roomtypejl.setFont(font);
    	roomtypejl.setText(roomtype);
    	roomtypejl.setBounds(95,15,100,30);
    	this.add(roomtypejl);
    	
    	bedtypejl.setFont(font);
    	bedtypejl.setText(bedtype);
    	bedtypejl.setBounds(270,15,100,30);
    	this.add(bedtypejl);
    	
    	pricejl.setFont(new Font("宋体",Font.BOLD, 18));
    	pricejl.setText(price+"");
    	pricejl.setBounds(440,15,100,30);
    	pricejl.setForeground(new Color(231, 64, 37));
    	this.add(pricejl);
    	
    	makeorderjb.setText("预定");
    	makeorderjb.setBounds(650,15,100,30);
    	this.add(makeorderjb);
    	makeorderjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (viewTag) {
				case HOTELRESERVERSION:
					reserveHotelViewController.generateNewOrder(hotelID);
					break;
				case MYHOTEL:
					myFootViewController.generateNewOrder(hotelID);
					break;
				default:
					break;
				
				}
			}
		});
    	
	}
	

}
