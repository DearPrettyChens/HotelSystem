package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

import presentation.ui.hotelstrategyui.distributecontroller.HotelStrategyDistributionController;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.webstrategyui.view.Singlewebclientlevelstr_Jpanel;
import util.HotelStrategyType;
import util.ResultMessage;
import util.WebStrategyType;
import vo.hotelstrategyvo.HotelStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 企业优惠策略
 * 
 *  未加确认按钮监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelEnterpriseStr_JPanel extends JPanel {
	private String hotelID;
	private JLabel titlejl = new JLabel("合作企业顾客折扣策略");

	private Font font = new Font("宋体", Font.BOLD, 18);
	private ArrayList<String> enterprise;
	private double discount;

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private MyButton addjb = new MyButton();

	private JLabel countjl = new JLabel("折扣值:");
	private JTextField countjtf = new JTextField();

	private JScrollPane scrollPane = new JScrollPane();// 存放合作企业
	private JPanel panel = new JPanel();

	private HotelStrategyDistributionController hotelStrategyDistributionControll = HotelStrategyDistributionController
			.getInstance();
	private HotelStrategyViewControllerImpl hotelStrategyViewControllerImpl = HotelStrategyViewControllerImpl
			.getInstance(null);

	ArrayList<SingleHotelEnterpriseStr_JPanel> singleinfos = new ArrayList<SingleHotelEnterpriseStr_JPanel>();

	public HotelEnterpriseStr_JPanel(String hotelID) {
		this.hotelID=hotelID;
		HotelStrVO hotelStrVO = hotelStrategyDistributionControll.getHotelStrategy(hotelID,
				HotelStrategyType.ENTERPRISE);
		enterprise = hotelStrVO.getEnterprise();
		discount = hotelStrVO.getDiscount();
		this.setLayout(null);
		this.setBackground(Color.white);
		 this.setBounds(0, 0, 800, 600);
		addComps();

	}

	void addComps() {

		addScrollPane();

		countjl.setFont(font);
		countjl.setBounds(280, 400, 100, 30);
		this.add(countjl);

		countjtf.setFont(font);
		countjtf.setBounds(380, 400, 100, 30);
		countjtf.setText(discount + "");
		this.add(countjtf);

		canclejb.setText("取消");
		canclejb.setBounds(450, 500, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotelStrategyViewControllerImpl.backToselectStrategy();

			}
		});

		confirmjb.setText("确定");
		confirmjb.setBounds(350, 500, 80, 30);
		this.add(confirmjb);

		addjb.setText("增加");
		addjb.setBounds(250, 500, 80, 30);
		addjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SingleHotelEnterpriseStr_JPanel newinfo = new SingleHotelEnterpriseStr_JPanel();
				singleinfos.add(newinfo);
				addToPanel();
				
			}

		});
		this.add(addjb);

		titlejl.setFont(font);
		titlejl.setBounds(280, 60, 300, 30);
		this.add(titlejl);

		JLabel saveError=new JLabel("请输入0～1之间的数字");
		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(280, 440, 200, 25);
		HotelEnterpriseStr_JPanel.this.add(saveError);
		saveError.setVisible(false);
		
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(countjtf.getText())<=1.0&&Double.parseDouble(countjtf.getText())>0){

					for(int i=0;i<singleinfos.size();i++){
						enterprise.add(singleinfos.get(i).getEnterpriseName().getText());
					}
					HotelStrVO str=new HotelStrVO(hotelID,Double.parseDouble(countjtf.getText()),
							enterprise);
					if(hotelStrategyDistributionControll.confirmHotelStrategy(str)==ResultMessage.SUCCESS){
						hotelStrategyViewControllerImpl.backToselectStrategy();
					}
					else{
						//TODO
						//保存失败
					}
				}
				else{
					saveError.setVisible(true);
				}
			}
			
		});
	}

	
	/**
	 * 增加滚动条面板
	 */
	public void addScrollPane() {
		scrollPane.setBounds(180, 120, 500, 250);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		initStrategyList();
		this.add(scrollPane);
	}

	/**
	 * 初始化企业列表，以及初始化单条企业panel
	 */
	public void initStrategyList() {
		singleinfos = new ArrayList<SingleHotelEnterpriseStr_JPanel>();

		for (String singleEnterprise : enterprise) {
			SingleHotelEnterpriseStr_JPanel singleHotelEnterpriseStr_JPanel = new SingleHotelEnterpriseStr_JPanel(
					singleEnterprise);
			singleinfos.add(singleHotelEnterpriseStr_JPanel);
		}
		addToPanel();
	}

	/**
	 * 将单条企业panel加到panel上。再加到scrollpane
	 * 单独把这个方法抽出来写是因为，在增加新的企业后，arraylist里面会加有新的企业，需要重新显示
	 */
	public void addToPanel() {

		panel.removeAll();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		for (int i = 0; i < singleinfos.size(); i++) {
			SingleHotelEnterpriseStr_JPanel singleHotelEnterpriseStr_JPanel = singleinfos.get(i);
			singleHotelEnterpriseStr_JPanel.setBounds(0, 20 + 60 * i, 400, 50);
			panel.add(singleHotelEnterpriseStr_JPanel);
		}
		panel.setPreferredSize(new Dimension(400, 50 + 60 * singleinfos.size()));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// this.add(scrollPane);
	}

}
