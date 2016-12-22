package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LogInfo extends JLabel {
	public JLabel userName;
	public JLabel password;
	public JLabel userType;
	public JLabel ipAddress;

	public LogInfo(String userName, String password, String userType, String ipAddress) {
		super();

		this.userName = new JLabel(userName, JLabel.CENTER);
		this.password = new JLabel(password,JLabel.CENTER);
		this.userType = new JLabel(userType,JLabel.CENTER);
		this.ipAddress = new JLabel(ipAddress,JLabel.CENTER);

		this.setSize(600, 25);
		this.setLayout(null);
		initComponent();
	}

	public void initComponent() {
		userName.setBounds(0, 0, 150, 25);
		this.add(userName);
		password.setBounds(150, 0, 150, 25);
		this.add(password);
		userType.setBounds(300, 0, 150, 25);
		this.add(userType);
		ipAddress.setBounds(450, 0, 150, 25);
		this.add(ipAddress);
	}

	public void setNameFont(Font font) {
		this.userName.setFont(font);
		this.password.setFont(font);
		this.userType.setFont(font);
		this.ipAddress.setFont(font);
	}
	
	public void setForeColor(Color color){
		this.userName.setForeground(color);
		this.password.setForeground(color);
		this.userType.setForeground(color);
		this.ipAddress.setForeground(color);
	}

	public JLabel getUserName() {
		return userName;
	}
	
}
