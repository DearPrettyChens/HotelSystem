package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import presentation.ui.hotelstrategyui.distributecontroller.HotelStrategyDistributionController;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import presentation.ui.webstrategyui.view.Singlewebspecialtimestr_JPanel;

import util.HotelStrategyType;
import util.ResultMessage;
import util.TransHelper;
import util.WebStrategyType;
import vo.hotelstrategyvo.HotelStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 特殊时期策略策略
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelSpecialTimeStr_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);
	private JLabel titlejl = new JLabel("特定节日优惠策略");
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
		singleHotelSpecialTimeStr.setBounds(0, 120, 800, 350);
		this.add(singleHotelSpecialTimeStr);

		canclejb.setText("取消");
		canclejb.setBounds(420, 470, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				hotelStrategyViewControllerImpl.backToselectStrategy();
			}
		});

		JLabel saveError = new JLabel("折扣值为0～1之间的数字");
		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(300, 240, 220, 25);
		singleHotelSpecialTimeStr.add(saveError);
		saveError.setVisible(false);

		JLabel saveError2 = new JLabel("活动开始日期应早于结束日期");
		saveError2.setForeground(Color.RED);
		saveError2.setFont(font);
		saveError2.setBounds(300, 80, 300, 25);
		singleHotelSpecialTimeStr.add(saveError2);
		saveError2.setVisible(false);

		confirmjb.setText("确认");
		confirmjb.setBounds(300, 470, 80, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				long begindate = TransHelper
						.stringToDate(singleHotelSpecialTimeStr.getBeginCalendarPanel().getReturnDateStr());
				if(singleHotelSpecialTimeStr.getBeginCalendarPanel().getReturnDateStr()==null){
					begindate=TransHelper.stringToDate(singleHotelSpecialTimeStr.begintime);
				}
				long enddate = TransHelper
						.stringToDate(singleHotelSpecialTimeStr.getEndCalendarPanel().getReturnDateStr());
				if(singleHotelSpecialTimeStr.getEndCalendarPanel().getReturnDateStr()==null){
					enddate=TransHelper.stringToDate(singleHotelSpecialTimeStr.endtime);
				}
				
				if(begindate<=enddate){
					saveError2.setVisible(false);
				}
				if (begindate > enddate) {
					saveError2.setVisible(true);
				} else if (Double.parseDouble(singleHotelSpecialTimeStr.getCountJtf().getText()) <= 1.0
						&& Double.parseDouble(singleHotelSpecialTimeStr.getCountJtf().getText()) > 0
						&& singleHotelSpecialTimeStr.getBeginJtf().getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}")
						&& singleHotelSpecialTimeStr.getEndJtf().getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}")) {
					Date[] dates = new Date[2];
					// dates[0]=new
					// Date(TransHelper.stringToDate(singleHotelSpecialTimeStr.getBeginJtf().getText()));
					// dates[1]=new
					// Date(TransHelper.stringToDate(singleHotelSpecialTimeStr.getEndJtf().getText()));
					
					dates[0] = new Date(begindate);
					dates[1] = new Date(enddate);

					HotelStrVO str = new HotelStrVO(hotelID,
							Double.parseDouble(singleHotelSpecialTimeStr.getCountJtf().getText()), dates);
					if (hotelStrategyDistributionController.confirmHotelStrategy(str) == ResultMessage.SUCCESS) {
						hotelStrategyViewControllerImpl.backToselectStrategy();
					} else {
						// 保存失败
						new SaveFail_JFrame();
					}
				}

				else {
					saveError.setVisible(true);
				}
			}

		});

		/**
		 * 实现编辑折扣值时提示错误消息消失
		 */
		Document countDoc = singleHotelSpecialTimeStr.getCountJtf().getDocument();
		countDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

		});
	}

}
