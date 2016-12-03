package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.JDBC4LoadBalancedMySQLConnection;
import com.mysql.jdbc.log.Log;

import dao.impl.LogDaoImpl;
import dao.logdao.LogDao;
import rmi.RMIHelper;
import ui.tools.ArrowButton;
import ui.tools.RefleshButton;
import ui.tools.CloseButton;
import ui.tools.NarrowButton;

public class ServerFrame extends JFrame {
	// ArrayList<LogInfo> list = new ArrayList<LogInfo>();

	private CloseButton closeJBT;
	private NarrowButton narrowJBT;

	private final String nameString = "服务器";
	private final String ipAddressString = "本机ip:";
	private final String logInNumberString = "当前在线用户数量:";
	private final String startTimeString = "开始时间:";
	private final String startString = "开始服务";
	private final String endString = "停止服务";
	private JLabel name;
	private JLabel ipAddress;
	private JLabel logInNumber;
	private JLabel startTime;
	private JLabel startServerLable;

	private Color backgroundColor = new Color(148, 221, 184);
	private Color buttonColor = new Color(120, 200, 160);
	private JPanel abovepanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private ServerPanel userPanel;

	// private JPanel userPanel = new JPanel();

	private LogDao logDao;

	public ServerFrame() {
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(backgroundColor);

		this.initAbovePanel();
		this.initServerInfoPanel();
		this.initUserPanel();

		this.setVisible(true);
	}

	// public void addList(LogInfo newInfo) {
	// list.add(newInfo);
	// this.repaintUserPanel();
	// }
	//
	// public void repaintUserPanel() {
	// userPanel.repaint();
	// }

	public void initAbovePanel() {
		closeJBT = new CloseButton();
		narrowJBT = new NarrowButton(this);
		abovepanel.add(narrowJBT);
		abovepanel.add(closeJBT);
		abovepanel.setBackground(backgroundColor);
		abovepanel.setBounds(895, 5, 100, 50);
		abovepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(abovepanel);
	}

	public void initServerInfoPanel() {
		// list = new ArrayList<LogInfo>();

		name = new JLabel(nameString, JLabel.CENTER);
		name.setBounds(300, 0, 300, 35);
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setVerticalAlignment(JLabel.CENTER);
		name.setFont(new Font("宋体", Font.BOLD, 30));
		name.setForeground(Color.white);

		ipAddress = new JLabel(ipAddressString + RMIHelper.getHostAddress());
		ipAddress.setBounds(300, 40, 300, 35);
		ipAddress.setHorizontalAlignment(JLabel.CENTER);
		ipAddress.setVerticalAlignment(JLabel.CENTER);
		ipAddress.setFont(new Font("宋体", Font.BOLD, 20));
		ipAddress.setForeground(Color.WHITE);

		logInNumber = new JLabel(logInNumberString + " 0 ");
		logInNumber.setBounds(300, 80, 300, 35);
		logInNumber.setHorizontalAlignment(JLabel.CENTER);
		logInNumber.setVerticalAlignment(JLabel.CENTER);
		logInNumber.setFont(new Font("宋体", Font.BOLD, 20));
		logInNumber.setForeground(Color.WHITE);

		startTime = new JLabel(startTimeString, JLabel.CENTER);
		startTime.setHorizontalAlignment(SwingConstants.CENTER);
		startTime.setFont(new Font("宋体", Font.BOLD, 20));
		startTime.setForeground(Color.white);
		startTime.setBounds(300, 120, 300, 35);

		startServerLable = new JLabel(startString, JLabel.CENTER);
		startServerLable.setHorizontalAlignment(SwingConstants.CENTER);
		startServerLable.setFont(new Font("宋体", Font.BOLD, 20));
		startServerLable.setForeground(Color.white);
		startServerLable.setBounds(300, 160, 300, 35);
		// startServerLable.setBackground(buttonColor);
		// startServerLable.setOpaque(true);
		startServerLable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				startServerLable.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startServerLable.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startServerLable.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				startServerLable.setForeground(Color.GRAY);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!RMIHelper.isStart()) {
					startServerLable.setText(endString);
					RMIHelper.connect();
				} else {
					startServerLable.setText(startString);
					RMIHelper.stop();
				}
				startServerLable.setForeground(Color.GRAY);
			}
		});
		backPanel.setLayout(null);

		backPanel.add(name);
		backPanel.add(ipAddress);
		backPanel.add(logInNumber);
		backPanel.add(startTime);
		backPanel.add(startServerLable);

		backPanel.setBackground(backgroundColor);
		backPanel.setBounds(50, 50, 900, 200);
		this.getContentPane().add(backPanel);
	}

	public void initUserPanel() {
		userPanel = new ServerPanel(this);
		userPanel.setBounds(200, 270, 600, 350);
		logDao = LogDaoImpl.getInstance();
		((LogDaoImpl) logDao).setPanel(userPanel);

		this.getContentPane().add(userPanel);
	}

	public static void main(String[] args) {
		new ServerFrame();
	}

	public void setNumber(int number) {
		this.logInNumber.setText(logInNumberString + number);
	}

	public LogDao getLogDao() {
		return logDao;
	}

}
