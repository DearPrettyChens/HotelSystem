package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.hibernate.annotations.OnDeleteAction;

import presentation.ui.checkinui.distributecontroller.CheckinDistributionController;
import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.hotelstrategyui.view.HotelEnterpriseStr_JPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.NewClient_JLabel;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
import vo.checkinvo.CheckinInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * 
 * 用户入住时，填写酒店入住信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CheckInInfo_JPanel extends JPanel {
	
	Date d;

	private Font font1 = new Font("宋体", Font.BOLD, 20);
	private Font font2 = new Font("宋体", Font.BOLD, 18);
	private Font font3 = new Font("宋体", Font.PLAIN, 16);

	private String name = "";
	private String idnumber = "";
	private String tel = "";
	private String roomnumber;
	private String roomtype = "";
	private String realcheckintime = "";
	private String realcheckouttime = "";
	private String bedType="";
	private BedType bedType2;
	private String  hotelID;
	private String orderID;

	private JLabel titlejl = new JLabel("酒店住房记录");
	private JLabel clientjl = new JLabel("●入住人登记");
	private JLabel roomjl = new JLabel("●房间信息登记");
	private JLabel timejl = new JLabel("●时间信息登记");

	private MyButton confirmjb = new MyButton();
	private MyButton canclejb = new MyButton();

	private JLabel namejl = new JLabel();
	private JLabel idnumberjl = new JLabel();
	private JLabel teljl = new JLabel();
	private JLabel roomnumberjl = new JLabel();
	private JLabel roomtypejl = new JLabel();
	private JLabel realcheckintimejl = new JLabel();
	private JLabel realcheckouttimejl = new JLabel();

	private JTextField idnumberjtf = new JTextField(idnumber);
	private JTextField realcheckintimejtf = new JTextField("");
	private JTextField realcheckouttimejtf = new JTextField("");
	private JTextField roomnumberjtf=new JTextField(roomnumber);

	private OnlineCheckinViewController onlineCheckinViewController = OnlineCheckinViewController.getInstance(null);
	private CheckinDistributionController checkinDistributionController=CheckinDistributionController.getInstance();
	
	public CheckInInfo_JPanel(OrderInfoVO orderInfoVO,String hotelID) {
     if (orderInfoVO!=null){
		this.name = orderInfoVO.getCustomerName();
		this.tel = orderInfoVO.getLiveinPersonTelephone();
		this.roomtype = orderInfoVO.getRoomType();
		this.hotelID=hotelID;
		this.orderID=orderInfoVO.getOrderID();
		this.bedType2=orderInfoVO.getBedType();
   		this.bedType=bedType2.toChinese();
     }

		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		this.setBounds(0, 0, 800, 600);

	}
	public CheckInInfo_JPanel() {
	     

			this.setLayout(null);
			this.setBackground(Color.white);
			addComp();
			this.setBounds(0, 0, 800, 600);

		}


	public void addComp() {

		titlejl.setFont(font1);

		titlejl.setBounds(50, 30, 300, 30);
		this.add(titlejl);

		clientjl.setFont(font2);

		clientjl.setBounds(50, 100, 300, 30);
		this.add(clientjl);

		namejl.setFont(font3);
		namejl.setText("姓名：" + name);
		namejl.setBounds(50, 150, 100, 30);
		this.add(namejl);

		idnumberjl.setFont(font3);
		idnumberjl.setText("身份证号：");
		idnumberjl.setBounds(220, 150, 100, 30);
		this.add(idnumberjl);

		idnumberjtf.setFont(font3);
		idnumberjtf.setBounds(300, 150, 200, 30);
		this.add(idnumberjtf);
		
		roomnumberjtf.setFont(font3);
		roomnumberjtf.setBounds(150, 250, 50, 30);
		this.add(roomnumberjtf);

		teljl.setFont(font3);
		teljl.setText("联系方式：" + tel);
		teljl.setBounds(550, 150, 300, 30);
		this.add(teljl);

		roomjl.setFont(font2);

		roomjl.setBounds(50, 200, 300, 30);
		this.add(roomjl);

		roomnumberjl.setFont(font3);
		roomnumberjl.setText("房间号：" );
		roomnumberjl.setBounds(50, 250, 100, 30);
		this.add(roomnumberjl);

		roomtypejl.setFont(font3);
		roomtypejl.setText("房间类型：" + roomtype);
		roomtypejl.setBounds(220, 250, 400, 30);
		this.add(roomtypejl);

		timejl.setFont(font2);
		timejl.setBounds(50, 300, 300, 30);
		this.add(timejl);

		realcheckintimejl.setFont(font3);
		realcheckintimejl.setText("实际入住时间：");
		realcheckintimejl.setBounds(50, 350, 120, 30);
		this.add(realcheckintimejl);

		realcheckintimejtf.setFont(font3);
		realcheckintimejtf.setBounds(160, 350, 300, 30);
		realcheckintimejtf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			    d = new Date();  
			        System.out.println("入住"+d);  
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			        String dateNowStr = sdf.format(d); 
			        realcheckintimejtf.setText(dateNowStr);
			        CheckInInfo_JPanel.this.repaint();
			        
			        System.out.println("入住格式化后的日期：" + dateNowStr);  
			}
		});
		this.add(realcheckintimejtf);

		realcheckouttimejl.setFont(font3);
		realcheckouttimejl.setText("实际退房时间：" );
		realcheckouttimejl.setBounds(50, 400, 200, 30);
		this.add(realcheckouttimejl);

		realcheckouttimejtf.setFont(font3);
		realcheckouttimejtf.setBounds(160, 400, 300, 30);
		this.add(realcheckouttimejtf);
		realcheckouttimejtf.setEditable(false);

		confirmjb.setText("确认");
		confirmjb.setBounds(510, 500, 100, 30);
		this.add(confirmjb);
		
		JLabel idError=new JLabel("身份证长度为18");
		idError.setForeground(Color.RED);
		idError.setFont(font3);
		idError.setBounds(300, 180, 200, 25);
		CheckInInfo_JPanel.this.add(idError);
		idError.setVisible(false);
		
		JLabel timeError=new JLabel("不能为空");
		timeError.setForeground(Color.RED);
		timeError.setFont(font3);
		timeError.setBounds(460,350, 200, 25);
		CheckInInfo_JPanel.this.add(timeError);
		timeError.setVisible(false);
		
		JLabel timeError2=new JLabel("日期格式为yyyy-mm-dd HH:mm:ss");
		timeError2.setForeground(Color.RED);
		timeError2.setFont(font3);
		timeError2.setBounds(460,350, 300, 25);
		CheckInInfo_JPanel.this.add(timeError2);
		timeError2.setVisible(false);
		
		JLabel roomError=new JLabel("不能为空");
		roomError.setForeground(Color.RED);
		roomError.setFont(font3);
		roomError.setBounds(150,280, 200, 25);
		CheckInInfo_JPanel.this.add(roomError);
		roomError.setVisible(false);
		
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(idnumberjtf.getText().length()!=
						18||idnumberjtf.getText().equals("")){
					idError.setVisible(true);
				}else if(realcheckintimejtf.getText().equals("")){
					timeError.setVisible(true);
				}
				else if(!realcheckintimejtf.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
					timeError2.setVisible(true);
				}
				else if(roomnumberjtf.getText().equals("")){
					roomError.setVisible(true);
				}
				else if(checkinDistributionController.checkIDLength(idnumberjtf.getText())==
						ResultMessage.SUCCESS&&!realcheckintimejtf.getText().equals("")&&
						!roomnumberjtf.getText().equals("")&&!idnumberjtf.getText().equals("")
						){
					CheckinInfoVO info=new CheckinInfoVO(name,idnumberjtf.getText(),tel,
							roomnumberjtf.getText(),roomtype,bedType2,new Date(TransHelper.stringToTime(realcheckintimejtf.getText())),
							null,hotelID,orderID);
					if(checkinDistributionController.confirmCheckinInfo(info)==ResultMessage.SUCCESS){
						
						onlineCheckinViewController.jumpToMainFrame();
					}
					else{
						//保存失败
						new SaveFail_JFrame();
					}
				}
			}
			
		});
		
		canclejb.setText("取消");
		canclejb.setBounds(640, 500, 100, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onlineCheckinViewController.jumpToMainFrame();
			}
		});

		/**
		 * 实现编辑时提示错误消息消失
		 */
		Document idDoc=idnumberjtf.getDocument();
		idDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				idError.setVisible(false);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				idError.setVisible(false);
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				idError.setVisible(false);
				
			}
			
		});
		
		Document timeDoc=realcheckintimejtf.getDocument();
		timeDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timeError.setVisible(false);
				
			}
			
		});
		
		Document roomDoc=roomnumberjtf.getDocument();
		roomDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				roomError.setVisible(false);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				roomError.setVisible(false);
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				roomError.setVisible(false);
				
			}
			
		});
	}

}
