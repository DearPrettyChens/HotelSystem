package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 单条的合作企业
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelEnterpriseStr_JPanel extends JPanel {
	private String enterprisename = "";
	private int count;

	private Font font = new Font("宋体", Font.BOLD, 18);

	private JLabel enterprisenamejl = new JLabel("合作企业:");
	private JTextField enterprisenamejtf = new JTextField();

	

	public SingleHotelEnterpriseStr_JPanel(String enterprisename) {
		this.enterprisename = enterprisename;
		
		enterprisenamejtf.setText(enterprisename);
		

		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();

	}

	public SingleHotelEnterpriseStr_JPanel() {

		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();

	}
	public JTextField getEnterpriseName(){
		return this.enterprisenamejtf;
	}
	public void addComp() {

		enterprisenamejl.setFont(font);
		enterprisenamejl.setBounds(50, 10, 200, 30);
		this.add(enterprisenamejl);

		enterprisenamejtf.setFont(font);
		enterprisenamejtf.setBounds(150, 10, 200, 30);
		this.add(enterprisenamejtf);

		

	}

}
