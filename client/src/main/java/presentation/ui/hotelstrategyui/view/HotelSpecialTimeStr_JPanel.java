package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.hotelstrategyui.distributecontroller.HotelStrategyDistributionController;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import presentation.ui.webstrategyui.view.Singlewebspecialtimestr_JPanel;

import util.HotelStrategyType;
import util.WebStrategyType;
import vo.hotelstrategyvo.HotelStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 特殊时期策略策略
 * 
 * 未添加确认监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelSpecialTimeStr_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);
	private JLabel titlejl = new JLabel("会员生日特惠策略");
	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private SingleHotelSpecialTimeStr singleHotelSpecialTimeStr;
	private HotelStrategyDistributionController hotelStrategyDistributionController = HotelStrategyDistributionController
			.getInstance();
	private HotelStrategyViewControllerImpl hotelStrategyViewControllerImpl = HotelStrategyViewControllerImpl
			.getInstance(null);

	public HotelSpecialTimeStr_JPanel(String hotelID) {
		// this.singleinfo; 向逻辑层要
		this.setLayout(null);
		this.setBackground(Color.white);
		 this.setBounds(0, 0, 800, 600);

		addComp(hotelID);
	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp(String hotelID) {
		titlejl.setFont(font);
		titlejl.setBounds(320, 80, 200, 30);
		this.add(titlejl);

		HotelStrVO hotelStrVO = hotelStrategyDistributionController.getHotelStrategy(hotelID,
				HotelStrategyType.SPECIALTIME);

		singleHotelSpecialTimeStr = new SingleHotelSpecialTimeStr(hotelStrVO);
		singleHotelSpecialTimeStr.setBounds(0, 120, 800, 300);
		this.add(singleHotelSpecialTimeStr);

		canclejb.setText("取消");
		canclejb.setBounds(420, 420, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				hotelStrategyViewControllerImpl.backToselectStrategy();
			}
		});

		confirmjb.setText("确认");
		confirmjb.setBounds(300, 420, 80, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//
			}

		});
	}

}
