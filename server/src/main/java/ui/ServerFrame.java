package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.jdbc.log.Log;

import ui.tools.ArrowButton;
import ui.tools.RefleshButton;
import ui.tools.CloseButton;
import ui.tools.NarrowButton;

public class ServerFrame extends JFrame {
	ArrayList<LogInfo> list = new ArrayList<LogInfo>();
	JLabel startServerLable;

	private CloseButton closeJBT;
	private NarrowButton narrowJBT;
	private RefleshButton refleshJBT;
	private ArrowButton arrowJBT;
	private JLabel line;

	private JLabel name;

	private Color backgroundcolor = new Color(148, 221, 184);
	private JPanel abovepanel = new JPanel();
	private JPanel backPanel = new JPanel();
	private ServerPanel userPanel = new ServerPanel(list);

	public ServerFrame() {
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(backgroundcolor);
		initComponent();

		this.setVisible(true);
	}

	public void initComponent() {
		list = new ArrayList<LogInfo>();
		startServerLable = new JLabel("开始服务",JLabel.CENTER);
		startServerLable.setHorizontalAlignment(SwingConstants.CENTER);
		startServerLable.setFont(new Font("宋体", Font.BOLD, 20));
		startServerLable.setForeground(Color.white);
		startServerLable.setBounds(300,40,300,35);
		closeJBT = new CloseButton();
		narrowJBT = new NarrowButton(this);
		name = new JLabel("服务器",JLabel.CENTER);
		name.setBounds(300,0,300,35);
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setVerticalAlignment(JLabel.CENTER);
		name.setFont(new Font("宋体", Font.BOLD, 30));
		name.setForeground(Color.white);
		abovepanel.add(narrowJBT);
		abovepanel.add(closeJBT);
		abovepanel.setBackground(backgroundcolor);
		abovepanel.setBounds(895, 5, 100, 50);
		abovepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(abovepanel);
		backPanel.setLayout(null);
		
		backPanel.add(name);
		backPanel.add(startServerLable);
		backPanel.setBackground(backgroundcolor);
		backPanel.setBounds(50,50,900,200);
		this.getContentPane().add(backPanel);
	}


	public static void main(String[] args) {
		new ServerFrame();
		// new ServerFrame(new JPanel());

	}

}
