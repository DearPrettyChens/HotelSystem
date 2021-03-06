package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import businesslogic.bl.userbl.User;
import exception.NotFoundHotelException;
import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.loginui.view.Hotelworker_JFrame;
import presentation.ui.loginui.view.Individualregister_JFrame;
import presentation.ui.tools.FileChooseHelper;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.NewClient_JLabel;
import util.City;
import util.ResultMessage;
import util.TradingArea;
import vo.hotelvo.HotelBasicInfoVO;

/**
 * 酒店工作人员维护酒店信息界面
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ModifyHotelBasicInfo_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color color = new Color(148, 221, 184);
	private Border border = new LineBorder(new Color(218, 218, 218), 1, false);

	private String hotelID;

	private String hotelname;
	int star;
	private String location;
	private String area;
	private String city;
	private String tel;
	private String introduction;
	private String commonFacility; // 通用设施
	private String activityFacility;// 活动设施
	private String service;// 服务项目
	private String roomFacility;// 客房设施
	private String enterprise;
	
	private String imagePath;

	private ImageIcon hotelimage = ImageTool.getScaledImage(new ImageIcon(ModifyHotelBasicInfo_JPanel.class.getResource("hotel.jpg")), 160);

	private City city2;
	private TradingArea tradingArea;

	private JLabel hotelnamejl;
	private JLabel hotelimagejl = new JLabel("酒店图片：");
	private JLabel starjl = new JLabel("星级：");
	private JLabel locationjl = new JLabel("酒店地址：");
	private JLabel cityjl = new JLabel("城市：");
	private JLabel areajl = new JLabel("商圈：");
	private JLabel teljl = new JLabel("电话：");
	private JLabel commonFacilityjl = new JLabel("通用设施：");
	private JLabel activityFacilityjl = new JLabel("活动设施：");
	private JLabel roomFacilityjl = new JLabel("客房设施：");
	private JLabel servicejl = new JLabel("服务项目：");
	private JLabel introductionjl = new JLabel("简介：");
	private JLabel enterprisesjl = new JLabel("合作企业：");
	private JLabel attentionjl = new JLabel("注：合作企业在我的策略中进行修改");

	private JTextField starjtf;
	private JTextField locationjtf;
	
	private JTextField teljtf;
	private JTextArea commonFacilityjtf;
	private JTextArea activityFacilityjtf;
	private JTextArea roomFacilityjtf;
	private JTextArea servicejtf;
	private JTextArea introductionjtf;
	private MyButton hotelimagejb;
	private JLabel hotelImageShow;

	private JComboBox citycomboBox = new JComboBox();
	private JComboBox tradingareacomboBox = new JComboBox();

	JLabel telError = new JLabel("电话不能为空");
	JLabel telError2 = new JLabel("电话为11位");
	JLabel starError = new JLabel("星级不能为空");
	JLabel locaError = new JLabel("地址不能为空");
	JLabel starError2 = new JLabel("星级为1～5之间的整数");

	private HotelDistributionController hotelDistributionController = HotelDistributionController.getInstance();

	public ModifyHotelBasicInfo_JPanel(String hotelID) {
		this.hotelID = hotelID;

		try {
			HotelBasicInfoVO hotelBasicInfoVO = hotelDistributionController.getHotelBasicInfo(hotelID);

			this.hotelname = hotelBasicInfoVO.getHotelName();

			ImageIcon icon = hotelBasicInfoVO.getHotelImage();
			if (icon != null) {
				icon = ImageTool.getScaledImage(icon, 160);
				this.hotelimage = icon;
			}

			this.city2 = hotelBasicInfoVO.getCity();
			if (city2 != null) {
				this.city = city2.toChinese();

				this.tradingArea = hotelBasicInfoVO.getTradingArea();
				this.area = tradingArea.getChinese();

				this.location = hotelBasicInfoVO.getAddress();
				this.tel = hotelBasicInfoVO.getTelephone();

				this.star = hotelBasicInfoVO.getStar();
				this.enterprise = hotelBasicInfoVO.getEnterprises();
				// 通用设施
				this.commonFacility = hotelBasicInfoVO.getCommonFacility();
				// 活动设施
				this.activityFacility = hotelBasicInfoVO.getActivityFacility();
				// 服务项目
				this.service = hotelBasicInfoVO.getService();
				// 客房设施
				this.roomFacility = hotelBasicInfoVO.getRoomFacility();

				this.introduction = hotelBasicInfoVO.getIntroduce();
			}
		} catch (NotFoundHotelException e) {
			e.printStackTrace();
		}

		hotelnamejl = new JLabel("酒店名称：" + hotelname);
		starjtf = new JTextField(star + "");
		locationjtf = new JTextField(location);

		teljtf = new JTextField(tel);
		servicejtf = new JTextArea(service);
		introductionjtf = new JTextArea(introduction);
		commonFacilityjtf = new JTextArea(commonFacility);
		activityFacilityjtf = new JTextArea(activityFacility);
		roomFacilityjtf = new JTextArea(roomFacility);
		if (enterprise == null) {
			enterprisesjl = new JLabel("合作企业：无");
		} else {
			enterprisesjl = new JLabel("合作企业：" + enterprise);
		}
		hotelImageShow = new JLabel(hotelimage);
		hotelimagejb = new MyButton();

		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);

		addComp();

	}

	void addComp() {

		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(80, 0, 500, 30);
		this.add(hotelnamejl);

		hotelimagejl.setFont(font);
		hotelimagejl.setBounds(80, 50, 100, 30);
		this.add(hotelimagejl);

		hotelImageShow.setFont(font);
		hotelImageShow.setBounds(163, 60, 160, 160);
		this.add(hotelImageShow);

		hotelimagejb.setText("选取酒店图片");
		hotelimagejb.setBounds(420, 190, 150, 30);
		this.add(hotelimagejb);

		// 实现选择图片文件
		hotelimagejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = FileChooseHelper.fileChoose();
				if (path != null) {
					imagePath = path;

					ImageIcon imageIcon = new ImageIcon(imagePath);
					
					imageIcon = ImageTool.getScaledImage(imageIcon, 160);
					hotelimage = imageIcon;
					hotelImageShow.setIcon(imageIcon);
					ModifyHotelBasicInfo_JPanel.this.hotelImageShow.updateUI();
					
				}

			}
		});

		teljl.setFont(font);
		teljl.setBounds(80, 250, 100, 30);
		this.add(teljl);

		teljtf.setFont(font);
		teljtf.setBounds(160, 250, 160, 30);
		this.add(teljtf);

		starjl.setFont(font);
		starjl.setBounds(420, 250, 100, 30);
		this.add(starjl);

		starjtf.setFont(font);
		starjtf.setBounds(500, 250, 100, 30);
		this.add(starjtf);

		cityjl.setFont(font);
		cityjl.setBounds(80, 300, 100, 30);
		this.add(cityjl);

		citycomboBox.addItem("南京");
		citycomboBox.setSelectedItem("南京");
		citycomboBox.setBounds(160, 300, 160, 30);
		this.add(citycomboBox);

		for (TradingArea e : TradingArea.values()) {
			tradingareacomboBox.addItem(e.getChinese());
		}

		if (tradingArea != null) {
			tradingareacomboBox.setSelectedItem(area);
		}else{
			tradingareacomboBox.setSelectedItem("新街口");
		}

		tradingareacomboBox.setBounds(500, 300, 100, 30);
		this.add(tradingareacomboBox);


		areajl.setFont(font);
		areajl.setBounds(420, 300, 100, 30);
		this.add(areajl);



		locationjl.setFont(font);
		locationjl.setBounds(80, 350, 100, 30);
		this.add(locationjl);

		locationjtf.setFont(font);
		locationjtf.setBounds(160, 350, 440, 30);
		this.add(locationjtf);

		enterprisesjl.setFont(font);
		enterprisesjl.setBounds(80, 400, 600, 30);
		this.add(enterprisesjl);

		attentionjl.setFont(new Font("宋体", Font.BOLD, 14));
		attentionjl.setForeground(new Color(148, 221, 184));
		attentionjl.setBounds(160, 420, 400, 30);
		this.add(attentionjl);

		introductionjl.setFont(font);
		introductionjl.setBounds(80, 470, 100, 30);
		this.add(introductionjl);

		introductionjtf.setFont(font);
		introductionjtf.setBounds(160, 470, 440, 80);
		introductionjtf.setBorder(border);
		this.add(introductionjtf);

		commonFacilityjl.setFont(font);
		commonFacilityjl.setBounds(80, 600, 100, 30);
		this.add(commonFacilityjl);

		commonFacilityjtf.setFont(font);
		commonFacilityjtf.setBounds(160, 600, 440, 80);
		commonFacilityjtf.setBorder(border);
		this.add(commonFacilityjtf);

		activityFacilityjl.setFont(font);
		activityFacilityjl.setBounds(80, 730, 100, 30);
		this.add(activityFacilityjl);

		activityFacilityjtf.setFont(font);
		activityFacilityjtf.setBounds(160, 730, 440, 80);

		activityFacilityjtf.setBorder(border);
		this.add(activityFacilityjtf);

		servicejl.setFont(font);
		servicejl.setBounds(80, 860, 100, 30);
		this.add(servicejl);

		servicejtf.setFont(font);
		servicejtf.setBounds(160, 860, 440, 80);
		servicejtf.setBorder(border);
		this.add(servicejtf);

		roomFacilityjl.setFont(font);
		roomFacilityjl.setBounds(80, 990, 100, 30);
		this.add(roomFacilityjl);

		roomFacilityjtf.setFont(font);
		roomFacilityjtf.setBounds(160, 990, 440, 80);
		roomFacilityjtf.setBorder(border);
		this.add(roomFacilityjtf);

		telError.setForeground(Color.RED);
		telError.setFont(font);
		telError.setBounds(160, 280, 150, 20);
		ModifyHotelBasicInfo_JPanel.this.add(telError);
		telError.setVisible(false);

		telError2.setForeground(Color.RED);
		telError2.setFont(font);
		telError2.setBounds(160, 280, 150, 20);
		ModifyHotelBasicInfo_JPanel.this.add(telError2);
		telError2.setVisible(false);

		starError.setForeground(Color.RED);
		starError.setFont(font);
		starError.setBounds(500, 280, 150, 20);
		ModifyHotelBasicInfo_JPanel.this.add(starError);
		starError.setVisible(false);

		starError2.setForeground(Color.RED);
		starError2.setFont(font);
		starError2.setBounds(500, 280, 150, 20);
		ModifyHotelBasicInfo_JPanel.this.add(starError2);
		starError2.setVisible(false);

		locaError.setForeground(Color.RED);
		locaError.setFont(font);
		locaError.setBounds(160, 380, 150, 20);
		ModifyHotelBasicInfo_JPanel.this.add(locaError);
		locaError.setVisible(false);

		/**
		 * 实现编辑值时提示错误消息消失
		 */
		Document telDoc = teljtf.getDocument();
		telDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				telError.setVisible(false);
				telError2.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				telError.setVisible(false);
				telError2.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				telError.setVisible(false);
				telError2.setVisible(false);
			}

		});

		Document starDoc = starjtf.getDocument();
		starDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				starError.setVisible(false);
				starError2.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				starError.setVisible(false);
				starError2.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				starError.setVisible(false);
				starError2.setVisible(false);
			}

		});

		Document locaDoc = locationjtf.getDocument();
		locaDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				locaError.setVisible(false);

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				locaError.setVisible(false);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				locaError.setVisible(false);

			}

		});
	}
	/**
	 * 上层面板获得内容
	 * 
	 * @return
	 */
	
	/**
	 * 保存当前酒店信息
	 */
	public ResultMessage saveInfo() {
		if (teljtf.getText() == "") {
			telError.setVisible(true);
			return ResultMessage.FAIL;
		}
		if (teljtf.getText().length() != 11) {
			telError2.setVisible(true);
			return ResultMessage.FAIL;
		}
		if (starjtf.getText() == "") {
			starError.setVisible(true);
			return ResultMessage.FAIL;
		}
		if (Integer.parseInt(starjtf.getText()) > 5 || Integer.parseInt(starjtf.getText()) <= 0) {
			starError2.setVisible(true);
			return ResultMessage.FAIL;
		}

		if (locationjtf.getText() == "") {
			locaError.setVisible(true);
			return ResultMessage.FAIL;
		}
		
		HotelBasicInfoVO basic = new HotelBasicInfoVO(hotelID, hotelname, hotelimage, locationjtf.getText(),
				City.values()[citycomboBox.getSelectedIndex()],
				TradingArea.values()[tradingareacomboBox.getSelectedIndex()], teljtf.getText(),
				Integer.parseInt(starjtf.getText()), introductionjtf.getText(), commonFacilityjtf.getText(),
				activityFacilityjtf.getText(), servicejtf.getText(), roomFacilityjtf.getText(), enterprise);
		
		if (hotelDistributionController.confirmModifyInfo(basic) == ResultMessage.SUCCESS) {
			 Hotelworker_JFrame hotelworker_JFrame=Hotelworker_JFrame.getInstance(hotelname,hotelname);
			 hotelworker_JFrame.changeImage(hotelimage);
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAIL;
		}
	}

	/**
	 * 恢复信息到未编辑之前
	 */
	public void recoverInfo() {
		hotelnamejl.setText("酒店名称：" + hotelname);
		starjtf.setText(star + "");
		locationjtf.setText(location);

		teljtf.setText(tel);
		servicejtf.setText(service);
		introductionjtf.setText(introduction);
		commonFacilityjtf.setText(commonFacility);
		activityFacilityjtf.setText(activityFacility);
		roomFacilityjtf.setText(roomFacility);
		enterprisesjl.setText("合作企业：" + enterprise);
	}
}
