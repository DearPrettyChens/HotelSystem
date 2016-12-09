package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyTextfield;
import util.City;
import util.TradingArea;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 顾客的搜索栏
 * 
 * 未实现复选框的监听。复选框的监听是实时的，只要选中一个，就会刷新酒店列表，每次传的hotelsearchinfovo是所有选中的复选框。
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHoteltoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color color = new Color(148, 221, 184);

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

	private MyTextfield fromtimejtf = new MyTextfield("请选择日期");
	private MyTextfield totimejtf = new MyTextfield("请选择日期");

	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy/MM/dd");
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy/MM/dd");

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

	private JCheckBox allprice = new JCheckBox("不限");
	private JCheckBox price1 = new JCheckBox("￥200以下");
	private JCheckBox price2 = new JCheckBox("￥200-400");
	private JCheckBox price3 = new JCheckBox("￥400-600");
	private JCheckBox price4 = new JCheckBox("￥600-800");
	private JCheckBox price5 = new JCheckBox("￥800以上");

	private JCheckBox allstar = new JCheckBox("不限");
	private JCheckBox star1 = new JCheckBox("1星");
	private JCheckBox star2 = new JCheckBox("2星");
	private JCheckBox star3 = new JCheckBox("3星");
	private JCheckBox star4 = new JCheckBox("4星");
	private JCheckBox star5 = new JCheckBox("5星");

	private JCheckBox allscore = new JCheckBox("不限");
	private JCheckBox score1 = new JCheckBox("<=1");
	private JCheckBox score2 = new JCheckBox("1~2");
	private JCheckBox score3 = new JCheckBox("2~3");
	private JCheckBox score4 = new JCheckBox("3~4");
	private JCheckBox score5 = new JCheckBox("4~5");

	private JCheckBox allstate = new JCheckBox("不限");
	private JCheckBox state1 = new JCheckBox("未执行");
	private JCheckBox state2 = new JCheckBox("已执行");
	private JCheckBox state3 = new JCheckBox("异常");
	private JCheckBox state4 = new JCheckBox("撤销");

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

	public SearchHoteltoClient_JPanel(HotelSearchInfoVO hotelSearchInfoVO) {

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

		fromtimejtf.setBounds(400, 65, 100, 25);
		Searchjp1.add(fromtimejtf);
		p1.initCalendarPanel();
		JLabel l1 = new JLabel("日历面板");
		p1.add(l1);
		this.add(p1);

		totimejtf.setBounds(550, 65, 100, 25);
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

		cityjl.setText("城市：");
		cityjl.setFont(font);
		cityjl.setBounds(100, 60, 80, 30);
		Searchjp1.add(cityjl);

		tradingareajl.setText("商圈：");
		tradingareajl.setFont(font);
		tradingareajl.setBounds(300, 60, 100, 30);
		Searchjp1.add(tradingareajl);

		citycomboBox.addItem("南京");
		citycomboBox.setSelectedItem(city);
		citycomboBox.setBounds(180, 60, 100, 30);
		this.add(citycomboBox);

		tradingareacomboBox.addItem("新街口");
		tradingareacomboBox.addItem("湖南路");
		tradingareacomboBox.setSelectedItem(tradingarea);
		tradingareacomboBox.setBounds(400, 60, 100, 30);
		this.add(tradingareacomboBox);

		checkintimejl.setFont(font);
		checkintimejl.setBounds(360, 60, 150, 30);
		Searchjp1.add(checkintimejl);

		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(510, 60, 100, 30);
		Searchjp1.add(checkouttimejl);

		tradingareajl.setText("商圈：" + tradingarea);
		tradingareajl.setFont(font);
		tradingareajl.setBounds(200, 60, 150, 30);
		Searchjp1.add(tradingareajl);

		bedtypejl.setFont(font);
		bedtypejl.setBounds(100, 90, 100, 30);
		Searchjp1.add(bedtypejl);

		allbed.setFont(font);
		allbed.setSelected(true);
		allbed.setBounds(150, 90, 80, 30);
		Searchjp1.add(allbed);

		onebed.setFont(font);
		onebed.setBounds(250, 90, 80, 30);
		Searchjp1.add(onebed);

		twobed.setFont(font);
		twobed.setBounds(350, 90, 80, 30);
		Searchjp1.add(twobed);

		threebed.setFont(font);
		threebed.setBounds(450, 90, 80, 30);
		Searchjp1.add(threebed);

		fourbed.setFont(font);
		fourbed.setBounds(550, 90, 80, 30);
		Searchjp1.add(fourbed);

		manybed.setFont(font);
		manybed.setBounds(650, 90, 80, 30);
		Searchjp1.add(manybed);

		allprice.setFont(font);
		allprice.setSelected(true);
		allprice.setBounds(150, 120, 280, 30);
		Searchjp1.add(allprice);

		price1.setFont(font);
		price1.setBounds(350, 120, 280, 30);
		Searchjp1.add(price1);

		price2.setFont(font);
		price2.setBounds(550, 120, 280, 30);
		Searchjp1.add(price2);

		price3.setFont(font);
		price3.setBounds(150, 150, 280, 30);
		Searchjp1.add(price3);

		price4.setFont(font);
		price4.setBounds(350, 150, 280, 30);
		Searchjp1.add(price4);

		price5.setFont(font);
		price5.setBounds(550, 150, 280, 30);
		Searchjp1.add(price5);

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
		allstar.setBounds(150, 0, 280, 30);
		Searchjp2.add(allstar);

		star1.setFont(font);
		star1.setBounds(250, 0, 280, 30);
		Searchjp2.add(star1);

		star2.setFont(font);
		star2.setBounds(350, 0, 280, 30);
		Searchjp2.add(star2);

		star3.setFont(font);
		star3.setBounds(450, 0, 280, 30);
		Searchjp2.add(star3);

		star4.setFont(font);
		star4.setBounds(550, 0, 280, 30);
		Searchjp2.add(star4);

		star5.setFont(font);
		star5.setBounds(650, 0, 280, 30);
		Searchjp2.add(star5);

		scorejl.setFont(font);
		scorejl.setBounds(100, 30, 100, 30);
		Searchjp2.add(scorejl);

		allscore.setFont(font);
		allscore.setSelected(true);
		allscore.setBounds(150, 30, 280, 30);
		Searchjp2.add(allscore);

		score1.setFont(font);
		score1.setBounds(250, 30, 280, 30);
		Searchjp2.add(score1);

		score2.setFont(font);
		score2.setBounds(350, 30, 280, 30);
		Searchjp2.add(score2);

		score3.setFont(font);
		score3.setBounds(450, 30, 280, 30);
		Searchjp2.add(score3);

		score4.setFont(font);
		score4.setBounds(550, 30, 280, 30);
		Searchjp2.add(score4);

		score5.setFont(font);
		score5.setBounds(650, 30, 280, 30);
		Searchjp2.add(score5);

		orderstatejl.setFont(font);
		orderstatejl.setBounds(100, 60, 100, 30);
		Searchjp2.add(orderstatejl);

		allstate.setFont(font);
		allstate.setSelected(true);
		allstate.setBounds(150, 60, 280, 30);
		Searchjp2.add(allstate);

		state1.setFont(font);
		state1.setBounds(250, 60, 280, 30);
		Searchjp2.add(state1);

		state2.setFont(font);
		state2.setBounds(350, 60, 280, 30);
		Searchjp2.add(state2);

		state3.setFont(font);
		state3.setBounds(450, 60, 280, 30);
		Searchjp2.add(state3);

		state4.setFont(font);
		state4.setBounds(550, 60, 280, 30);
		Searchjp2.add(state4);

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
				// TODO Auto-generated method stub

				SearchHoteltoClient_JPanel.this.remove(Searchjp2);
				SearchHoteltoClient_JPanel.this.add(moresearchjp);
				SearchHoteltoClient_JPanel.this.remove(lesssearchjp);
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

		popularSortDownjb.setBounds(90, 20, 20, 15);
		popularSortDownjb.setBorder(null);
		sortjp.add(popularSortDownjb);

		pricesortjl.setFont(font);
		pricesortjl.setBounds(195, 5, 100, 30);
		sortjp.add(pricesortjl);

		priceSortUpjb.setBounds(245, 5, 20, 14);
		priceSortUpjb.setBorder(null);
		sortjp.add(priceSortUpjb);

		priceSortDownjb.setBounds(245, 20, 20, 15);
		priceSortDownjb.setBorder(null);
		sortjp.add(priceSortDownjb);

		starsortjl.setFont(font);
		starsortjl.setBounds(370, 5, 100, 30);
		sortjp.add(starsortjl);

		starSortUpjb.setBounds(420, 5, 20, 14);
		starSortUpjb.setBorder(null);
		sortjp.add(starSortUpjb);

		starSortDownjb.setBounds(420, 20, 20, 15);
		starSortDownjb.setBorder(null);
		sortjp.add(starSortDownjb);

		scoresortjl.setFont(font);
		scoresortjl.setBounds(545, 5, 100, 30);
		sortjp.add(scoresortjl);

		scoreSortUpjb.setBounds(595, 5, 20, 14);
		scoreSortUpjb.setBorder(null);
		sortjp.add(scoreSortUpjb);

		scoreSortDownjb.setBounds(595, 20, 20, 15);
		scoreSortDownjb.setBorder(null);
		sortjp.add(scoreSortDownjb);

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

}
