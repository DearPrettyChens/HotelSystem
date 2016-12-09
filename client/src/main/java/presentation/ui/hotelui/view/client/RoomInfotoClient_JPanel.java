package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.webstrategyui.view.Singlewebclientlevelstr_Jpanel;
import util.ViewTag;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * 顾客查看房型列表的面板
 * 
 * 未实现搜索的监听和调用
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class RoomInfotoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color color = new Color(148, 221, 184);

	private MyTextfield fromtimejtf = new MyTextfield("请选择日期");
	private MyTextfield totimejtf = new MyTextfield("请选择日期");

	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy/MM/dd");
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy/MM/dd");

	private MyButton searchjb = new MyButton();

	private ArrayList<SingleRoomInfotoClient_JPanel> singleinfos = new ArrayList<SingleRoomInfotoClient_JPanel>();
	
	private JPanel titlejp = new JPanel();
	private JLabel roomtypejl = new JLabel("房型");
	private JLabel bedtypejl = new JLabel("床型");
	private JLabel pricejl = new JLabel("价格");

	private JLabel checkinjl = new JLabel("入住");
	private JLabel checkoutjl = new JLabel("退房");

	private ViewTag tag;
	private ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs;
	public RoomInfotoClient_JPanel(ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs,ViewTag tag) {
        this.tag=tag;
		this.availableRoomInfoVOs=availableRoomInfoVOs;
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
        addSingle();
	}


	public void addComp() {

		fromtimejtf.setBounds(160, 10, 150, 30);

		this.add(fromtimejtf);

		p1.initCalendarPanel();
		JLabel l1 = new JLabel("日历面板");
		p1.add(l1);
		this.add(p1);

		checkinjl.setBounds(100, 10, 100, 30);
		checkinjl.setFont(font);
		this.add(checkinjl);

		totimejtf.setBounds(420, 10, 150, 30);

		this.add(totimejtf);

		p2.initCalendarPanel();
		JLabel l2 = new JLabel("日历面板");
		p2.add(l2);
		this.add(p2);

		checkoutjl.setBounds(360, 10, 100, 30);
		checkoutjl.setFont(font);
		this.add(checkoutjl);

		titlejp.setBackground(color);
		titlejp.setLayout(null);
		titlejp.setBounds(50, 50, 700, 50);
		this.add(titlejp);

		roomtypejl.setFont(font);
		roomtypejl.setBounds(50, 10, 100, 30);
		titlejp.add(roomtypejl);

		bedtypejl.setFont(font);
		bedtypejl.setBounds(225, 10, 100, 30);
		titlejp.add(bedtypejl);

		pricejl.setFont(font);
		pricejl.setBounds(400, 10, 100, 30);
		titlejp.add(pricejl);

		searchjb.setText("搜索");
		searchjb.setBounds(650, 10, 100, 30);
		this.add(searchjb);

		int size = singleinfos.size();
		for (int i = 0; i < size; i++) {

			SingleRoomInfotoClient_JPanel tempinfo = singleinfos.get(i);
			tempinfo.setBounds(0, 100 + i * 50, 800, 50);
			this.add(tempinfo);

		}

	}

	public void addSingle(){
		for(AvailableRoomInfoVO availableRoomInfoVO:availableRoomInfoVOs){
			SingleRoomInfotoClient_JPanel singleRoomInfotoClient_JPanel=new SingleRoomInfotoClient_JPanel(availableRoomInfoVO,tag);
		    singleinfos.add(singleRoomInfotoClient_JPanel);
		}
		
		for(int i=0;i<singleinfos.size();i++){
			SingleRoomInfotoClient_JPanel singleRoomInfotoClient_JPanel = singleinfos.get(i);
			singleRoomInfotoClient_JPanel.setBounds(0, 100 + 60 * i, 800, 60);
			this.add(singleRoomInfotoClient_JPanel);
		}
		this.setSize(780, 100 + 60 * singleinfos.size());
		
	}
}
