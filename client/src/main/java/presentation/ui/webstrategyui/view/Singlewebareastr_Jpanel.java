package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import util.TradingArea;
import util.TransHelper;
import vo.webstrategyvo.WebStrVO;

/**
 * 修改网站营销策略时，单条的特殊商圈策略
 * 
 * 商圈未做成下拉框形式，在我们的系统中商圈应该是固定死的可选的，而不是让人自己输入进去
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Singlewebareastr_Jpanel extends JLabel {
	private Font font = new Font("宋体", Font.BOLD, 20);
	private TradingArea tradingArea;
	private String place;
	private double count;
	private JLabel leveljl = new JLabel("商圈：");
	private JLabel countjl = new JLabel("折扣值：");
	private JTextField leveljtf = new JTextField();
	private JTextField countjtf = new JTextField();

	Singlewebareastr_Jpanel(int area, double cout) {
		// this.place=place;
		if (area == -1) {
			place = "请选择商圈";
		} else {
			this.tradingArea = TransHelper.intToArea(area);
			this.place = tradingArea.getChinese();
		}

		this.count = cout;
		this.setLayout(null);
		this.setBackground(Color.white);

		this.setSize(800, 50);
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
		leveljl.setBounds(200, 15, 150, 30);
		leveljl.setFont(font);
		this.add(leveljl);

		leveljtf.setBounds(260, 16, 100, 30);
		leveljtf.setText(place + "");
		leveljtf.addActionListener(new ActionListener() {
			// 每次选择商圈之后要更新tradingare属性
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(leveljtf);

		countjl.setBounds(430, 15, 200, 30);
		countjl.setFont(font);
		this.add(countjl);

		countjtf.setBounds(510, 16, 100, 30);
		countjtf.setText(count + "");
		this.add(countjtf);

	}

	// WebSpecialArea调用，每次新建策略时都要判断，用来判断是否输入策略。
	public boolean hasInputStr() {
		return !(tradingArea == null) && (Double.parseDouble(countjtf.getText()) != 0);
	}

	public int getTradingArea() {
		if (tradingArea != null) {
			return tradingArea.ordinal();
		} else {
			return -1;
		}
	}

	public double getDiscount() {
		return Double.parseDouble(countjtf.getText());
	}

}
