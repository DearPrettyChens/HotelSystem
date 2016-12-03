package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mysql.jdbc.JDBC4LoadBalancedMySQLConnection;
import com.mysql.jdbc.log.Log;

import javafx.fxml.Initializable;
import util.ResultMessage;

public class ServerPanel extends JPanel {
	private ArrayList<LogInfo> list;

	private LogInfo nameLabel;
	private ServerFrame frame;

	// private JLabel passwordLable;
	// private JLabel userTypeLable;
	// private JLabel
	public ServerPanel(ServerFrame frame) {
		super();
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(Color.white);
		this.setSize(600, 350);
		this.setVisible(true);
		this.frame = frame;

		initLabel();
		initList();

	}

	public void initLabel() {
		nameLabel = new LogInfo("用户名", "密码", "用户类型", "ip地址");
		nameLabel.setNameFont(new Font("宋体", Font.BOLD, 15));
		nameLabel.setForeColor(Color.gray);
		this.add(nameLabel);
	}

	public void initList() {
		list = new ArrayList<LogInfo>();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (list != null && list.size() > 0) {
			for (LogInfo each : list) {
				this.add(each);
			}
		}
	}

	public void addList(LogInfo newInfo) {
		newInfo.setForeColor(Color.lightGray);
		newInfo.setNameFont(new Font("宋体", Font.BOLD, 13));
		list.add(newInfo);
		this.frame.setNumber(list.size());
		this.repaint();
	}

	public ResultMessage deleteList(String userName) {
		ResultMessage message = ResultMessage.FAIL;
		if (list != null && list.size() > 0) {
			for (LogInfo each : list) {
				if (each.getUserName().getText().equals(userName)) {
					list.remove(each);
					message = ResultMessage.SUCCESS;
					break;
				}
			}
		}
		if (list != null) {
			frame.setNumber(list.size());
		}
		return message;
	}
}
