package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import exception.NotFoundHotelException;
import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.newclient_JLabel;
import util.BedType;
import util.Children;
import util.OrderState;
import util.ResultMessage;
import util.Telephone;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * 顾客填写订单的界面
 * 
 * 未添加controller调用 未实现时时检查
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class WriteOrdertoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color color = new Color(148, 221, 184);

	private String hotelname;
	private ArrayList<String> roomtypes = new ArrayList<String>();
	private ArrayList<BedType> bedtypes = new ArrayList<BedType>();

	private JComboBox roomtypecomboBox = new JComboBox();
	private JComboBox bedtypecomboBox = new JComboBox();

	private JPanel bgjp1 = new JPanel();
	private JPanel bgjp2 = new JPanel();
	private JPanel bgjp3 = new JPanel();
	private JPanel bgjp4 = new JPanel();

	private MyTextfield namejtf = new MyTextfield("2—8位汉字");
	private JLabel infoBesideName = new JLabel();
	private MyTextfield teljtf = new MyTextfield("11位手机号");
	private JLabel infoBesideTel = new JLabel();

	private boolean telephoneValid = false;
	private boolean numberValid = false;
	
	private JTextField numberjtf = new JTextField();
	private JLabel infoBesideNumber = new JLabel();

	private MyTextfield fromtimejtf = new MyTextfield("请选择日期");
	private MyTextfield totimejtf = new MyTextfield("请选择日期");
	private JLabel infoBesideTime = new JLabel();

	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy-MM-dd");
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy-MM-dd");

	private JLabel roommessagejl = new JLabel("客房信息");
	private JLabel clientmessagejl = new JLabel("入住人信息");

	private JLabel checkintimejl = new JLabel("入住时间：");

	private JLabel checkouttimejl = new JLabel("至");

	private JLabel hotelnamejl = new JLabel("入住酒店：");

	private JLabel roomtypejl = new JLabel("房间类型：");
	private JLabel bedtypejl = new JLabel("床型：");
	private JLabel roomnumberjl = new JLabel("房间数量：");
	private JLabel haschildjl = new JLabel("有无儿童：");
	private JLabel clientnamejl = new JLabel("姓名：");
	private JLabel clientteljl = new JLabel("联系方式：");

	private JRadioButton haschildjb = new JRadioButton("是");
	private JRadioButton hasnochildjb = new JRadioButton("否");

	private ButtonGroup group = new ButtonGroup();
	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();

	private String hotelID;
	private String userID;

	public WriteOrdertoClient_JPanel(String hotelID, String userID) {
		this.userID = userID;
		this.hotelID = hotelID;
		try {
			HotelDetailInfoVO hotelDetailInfoVO = orderDistributionController.getHotelDetailInfo(hotelID);
			this.hotelname = hotelDetailInfoVO.getHotelName();
			ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs = hotelDetailInfoVO.getAvailableRoomInfoVO();
			for (AvailableRoomInfoVO availableRoomInfoVO : availableRoomInfoVOs) {
				this.roomtypes.add(availableRoomInfoVO.getRoomType());
				this.bedtypes.add(availableRoomInfoVO.getBedType());
			}

			// 删除重复的房型和床型
			for (int i = 0; i < roomtypes.size(); i++) {
				for (int j =i+ 1; j < roomtypes.size(); j++) {
					if (roomtypes.get(i).equals(roomtypes.get(j))) {
						roomtypes.remove(j);
					}
				}
			}

			for (int i = 0; i < bedtypes.size(); i++) {
				for (int j = i+1; j < bedtypes.size(); j++) {
					if (bedtypes.get(i).equals(bedtypes.get(j))) {
						bedtypes.remove(j);
					}
				}
			}

		} catch (NotFoundHotelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 360);
		addComp();

	}

	public void addComp() {

		fromtimejtf.setBounds(290, 50, 100, 25);

		this.add(fromtimejtf);
		// this.add(jp);
		p1.initCalendarPanel();
		JLabel l1 = new JLabel("日历面板");
		p1.add(l1);
		this.add(p1);
		// this.getContentPane().add(txt1);

		totimejtf.setBounds(430, 50, 100, 25);

		this.add(totimejtf);
		
		// this.add(jp);
		p2.initCalendarPanel();
		JLabel l2 = new JLabel("日历面板");
		p2.add(l2);
		this.add(p2);
		// this.getContentPane().add(txt1);

		infoBesideTime.setBounds(550,50,150,25);
		infoBesideTime.setFont(font);
		infoBesideTime.setForeground(Color.RED);
		this.add(infoBesideTime);
		
		roommessagejl.setFont(font);
		roommessagejl.setBounds(50, 120, 150, 30);
		this.add(roommessagejl);

		checkintimejl.setFont(font);
		checkintimejl.setBounds(200, 50, 100, 25);
		this.add(checkintimejl);

		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(400, 50, 100, 25);
		this.add(checkouttimejl);
		
		hotelnamejl.setFont(font);
		hotelnamejl.setText("入住酒店：" + hotelname);
		hotelnamejl.setBounds(200, 85, 300, 25);
		this.add(hotelnamejl);

		roomtypejl.setFont(font);
		roomtypejl.setBounds(200, 120, 150, 25);
		this.add(roomtypejl);

		if (roomtypes.size() != 0) {
			for (int i = 0; i < roomtypes.size(); i++) {

				roomtypecomboBox.addItem(roomtypes.get(i));

			}
		}

		roomtypecomboBox.setBounds(300, 120, 150, 25);
		this.add(roomtypecomboBox);

		if (bedtypes.size() != 0) {
			for (int i = 0; i < bedtypes.size(); i++) {

				bedtypecomboBox.addItem(bedtypes.get(i).toChinese());

			}
		}
		bedtypecomboBox.setBounds(300, 155, 150, 25);
		this.add(bedtypecomboBox);

		bedtypejl.setFont(font);
		bedtypejl.setBounds(200, 155, 150, 25);
		this.add(bedtypejl);

		roomnumberjl.setFont(font);
		roomnumberjl.setBounds(200, 190, 150, 25);
		this.add(roomnumberjl);

		numberjtf.setFont(font);
		numberjtf.setBounds(300, 190, 100, 25);
		this.add(numberjtf);
		Document numberDoc = teljtf.getDocument();
		numberDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				infoBesideNumber.setText("");
				if ( numberjtf.getText().trim().equals("")) {
					numberValid = false;
					infoBesideNumber.setText("请输入房间数！");
				} else {
					Document document = e.getDocument();
					AvailableRoomNumberVO vo= new AvailableRoomNumberVO(Integer.parseInt(numberjtf.getText()), bedtypes.get(bedtypecomboBox.getSelectedIndex()),
							new Date(TransHelper.stringToTime(fromtimejtf.getText())), hotelID);
					ResultMessage message = orderDistributionController.checkAvailableRoomNumber(vo);
					if (message == ResultMessage.FAIL||message==ResultMessage.NOTENOUGHAVAILABLEROOM) {
						numberValid = false;
						infoBesideNumber.setText("房间数量不足！");
					} else {
						numberValid = true;
						infoBesideNumber.setText("√");
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				infoBesideNumber.setText("");
				if ( numberjtf.getText().trim().equals("")) {
					numberValid = false;
					infoBesideNumber.setText("请输入房间数！");
				} else {
					Document document = e.getDocument();
					AvailableRoomNumberVO vo= new AvailableRoomNumberVO(Integer.parseInt(numberjtf.getText()), bedtypes.get(bedtypecomboBox.getSelectedIndex()),
							new Date(TransHelper.stringToTime(fromtimejtf.getText())), hotelID);
					ResultMessage message = orderDistributionController.checkAvailableRoomNumber(vo);
					if (message == ResultMessage.FAIL||message==ResultMessage.NOTENOUGHAVAILABLEROOM) {
						numberValid = false;
						infoBesideNumber.setText("房间数量不足！");
					} else {
						numberValid = true;
						infoBesideNumber.setText("√");
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				infoBesideNumber.setText("");
				if ( numberjtf.getText().trim().equals("")) {
					numberValid = false;
					infoBesideNumber.setText("请输入房间数！");
				} else {
					Document document = e.getDocument();
					AvailableRoomNumberVO vo= new AvailableRoomNumberVO(Integer.parseInt(numberjtf.getText()), bedtypes.get(bedtypecomboBox.getSelectedIndex()),
							new Date(TransHelper.stringToTime(fromtimejtf.getText())), hotelID);
					ResultMessage message = orderDistributionController.checkAvailableRoomNumber(vo);
					if (message == ResultMessage.FAIL||message==ResultMessage.NOTENOUGHAVAILABLEROOM) {
						numberValid = false;
						infoBesideNumber.setText("房间数量不足！");
					} else {
						numberValid = true;
						infoBesideNumber.setText("√");
					}
				}
			}
		});
		infoBesideNumber.setBounds(420,190,150,25);
		infoBesideNumber.setFont(font);
		infoBesideNumber.setForeground(Color.RED);
		this.add(infoBesideNumber);

		clientmessagejl.setFont(font);
		clientmessagejl.setBounds(50, 280, 150, 25);
		this.add(clientmessagejl);

		haschildjl.setFont(font);
		haschildjl.setBounds(200, 245, 150, 25);
		this.add(haschildjl);

		haschildjb.setBounds(300, 245, 100, 25);
		this.add(haschildjb);

		hasnochildjb.setBounds(350, 245, 100, 25);
		hasnochildjb.setSelected(true);
		this.add(hasnochildjb);

		clientnamejl.setFont(font);
		clientnamejl.setBounds(200, 280, 150, 25);
		this.add(clientnamejl);

		namejtf.setBounds(300, 280, 200, 25);
		this.add(namejtf);
		infoBesideName.setBounds(520, 280, 150, 25);
		infoBesideName.setFont(font);
		infoBesideName.setForeground(Color.RED);
		this.add(infoBesideName);

		clientteljl.setFont(font);
		clientteljl.setBounds(200, 315, 150, 25);
		this.add(clientteljl);

		teljtf.setBounds(300, 315, 200, 25);
		this.add(teljtf);
		infoBesideTel.setBounds(520,315,150,25);
		infoBesideTel.setFont(font);
		infoBesideTel.setForeground(Color.RED);
		this.add(infoBesideTel);
		
		Document telDoc = teljtf.getDocument();
		telDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				infoBesideTel.setText("");
				if (teljtf.getText().equals("--11位手机号--") || teljtf.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					infoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = orderDistributionController.checkTelephone(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							infoBesideTel.setText("联系方式格式错误！");
						} else {
							telephoneValid = true;
							infoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				infoBesideTel.setText("");
				if (teljtf.getText().equals("--11位手机号--") || teljtf.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					infoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = orderDistributionController.checkTelephone(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							infoBesideTel.setText("联系方式格式错误！");
						} else {
							telephoneValid = true;
							infoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				infoBesideTel.setText("");
				if (teljtf.getText().equals("--11位手机号--") || teljtf.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					infoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = orderDistributionController.checkTelephone(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							infoBesideTel.setText("联系方式格式错误！");
						} else {
							telephoneValid = true;
							infoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});


		bgjp1.setBackground(color);
		bgjp1.setBounds(50, 10, 700, 20);
		this.add(bgjp1);

		bgjp2.setBackground(color);
		bgjp2.setBounds(50, 230, 700, 2);
		this.add(bgjp2);

		bgjp3.setBackground(color);
		bgjp3.setBounds(50, 350, 700, 2);
		this.add(bgjp3);

		bgjp4.setBackground(color);
		bgjp4.setBounds(150, 20, 2, 330);
		this.add(bgjp4);

		group.add(haschildjb);
		group.add(hasnochildjb);

	}
	
	public OrderInfoVO getOrderInfo(){
		if(orderDistributionController.checkUserCredit(userID)==ResultMessage.LACKOFCREDIT){
			//信用不足无法生成订单
			SaveFail_JFrame fail_JFrame = new SaveFail_JFrame();
			fail_JFrame.setLableText("您的信用值不足，无法下订单噢～");
			return null;
		}
		boolean infoValid = true;
		infoBesideName.setText("");
		infoBesideNumber.setText("");
		infoBesideTime.setText("");
		if(namejtf.getText().equals("2—8位汉字")||namejtf.getText().length()<2||namejtf.getText().length()>8){
			infoBesideName.setText("姓名长度错误！");
			infoValid = false;
		}
		if(fromtimejtf.getText().equals("请选择日期")||totimejtf.getText().equals("请选择日期")){
			infoBesideTime.setText("请选择日期！");
			infoValid=false;
		}
		if(!telephoneValid||teljtf.getText().equals("11位手机号")){
			infoBesideTel.setText("联系方式格式错误！");
			infoValid=false;
		}
		if(numberValid=false){
			infoBesideNumber.setText("房间数量错误！");
			infoValid=false;
		}
		if(orderDistributionController.checkTime(new Date(TransHelper.stringToDate(fromtimejtf.getText())))
				!=ResultMessage.SUCCESS){
			infoValid=false;
		}
		if(!infoValid){
			return null;
		}else{
			//username从哪拿到？
			Children hasChild = Children.NOTEXIST;
			if(haschildjb.isSelected()){
				hasChild=Children.EXIST;
			}
			//入住人数默认为1
			OrderInfoVO vo = new OrderInfoVO(null, hotelID, hotelname, userID,null, namejtf.getText(), 
				teljtf.getText(), new Date(), new Date(TransHelper.stringToDate(fromtimejtf.getText())),
						new Date(TransHelper.stringToDate(totimejtf.getText())), null,
						roomtypes.get(roomtypecomboBox.getSelectedIndex()), bedtypes.get(bedtypecomboBox.getSelectedIndex()), 
						Integer.parseInt(numberjtf.getText()), 1, hasChild, 0,OrderState.NOTEXECUTED);
			return vo;
		}
	}

}
