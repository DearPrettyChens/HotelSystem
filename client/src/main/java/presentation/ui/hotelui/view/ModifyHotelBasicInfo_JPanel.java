package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import exception.NotFoundHotelException;
import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import util.City;
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
    private Border border=new LineBorder(new Color(218, 218, 218), 1, false);
	
	private String hotelID;

	private String hotelname;
	int star;
	private String location;
	private String area;
	private String city;
	private String tel;
	private ImageIcon hotelimage;
	private String introduction;
	private String commonFacility; // 通用设施
	private String activityFacility;// 活动设施
	private String service;// 服务项目
	private String roomFacility;// 客房设施
	private String enterprise;

	private City city2;
	private TradingArea tradingArea;

	private JLabel hotelnamejl;
	private JLabel hotelimagejl=new JLabel("酒店图片：");
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
	private JTextField areajtf;
	private JTextField cityjtf;
	private JTextField teljtf;
	private JTextArea commonFacilityjtf;
	private JTextArea activityFacilityjtf;
	private JTextArea roomFacilityjtf;
	private JTextArea servicejtf;
	private JTextArea introductionjtf;
    private JButton hotelimagejb;
	
	private HotelDistributionController hotelDistributionController = HotelDistributionController.getInstance();

	public ModifyHotelBasicInfo_JPanel(String hotelID) {
		this.hotelID = hotelID;

		try {
			HotelBasicInfoVO hotelBasicInfoVO = hotelDistributionController.getHotelBasicInfo(hotelID);
			this.hotelname =hotelBasicInfoVO.getHotelName();
			this.hotelimage=hotelBasicInfoVO.getHotelImage();
			
			this.city2=hotelBasicInfoVO.getCity();
			this.city=city2.toChinese();
			
			this.tradingArea=hotelBasicInfoVO.getTradingArea();
			this.area = tradingArea.getChinese();
			
			this.location =hotelBasicInfoVO.getAddress();
			this.tel = hotelBasicInfoVO.getTelephone();
			
			this.star=hotelBasicInfoVO.getStar();
			this.enterprise=hotelBasicInfoVO.getEnterprises();
			// 通用设施
	    	this.commonFacility=hotelBasicInfoVO.getCommonFacility();
	    		// 活动设施
	    	this.activityFacility=hotelBasicInfoVO.getActivityFacility();
	    		// 服务项目
	    	this.service=hotelBasicInfoVO.getService();
	    		// 客房设施
	    	this.roomFacility=hotelBasicInfoVO.getRoomFacility();
			
	    	this.introduction = hotelBasicInfoVO.getIntroduce();
		} catch (NotFoundHotelException e) {
			e.printStackTrace();
		}

		hotelnamejl = new JLabel("酒店名称："+hotelname);
		starjtf = new JTextField(star + "");
		locationjtf = new JTextField(location);
		cityjtf=new JTextField(city);
		areajtf = new JTextField(area);
		teljtf = new JTextField(tel);
		servicejtf = new JTextArea(service);
		introductionjtf = new JTextArea(introduction);
        commonFacilityjtf=new JTextArea(commonFacility);
        activityFacilityjtf=new JTextArea(activityFacility);
        roomFacilityjtf=new JTextArea(roomFacility);
		enterprisesjl=new JLabel("合作企业："+enterprise);
        hotelimagejb=new JButton(hotelimage);
		
		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);

		addComp();

	}

	void addComp() {


		
		
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(80, 0, 200, 30);
		this.add(hotelnamejl);
		
		hotelimagejl.setFont(font);
		hotelimagejl.setBounds(80, 50, 100, 30);
		this.add(hotelimagejl);

		hotelimagejb.setFont(font);
		hotelimagejb.setBounds(163, 60, 160, 160);
		this.add(hotelimagejb);
		
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

		cityjtf.setFont(font);
		cityjtf.setBounds(160, 300, 100, 30);
		this.add(cityjtf);
		
		areajl.setFont(font);
		areajl.setBounds(420, 300, 100, 30);
		this.add(areajl);

		areajtf.setFont(font);
		areajtf.setBounds(500, 300, 100, 30);
		this.add(areajtf);

		
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

		
	}

}
