package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sf.cglib.transform.impl.AddDelegateTransformer;
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.UserType;
import util.WebStrategyType;
import vo.personnelvo.PersonListVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 
 * 制定网站营销策略时，包含所有的会员策略面板
 * 
 * 确认按钮未实现监听
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Webclientlevelstr_Jpanel extends JPanel {

	private MyButton addjb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private ArrayList<Singlewebclientlevelstr_Jpanel> singleinfo;
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private WebstrategyDistributionController webstrategyDistributionController = WebstrategyDistributionController
			.getInstance();
	private Map<Integer, Double> vipStrategy;

	public Webclientlevelstr_Jpanel() {
		// this.singleinfo;到逻辑层取
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
				Singlewebclientlevelstr_Jpanel newsingleinfo = new Singlewebclientlevelstr_Jpanel(0, 0);
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
		singleinfo = new ArrayList<Singlewebclientlevelstr_Jpanel>();

		WebStrVO webStrVO = webstrategyDistributionController.getWebStrategy(WebStrategyType.VIP);
		vipStrategy = webStrVO.getVIPOrTradingAreaStrategy();

		for (int level : vipStrategy.keySet()) {
			double discount = vipStrategy.get(level);
			Singlewebclientlevelstr_Jpanel singlewebclientlevelstr_Jpanel = new Singlewebclientlevelstr_Jpanel(level,
					discount);
			singleinfo.add(singlewebclientlevelstr_Jpanel);
		}
		addToPanel();
	}

	public void addToPanel() {
		panel.removeAll();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		for (int i = 0; i < singleinfo.size(); i++) {
			Singlewebclientlevelstr_Jpanel singlewebclientlevelstr_Jpanel = singleinfo.get(i);
			singlewebclientlevelstr_Jpanel.setBounds(0, 20 + 60 * i, 700, 50);
			panel.add(singlewebclientlevelstr_Jpanel);
		}
		panel.setPreferredSize(new Dimension(700, 50 + 60 * singleinfo.size()));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// this.add(scrollPane);
	}

}
