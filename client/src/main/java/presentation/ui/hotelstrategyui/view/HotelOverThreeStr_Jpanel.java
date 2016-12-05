package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.hotelstrategyui.distributecontroller.HotelStrategyDistributionController;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import util.HotelStrategyType;
import vo.hotelstrategyvo.HotelStrVO;

/**
 * 三间及三间以上策略
 * 
 * 未加确认监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelOverThreeStr_Jpanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3269373873347409616L;

	private Font font = new Font("宋体", Font.BOLD, 20);

	private JLabel title = new JLabel("房间数量优惠策略");
	private int roomnumber;
	private double count;

	private JLabel roomnumberjl = new JLabel("满足该策略的最小房间数量:");
	private JLabel countjl = new JLabel("折扣值:");

	private MyTextfield roomnumberjtf = new MyTextfield("");
	private MyTextfield countjtf = new MyTextfield("");

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();

	private HotelStrategyDistributionController hotelStrategyDistributionController = HotelStrategyDistributionController
			.getInstance();
	private HotelStrategyViewControllerImpl hotelStrategyViewControllerImpl = HotelStrategyViewControllerImpl
			.getInstance(null);

	public HotelOverThreeStr_Jpanel(String hotelID) {
		HotelStrVO hotelStrVO = hotelStrategyDistributionController.getHotelStrategy(hotelID, HotelStrategyType.AMOUNT);

		this.roomnumber = hotelStrVO.getAmount();
		this.count = hotelStrVO.getDiscount();

		roomnumberjtf.setText("" + roomnumber);

		countjtf.setText("" + count);

		this.setLayout(null);
		this.setBackground(Color.white);
		 this.setBounds(0, 0, 800, 600);

		addComp();

	}

	public HotelOverThreeStr_Jpanel() {

		this.setLayout(null);
		this.setBackground(Color.white);

		this.setSize(800, 600);

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
		title.setFont(font);
		title.setBounds(300, 80, 300, 50);
		this.add(title);

		roomnumberjl.setFont(font);
		roomnumberjl.setBounds(100, 200, 300, 50);
		this.add(roomnumberjl);

		roomnumberjtf.setFont(font);
		roomnumberjtf.setBounds(400, 200, 200, 50);
		roomnumberjtf.setText(roomnumber + "");
		this.add(roomnumberjtf);

		countjl.setFont(font);
		countjl.setBounds(280, 300, 200, 50);
		this.add(countjl);

		countjtf.setFont(font);
		countjtf.setBounds(400, 300, 200, 50);
		countjtf.setText(count + "");
		this.add(countjtf);

		canclejb.setText("取消");
		canclejb.setBounds(400, 450, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotelStrategyViewControllerImpl.backToselectStrategy();

			}
		});

		confirmjb.setText("确定");
		confirmjb.setBounds(280, 450, 80, 30);
		this.add(confirmjb);

	}

}
