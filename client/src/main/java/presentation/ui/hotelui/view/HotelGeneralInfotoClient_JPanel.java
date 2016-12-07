package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class HotelGeneralInfotoClient_JPanel  extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 15);
	
	
	
	private Color darkgreen=new Color(52,131,115);
	private Color lightgreen=new Color(180,241,214);
	private Color orange=new Color(231,64,37);
	private Color yellow=new Color(243,150,39);
	
	private JPanel linejp=new JPanel();
	
	private JLabel guidejl=new JLabel();
	private JLabel imagejl=new JLabel();
	private JLabel namejl=new JLabel();
	private JPanel starjp=new JPanel();
	private JLabel locationjl=new JLabel("地址：");
	private JTextArea locationjta=new JTextArea();
	private JLabel teljl=new JLabel();
	
	
	
	private JLabel pricejl=new JLabel();
	private JLabel pricejl1=new JLabel("￥");
	private JLabel pricejl2=new JLabel("起");
	private JPanel pricejp=new JPanel();
	
	private JPanel choosejp=new JPanel();
	private JPanel bgjp1=new JPanel();
	private JPanel bgjp2=new JPanel();
	private JPanel bgjp3=new JPanel();
	private JPanel bgjp4=new JPanel();
	
    private JLabel rooninfojl=new JLabel("房型列表",JLabel.CENTER);
    private JLabel hotelinfojl=new JLabel("酒店详情",JLabel.CENTER);
    private JLabel hotelremarkjl=new JLabel("酒店点评",JLabel.CENTER);
    private JLabel orderjl=new JLabel("酒店订单",JLabel.CENTER);
	
	
	
	
	private JPanel strjp=new JPanel();
	
	
	
	
	private ImageIcon realstar=new ImageIcon("image/realstar.png");
	private ImageIcon emptystar=new ImageIcon("image/emptystar.png");
	
	private JLabel starjl1=new JLabel();
	private JLabel starjl2=new JLabel();
	private JLabel starjl3=new JLabel();
	private JLabel starjl4=new JLabel();
	private JLabel starjl5=new JLabel();
	
	private MyButton orderjb=new MyButton();
	
	
	private JLabel[] allstar=new JLabel[]{starjl1,starjl2,starjl3,starjl4,starjl5};
	
	private String name="";
	private String image="";
	private int star=5;
	private double price=0;
	private String location="";
	private String tel="";
	
	
	
	
//	private String 
	
	
	public HotelGeneralInfotoClient_JPanel(String name,String image,int star,String location,String tel,int price){
		
		this.name=name;
		this.image=image;
		this.star=star;
		this.location=location;
		this.tel=tel;
	
		this.price=price;
		
		
		this.setLayout(null);
		this.setSize(800,100);
		this.setBackground(Color.white);
		addComp();
		addChoosejp();
		
		
		
	}
	
   public HotelGeneralInfotoClient_JPanel(){
		
		
	   this.setLayout(null);
	   this.setSize(800,600);
	   this.setBackground(Color.white);
	   addComp();
	   addChoosejp();
		
		
	}

   
   public void addComp(){
	   
	   
	   imagejl.setIcon(new ImageIcon(image));
	   imagejl.setBounds(450,10,130,130);
	   this.add(imagejl);
	   
	   guidejl.setText("酒店预订 >> "+name);
	   guidejl.setFont(new Font("宋体",Font.BOLD, 10));
	   guidejl.setBounds(50,0,300,20);
	   this.add(guidejl);
	   
	   namejl.setText(name);
	   namejl.setForeground(darkgreen);
	   namejl.setFont(new Font("宋体",Font.BOLD, 23));
	   namejl.setBounds(50,20,200,35);
	   this.add(namejl);
	   
	   starjp.setLayout(null);
	   starjp.setBounds(50,60,150,10);
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
       locationjl.setBounds(50,80,50,15);
       this.add(locationjl);
       
       locationjta.setText(location);
       locationjta.setFont(font);
       locationjta.setEditable(false);
       locationjta.setBackground(Color.white);
       locationjta.setLineWrap(true);
       locationjta.setBounds(100,80,300,40);
       this.add(locationjta);
       
       
       
       teljl.setText("联系方式："+tel);
       teljl.setFont(font);
       teljl.setBounds(50,125,200,15);
       this.add(teljl);
       
       linejp.setBackground(lightgreen);
       linejp.setBounds(50,95,700,2);
       //this.add(linejp);
       
     
       
       
       pricejp.setLayout(null);
       pricejp.setBackground(Color.white);
       pricejp.setBounds(600,10,150,150);
       this.add(pricejp);
       
       pricejl.setText(price+"");
       pricejl.setBounds(15,10,200,60);
       pricejl.setFont(new Font("宋体",Font.BOLD, 40));
       pricejl.setForeground(orange);
       pricejp.add(pricejl);
       
       pricejl1.setBounds(0,0,15,15);
       pricejl1.setFont(font);
       pricejp.add(pricejl1);
       
       pricejl2.setBounds(135,80,15,15);
       pricejl2.setFont(font);
       pricejp.add(pricejl2);
       
       orderjb.setText("预定");
       orderjb.setBounds(20,100,100,30);
       pricejp.add(orderjb);
       
       
       
       
       strjp.setLayout(null);
       strjp.setBackground(Color.white);
       strjp.setBounds(550,10,90,80);
       this.add(strjp);
       
       
       
      
       
   }
   
   public void addChoosejp(){
	   
	   
	   choosejp.setLayout(null);
	   choosejp.setBounds(50,170,700,30);
	   choosejp.setBackground(Color.white);
	   
	   this.add(choosejp);
	   
	   rooninfojl.setBounds(0,0,175,30);
	   rooninfojl.setFont(font);
	   rooninfojl.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			rooninfojl.setForeground(lightgreen);
			 hotelremarkjl.setForeground(Color.black);
			rooninfojl.setForeground(Color.black);
			orderjl.setForeground(Color.black);
			HotelGeneralInfotoClient_JPanel.this.repaint();
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
	   choosejp.add(rooninfojl);
	   
	   hotelinfojl.setBounds(175,0,175,30);
	   hotelinfojl.setFont(font);
	   hotelinfojl.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			rooninfojl.setForeground(Color.black);
			 hotelremarkjl.setForeground(lightgreen);
			rooninfojl.setForeground(Color.black);
			orderjl.setForeground(Color.black);
			HotelGeneralInfotoClient_JPanel.this.repaint();
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
	   
	 
	   choosejp.add(hotelinfojl);
	   
	   hotelremarkjl.setBounds(350,0,175,30);
	   hotelremarkjl.setFont(font);
	   hotelremarkjl.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			rooninfojl.setForeground(Color.black);
			 hotelremarkjl.setForeground(lightgreen);
			rooninfojl.setForeground(Color.black);
			orderjl.setForeground(Color.black);
			HotelGeneralInfotoClient_JPanel.this.repaint();
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
	   choosejp.add(hotelremarkjl);
	   
	   orderjl.setBounds(525,0,175,30);
	   orderjl.setFont(font);
	   orderjl.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			rooninfojl.setForeground(Color.black);
			 hotelremarkjl.setForeground(Color.black);
			rooninfojl.setForeground(Color.black);
			orderjl.setForeground(lightgreen);
			HotelGeneralInfotoClient_JPanel.this.repaint();
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
	   choosejp.add(orderjl);
	   
	   bgjp1.setBackground(lightgreen);
	   bgjp1.setBounds(0,28,700,2);
	   choosejp.add(bgjp1);
	   
	   bgjp2.setBackground(lightgreen);
	   bgjp2.setBounds(175,0,2,30);
	   choosejp.add(bgjp2);
	   
	   bgjp3.setBackground(lightgreen);
	   bgjp3.setBounds(350,0,2,30);
	   choosejp.add(bgjp3);
	   
	   bgjp4.setBackground(lightgreen);
	   bgjp4.setBounds(525,0,2,30);
	   choosejp.add(bgjp4);
	   
	   
	   
   }
   
   
}
