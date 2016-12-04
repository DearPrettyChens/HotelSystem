package presentation.ui.webstrategyui.view;

import java.awt.Color;

import javax.swing.JPanel;

public class ChooseStrategy_JPanel extends JPanel {

	private Webclientlevelstr_Jpanel webclientlevelstr_Jpanel;
	private WebSpecialAreaStr_JPanel webSpecialAreaStr_JPanel;
	private Webspecialtimestr_JPanel webspecialtimestr_JPanel;
	
	public ChooseStrategy_JPanel() {

		this.setBackground(Color.white);
		this.setBounds(0,100,800,500);
		this.setLayout(null);
        changeToAreaStr();
	}

	public void changeToAreaStr() {
        webSpecialAreaStr_JPanel =new WebSpecialAreaStr_JPanel();
		this.removeAll();
        this.add(webSpecialAreaStr_JPanel);
        this.updateUI();
	}

	public void changeToLevelStr() {
        webclientlevelstr_Jpanel=new Webclientlevelstr_Jpanel();
        this.removeAll();
        this.add(webclientlevelstr_Jpanel);
        this.updateUI();
	}

	public void changeToTimeStr() {
		webspecialtimestr_JPanel=new Webspecialtimestr_JPanel();
        this.removeAll();
        this.add(webspecialtimestr_JPanel);
        this.updateUI();
	}

}
