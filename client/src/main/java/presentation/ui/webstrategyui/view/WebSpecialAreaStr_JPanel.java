package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.tools.MyButton;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.TradingArea;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 
 * 制定网站营销策略时，包含所有的特殊商圈策略面板
 * 
 * 确认按钮未实现监听
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class WebSpecialAreaStr_JPanel extends JPanel {

	private MyButton addjb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private ArrayList<Singlewebareastr_Jpanel> singleinfo = new ArrayList<Singlewebareastr_Jpanel>();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private WebstrategyDistributionController webstrategyDistributionController = WebstrategyDistributionController
			.getInstance();
	private Map<Integer, Double> areaStrategy;

	public WebSpecialAreaStr_JPanel() {
		// this.singleinfo=;到逻辑层取

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 500);

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

		addScrollPane();

		addjb.setText("增加");
		addjb.setBounds(250, 400, 80, 30);
		addjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singlewebareastr_Jpanel newsingleinfo = new Singlewebareastr_Jpanel(-1, 0);
				singleinfo.add(newsingleinfo);
				addToPanel();
			}

		});
		this.add(addjb);

		confirmjb.setText("确认");
		confirmjb.setBounds(450, 400, 80, 30);
		this.add(confirmjb);

	}

	public void addScrollPane() {
		scrollPane.setBounds(0, 0, 800, 350);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		initStrategyList();
		this.add(scrollPane);
	}

	public void initStrategyList() {
		singleinfo = new ArrayList<Singlewebareastr_Jpanel>();

		WebStrVO webStrVO = webstrategyDistributionController.getWebStrategy(WebStrategyType.SPECIALAREA);
		areaStrategy = webStrVO.getVIPOrTradingAreaStrategy();

		for (int area : areaStrategy.keySet()) {
			double discount = areaStrategy.get(area);
			Singlewebareastr_Jpanel singlewebareastr_Jpanel = new Singlewebareastr_Jpanel(area, discount);
			singleinfo.add(singlewebareastr_Jpanel);
		}
		addToPanel();
	}

	public void addToPanel() {
		panel.removeAll();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		for (int i = 0; i < singleinfo.size(); i++) {
			Singlewebareastr_Jpanel singlewebareastr_Jpanel = singleinfo.get(i);
			singlewebareastr_Jpanel.setBounds(0, 20 + 60 * i, 700, 50);
			panel.add(singlewebareastr_Jpanel);
		}
		panel.setPreferredSize(new Dimension(700, 50 + 60 * singleinfo.size()));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// this.add(scrollPane);
	}

}
