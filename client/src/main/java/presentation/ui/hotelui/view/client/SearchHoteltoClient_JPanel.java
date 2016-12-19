package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.impl.BaseMesh.FaceMembers;

import businesslogic.bl.orderbl.Order;
import presentation.ui.loginui.view.newclient_JFrame;
import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyTextfield;
import util.BedType;
import util.City;
import util.HotelSortType;
import util.OrderState;
import util.TradingArea;
import util.TransHelper;
import util.ViewTag;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 顾客的搜索栏
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHoteltoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color color = new Color(148, 221, 184);

	private HotelSearchInfoVO vo = new HotelSearchInfoVO();
	
	
	private City city2;
	private TradingArea tradingArea2;
	private String city = "";
	private String tradingarea = "";

	private String customerID;

	private JPanel Searchjp1 = new JPanel();
	private JPanel Searchbgjp1 = new JPanel();
	private JPanel Searchllintjp1 = new JPanel();
	private JPanel Searchllintjp2 = new JPanel();
	private JPanel Searchllintjp3 = new JPanel();
	private JPanel Searchllintjp4 = new JPanel();
	private JPanel Searchllintjp5 = new JPanel();
	private JPanel Searchllintjp6 = new JPanel();
	private JPanel Searchllintjp7 = new JPanel();
	private JPanel Searchllintjp8 = new JPanel();
	private JPanel Searchllintjp9 = new JPanel();
	private JPanel Searchllintjp10 = new JPanel();

	private JLabel cityjl = new JLabel();
	private JLabel tradingareajl = new JLabel();

	private JLabel checkintimejl = new JLabel("入住：");

	private JLabel checkouttimejl = new JLabel("退房：");

	private MyTextfield fromtimejtf = new MyTextfield(TransHelper.dateToString(new Date()));
	private MyTextfield totimejtf = new MyTextfield(TransHelper.dateToString(new Date()));

	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy-MM-dd");
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy-MM-dd");

	private JLabel bedtypejl = new JLabel("床型：");
	private JLabel pricejl = new JLabel("价格：");
	private JLabel starjl = new JLabel("星级：");
	private JLabel scorejl = new JLabel("评分：");
	private JLabel orderstatejl = new JLabel("订单：");

	private JPanel nextjp = new JPanel();

	private JLabel keyjl = new JLabel("关键词");
	private MyTextfield searchjtf = new MyTextfield("请输入酒店名称");
	private JButton searchjb = new JButton(new ImageIcon("image/search.png"));

	private JPanel Searchjp2 = new JPanel();

	private JComboBox citycomboBox = new JComboBox();
	private JComboBox tradingareacomboBox = new JComboBox();

	private JCheckBox allbed = new JCheckBox("不限");
	private JCheckBox onebed = new JCheckBox("大床");
	private JCheckBox twobed = new JCheckBox("双床");
	private JCheckBox threebed = new JCheckBox("三床");
	private JCheckBox fourbed = new JCheckBox("四床");
	private JCheckBox manybed = new JCheckBox("家庭床");

	private boolean chooseAllBeds = true;
	private Map<String, BedType> bedMap = new HashMap<String,BedType>(){
		{
			put("不限", null);
			put("大床", BedType.BIGBED);
			put("双床", BedType.TWOBEDS);
			put("三床", BedType.THREEBEDS);
			put("四床", BedType.FOURBEDS);
			put("家庭床", BedType.FAMILYBED);
		}
	};
	private ArrayList<BedType> allBedTypes = new ArrayList<BedType>(){
		{
			add(BedType.BIGBED);
			add(BedType.FAMILYBED);
			add(BedType.FOURBEDS);
			add(BedType.THREEBEDS);
			add(BedType.TWOBEDS);
		}
	};
	private ArrayList<BedType> bedTypes = new ArrayList<BedType>();
	
	private JCheckBox allprice = new JCheckBox("不限");
	private JCheckBox price1 = new JCheckBox("￥200以下");
	private JCheckBox price2 = new JCheckBox("￥200-400");
	private JCheckBox price3 = new JCheckBox("￥400-600");
	private JCheckBox price4 = new JCheckBox("￥600-800");
	private JCheckBox price5 = new JCheckBox("￥800以上");
	//800以上怎么表示
	
	private boolean chooseAllPrice = true;
    private Map<String, Integer> priceMap = new HashMap<String, Integer>(){
    	{
    		put("不限", -1);
    		put("￥200以下", 0);
    		put("￥200-400", 200);
    		put("￥400-600", 400);
    		put("￥600-800", 600);
    		put("￥800以上", 800);
    	}
    };
    private ArrayList<Integer> allLowPrice = new ArrayList<Integer>(){
    	{
    		add(0);
    		add(200);
    		add(400);
    		add(600);
    		add(800);
    	}
    };
    private ArrayList<Integer> allHighPrice = new ArrayList<Integer>(){
    	{
    		add(200);
    		add(400);
    		add(600);
    		add(800);
    		add(Integer.MAX_VALUE);
    	}
    };
    private ArrayList<Integer> lowPrice = new ArrayList<Integer>();
    private ArrayList<Integer> highPrice = new ArrayList<Integer>();
    
	private JCheckBox allstar = new JCheckBox("不限");
	private JCheckBox star1 = new JCheckBox("1星");
	private JCheckBox star2 = new JCheckBox("2星");
	private JCheckBox star3 = new JCheckBox("3星");
	private JCheckBox star4 = new JCheckBox("4星");
	private JCheckBox star5 = new JCheckBox("5星");
	
	private boolean chooseAllStar = true;
	private Map<String, Integer> starMap = new HashMap<String,Integer>(){
		{
			put("不限", -1);
			put("1星", 1);
			put("2星", 2);
			put("3星", 3);
			put("4星", 4);
			put("5星", 5);
		}
	};
	private ArrayList<Integer> allStarArrayList = new ArrayList<Integer>(){
		{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}
	};
	private ArrayList<Integer> starArrayList = new ArrayList<Integer>();
	
	private JCheckBox allscore = new JCheckBox("不限");
	private JCheckBox score1 = new JCheckBox("<=1");
	private JCheckBox score2 = new JCheckBox("1~2");
	private JCheckBox score3 = new JCheckBox("2~3");
	private JCheckBox score4 = new JCheckBox("3~4");
	private JCheckBox score5 = new JCheckBox("4~5");

	private boolean chooseAllScore = true;
	private Map<String, Double> scoreMap = new HashMap<String ,Double>(){
		{
			put("不限",  -1.0);
			put("<=1", 0.0);
			put("1~2", 1.0);
			put("2~3", 2.0);
			put("3~4", 3.0);
			put("4~5", 4.0);
		}
	};
	private  ArrayList<Double> allLowScoreNumbers = new ArrayList<Double>(){
		{
			add(0.0);
			add(1.0);
			add(2.0);
			add(3.0);
			add(4.0);
		}
	};
	private  ArrayList<Double> allHighScoreNumbers = new ArrayList<Double>(){
		{
			add(1.0);
			add(2.0);
			add(3.0);
			add(4.0);
			add(5.0);
		}
	};
	private ArrayList<Double> lowScoreNumbers = new ArrayList<Double>();
	private  ArrayList<Double> highScoreNumbers = new ArrayList<Double>();
	
	private JCheckBox allstate = new JCheckBox("不限");
	private JCheckBox state1 = new JCheckBox("未执行");
	private JCheckBox state2 = new JCheckBox("已执行");
	private JCheckBox state3 = new JCheckBox("异常");
	private JCheckBox state4 = new JCheckBox("撤销");

	private boolean chooseAllState = true;
	private Map<String, OrderState> stateMap = new HashMap<String,OrderState>(){
		{
			put("不限", null);
			put("未执行", OrderState.NOTEXECUTED);
			put("已执行", OrderState.EXECUTED);
			put("异常", OrderState.UNUSUAL);
			put("撤销", OrderState.HASCANCELED);
		}
	};
	private ArrayList<OrderState> allOrderStates = new ArrayList<OrderState>(){
		{
			add(OrderState.EXECUTED);
			add(OrderState.HASCANCELED);
			add(OrderState.NOTEXECUTED);
			add(OrderState.UNUSUAL);
		}
	};
	private ArrayList<OrderState> orderStates = new ArrayList<OrderState>();
	
	private JPanel sortjp = new JPanel();

	private JLabel popularsortjl = new JLabel("最受欢迎");
	private JLabel pricesortjl = new JLabel("价格");
	private JLabel starsortjl = new JLabel("星级");
	private JLabel scoresortjl = new JLabel("评分");

	private ImageIcon upicon = new ImageIcon("image/top.png");
	private ImageIcon downicon = new ImageIcon("image/down.png");

	private JButton popularSortUpjb = new JButton(upicon);
	private JButton popularSortDownjb = new JButton(downicon);
	private JButton priceSortUpjb = new JButton(upicon);
	private JButton priceSortDownjb = new JButton(downicon);
	private JButton starSortUpjb = new JButton(upicon);
	private JButton starSortDownjb = new JButton(downicon);
	private JButton scoreSortUpjb = new JButton(upicon);
	private JButton scoreSortDownjb = new JButton(downicon);

	private JPanel moresearchjp = new JPanel();
	private JPanel lesssearchjp = new JPanel();
	private JLabel moreinfo = new JLabel("↓ 星级、评分、订单类型", JLabel.CENTER);

	private JLabel lessinfo = new JLabel("↑ 收起", JLabel.CENTER);

	private SearchHotelPane_JPanel searchHotelPane_JPanel ;
	
	public SearchHoteltoClient_JPanel(HotelSearchInfoVO hotelSearchInfoVO,SearchHotelPane_JPanel searchHotelPane_JPanel) {
		this.searchHotelPane_JPanel = searchHotelPane_JPanel;
		
		this.vo = hotelSearchInfoVO;
		
		this.city2 = hotelSearchInfoVO.getCity();
		this.city = city2.toChinese();

		this.tradingArea2 = hotelSearchInfoVO.getTradingArea();
		this.tradingarea = tradingArea2.getChinese();

		this.customerID = hotelSearchInfoVO.getCustomerID();

		this.setLayout(null);
		this.setSize(800, 600);
		this.setBackground(Color.white);

		addComp();

		addCompSearchjjp1();
		addCompSearchjjp2();
		addmoreSearchComp();

		addSortComp();

	}

	public void addCompSearchjjp1() {

		fromtimejtf.setBounds(450, 65, 120, 25);
		Searchjp1.add(fromtimejtf);
		p1.initCalendarPanel();
		JLabel l1 = new JLabel("日历面板");
		p1.add(l1);
		this.add(p1);

		totimejtf.setBounds(620, 65, 120, 25);
		Searchjp1.add(totimejtf);
		p2.initCalendarPanel();
		JLabel l2 = new JLabel("日历面板");
		p2.add(l2);
		this.add(p2);

		Searchjp1.setBackground(Color.white);
		Searchjp1.setLayout(null);
		Searchjp1.setBounds(0, 0, 800, 180);
		this.add(Searchjp1);

		Searchbgjp1.setLayout(null);
		Searchbgjp1.setBounds(50, 20, 700, 40);
		Searchbgjp1.setBackground(color);
		Searchjp1.add(Searchbgjp1);

		keyjl.setBounds(50, 5, 100, 30);
		keyjl.setFont(font);
		Searchbgjp1.add(keyjl);

		searchjtf.setBounds(120, 5, 500, 30);
		Searchbgjp1.add(searchjtf);

		searchjb.setBounds(650, 5, 30, 30);
		searchjb.setBorder(null);
		Searchbgjp1.add(searchjb);
		searchjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateHotelListPanel();				
			}
		});

		cityjl.setText("城市：");
		cityjl.setFont(font);

		cityjl.setBounds(100, 60, 100, 30);
	//cityjl.setBounds(100, 60, 150, 30);

		Searchjp1.add(cityjl);

		tradingareajl.setText("商圈：");
		tradingareajl.setFont(font);
		tradingareajl.setBounds(250, 60, 100, 30);
		Searchjp1.add(tradingareajl);

		citycomboBox.addItem("南京");
		citycomboBox.setSelectedItem(city);

		citycomboBox.setBounds(140, 60, 100, 30);
		Searchjp1.add(citycomboBox);

		//citycomboBox.setBounds(150, 60, 50, 30);
		//Searchjp1.add(citycomboBox);


		for(TradingArea e:TradingArea.values()){
			tradingareacomboBox.addItem(e.getChinese());
		}
		
		tradingareacomboBox.setSelectedItem(tradingarea);

		tradingareacomboBox.setBounds(290, 60, 	100, 30);

		//tradingareacomboBox.setBounds(235, 60, 115, 30);

		Searchjp1.add(tradingareacomboBox);
		
		tradingareacomboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vo.setTradingArea(TradingArea.values()[tradingareacomboBox.getSelectedIndex()]);
				updateHotelListPanel();
			}
		});

		checkintimejl.setFont(font);
		checkintimejl.setBounds(400, 60, 150, 30);
		Searchjp1.add(checkintimejl);

		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(580, 60, 100, 30);
		Searchjp1.add(checkouttimejl);

		

		bedtypejl.setFont(font);
		bedtypejl.setBounds(100, 90, 100, 30);
		Searchjp1.add(bedtypejl);

		allbed.setFont(font);
		allbed.setSelected(true);
		allbed.setBounds(150, 90, 80, 30);
		Searchjp1.add(allbed);
		allbed.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					chooseAllBeds=true;
					updateHotelListPanel();
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					chooseAllBeds=false;
					updateHotelListPanel();
				}
			}
		});

		BedItemListenner bedItemListenner = new BedItemListenner();
		
		onebed.setFont(font);
		onebed.setBounds(250, 90, 70, 30);
		Searchjp1.add(onebed);
		onebed.addItemListener(bedItemListenner);

		twobed.setFont(font);
		twobed.setBounds(350, 90, 70, 30);
		twobed.addItemListener(bedItemListenner);
		Searchjp1.add(twobed);

		threebed.setFont(font);
		threebed.setBounds(450, 90, 70, 30);
		threebed.addItemListener(bedItemListenner);
		Searchjp1.add(threebed);

		fourbed.setFont(font);
		fourbed.setBounds(550, 90, 70, 30);
		fourbed.addItemListener(bedItemListenner);
		Searchjp1.add(fourbed);

		manybed.setFont(font);
		manybed.setBounds(650, 90, 100, 30);
		manybed.addItemListener(bedItemListenner);
		Searchjp1.add(manybed);

		allprice.setFont(font);
		allprice.setSelected(true);
		allprice.setBounds(150, 120, 100, 30);
		Searchjp1.add(allprice);
		allprice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					chooseAllPrice=true;
					updateHotelListPanel();
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					chooseAllPrice=false;
					updateHotelListPanel();
				}
			}
		});

		PriceItemListenner priceItemListenner = new PriceItemListenner();
		
		price1.setFont(font);
		price1.setBounds(350, 120, 150, 30);
		Searchjp1.add(price1);
		price1.addItemListener(priceItemListenner);

		price2.setFont(font);
		price2.setBounds(550, 120, 150, 30);
		Searchjp1.add(price2);
		price2.addItemListener(priceItemListenner);

		price3.setFont(font);
		price3.setBounds(150, 150, 150, 30);
		Searchjp1.add(price3);
		price3.addItemListener(priceItemListenner);

		price4.setFont(font);
		price4.setBounds(350, 150,150, 30);
		Searchjp1.add(price4);
		price4.addItemListener(priceItemListenner);

		price5.setFont(font);
		price5.setBounds(550, 150,150, 30);
		Searchjp1.add(price5);
		price5.addItemListener(priceItemListenner);

		pricejl.setFont(font);
		pricejl.setBounds(100, 120, 100, 30);
		Searchjp1.add(pricejl);

		Searchllintjp1.setBounds(50, 90, 700, 2);
		Searchllintjp1.setBackground(color);
		Searchjp1.add(Searchllintjp1);

		Searchllintjp2.setBounds(50, 120, 700, 2);
		Searchllintjp2.setBackground(color);
		Searchjp1.add(Searchllintjp2);

		Searchllintjp3.setBounds(50, 178, 700, 2);
		Searchllintjp3.setBackground(color);
		Searchjp1.add(Searchllintjp3);

		Searchllintjp4.setBounds(50, 20, 2, 160);
		Searchllintjp4.setBackground(color);
		Searchjp1.add(Searchllintjp4);

		Searchllintjp5.setBounds(748, 20, 2, 160);
		Searchllintjp5.setBackground(color);
		Searchjp1.add(Searchllintjp5);

	}

	public void addCompSearchjjp2() {

		Searchjp2.setLayout(null);
		Searchjp2.setBackground(Color.white);
		Searchjp2.setBounds(0, 180, 800, 90);
		// this.add(Searchjp2);

		starjl.setFont(font);
		starjl.setBounds(100, 0, 100, 30);
		Searchjp2.add(starjl);

		allstar.setFont(font);
		allstar.setSelected(true);
		allstar.setBounds(150, 0, 70, 30);
		Searchjp2.add(allstar);
		allstar.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					chooseAllStar=true;
					updateHotelListPanel();
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					chooseAllStar=false;
					updateHotelListPanel();
				}
			}
		});

		StarItemListenner starItemListenner = new StarItemListenner();
		
		star1.setFont(font);
		star1.setBounds(250, 0, 70, 30);
		Searchjp2.add(star1);
		star1.addItemListener(starItemListenner);

		star2.setFont(font);
		star2.setBounds(350, 0, 70, 30);
		Searchjp2.add(star2);
		star2.addItemListener(starItemListenner);
		
		star3.setFont(font);
		star3.setBounds(450, 0, 70, 30);
		Searchjp2.add(star3);
		star3.addItemListener(starItemListenner);
		
		star4.setFont(font);
		star4.setBounds(550, 0, 70, 30);
		Searchjp2.add(star4);
		star4.addItemListener(starItemListenner);

		star5.setFont(font);
		star5.setBounds(650, 0, 70, 30);
		Searchjp2.add(star5);
		star5.addItemListener(starItemListenner);

		scorejl.setFont(font);
		scorejl.setBounds(100, 30, 100, 30);
		Searchjp2.add(scorejl);

		allscore.setFont(font);
		allscore.setSelected(true);
		allscore.setBounds(150, 30, 70, 30);
		Searchjp2.add(allscore);
		allscore.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					chooseAllScore=true;
					updateHotelListPanel();
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					chooseAllScore=false;
					updateHotelListPanel();
				}
			}
		});
		
		ScoreItemListenner scoreItemListenner = new ScoreItemListenner();
		
		score1.setFont(font);
		score1.setBounds(250, 30, 70, 30);
		Searchjp2.add(score1);
		score1.addItemListener(scoreItemListenner);
		
		score2.setFont(font);
		score2.setBounds(350, 30, 70, 30);
		Searchjp2.add(score2);
		score2.addItemListener(scoreItemListenner);

		score3.setFont(font);
		score3.setBounds(450, 30, 70, 30);
		Searchjp2.add(score3);
		score3.addItemListener(scoreItemListenner);

		score4.setFont(font);
		score4.setBounds(550, 30, 70, 30);
		Searchjp2.add(score4);
		score4.addItemListener(scoreItemListenner);

		score5.setFont(font);
		score5.setBounds(650, 30, 70, 30);
		Searchjp2.add(score5);
		score5.addItemListener(scoreItemListenner);

		orderstatejl.setFont(font);
		orderstatejl.setBounds(100, 60, 100, 30);
		Searchjp2.add(orderstatejl);

		allstate.setFont(font);
		allstate.setSelected(true);
		allstate.setBounds(150, 60, 70, 30);
		Searchjp2.add(allstate);
		allstate.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					chooseAllState=true;
					updateHotelListPanel();
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					chooseAllState=false;
					updateHotelListPanel();
				}
			}
		});

		OrderStateItemListenner orderStateItemListenner = new OrderStateItemListenner();
		
		state1.setFont(font);
		state1.setBounds(250, 60,100, 30);
		Searchjp2.add(state1);
		state1.addItemListener(orderStateItemListenner);

		state2.setFont(font);
		state2.setBounds(350, 60, 100, 30);
		Searchjp2.add(state2);
		state2.addItemListener(orderStateItemListenner);

		state3.setFont(font);
		state3.setBounds(450, 60, 70, 30);
		Searchjp2.add(state3);
		state3.addItemListener(orderStateItemListenner);

		state4.setFont(font);
		state4.setBounds(550, 60, 70, 30);
		Searchjp2.add(state4);
		state4.addItemListener(orderStateItemListenner);

		Searchllintjp10.setBounds(50, 30, 700, 2);
		Searchllintjp10.setBackground(color);
		Searchjp2.add(Searchllintjp10);

		Searchllintjp6.setBounds(50, 60, 700, 2);
		Searchllintjp6.setBackground(color);
		Searchjp2.add(Searchllintjp6);

		Searchllintjp7.setBounds(50, 88, 700, 2);
		Searchllintjp7.setBackground(color);
		Searchjp2.add(Searchllintjp7);

		Searchllintjp8.setBounds(50, 0, 2, 90);
		Searchllintjp8.setBackground(color);
		Searchjp2.add(Searchllintjp8);

		Searchllintjp9.setBounds(748, 0, 2, 90);
		Searchllintjp9.setBackground(color);
		Searchjp2.add(Searchllintjp9);

		lesssearchjp.setBackground(color);
		lesssearchjp.setBounds(300, 270, 200, 30);
		lessinfo.setForeground(Color.black);
		lessinfo.setFont(font);
		lessinfo.setBounds(0, 0, 200, 30);
		lesssearchjp.add(lessinfo);
		lesssearchjp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				SearchHoteltoClient_JPanel.this.remove(Searchjp2);
				SearchHoteltoClient_JPanel.this.add(moresearchjp);
				SearchHoteltoClient_JPanel.this.remove(lesssearchjp);
				SearchHoteltoClient_JPanel.this.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});

	}

	public void addComp() {

	}

	public void addSortComp() {

		popularsortjl.setFont(font);
		popularsortjl.setBounds(20, 5, 100, 30);
		sortjp.add(popularsortjl);

		popularSortUpjb.setBounds(90, 5, 20, 14);
		popularSortUpjb.setBorder(null);
		sortjp.add(popularSortUpjb);
		popularSortUpjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.MULTIPLE_HIGH_TO_LOW);
			}
		});

		popularSortDownjb.setBounds(90, 20, 20, 15);
		popularSortDownjb.setBorder(null);
		sortjp.add(popularSortDownjb);
		popularSortDownjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.MULTIPLE_LOW_TO_HIGH);
			}
		});

		pricesortjl.setFont(font);
		pricesortjl.setBounds(195, 5, 100, 30);
		sortjp.add(pricesortjl);

		priceSortUpjb.setBounds(245, 5, 20, 14);
		priceSortUpjb.setBorder(null);
		sortjp.add(priceSortUpjb);
		priceSortUpjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.PRICE_HIGH_TO_LOW);
			}
		});

		priceSortDownjb.setBounds(245, 20, 20, 15);
		priceSortDownjb.setBorder(null);
		sortjp.add(priceSortDownjb);
		priceSortDownjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.PRICE_LOW_TO_HIGH);
			}
		});

		starsortjl.setFont(font);
		starsortjl.setBounds(370, 5, 100, 30);
		sortjp.add(starsortjl);

		starSortUpjb.setBounds(420, 5, 20, 14);
		starSortUpjb.setBorder(null);
		sortjp.add(starSortUpjb);
		starSortUpjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.STARLEVEL_HIGH_TO_LOW);
			}
		});

		starSortDownjb.setBounds(420, 20, 20, 15);
		starSortDownjb.setBorder(null);
		sortjp.add(starSortDownjb);
		starSortDownjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.STARLEVEL_LOW_TO_HIGH);
			}
		});

		scoresortjl.setFont(font);
		scoresortjl.setBounds(545, 5, 100, 30);
		sortjp.add(scoresortjl);

		scoreSortUpjb.setBounds(595, 5, 20, 14);
		scoreSortUpjb.setBorder(null);
		sortjp.add(scoreSortUpjb);
		scoreSortUpjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.SCORE_HIGH_TO_LOW);
			}
		});

		scoreSortDownjb.setBounds(595, 20, 20, 15);
		scoreSortDownjb.setBorder(null);
		sortjp.add(scoreSortDownjb);
		scoreSortDownjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sortHotel(HotelSortType.SCORE_LOW_TO_HIGH);
			}
		});

		sortjp.setBackground(color);
		sortjp.setLayout(null);
		sortjp.setBounds(50, 240, 700, 40);
		this.add(sortjp);

	}

	public void addmoreSearchComp() {

		moresearchjp.setLayout(null);
		moresearchjp.setBackground(color);
		moresearchjp.setBounds(300, 180, 200, 30);
		moresearchjp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				SearchHoteltoClient_JPanel.this.remove(moresearchjp);
				SearchHoteltoClient_JPanel.this.remove(sortjp);
				SearchHoteltoClient_JPanel.this.add(Searchjp2);

				SearchHoteltoClient_JPanel.this.add(lesssearchjp);
				SearchHoteltoClient_JPanel.this.add(sortjp);
				SearchHoteltoClient_JPanel.this.repaint();
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
		this.add(moresearchjp);

		moreinfo.setFont(font);
		moreinfo.setBounds(0, 0, 200, 30);
		moresearchjp.add(moreinfo);

	}

	class BedItemListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox)e.getItem();
			BedType type = bedMap.get(box.getText());
			if(e.getStateChange()==ItemEvent.SELECTED){
				bedTypes.add(type);
			}
			if(e.getStateChange()==ItemEvent.DESELECTED){
				bedTypes.remove(type);
			}
			updateHotelListPanel();
		}
		
	}
	class PriceItemListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox)e.getItem();
			Integer low = priceMap.get(box.getText());
			if(e.getStateChange()==ItemEvent.SELECTED){
				lowPrice.add(low);
				if(low!=800){
					highPrice.add(low+200);
				}else{
					highPrice.add(Integer.MAX_VALUE);
				}
			}
			if(e.getStateChange()==ItemEvent.DESELECTED){
				lowPrice.remove(new Integer(low));
				if(low!=800){
					highPrice.remove(new Integer(low+200));
				}else{
					highPrice.remove(new Integer(Integer.MAX_VALUE));
				}
			}
			updateHotelListPanel();
		}
		
		
	}
	class StarItemListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox)e.getItem();
			Integer star = starMap.get(box.getText());
			if(e.getStateChange()==ItemEvent.SELECTED){
				starArrayList.add(star);
			}
			if(e.getStateChange()==ItemEvent.DESELECTED){
				starArrayList.remove(new Integer(star));
			}
			updateHotelListPanel();
		}
		
	}
	class OrderStateItemListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox)e.getItem();
			OrderState state = stateMap.get(box.getText());
			if(e.getStateChange()==ItemEvent.SELECTED){
				orderStates.add(state);
			}
			if(e.getStateChange()==ItemEvent.DESELECTED){
				orderStates.remove(state);
			}
			updateHotelListPanel();
		}
		
	}
	class ScoreItemListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox)e.getItem();
			Double score = scoreMap.get(box.getText());
			if(e.getStateChange()==ItemEvent.SELECTED){
				allLowScoreNumbers.add(score);
				allHighScoreNumbers.add(score+1);
			}
			if(e.getStateChange()==ItemEvent.DESELECTED){
				allLowScoreNumbers.remove(new Double(score));
				allHighScoreNumbers.remove(new Double(score+1));
			}
			updateHotelListPanel();
		}
		
	}
	public void updateHotelListPanel(){
		if(chooseAllBeds){
			vo.setBedTypes(allBedTypes);
		}else{
			vo.setBedTypes(bedTypes);
		}
		if(chooseAllPrice){
			vo.setHighPrice(allHighPrice);
			vo.setLowPrice(allLowPrice);
		}else{
			vo.setHighPrice(highPrice);
			vo.setLowPrice(lowPrice);
		}
		if(chooseAllScore){
			vo.setHighRemarkNumbers(allHighScoreNumbers);
			vo.setLowRemarkNumbers(allLowScoreNumbers);
		}else{
			vo.setHighRemarkNumbers(highScoreNumbers);
			vo.setLowRemarkNumbers(lowScoreNumbers);
		}
		if(chooseAllState){
			vo.setOrderStates(null);
		}else{
			vo.setOrderStates(orderStates);
		}
		if(chooseAllStar){
			vo.setStars(allStarArrayList);
		}else{
			vo.setStars(starArrayList);
		}
		
		vo.setHotelSortType(null);
		
		if((!fromtimejtf.getText().equals("请选择日期"))&&(!fromtimejtf.getText().equals(""))){
			vo.setCheckinTime(new Date(TransHelper.stringToDate(fromtimejtf.getText())));
		}
		if((!totimejtf.getText().equals("请选择日期"))&&(!totimejtf.getText().equals(""))){
			vo.setCheckoutTime(new Date(TransHelper.stringToDate(totimejtf.getText())));
		}
		if((!searchjtf.getText().equals("请输入酒店名称"))&&(!searchjtf.getText().equals(""))){
			vo.setHotelName(searchjtf.getText());
		}
		else if(searchjtf.getText().equals("")){
			vo.setHotelName(null);
		}
		HotelListPane_JPanel pane_JPanel = new HotelListPane_JPanel(vo, ViewTag.HOTELRESERVERSION);
		searchHotelPane_JPanel.setHotelListPanePanel(pane_JPanel);
//		searchHotelPane_JPanel.hotelListPane_JPanel.change(vo);;

	}
	public void sortHotel(HotelSortType type){
		vo.setHotelSortType(type);
		HotelListPane_JPanel pane_JPanel = new HotelListPane_JPanel(vo, ViewTag.HOTELRESERVERSION);
		searchHotelPane_JPanel.setHotelListPanePanel(pane_JPanel);
//		vo.setHotelSortType(type);
//		searchHotelPane_JPanel.hotelListPane_JPanel.change(vo);;
	}
}

