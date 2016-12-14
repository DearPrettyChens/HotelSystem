package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

import util.TransHelper;
import vo.webstrategyvo.WebStrVO;

/**
 * 修改网站营销策略时，单条的特殊时期策略
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Singlewebspecialtimestr_JPanel extends JLabel {
	private Font font = new Font("宋体", Font.BOLD, 20);
	private String begintime;
	private String endtime;
	private double count;
	private JLabel begintimejl = new JLabel("起始时间：");
	private JLabel endtimejl = new JLabel("结束时间：");
	private JLabel countjl = new JLabel("折      扣：");
	private JTextField begintimejtf = new JTextField();
	private JTextField endtimejtf = new JTextField();
	private JTextField countjtf = new JTextField();

	private Date beginTimeinDate;
	private Date endTimeinDate;

	Singlewebspecialtimestr_JPanel(WebStrVO webStrVO) {
		Date[] dates = webStrVO.getDate();
		beginTimeinDate = dates[0];
		endTimeinDate = dates[1];
		this.begintime = TransHelper.dateToString(beginTimeinDate);
		this.endtime = TransHelper.dateToString(endTimeinDate);
		this.count = webStrVO.getDiscount();
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 300);

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
		begintimejl.setBounds(300, 40, 200, 30);
		begintimejl.setFont(font);
		this.add(begintimejl);

		begintimejtf.setBounds(400, 40, 100, 30);
		begintimejtf.setText(begintime + "");
		this.add(begintimejtf);

		endtimejl.setBounds(300, 120, 200, 30);
		endtimejl.setFont(font);
		this.add(endtimejl);

		endtimejtf.setBounds(400, 120, 100, 30);
		endtimejtf.setText(endtime + "");
		this.add(endtimejtf);

		countjl.setBounds(300, 200, 200, 30);
		countjl.setFont(font);
		this.add(countjl);

		countjtf.setBounds(400, 200, 100, 30);
		countjtf.setText(count + "");
		this.add(countjtf);

	}

	public boolean hasInputStr() {
		return (endtimejtf.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}") 
				&& begintimejtf.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}") 
				&& countjtf.getText().matches("^[0-9]+(.[0-9]{1,3})?$"))
				&&(countjtf.getText()!="0");
	}

	public Date[] getTime() {
		Date[] date = new Date[2];
		date[0] = getBeginTimeinDate();
		date[1] = getEndTimeinDate();
		return date;
	}

	public Date getBeginTimeinDate() {
		return new Date(TransHelper.stringToDate(begintimejtf.getText()));
	}

	public Date getEndTimeinDate() {
		return new Date(TransHelper.stringToDate(endtimejtf.getText()));
	}

	public double getCount() {
		return Double.parseDouble(countjtf.getText());
	}

}
