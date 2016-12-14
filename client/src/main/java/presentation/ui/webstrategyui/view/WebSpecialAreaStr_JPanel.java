package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.ResultMessage;
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
	private WebstrategyDistributionController webstrategyDistributionController=WebstrategyDistributionController.getInstance();
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
				Singlewebareastr_Jpanel newsingleinfo = new Singlewebareastr_Jpanel(-1, 0);
				singleinfo.add(newsingleinfo);
				addToPanel();
			}

		});
		this.add(addjb);

		confirmjb.setText("确认");
		confirmjb.setBounds(450, 400, 80, 30);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Map<Integer, Double> newAreaStrategy = new HashMap<Integer, Double>();
				if (singleinfo.size() != 0) {
					for (Singlewebareastr_Jpanel each : singleinfo) {
						if (each.hasInputStr()) {
							newAreaStrategy.put(each.getTradingArea(), each.getDiscount());
						}
					}
				}
				if (newAreaStrategy.size() > 0) {
					WebStrVO vo = new WebStrVO(newAreaStrategy, -1, WebStrategyType.SPECIALAREA);
					//根据返回的resultmessage跳出提示界面。
					ResultMessage resultMessage = webstrategyDistributionController.confirmWebStrategy(vo);
//					System.out.println(resultMessage);
					if(resultMessage == ResultMessage.SUCCESS){
						//更新 保证下次界面显示是最新的策略。
						areaStrategy = newAreaStrategy ;
						new SaveSuccess_JFrame();
					}
					else{
						new SaveFail_JFrame();
					}
					
				}else{
					//跳出未输入有效信息 无法确认 提示框
					SaveFail_JFrame frame=new SaveFail_JFrame();
					frame.setLableText("未输入有效信息");
				}
			}
		});
		this.add(confirmjb);

	}

	/**
	 * 增加滚动条面板
	 */
	public void addScrollPane() {
		scrollPane.setBounds(0, 0, 800, 350);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		initStrategyList();
		this.add(scrollPane);
	}

	/**
	 * 初始化策略列表，以及初始化单条策略panel
	 */
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

	/**
	 * 将单条策略panel加到panel上。再加到scrollpane
	 * 单独把这个方法抽出来写是因为，在增加新的策略后，arraylist里面会加有新的策略，需要重新显示
	 */
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
