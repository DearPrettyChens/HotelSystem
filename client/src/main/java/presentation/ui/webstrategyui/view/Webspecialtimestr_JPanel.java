package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JPanel;

import presentation.ui.loginui.view.newclient_JFrame;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.ResultMessage;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 
 * 制定网站营销策略时，包含所有的特殊商圈策略面板
 * 
 * 确认和取消按钮还没加监听
 * 已加
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Webspecialtimestr_JPanel extends JPanel {

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private Singlewebspecialtimestr_JPanel singlewebspecialtimestr_JPanel;
	private WebstrategyDistributionController webstrategyDistributionController = WebstrategyDistributionController
			.getInstance();
	private WebStrVO webStrVO;

	public Webspecialtimestr_JPanel() {
		// this.singleinfo; 向逻辑层要
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

		webStrVO = webstrategyDistributionController.getWebStrategy(WebStrategyType.SPECIALTIME);

		singlewebspecialtimestr_JPanel = new Singlewebspecialtimestr_JPanel(webStrVO);
		this.add(singlewebspecialtimestr_JPanel);

		canclejb.setText("取消");
		canclejb.setBounds(420, 300, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remove(singlewebspecialtimestr_JPanel);
				singlewebspecialtimestr_JPanel = new Singlewebspecialtimestr_JPanel(webStrVO);
				add(singlewebspecialtimestr_JPanel);
			}
		});

		confirmjb.setText("确认");
		confirmjb.setBounds(300, 300, 80, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (singlewebspecialtimestr_JPanel.hasInputStr()) {
					WebStrVO vo = new WebStrVO(singlewebspecialtimestr_JPanel.getTime(),
							singlewebspecialtimestr_JPanel.getCount(), WebStrategyType.SPECIALTIME);
					// 根据message跳出提示框
					ResultMessage message = webstrategyDistributionController.confirmWebStrategy(vo);
//					System.out.println(message);
					if (message == ResultMessage.SUCCESS) {
						//更新vo 保证下次再进入该界面时为最新的策略
						webStrVO = vo;
						new SaveSuccess_JFrame();
					}
					else{
						new SaveFail_JFrame();
					}
				} else {
					// 提示输入无效
					SaveFail_JFrame frame=new SaveFail_JFrame();
					frame.setLableText("未输入有效信息");
				}
			}

		});
	}

}
