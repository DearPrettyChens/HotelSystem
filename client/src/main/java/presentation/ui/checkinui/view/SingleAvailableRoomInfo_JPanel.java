package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import util.BedType;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * 单条的可用客房信息，用来进行用户线下入住退房
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleAvailableRoomInfo_JPanel extends JPanel {

	private String bedtype;
	 private String roomtype;
	private int number;

	private BedType bedType2;

	private Font font = new Font("宋体", Font.BOLD, 16);

	private JLabel bedtypejl = new JLabel("床型：");
	private JLabel roomtypejl = new JLabel("房型：");
	private JLabel numberjl = new JLabel("数量：");

	private JTextField numberjtf = new JTextField();

	public SingleAvailableRoomInfo_JPanel(AvailableRoomInfoVO availableRoomInfoVO) {

		this.bedType2 = availableRoomInfoVO.getBedType();
		this.bedtype = bedType2.toChinese();


		 this.roomtype=availableRoomInfoVO.getRoomType();
		this.number = availableRoomInfoVO.getCurrentNumber();

		bedtypejl.setText("床型：" + bedtype);

		roomtypejl.setText("日期：" + roomtype);

		numberjtf.setText(number + "");

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800, 50);
		addComp();

	}

	public SingleAvailableRoomInfo_JPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800, 50);
		addComp();

	}

	public void addComp() {

		bedtypejl.setFont(font);
		bedtypejl.setBounds(60, 10, 120, 30);
		this.add(bedtypejl);

		roomtypejl.setFont(font);
		roomtypejl.setBounds(260, 10, 120, 30);
		this.add(roomtypejl);

		numberjl.setFont(font);
		numberjl.setBounds(460, 10, 80, 30);
		this.add(numberjl);

		numberjtf.setFont(font);
		numberjtf.setBounds(520, 10, 80, 30);
		this.add(numberjtf);

		this.setLayout(null);

	}

}
