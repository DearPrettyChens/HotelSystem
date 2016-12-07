package presentation.ui.creditui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.TransHelper;
import vo.creditvo.CreditVO;

/**
 * 顾客查看每条信用记录的面板,大小是400*300
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleCreditinfo_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 15);

	private JLabel datejl = new JLabel("时   间：");
	private JLabel ordernumberjl = new JLabel("订单号：");
	private JLabel reasonjl = new JLabel("原   因：");
	private JLabel creditjl = new JLabel("信用值：");

	private JLabel background = new JLabel();

	private JLabel dateinfo = new JLabel("");
	private JLabel ordernumberinfo = new JLabel("");
	private JLabel reasoninfo = new JLabel("");
	private JLabel creditinfo = new JLabel("");

	private String date;
	private String ordernumber;
	private String reason;
	private int credit;
	private int change;

	private Date dateInDate;

	private JLabel changeinfo = new JLabel();

	public SingleCreditinfo_JPanel(CreditVO creditVO) {

		this.dateInDate = creditVO.getTime();
		this.date = TransHelper.dateToString(dateInDate);
		this.ordernumber = creditVO.getID();
		this.reason = creditVO.getReason();
		this.credit = creditVO.getCredit();
		this.change = creditVO.getCreditChange();

		dateinfo.setText(date);
		ordernumberinfo.setText(ordernumber);
		reasoninfo.setText(reason);
		creditinfo.setText(String.valueOf(credit));
		
		if(change>0){
			changeinfo.setText("+"+String.valueOf(change));
		}else{
			changeinfo.setText(String.valueOf(change));
		}
		
		this.setBackground(Color.white);
		this.setLayout(null);
		addComp();

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		datejl.setFont(font);
		datejl.setBounds(80, 140, 100, 30);
		this.add(datejl);

		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(80, 170, 100, 30);
		this.add(ordernumberjl);

		reasonjl.setFont(font);
		reasonjl.setBounds(80, 200, 100, 30);
		this.add(reasonjl);

		creditjl.setFont(font);
		creditjl.setBounds(80, 230, 100, 30);
		this.add(creditjl);

		changeinfo.setFont(new Font("宋体", Font.BOLD, 20));
		changeinfo.setForeground(new Color(234, 114, 93));
		changeinfo.setBounds(170, 73, 100, 30);
		this.add(changeinfo);

		ImageIcon icon = new ImageIcon("image//rec.png");
		background.setIcon(icon);
		background.setBounds(0, 0, 400, 300);
		this.add(background);

		dateinfo.setFont(font);
		dateinfo.setBounds(150, 140, 200, 30);
		this.add(dateinfo);

		ordernumberinfo.setFont(font);
		ordernumberinfo.setBounds(150, 170, 250, 30);
		this.add(ordernumberinfo);

		reasoninfo.setFont(font);
		reasoninfo.setBounds(150, 200, 200, 30);
		this.add(reasoninfo);

		creditinfo.setFont(font);
		creditinfo.setBounds(150, 230, 200, 30);
		this.add(creditinfo);

	}

}
