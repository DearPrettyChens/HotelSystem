package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;

/**
 * 
 * 维护酒店基本信息的总面板
 * 
 * 确认和取消按钮未实现监听
 * 
 * @author csy
 * 
 *
 */
public class MaintainHotelBasicInfoPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 20);
	private MyButton confirm = new MyButton();
	private MyButton cancle = new MyButton();

	private JLabel titlejl = new JLabel("维护酒店信息");
	private JScrollPane scrollPane = new JScrollPane();
	private String hotelID;
	private ModifyHotelBasicInfo_JPanel modifyHotelBasicInfo_JPanel;

	public MaintainHotelBasicInfoPanel(String hotelID) {
		this.hotelID = hotelID;
		modifyHotelBasicInfo_JPanel = new ModifyHotelBasicInfo_JPanel(hotelID);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		addComp();
	}

	public void addComp() {
		initScrollpane();

		titlejl.setFont(font);
		titlejl.setBounds(40, 30, 800, 50);
		this.add(titlejl);

		confirm.setText("确认");
		confirm.setBounds(500, 500, 100, 30);
		this.add(confirm);

		cancle.setText("取消");
		cancle.setBounds(650, 500, 100, 30);
		this.add(cancle);

	}

	public void initScrollpane() {
		scrollPane.setBounds(50, 100, 750, 350);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		modifyHotelBasicInfo_JPanel.setPreferredSize(new Dimension(700, 1100));
		scrollPane.setViewportView(modifyHotelBasicInfo_JPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

}
