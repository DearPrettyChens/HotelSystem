package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.ui.tools.MyButton;

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
	
	private JLabel birthjl=new JLabel("生日");
	private JLabel threeroomjl=new JLabel("三间");
	
	private JLabel birthcountjl=new JLabel();
	private JLabel threeroomcountjl=new JLabel();
	
	private JPanel strjp=new JPanel();
	
	private MyButton orderjb=new MyButton();
	
	
	private ImageIcon realstar=new ImageIcon("image/realstar.png");
	private ImageIcon emptystar=new ImageIcon("image/emptystar.png");
	
	private JLabel starjl1=new JLabel();
	private JLabel starjl2=new JLabel();
	private JLabel starjl3=new JLabel();
	private JLabel starjl4=new JLabel();
	private JLabel starjl5=new JLabel();
	
	private JPanel scorejp=new JPanel();
	
	
	private JLabel[] allstar=new JLabel[]{starjl1,starjl2,starjl3,starjl4,starjl5};
	
	private String name="";
	private String image="";
	private int star=5;
	private double price=0;
	private String location="";
	private String tel="";
	private double score=5.0;
	private int threeroomcount=0;
	private int birthcount=0;
	private String[] orderstate;
	
	
//	private String 
	
	
	public HotelListInfo_JPanel(String name,String image,int star,String location,String tel,double score,int threeroomcount,int birthcount,String[] orderstate,int price){
		
		this.name=name;
		this.image=image;
		this.star=star;
		this.location=location;
		this.tel=tel;
		this.score=score;
		this.threeroomcount=threeroomcount;
		this.birthcount=birthcount;
		this.orderstate=orderstate;
		this.price=price;
		
		
		this.setLayout(null);
		this.setSize(800,100);
		this.setBackground(Color.white);
		addComp();
		
		
		
	}
	
   public HotelListInfo_JPanel(){
		
		
	   this.setLayout(null);
	   this.setSize(800,100);
	   this.setBackground(Color.white);
	   addComp();
		
		
	}

   
   public void addComp(){
	   
	   
	   imagejl.setIcon(new ImageIcon(image));
	   imagejl.setBounds(50,10,80,80);
	   this.add(imagejl);
	   
	   namejl.setText(name);
	   namejl.setForeground(darkgreen);
	   namejl.setFont(new Font("宋体",Font.BOLD, 20));
	   namejl.setBounds(200,0,200,30);
	   this.add(namejl);
	   
	   starjp.setLayout(null);
	   starjp.setBounds(200,30,150,10);
	   starjp.setBackground(Color.white);
	   this.add(starjp);
	   for(int i=0;i<star;i++){
		   
		   allstar[i].setIcon(realstar);
		   allstar[i].setBounds(30*i,0,10,10);
		   starjp.add(allstar[i]);
		   
		   
	   }
       for(int i=star;i<5;i++){
		   
		   allstar[i].setIcon(emptystar);
		   allstar[i].setBounds(30*i,0,10,10);
		   starjp.add(allstar[i]);
		   
		   
	   }
	   
       locationjl.setFont(font);
       locationjl.setBounds(200,40,50,15);
       this.add(locationjl);
       
       locationjta.setText(location);
       locationjta.setFont(font);
       locationjta.setEditable(false);
       locationjta.setBackground(Color.white);
       locationjta.setLineWrap(true);
       locationjta.setBounds(250,40,150,35);
       this.add(locationjta);
       
       
       
       teljl.setText("联系方式："+tel);
       teljl.setFont(font);
       teljl.setBounds(200,75,200,15);
       this.add(teljl);
       
       linejp.setBackground(lightgreen);
       linejp.setBounds(50,95,700,2);
       this.add(linejp);
       
       scorejp.setBackground(lightgreen);
       scorejp.setLayout(null);
       scorejp.setBounds(430,10,100,80);
       this.add(scorejp);
       
       scorejl.setText(score+"");
       scorejl.setForeground(darkgreen);
       scorejl.setFont(new Font("宋体",Font.BOLD, 25));
       scorejl.setBounds(20,0,40,40);
       scorejp.add(scorejl);
       
       scorejl1.setFont(new Font("宋体",Font.BOLD, 10));
       scorejl1.setBounds(60,20,50,15);
       scorejp.add(scorejl1);
       
       for(int i=0;i<orderstate.length;i++){
    	   JLabel tempjl=new JLabel(orderstate[i]);
    	   tempjl.setFont(font);
    	   tempjl.setBounds(20,35+15*i,80,15);
    	   scorejp.add(tempjl);
    	   
    	   
       }
       
       
       pricejp.setLayout(null);
       pricejp.setBackground(Color.white);
       pricejp.setBounds(660,10,90,80);
       this.add(pricejp);
       
       pricejl.setText(price+"");
       pricejl.setBounds(15,0,100,40);
       pricejl.setFont(new Font("宋体",Font.BOLD, 25));
       pricejl.setForeground(orange);
       pricejp.add(pricejl);
       
       pricejl1.setBounds(0,0,15,15);
       pricejl1.setFont(font);
       pricejp.add(pricejl1);
       
       pricejl2.setBounds(75,40,15,15);
       pricejl2.setFont(font);
       pricejp.add(pricejl2);
       
       orderjb.setText("预定");
       orderjb.setBounds(0,60,90,20);
       pricejp.add(orderjb);
       
       
       
       strjp.setLayout(null);
       strjp.setBackground(Color.white);
       strjp.setBounds(550,10,90,80);
       this.add(strjp);
       
       yellowjp1.setBackground(yellow);
       yellowjp1.setLayout(null);
       yellowjp1.setBounds(0,0,90,35);
       yellowjp1.setLayout(null);
       strjp.add(yellowjp1);
       
       whitejp1.setBackground(Color.white);
       whitejp1.setBounds(45,2,43,31);
       whitejp1.setLayout(null);
       yellowjp1.add(whitejp1);
       
       birthjl.setFont(font);
       birthjl.setForeground(Color.white);
       birthjl.setBounds(10,0,50,30);
       yellowjp1.add(birthjl);
       
       birthjl.setFont(font);
       birthjl.setForeground(Color.white);
       birthjl.setBounds(10,0,50,30);
       yellowjp1.add(birthjl);
       
       birthcountjl.setFont(font);
       birthcountjl.setText(birthcount+"折");
       birthcountjl.setBounds(10,0,50,30);
       whitejp1.add(birthcountjl);
       
       yellowjp2.setBackground(yellow);
       yellowjp2.setLayout(null);
       yellowjp2.setBounds(0,45,90,35);
       yellowjp2.setLayout(null);
       strjp.add(yellowjp2);
       
       
       
       
       whitejp2.setBackground(Color.white);
       whitejp2.setBounds(45,2,43,31);
       whitejp2.setLayout(null);
       yellowjp2.add(whitejp2);
       
       threeroomcountjl.setFont(font);
       threeroomcountjl.setText(threeroomcount+"折");
       threeroomcountjl.setBounds(10,0,50,30);
       whitejp2.add(threeroomcountjl);
       
       threeroomjl.setFont(font);
       threeroomjl.setForeground(Color.white);
       threeroomjl.setBounds(10,0,50,30);
       yellowjp2.add(threeroomjl);
       
   }
   
   
}
