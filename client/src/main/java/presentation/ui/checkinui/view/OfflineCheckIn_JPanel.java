package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.availableroomui.view.SingleRoomInfo_JPanel;
import presentation.ui.checkinui.distributecontroller.CheckinDistributionController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.checkinvo.AvailableRoomNumberVO;

/**
 * 
 * 酒店工作人员进行线下入住退房管理
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class OfflineCheckIn_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);

	private JLabel titlejl = new JLabel("可用客房数量修改");
	private ArrayList<SingleAvailableRoomInfo_JPanel> singleinfo = new ArrayList<SingleAvailableRoomInfo_JPanel>();

	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();

	private CheckinDistributionController checkinDistributionController = CheckinDistributionController.getInstance();
	private String hotelID;

	public OfflineCheckIn_JPanel(String hotelID) {

		this.hotelID = hotelID;
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.white);
		addComp();

	}

	public OfflineCheckIn_JPanel() {

		this.setLayout(null);
		this.setSize(800, 600);
		this.setBackground(Color.white);
		addComp();

	}

	public void addComp() {

		addScrollPane();

		titlejl.setFont(new Font("宋体", Font.BOLD, 20));
		titlejl.setBounds(40, 30, 800, 50);
		this.add(titlejl);

		canclejb.setText("取消");
		canclejb.setBounds(700, 500, 80, 30);
		this.add(canclejb);
		/**
		 * 恢复成未编辑之前的状态
		 */
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < singleinfo.size(); i++) {
					singleinfo.get(i).recoverRoom();
				}
			}
		});

		confirmjb.setText("确认");
		confirmjb.setBounds(600, 500, 80, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultMessage result = ResultMessage.SUCCESS;
				for (int i = 0; i < singleinfo.size(); i++) {
					result = singleinfo.get(i).saveRoom();
					if (result == ResultMessage.FAIL) {
						// 保存失败
						new SaveFail_JFrame();
						System.out.println("nono");
						break;
					}
				}
				// 保存成功
				if (result == ResultMessage.SUCCESS) {
					new SaveSuccess_JFrame();
				}
			}

		});
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
		singleinfo = new ArrayList<SingleAvailableRoomInfo_JPanel>();

		ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs = checkinDistributionController
				.getAvailableRoomInfo(hotelID);
		if (availableRoomInfoVOs != null) {
			for (AvailableRoomInfoVO availableRoomInfoVO : availableRoomInfoVOs) {
				SingleAvailableRoomInfo_JPanel singleAvailableRoomInfo_JPanel = new SingleAvailableRoomInfo_JPanel(
						availableRoomInfoVO);
				singleinfo.add(singleAvailableRoomInfo_JPanel);
			}
			System.out.print(singleinfo.size());
			addToPanel();
		}
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
			SingleAvailableRoomInfo_JPanel singleRoomInfo_JPanel = singleinfo.get(i);
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
