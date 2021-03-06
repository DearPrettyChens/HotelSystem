package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import presentation.ui.checkinui.distributecontroller.CheckinDistributionController;
import presentation.ui.checkinui.viewcontroller.OnlineCheckoutViewController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
import vo.checkinvo.CheckinInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * 
 * 用户退房时，显示出来的酒店入住信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CheckOutInfo_JPanel extends JPanel {
	Date d ;
	
	private Font font1=new Font("宋体",Font.BOLD, 20);
	private Font font2=new Font("宋体",Font.BOLD, 18);
	private Font font3=new Font("宋体",Font.PLAIN, 16);
	
	private String name="";
	private String idnumber="";
	private String tel="";
	private String roomnumber="";
	private String roomtype="";
	private String realcheckintime="";
	private String realcheckouttime="";
	
	private String bedType="";
	private BedType bedType2=BedType.BIGBED;
	
	private Date checkintimeInDate=new Date(1);
	
	private Date checkouttimeInDate=new Date(1);
	private String hotelID="";
	private String orderID="";
	
	
	private JLabel titlejl=new JLabel("酒店住房记录");
	private JLabel clientjl=new JLabel("●入住人登记");
	private JLabel roomjl=new JLabel("●房间信息登记");
	private JLabel timejl=new JLabel("●时间信息登记");

	private MyButton confirmjb=new MyButton();
	private MyButton canclejb=new MyButton();
	
	private CheckinDistributionController checkinDistributionController=CheckinDistributionController.getInstance();
	
	
	
	private JLabel namejl=new JLabel();
	private JLabel idnumberjl=new JLabel();
	private JLabel teljl=new JLabel();
	private JLabel roomnumberjl=new JLabel();
	private JLabel roomtypejl=new JLabel();
	private JLabel realcheckintimejl=new JLabel();
	private JLabel realcheckouttimejl=new JLabel();
	
    private JTextField realcheckouttimejtf=new JTextField();
	
    private CheckinDistributionController distributionController=CheckinDistributionController.getInstance();
	
    private OnlineCheckoutViewController onlineCheckoutViewController=OnlineCheckoutViewController.getInstance(null);
    
    public CheckOutInfo_JPanel(CheckinInfoVO checkinInfoVO,String hotelID) {
      
    	if (checkinInfoVO!=null){
        	
        	this.name=checkinInfoVO.getCostumername();
    		this.idnumber=checkinInfoVO.getID();
    		this.tel=checkinInfoVO.getTel();
    		this.roomnumber=checkinInfoVO.getRoomnumber();
    		this.roomtype=checkinInfoVO.getRoomType();
    		this.checkintimeInDate=checkinInfoVO.getCheckintime();
    		this.realcheckintime=TransHelper.timeToString(checkintimeInDate);
    		this.hotelID=checkinInfoVO.getHotelnumber();
    		this.bedType2=checkinInfoVO.getBedtype();
       		this.bedType=bedType2.toChinese();
   		    this.orderID=checkinInfoVO.getOrdernumber();
   		
        }

   		this.setLayout(null);
   		this.setBackground(Color.white);
   		addComp();
   		this.setBounds(0, 0, 800, 600);

   	}
    
	public CheckOutInfo_JPanel(String orderID){
		
		this.orderID=orderID;
		CheckinInfoVO checkinInfoVO=distributionController.getCheckinInfo(orderID);
		
		if(checkinInfoVO!=null){
		
		this.name=checkinInfoVO.getCostumername();
		this.idnumber=checkinInfoVO.getID();
		this.tel=checkinInfoVO.getTel();
		this.roomnumber=checkinInfoVO.getRoomnumber();
		this.roomtype=checkinInfoVO.getRoomType();
		this.checkintimeInDate=checkinInfoVO.getCheckintime();
		this.realcheckintime=TransHelper.timeToString(checkintimeInDate);
		this.hotelID=checkinInfoVO.getHotelnumber();
		this.bedType2=checkinInfoVO.getBedtype();
   		this.bedType=bedType2.toChinese();
		}
		
		this.setLayout(null);
		this.setBackground(Color.white);
	    addComp();
		
		
		this.setSize(800,600);
	}

	
	
	
	public void addComp(){
		
		titlejl.setFont(font1);
		
		titlejl.setBounds(50,30,300,30);
		this.add(titlejl);
		
		clientjl.setFont(font2);
		
		clientjl.setBounds(50,100,300,30);
		this.add(clientjl);
		
		namejl.setFont(font3);
		namejl.setText("姓名："+name);
		namejl.setBounds(50,150,100,30);
		this.add(namejl);
		

		
		idnumberjl.setFont(font3);
		idnumberjl.setText("身份证号："+idnumber);
		idnumberjl.setBounds(220,150,400,30);
		this.add(idnumberjl);

		
		teljl.setFont(font3);
		teljl.setText("联系方式："+tel);
		teljl.setBounds(550,150,300,30);
		this.add(teljl);

		
		roomjl.setFont(font2);
		
		roomjl.setBounds(50,200,300,30);
		this.add(roomjl);
		
		
		
		roomnumberjl.setFont(font3);
		roomnumberjl.setText("房间号："+roomnumber);
		roomnumberjl.setBounds(50,250,100,30);
		this.add(roomnumberjl);
		

		roomtypejl.setFont(font3);
		roomtypejl.setText("房间类型："+roomtype);
		roomtypejl.setBounds(220,250,400,30);
		this.add(roomtypejl);

		
		timejl.setFont(font2);
		timejl.setBounds(50,300,300,30);
		this.add(timejl);
		
		realcheckintimejl.setFont(font3);
		realcheckintimejl.setText("实际入住时间："+realcheckintime);
		realcheckintimejl.setBounds(50,350,400,30);
		this.add(realcheckintimejl);

		
		realcheckouttimejl.setFont(font3);
		realcheckouttimejl.setText("实际退房时间：");
		realcheckouttimejl.setBounds(50,400,400,30);
		this.add(realcheckouttimejl);
		
		realcheckouttimejtf.setFont(font3);
		realcheckouttimejtf.setBounds(160,400,180,30);
		realcheckouttimejtf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				
					
					  d = new Date();  
				        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				        String dateNowStr = sdf.format(d); 
				        realcheckouttimejtf.setText(dateNowStr);
				        CheckOutInfo_JPanel.this.repaint();
				
				
				
			}
		});
		this.add(realcheckouttimejtf);
		
		
		confirmjb.setText("确认");
		confirmjb.setBounds(510,500,100,30);
		this.add(confirmjb);
		
		canclejb.setText("取消");
		canclejb.setBounds(640,500,100,30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onlineCheckoutViewController.jumpToMainFrame();
			}
		});
		
		JLabel timeError=new JLabel("不能为空");
		timeError.setForeground(Color.RED);
		timeError.setFont(font3);
		timeError.setBounds(340,400, 100, 25);
		CheckOutInfo_JPanel.this.add(timeError);
		timeError.setVisible(false);
		
		JLabel timeError2=new JLabel("日期格式为yyyy-mm-dd HH:mm:ss");
		timeError2.setForeground(Color.RED);
		timeError2.setFont(font3);
		timeError2.setBounds(340,400, 100, 25);
		CheckOutInfo_JPanel.this.add(timeError2);
		timeError2.setVisible(false);
		
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if(realcheckouttimejtf.getText().equals("")){
					timeError.setVisible(true);
				}
				else if(!realcheckouttimejtf.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
					timeError2.setVisible(true);
				}

				else if(!realcheckouttimejtf.getText().equals("")){
					CheckinInfoVO info=new CheckinInfoVO(name,idnumber,tel,
							roomnumber,roomtype,bedType2,checkintimeInDate,new Date(TransHelper.stringToTime(realcheckouttimejtf.getText()))
							,hotelID,orderID);
					if(checkinDistributionController.confirmCheckoutInfo(info)==ResultMessage.SUCCESS){
						onlineCheckoutViewController.jumpToMainFrame();
					}
					else{
						//保存失败
						new SaveFail_JFrame();
					}
				}
			}
			
		});
		
		Document timeDoc=realcheckouttimejtf.getDocument();
		timeDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				timeError2.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				timeError2.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				timeError2.setVisible(false);
			}
			
		});
		
	}
	
	
	

}

