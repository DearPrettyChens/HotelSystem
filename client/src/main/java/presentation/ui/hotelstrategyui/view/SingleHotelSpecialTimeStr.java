package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.CalendarPanel;
import util.TransHelper;
import vo.hotelstrategyvo.HotelStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 单条的特殊时期优惠
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelSpecialTimeStr extends JPanel {
	private Font font = new Font("宋体", Font.BOLD, 18);
	public String begintime;
	public String endtime;
	private double count;
	private JLabel begintimejl = new JLabel("起始时间：");
	private JLabel endtimejl = new JLabel("结束时间：");
	private JLabel countjl = new JLabel("折      扣：");
	private JTextField begintimejtf = new JTextField();
	private JTextField endtimejtf = new JTextField();
	private JTextField countjtf = new JTextField();

	private CalendarPanel p1 = new CalendarPanel(begintimejtf, "yyyy-MM-dd");
	private CalendarPanel p2 = new CalendarPanel(endtimejtf, "yyyy-MM-dd");

	private Date beginTimeinDate;
	private Date endTimeinDate;

	public JTextField getBeginJtf() {
		return this.begintimejtf;
	}

	public JTextField getEndJtf() {
		return this.endtimejtf;
	}

	public JTextField getCountJtf() {
		return this.countjtf;
	}

	public CalendarPanel getBeginCalendarPanel() {
		return this.p1;
	}

	public CalendarPanel getEndCalendarPanel() {
		return this.p2;
	}

	SingleHotelSpecialTimeStr(HotelStrVO hotelStrVO) {
	
		if (hotelStrVO != null) {
			Date[] dates = hotelStrVO.getDate();
			beginTimeinDate = dates[0];
			endTimeinDate = dates[1];
			this.count = hotelStrVO.getDiscount();
		} else {
			beginTimeinDate = new Date();
			endTimeinDate = new Date();
		}
		this.begintime = TransHelper.dateToString(beginTimeinDate);
		this.endtime = TransHelper.dateToString(endTimeinDate);

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 200, 800, 350);

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

		p1.initCalendarPanel();
		p1.setBounds(400, 70, 250, 230);
		this.add(p1);

		p2.initCalendarPanel();
		p2.setBounds(400, 150, 250, 230);
		this.add(p2);

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

}
