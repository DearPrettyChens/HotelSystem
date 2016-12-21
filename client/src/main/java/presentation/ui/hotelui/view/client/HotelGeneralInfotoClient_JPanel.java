package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import exception.NotFoundHotelException;
import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import util.City;
import util.TradingArea;
import util.ViewTag;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * 顾客查看的酒店详细信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelGeneralInfotoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 15);

	private Color darkgreen = new Color(52, 131, 115);
	private Color lightgreen = new Color(148, 221, 184);
	private Color orange = new Color(231, 64, 37);
	private Color yellow = new Color(243, 150, 39);


	private JPanel linejp = new JPanel();

	private JLabel guidejl = new JLabel();
	private JLabel imagejl = new JLabel();
	private JLabel namejl = new JLabel();
	private JPanel starjp = new JPanel();
	private JLabel locationjl = new JLabel("地址：");
	private JTextArea locationjta = new JTextArea();
	private JLabel teljl = new JLabel();

	private JLabel pricejl = new JLabel();
	private JLabel pricejl1 = new JLabel("￥");
	private JLabel pricejl2 = new JLabel("起");
	private JPanel pricejp = new JPanel();

	private JPanel choosejp = new JPanel();
	private JPanel bgjp1 = new JPanel();
	private JPanel bgjp2 = new JPanel();
	private JPanel bgjp3 = new JPanel();
	private JPanel bgjp4 = new JPanel();

	private JLabel rooninfojl = new JLabel("房型列表", JLabel.CENTER);
	private JLabel hotelinfojl = new JLabel("酒店详情", JLabel.CENTER);
	private JLabel hotelremarkjl = new JLabel("酒店点评", JLabel.CENTER);
	private JLabel orderjl = new JLabel("酒店订单", JLabel.CENTER);

	private JPanel strjp = new JPanel();

	private ImageIcon realstar = new ImageIcon(HotelGeneralInfotoClient_JPanel.class.getResource("image/realstar.png"));
	private ImageIcon emptystar = new ImageIcon(HotelGeneralInfotoClient_JPanel.class.getResource("image/emptystar.png"));

	private JLabel starjl1 = new JLabel();
	private JLabel starjl2 = new JLabel();
	private JLabel starjl3 = new JLabel();
	private JLabel starjl4 = new JLabel();
	private JLabel starjl5 = new JLabel();

	private MyButton orderjb = new MyButton();

	private JLabel[] allstar = new JLabel[] { starjl1, starjl2, starjl3, starjl4, starjl5 };

	private String name = "";
	private ImageIcon image;
	private int star = 5;
	private double price = 0;
	private String location = "";
	private String tel = "";

	// 城市
	private City city;
	// 商圈
	private TradingArea area;
	// 酒店简介
	private String introduce;
	// 通用设施
	private String commonFacility;
	// 活动设施
	private String activityFacility;
	// 服务项目
	private String service;
	// 客房设施
	private String roomFacility;
	// 合作企业
	private String enterprises;
	// 酒店策略
	private ArrayList<HotelStrVO> hotelStrVO;
	// 可用房间信息
	private ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs;
	// 评分
	private double remarkNumber;
	// 评论
	private ArrayList<String> remarkDetailInfo;
	// 订单记录
	private ArrayList<HotelOrderVO> orderRecordVO;

	private String hotelID;
	private String userID;
	private ViewTag viewTag;
 
	private HotelDistributionController hotelDistributionController = HotelDistributionController.getInstance();
    private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
    private MyFootViewController myFootViewController=MyFootViewController.getInstance(null);
	
	
    private JPanel panel=new JPanel();
    private JPanel container=new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    
	private RoomInfotoClient_JPanel roomInfotoClient_JPanel;
    private HotelDetailInfotoClient_JPanel hotelDetailInfotoClient_JPanel;
    private HotelRemarktoClient_JPanel hotelRemarktoClient_JPanel;
    private ChooseOrderTypetoClient_JPanel chooseOrderTypetoClient_JPanel;
    
	private HotelDetailInfoVO hotelDetailInfoVO;
	
	public HotelGeneralInfotoClient_JPanel(String hotelID, String userID,ViewTag viewTag) {
        this.viewTag=viewTag;
		this.hotelID = hotelID;
		this.userID = userID;
		try {
			hotelDetailInfoVO = hotelDistributionController.getHotelDetailInfo(hotelID, userID);
			
			this.name = hotelDetailInfoVO.getHotelName();
			this.image = hotelDetailInfoVO.getHotelImage();
			this.star = hotelDetailInfoVO.getStar();
			this.location = hotelDetailInfoVO.getAddress();
			this.tel = hotelDetailInfoVO.getTelephone();
			this.price = hotelDetailInfoVO.getLowestPrice();
			this.city = hotelDetailInfoVO.getCity();
			this.area = hotelDetailInfoVO.getArea();
			this.introduce = hotelDetailInfoVO.getIntroduce();
			this.commonFacility = hotelDetailInfoVO.getCommonFacility();
			this.service = hotelDetailInfoVO.getService();
			this.roomFacility = hotelDetailInfoVO.getRoomFacility();
			this.enterprises = hotelDetailInfoVO.getEnterprises();
			this.hotelStrVO = hotelDetailInfoVO.getHotelStrVO();
			this.availableRoomInfoVOs = hotelDetailInfoVO.getAvailableRoomInfoVO();
			this.remarkNumber = hotelDetailInfoVO.getRemarkNumber();
			this.remarkDetailInfo = hotelDetailInfoVO.getRemarkDetailInfo();
			this.orderRecordVO = hotelDetailInfoVO.getOrderRecordVO();
		} catch (NotFoundHotelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.price = price;

		this.setLayout(null);

		this.setBackground(Color.white);
		addComp();
		addChoosejp();
		addToPanel();
		this.setBounds(0, 0, 800, 550);
	}



	public void addComp() {
        container.setLayout(null);
        container.setBackground(Color.WHITE);
		
		image = ImageTool.getScaledImage(image, 130);
		imagejl.setIcon(image);
		imagejl.setBounds(450, 20, 120, 120);
		container.add(imagejl);

		// guidejl.setText("酒店预订 >> "+name);
		// guidejl.setFont(new Font("宋体",Font.BOLD, 10));
		// guidejl.setBounds(50,0,300,20);
		// this.add(guidejl);
		//
		namejl.setText(name);
		namejl.setForeground(darkgreen);
		namejl.setFont(new Font("宋体", Font.BOLD, 23));
		namejl.setBounds(50, 20, 400, 35);
		container.add(namejl);

		starjp.setLayout(null);
		starjp.setBounds(50, 60, 150, 10);
		starjp.setBackground(Color.white);
		container.add(starjp);
		for (int i = 0; i < star; i++) {

			allstar[i].setIcon(realstar);
			allstar[i].setBounds(30 * i, 0, 10, 10);
			starjp.add(allstar[i]);

		}
		for (int i = star; i < 5; i++) {

			allstar[i].setIcon(emptystar);
			allstar[i].setBounds(30 * i, 0, 10, 10);
			starjp.add(allstar[i]);

		}

		locationjl.setFont(font);
		locationjl.setBounds(50, 80, 50, 15);
		container.add(locationjl);

		locationjta.setText(location);
		locationjta.setFont(font);
		locationjta.setEditable(false);
		locationjta.setBackground(Color.white);
		locationjta.setLineWrap(true);
		locationjta.setBounds(100, 80, 300, 40);
		container.add(locationjta);

		teljl.setText("联系方式：" + tel);
		teljl.setFont(font);
		teljl.setBounds(50, 125, 200, 15);
		container.add(teljl);

		linejp.setBackground(lightgreen);
		linejp.setBounds(50, 95, 700, 2);
		// this.add(linejp);

		pricejp.setLayout(null);
		pricejp.setBackground(Color.white);
		pricejp.setBounds(600, 20, 150, 150);
		container.add(pricejp);

		pricejl.setText(price + "");
		pricejl.setBounds(25, 10, 200, 60);
		pricejl.setFont(new Font("宋体", Font.BOLD, 40));
		pricejl.setForeground(orange);
		pricejp.add(pricejl);

		pricejl1.setBounds(10, 0, 15, 15);
		pricejl1.setFont(font);
		pricejp.add(pricejl1);

		pricejl2.setBounds(135, 70, 15, 15);
		pricejl2.setFont(font);
		pricejp.add(pricejl2);

		orderjb.setText("立即预定");
		orderjb.setBounds(20, 90, 130, 30);
		pricejp.add(orderjb);
		orderjb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (viewTag) {
				case HOTELRESERVERSION:
					reserveHotelViewController.generateNewOrder(hotelID);
					break;
				case MYHOTEL:
					myFootViewController.generateNewOrder(hotelID);
					break;
				default:
					break;
				
				}

			}

		});
		
		
		strjp.setLayout(null);
		strjp.setBackground(Color.white);
		strjp.setBounds(550, 10, 90, 80);
		container.add(strjp);

	}

	public void addChoosejp() {

		choosejp.setLayout(null);
		choosejp.setBounds(50, 170, 700, 35);
		choosejp.setBackground(Color.white);

		container.add(choosejp);

		rooninfojl.setBounds(0, 0, 175, 30);
		rooninfojl.setFont(font);
		rooninfojl.setForeground(lightgreen);
		rooninfojl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				rooninfojl.setForeground(lightgreen);
				hotelremarkjl.setForeground(Color.black);
				hotelinfojl.setForeground(Color.black);
				orderjl.setForeground(Color.black);
				changeToRoomInfo();
				container.updateUI();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		choosejp.add(rooninfojl);

		hotelinfojl.setBounds(175, 0, 175, 30);
		hotelinfojl.setFont(font);
		hotelinfojl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				rooninfojl.setForeground(Color.black);
				hotelinfojl.setForeground(lightgreen);
				hotelremarkjl.setForeground(Color.black);
				orderjl.setForeground(Color.black);
				container.updateUI();
				changeToHotelInfo();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		choosejp.add(hotelinfojl);

		hotelremarkjl.setBounds(350, 0, 175, 30);
		hotelremarkjl.setFont(font);
		hotelremarkjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				rooninfojl.setForeground(Color.black);
				hotelremarkjl.setForeground(lightgreen);
				hotelinfojl.setForeground(Color.black);
				orderjl.setForeground(Color.black);
				container.updateUI();
				changeToHotelRemark();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		choosejp.add(hotelremarkjl);

		orderjl.setBounds(525, 0, 175, 30);
		orderjl.setFont(font);
		orderjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				rooninfojl.setForeground(Color.black);
				hotelremarkjl.setForeground(Color.black);
				hotelinfojl.setForeground(Color.black);
				orderjl.setForeground(lightgreen);
				container.updateUI();
				changeToHotelOrder();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		choosejp.add(orderjl);

		bgjp1.setBackground(lightgreen);
		bgjp1.setBounds(0, 31, 700, 2);
		choosejp.add(bgjp1);

		bgjp2.setBackground(lightgreen);
		bgjp2.setBounds(175, 3, 2, 25);
		choosejp.add(bgjp2);

		bgjp3.setBackground(lightgreen);
		bgjp3.setBounds(350, 3, 2, 25);
		choosejp.add(bgjp3);

		bgjp4.setBackground(lightgreen);
		bgjp4.setBounds(525, 3, 2, 25);
		choosejp.add(bgjp4);

	}

	public void addToPanel() {
		scrollPane.setBounds(0, 0, 800, 550);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		roomInfotoClient_JPanel = new RoomInfotoClient_JPanel(availableRoomInfoVOs,viewTag);
		panel.add(roomInfotoClient_JPanel);
		panel.setBounds(0, 205, 800, roomInfotoClient_JPanel.getHeight());
	    container.add(panel);
	    container.setPreferredSize(new Dimension(780, 205+panel.getHeight()));
	    scrollPane.setViewportView(container);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}
	
	public void changeToRoomInfo(){
		panel.removeAll();
		roomInfotoClient_JPanel =new RoomInfotoClient_JPanel(availableRoomInfoVOs,viewTag);
		panel.add(roomInfotoClient_JPanel);
		panel.setBounds(0, 205, 800, roomInfotoClient_JPanel.getHeight());
		panel.updateUI();
		container.setPreferredSize(new Dimension(780, 205+panel.getHeight()));
	    container.updateUI();
	}

	public void changeToHotelInfo(){
		panel.removeAll();
		hotelDetailInfotoClient_JPanel=new HotelDetailInfotoClient_JPanel(hotelDetailInfoVO);
		panel.add(hotelDetailInfotoClient_JPanel);
		panel.setBounds(0, 205, 800, hotelDetailInfotoClient_JPanel.getHeight());
		panel.updateUI();
		container.setPreferredSize(new Dimension(780, 205+panel.getHeight()));
	    container.updateUI();
	}
	public void changeToHotelRemark(){
		panel.removeAll();
		hotelRemarktoClient_JPanel =new HotelRemarktoClient_JPanel(remarkDetailInfo, remarkNumber);
		panel.add(hotelRemarktoClient_JPanel);
		panel.setBounds(0, 205, 800, hotelRemarktoClient_JPanel.getHeight());
		panel.updateUI();
		container.setPreferredSize(new Dimension(780, 205+panel.getHeight()));
	    container.updateUI();
	}
	
	public void changeToHotelOrder(){
		panel.removeAll();
		chooseOrderTypetoClient_JPanel=new ChooseOrderTypetoClient_JPanel(userID, hotelID);
		panel.add(chooseOrderTypetoClient_JPanel);
		panel.setBounds(0, 205, 800, chooseOrderTypetoClient_JPanel.getHeight());
		container.setPreferredSize(new Dimension(780, 205+panel.getHeight()));
	    container.updateUI();
	}
}
