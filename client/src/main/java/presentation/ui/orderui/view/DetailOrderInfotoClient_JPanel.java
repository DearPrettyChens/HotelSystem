package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 顾客查看的详细订单信息
 * @author cy
 * @version 1.0
 * 
 */

public class DetailOrderInfotoClient_JPanel  extends JPanel{
	
	private Color color = new Color(148, 221, 184);
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	private JPanel titlejp=new JPanel();
	private JPanel linejp=new JPanel();
	private JLabel titlejl=new JLabel("订单详细信息",JLabel.CENTER);
	
	private JLabel backjl=new JLabel("<返回已执行订单界面");
	
	private String ordernumber="";
	private String orderstate="";
	private String clientname="";
	private String clienttel="";
	
	private String haschild="";
	private String checkintime="";//预计
	private String checkouttime="";
	private String hotelname="";
	private String hotelloc="";
	private String hoteltel="";
	private String bedtype="";
	private int roomnumber=1;
	private String latestcheckintime="";
	private String realcheckintime="";
	private String realcheckouttime="";
	private String makeordertime="";
	private String score="";
	private String remark="";
	
	private JLabel ordernumberjl=new JLabel();
	private JLabel orderstatejl=new JLabel();
	private JLabel clientnamejl=new JLabel();
	private JLabel clientteljl=new JLabel();
	
	private JLabel haschildjl=new JLabel();
	private JLabel checkintimejl=new JLabel();
	private JLabel checkouttimejl=new JLabel();
	private JLabel hotelnamejl=new JLabel();
	private JLabel hotellocjl=new JLabel();
	private JLabel hotelteljl=new JLabel();
	private JLabel bedtypejl=new JLabel();
	private JLabel roomnumberjl=new JLabel();
	private JLabel latestcheckintimejl=new JLabel();
	private JLabel realcheckintimejl=new JLabel();
	private JLabel realcheckouttimejl=new JLabel();
	private JLabel makeordertimejl=new JLabel();
	private JLabel scorejl=new JLabel();
	private JLabel remarkjl=new JLabel();
	
	
	private JLabel peoplemessagejl=new JLabel("入住人");
	
	private JLabel roommessagejl=new JLabel("客房信息");
	private JLabel checkinmessagejl=new JLabel("入住信息");
	private JLabel othermessagejl=new JLabel("其他信息");
	
	
	
	public  DetailOrderInfotoClient_JPanel( String ordernumber,String orderstate,String clientname,String clienttel, String haschild,String checkintime,
			String checkouttime,String hotelname,String hotelloc,String hoteltel,String bebtype,int roomnumber
			,String latestcheckintime,String realcheckintime,String realcheckouttime,String makeordertime,
			String score,String remark){
		
		
		
		this.ordernumber=ordernumber;
		this.orderstate=orderstate;
		this.clientname=clientname;
		this.clienttel=clienttel;
		this.haschild=haschild;
		this.checkintime=checkintime;
		this.checkouttime=checkouttime;
		this.hotelname=hotelname;
		this.hotelloc=hotelloc;
		this.hoteltel=hoteltel;
		this.bedtype=bedtype;
		this.roomnumber=roomnumber;
		this.latestcheckintime=latestcheckintime;
		this.realcheckintime=realcheckintime;
		this.realcheckouttime=realcheckouttime;
		this.makeordertime=makeordertime;
		this.score=score;
		this.remark=remark;
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);
		addComp();
		
		
		
		
	}
	
	
	
	
    public  DetailOrderInfotoClient_JPanel(){
    	this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);
		addComp();
		
		
		
	}
	
	
	
	
	
	public void addComp(){
		
		
		
		titlejp.setBounds(50,10,120,30);
    	titlejp.setBackground(color);
    	this.add(titlejp);
    	
    	linejp.setBounds(50,38,700,2);
    	linejp.setBackground(color);
    	this.add(linejp);
    	
    	titlejl.setForeground(Color.white);
    	titlejl.setFont(font);
    	titlejl.setBounds(0,20,200,30);
    	titlejp.add(titlejl);
		
		ordernumberjl.setText("订单号："+ordernumber);
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(200,10,300,30);
		this.add(ordernumberjl);
		
		orderstatejl.setText("订单状态："+orderstate);
		orderstatejl.setFont(font);
		orderstatejl.setBounds(500,10,300,30);
		this.add(orderstatejl);
		
		clientnamejl.setText("姓名："+clientname);
		clientnamejl.setFont(font);
		clientnamejl.setBounds(200,40,300,30);
		this.add(clientnamejl);
		
		clientteljl.setText("联系方式："+clienttel);
		clientteljl.setFont(font);
		clientteljl.setBounds(200,65,300,30);
		this.add(clientteljl);
		
		haschildjl.setText("有无儿童："+haschild);
		haschildjl.setFont(font);
		haschildjl.setBounds(200,90,300,30);
		this.add(haschildjl);
		
		checkintimejl.setText("入住时间："+checkintime);
		checkintimejl.setFont(font);
		checkintimejl.setBounds(200,120,300,30);
		this.add(checkintimejl);
		
		checkouttimejl.setText("至"+ordernumber);
		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(500,120,300,30);
		this.add(checkouttimejl);
		
		hotelnamejl.setText("入住酒店："+hotelloc);
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(200,145,300,30);
		this.add(hotelnamejl);
		
		hotellocjl.setText("酒店地址：："+hotelloc);
		hotellocjl.setFont(font);
		hotellocjl.setBounds(200,170,300,30);
		this.add(hotellocjl);
		
		hotelteljl.setText("房间类型："+hoteltel);
		hotelteljl.setFont(font);
		hotelteljl.setBounds(200,195,300,30);
		this.add(hotelteljl);
		
		bedtypejl.setText("床型："+bedtype);
		bedtypejl.setFont(font);
		bedtypejl.setBounds(200,220,300,30);
		this.add(bedtypejl);
		
		roomnumberjl.setText("房间数量："+roomnumber);
		roomnumberjl.setFont(font);
		roomnumberjl.setBounds(200,250,300,30);
		this.add(roomnumberjl);
		
		latestcheckintimejl.setText("最晚入住时间："+latestcheckintime);
		latestcheckintimejl.setFont(font);
		latestcheckintimejl.setBounds(200,275,300,30);
		this.add(latestcheckintimejl);
		
		realcheckintimejl.setText("实际入住时间："+realcheckintime);
		realcheckintimejl.setFont(font);
		realcheckintimejl.setBounds(200,300,300,30);
		this.add(realcheckintimejl);
		
		realcheckouttimejl.setText("实际退房时间："+realcheckouttime);
		realcheckouttimejl.setFont(font);
		realcheckouttimejl.setBounds(200,325,300,30);
		this.add(realcheckouttimejl);
		
		makeordertimejl.setText("下单时间："+makeordertime);
		makeordertimejl.setFont(font);
		makeordertimejl.setBounds(200,355,300,30);
		this.add(makeordertimejl);
		
		scorejl.setText("我的评分："+score);
		scorejl.setFont(font);
		scorejl.setBounds(200,380,300,30);
		this.add(scorejl);
		
		remarkjl.setText("我的评价："+remark);
		remarkjl.setFont(font);
		remarkjl.setBounds(200,405,300,30);
		this.add(remarkjl);
		
		//peoplemessagejl.setText("订单号"+ordernumber);
		peoplemessagejl.setFont(font);
		peoplemessagejl.setBounds(50,50,200,30);
		this.add(peoplemessagejl);
		
		
		
		//roommessagejl.setText("订单号"+ordernumber);
		roommessagejl.setFont(font);
		roommessagejl.setBounds(50,150,150,30);
		this.add(roommessagejl);
		
		//ordernumberjl.setText("订单号"+ordernumber);
		checkinmessagejl.setFont(font);
		checkinmessagejl.setBounds(50,250,200,30);
		this.add(checkinmessagejl);
		
		//ordernumberjl.setText("订单号"+ordernumber);
		othermessagejl.setFont(font);
		othermessagejl.setBounds(50,350,200,30);
		this.add(othermessagejl);
		
		
		

    	backjl.setForeground(color);
    	backjl.setBounds(50,500,200,30);
    	backjl.setFont(new Font("宋体",Font.BOLD, 15));
    	backjl.addMouseListener( new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				backjl.setFont(font);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				backjl.setFont(new Font("宋体",Font.BOLD, 15));
			}
    		
    	});
    	this.add(backjl);
    	
		
		
		
		
		
	}
	
	

}
