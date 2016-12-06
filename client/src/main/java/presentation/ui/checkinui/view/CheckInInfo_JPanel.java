package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import vo.hotelvo.HotelOrderInfoVO;

/**
 * 
 * 用户入住时，显示出来的酒店入住信息
 * 
 * 确认按钮的监听未实现
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CheckInInfo_JPanel extends JPanel {

	private Font font1 = new Font("宋体", Font.BOLD, 20);
	private Font font2 = new Font("宋体", Font.BOLD, 18);
	private Font font3 = new Font("宋体", Font.PLAIN, 16);

	private String name = "";
	private String idnumber = "";
	private String tel = "";
	private int roomnumber;
	private String roomtype = "";
	private String realcheckintime = "";
	private String realcheckouttime = "";

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
	private JTextField realcheckintimejtf = new JTextField(realcheckintime);
	private JTextField realcheckouttimejtf = new JTextField(realcheckouttime);

	private OnlineCheckinViewController onlineCheckinViewController = OnlineCheckinViewController.getInstance(null);

	public CheckInInfo_JPanel(HotelOrderInfoVO hotelOrderInfoVO) {

		this.name = hotelOrderInfoVO.getCustomerName();
		this.tel = hotelOrderInfoVO.getLodgerTel();
		this.roomnumber = hotelOrderInfoVO.getRoomNumber();
		this.roomtype = hotelOrderInfoVO.getRoomType();

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

		teljl.setFont(font3);
		teljl.setText("联系方式：" + tel);
		teljl.setBounds(550, 150, 300, 30);
		this.add(teljl);

		roomjl.setFont(font2);

		roomjl.setBounds(50, 200, 300, 30);
		this.add(roomjl);

		roomnumberjl.setFont(font3);
		roomnumberjl.setText("房间号：" + roomnumber);
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
		this.add(realcheckintimejtf);

		realcheckouttimejl.setFont(font3);
		realcheckouttimejl.setText("实际退房时间：" + realcheckouttime);
		realcheckouttimejl.setBounds(50, 400, 200, 30);
		this.add(realcheckouttimejl);

		realcheckouttimejtf.setFont(font3);
		realcheckouttimejtf.setBounds(160, 400, 300, 30);
		this.add(realcheckouttimejtf);
		realcheckouttimejtf.setEditable(false);

		confirmjb.setText("确认");
		confirmjb.setBounds(510, 500, 100, 30);
		this.add(confirmjb);

		canclejb.setText("取消");
		canclejb.setBounds(640, 500, 100, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onlineCheckinViewController.jumpToMainFrame();
			}
		});

	}

}
