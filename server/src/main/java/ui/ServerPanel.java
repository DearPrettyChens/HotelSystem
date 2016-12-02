package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.mysql.jdbc.log.Log;

public class ServerPanel extends JPanel {
	ArrayList<LogInfo> list;

	public ServerPanel(ArrayList<LogInfo> list) {
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(Color.white);
		this.setSize(450, 450);
		this.setVisible(true);
		this.list = list;
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	
}
