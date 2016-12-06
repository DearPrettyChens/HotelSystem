package presentation.ui.availableroomui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.availableroomui.distributecontroller.AvailableroomDistributionController;
import presentation.ui.tools.MyButton;
import presentation.ui.webstrategyui.view.Singlewebareastr_Jpanel;
import util.WebStrategyType;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 所有房间信息的面板，供酒店工作人员录入客房信息时增加或修改
 * 
 * 未实现确认监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class RoomInfo_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 20);

	private JLabel titlejl = new JLabel("录入客房信息");

	private MyButton addjb = new MyButton();

	private MyButton canclejb = new MyButton();

	private MyButton confirmjb = new MyButton();

	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private AvailableroomDistributionController availableroomDistributionController = AvailableroomDistributionController
			.getInstance();
	private String hotelID;

	private ArrayList<SingleRoomInfo_JPanel> singleinfo = new ArrayList<SingleRoomInfo_JPanel>();

	public RoomInfo_JPanel(String hotelID) {
		this.hotelID = hotelID;

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);

		addComp();

	}

	public void addComp() {

		addScrollPane();

		titlejl.setFont(font);
		titlejl.setBounds(40, 30, 800, 50);
		this.add(titlejl);

		addjb.setText("增加");
		addjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SingleRoomInfo_JPanel newsingleinfo = new SingleRoomInfo_JPanel();
				singleinfo.add(newsingleinfo);
				addToPanel();

			}

		});
		addjb.setBounds(500, 500, 80, 30);
		this.add(addjb);

		canclejb.setText("删除");
		canclejb.setBounds(600, 500, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				singleinfo.remove(singleinfo.size() - 1);
				addToPanel();
			}
		});

		confirmjb.setText("确认");
		confirmjb.setBounds(700, 500, 80, 30);
		this.add(confirmjb);

	}

	/**
	 * 增加滚动条面板
	 */
	public void addScrollPane() {
		scrollPane.setBounds(50, 100, 750, 350);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		initAvailableRoomList();
		this.add(scrollPane);
	}

	/**
	 * 初始化可用客房列表，以及初始化单条客房信息panel
	 */
	public void initAvailableRoomList() {
		singleinfo = new ArrayList<SingleRoomInfo_JPanel>();

		ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs = availableroomDistributionController
				.getAvailableRoomInfo(hotelID);

		for (AvailableRoomInfoVO availableRoomInfoVO : availableRoomInfoVOs) {
			SingleRoomInfo_JPanel singleRoomInfo_JPanel = new SingleRoomInfo_JPanel(availableRoomInfoVO);
			singleinfo.add(singleRoomInfo_JPanel);
		}
		addToPanel();
	}

	/**
	 * 将单条客房信息panel加到panel上。再加到scrollpane
	 * 单独把这个方法抽出来写是因为，在增加新的客房信息后，arraylist里面会加有新的客房信息，需要重新显示 取消的时候也是一个原理
	 */
	public void addToPanel() {
		panel.removeAll();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		for (int i = 0; i < singleinfo.size(); i++) {
			SingleRoomInfo_JPanel singleRoomInfo_JPanel = singleinfo.get(i);
			singleRoomInfo_JPanel.setBounds(0, 20 + 60 * i, 700, 50);
			panel.add(singleRoomInfo_JPanel);
		}
		panel.setPreferredSize(new Dimension(700, 50 + 60 * singleinfo.size()));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// this.add(scrollPane);
	}

}
