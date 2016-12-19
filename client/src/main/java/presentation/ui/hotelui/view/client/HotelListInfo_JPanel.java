package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import util.OrderState;
import util.ViewTag;
import vo.searchhotelvo.HotelListVO;

/**
 * 顾客查看的酒店列表信息
 * @author cy
 * @version 1.0
 * 
 */
public class HotelListInfo_JPanel  extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 14);
	
	private Color darkgreen=new Color(52,131,115);
	private Color lightgreen=new Color(180,241,214);
	private Color orange=new Color(231,64,37);
	private Color yellow=new Color(243,150,39);
	
	private JPanel linejp=new JPanel();
	
	private JPanel yellowjp1=new JPanel();
	private JPanel whitejp1=new JPanel();
	private JPanel yellowjp2=new JPanel();
	private JPanel whitejp2=new JPanel();
	
	private JLabel imagejl=new JLabel();
	private JLabel namejl=new JLabel();
	private JPanel starjp=new JPanel();
	private JLabel locationjl=new JLabel("地址：");
	private JTextArea locationjta=new JTextArea();
	private JLabel teljl=new JLabel();
	private JLabel scorejl=new JLabel();
	private JLabel scorejl1=new JLabel("/5分");
	
	private JLabel strjl=new JLabel();
	private JLabel pricejl=new JLabel();
	private JLabel pricejl1=new JLabel("￥");
	private JLabel pricejl2=new JLabel("起");
	private JPanel pricejp=new JPanel();
	
//	private JLabel birthjl=new JLabel("生日");
//	private JLabel threeroomjl=new JLabel("三间");
	
	private JLabel birthcountjl=new JLabel();
	private JLabel threeroomcountjl=new JLabel();
	
	private JPanel strjp=new JPanel();
	
	private MyButton orderjb=new MyButton();
	
	
	private ImageIcon realstar=new ImageIcon(HotelListInfo_JPanel.class.getResource("image/realstar.png"));
	private ImageIcon emptystar=new ImageIcon(HotelListInfo_JPanel.class.getResource("image/emptystar.png"));
	
	private JLabel starjl1=new JLabel();
	private JLabel starjl2=new JLabel();
	private JLabel starjl3=new JLabel();
	private JLabel starjl4=new JLabel();
	private JLabel starjl5=new JLabel();
	
	private JPanel scorejp=new JPanel();
	
	
	private JLabel[] allstar=new JLabel[]{starjl1,starjl2,starjl3,starjl4,starjl5};
	
	private String hotelID;
	private String name="";
	private ImageIcon image;
	private int star=5;
	private int price=0;
	private String location="";
	private String tel="";
	private double score=5.0;
//	private int threeroomcount=0;
//	private int birthcount=0;
	private ArrayList<OrderState> orderstate;
	private ViewTag viewTag;
	private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
	private MyFootViewController myFootViewController=MyFootViewController.getInstance(null);
	
	public HotelListInfo_JPanel(HotelListVO hotelListVO,ViewTag viewTag){
		this.viewTag=viewTag;
		this.hotelID=hotelListVO.getHotelID();
		this.name=hotelListVO.getHotelName();
//		
//		if(hotelListVO.getHotelImage()==null){
//			System.out.println("hotelID");
//			System.out.println("image");
//		}
		
//		this.image=new ImageIcon("image//hotel.jpg");
		this.image=hotelListVO.getHotelImage();
		this.star=hotelListVO.getStar();
		this.location=hotelListVO.getHotelAddress();
		this.tel=hotelListVO.getTelephone();
		this.score=hotelListVO.getRemark();
		this.orderstate=hotelListVO.getOrderStates();
		this.price=(int) hotelListVO.getLowestPrice();
		
		
		this.setLayout(null);
		this.setSize(800,150);
		this.setBackground(Color.white);
		addComp();
		
		
		
	}


   
   public void addComp(){
	   
	   image=ImageTool.getScaledImage(image, 100);
	   imagejl.setIcon(image);
	   imagejl.setBounds(50,22,100,100);
	   this.add(imagejl);
	   
	   namejl.setText(name);
	   namejl.setForeground(darkgreen);
	   namejl.setFont(new Font("宋体",Font.BOLD, 20));
	   namejl.setBounds(200,15,400,30);
	   this.add(namejl);
	   
	   starjp.setLayout(null);
	   starjp.setBounds(200,50,150,10);
	   starjp.setBackground(Color.white);
	   this.add(starjp);
	   for(int i=0;i<star;i++){
		   
		   allstar[i].setIcon(realstar);
		   allstar[i].setBounds(20*i,0,10,10);
		   starjp.add(allstar[i]);
		   
		   
	   }
       for(int i=star;i<5;i++){
		   
		   allstar[i].setIcon(emptystar);
		   allstar[i].setBounds(20*i,0,10,10);
		   starjp.add(allstar[i]);
		   
		   
	   }
	   
       locationjl.setFont(font);
       locationjl.setBounds(200,70,50,15);
       this.add(locationjl);
       
       locationjta.setText(location);
       locationjta.setFont(font);
       locationjta.setEditable(false);
       locationjta.setBackground(Color.white);
       locationjta.setLineWrap(true);
       locationjta.setBounds(250,70,250,32);
       this.add(locationjta);
       
       
       
       teljl.setText("联系方式："+tel);
       teljl.setFont(font);
       teljl.setBounds(200,110,200,15);
       this.add(teljl);
       
       linejp.setBackground(lightgreen);
       linejp.setBounds(50,148,700,2);
       this.add(linejp);
       
       scorejp.setBackground(lightgreen);
       scorejp.setLayout(null);
       scorejp.setBounds(530,20,100,110);
       this.add(scorejp);
       
       scorejl.setText(score+"");
       scorejl.setForeground(darkgreen);
       scorejl.setFont(new Font("宋体",Font.BOLD, 30));
       scorejl.setBounds(13,0,60,40);
       scorejp.add(scorejl);
       
       scorejl1.setFont(new Font("宋体",Font.BOLD, 15));
       scorejl1.setBounds(60,20,50,15);
       scorejp.add(scorejl1);
       
       //去掉重复的订单状态
       for(int i=0;i<orderstate.size();i++){
    	   for(int j=i+1;j<orderstate.size();j++){
    		   if(orderstate.get(i).name().equals(orderstate.get(j).name())){
    			   orderstate.remove(j);
    		   }
    	   }
       }
       
       for(int i=0;i<orderstate.size();i++){
    	   JLabel tempjl=new JLabel(orderstate.get(i).toChinese());
    	   tempjl.setFont(new Font("宋体",Font.BOLD, 10));
    	   tempjl.setBounds(25,85-15*i,80,15);
    	   scorejp.add(tempjl);   	   
       }
       
       
       pricejp.setLayout(null);
       pricejp.setBackground(Color.white);
       pricejp.setBounds(660,20,90,110);
       this.add(pricejp);
       
       pricejl.setText(price+"");
       pricejl.setBounds(10,20,100,40);
       pricejl.setFont(new Font("宋体",Font.BOLD, 30));
       pricejl.setForeground(orange);
       pricejp.add(pricejl);
       
       pricejl1.setBounds(0,0,15,15);
       pricejl1.setFont(font);
       pricejp.add(pricejl1);
       
       pricejl2.setBounds(75,60,15,15);
       pricejl2.setFont(font);
       pricejp.add(pricejl2);
       
       orderjb.setText("预定");
       orderjb.setBounds(0,80,90,30);
       pricejp.add(orderjb);
       orderjb.addActionListener(new ActionListener() {
		
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
       this.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			switch (viewTag) {
			case HOTELRESERVERSION:
				reserveHotelViewController.generateNewHotelDetailView(hotelID);;
				break;
			case MYHOTEL:
				myFootViewController.generateNewHotelDetailView(hotelID);;
				break;
			default:
				break;
			
			}
			
		}
	});
       
//       strjp.setLayout(null);
//       strjp.setBackground(Color.white);
//       strjp.setBounds(550,10,90,80);
//       this.add(strjp);
       
//       yellowjp1.setBackground(yellow);
//       yellowjp1.setLayout(null);
//       yellowjp1.setBounds(0,0,90,35);
//       yellowjp1.setLayout(null);
//       strjp.add(yellowjp1);
//       
//       whitejp1.setBackground(Color.white);
//       whitejp1.setBounds(45,2,43,31);
//       whitejp1.setLayout(null);
//       yellowjp1.add(whitejp1);
       
//       birthjl.setFont(font);
//       birthjl.setForeground(Color.white);
//       birthjl.setBounds(10,0,50,30);
//       yellowjp1.add(birthjl);
//       
//       birthjl.setFont(font);
//       birthjl.setForeground(Color.white);
//       birthjl.setBounds(10,0,50,30);
//       yellowjp1.add(birthjl);
//       
//       birthcountjl.setFont(font);
//       birthcountjl.setText(birthcount+"折");
//       birthcountjl.setBounds(10,0,50,30);
//       whitejp1.add(birthcountjl);
       
//       yellowjp2.setBackground(yellow);
//       yellowjp2.setLayout(null);
//       yellowjp2.setBounds(0,45,90,35);
//       yellowjp2.setLayout(null);
//       strjp.add(yellowjp2);
//       
       
       
//       
//       whitejp2.setBackground(Color.white);
//       whitejp2.setBounds(45,2,43,31);
//       whitejp2.setLayout(null);
//       yellowjp2.add(whitejp2);
//       
//       threeroomcountjl.setFont(font);
//       threeroomcountjl.setText(threeroomcount+"折");
//       threeroomcountjl.setBounds(10,0,50,30);
//       whitejp2.add(threeroomcountjl);
//       
//       threeroomjl.setFont(font);
//       threeroomjl.setForeground(Color.white);
//       threeroomjl.setBounds(10,0,50,30);
//       yellowjp2.add(threeroomjl);
       
   }
   
   
}
