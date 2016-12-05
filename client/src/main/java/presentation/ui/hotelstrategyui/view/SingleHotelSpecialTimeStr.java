package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.TransHelper;
import vo.hotelstrategyvo.HotelStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 单条的特殊时期优惠
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelSpecialTimeStr  extends JPanel{
	private Font font=new Font("宋体",Font.BOLD, 18);
	private String begintime;
	private String endtime;
	private double count;
	private JLabel begintimejl=new JLabel("起始时间：");
	private JLabel endtimejl=new JLabel("结束时间：");
	private JLabel countjl=new JLabel("折      扣："); 
	private JTextField begintimejtf=new JTextField(); 
	private JTextField endtimejtf=new JTextField();
	private JTextField countjtf=new JTextField();
	
	private Date beginTimeinDate;
	private Date endTimeinDate;
	
	public JTextField getBeginJtf(){
		return this.begintimejtf;
	}
	
	public JTextField getEndJtf(){
		return this.endtimejtf;
	}
	
	public JTextField getCountJtf(){
		return this.countjtf;
	}
	SingleHotelSpecialTimeStr(HotelStrVO hotelStrVO){
		Date[] dates=hotelStrVO.getDate();
		beginTimeinDate=dates[0];
		endTimeinDate=dates[1];
		this.begintime=TransHelper.dateToString(beginTimeinDate);
		this.endtime=TransHelper.dateToString(endTimeinDate);
		this.count=hotelStrVO.getDiscount();
		this.setLayout(null);
		this.setBackground(Color.white);
	    this.setBounds(0,200, 800, 300);

		addComp();
		
	}
	

	
	 /**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	begintimejl.setBounds(300,40,200,30);
	    	begintimejl.setFont(font);
	    	this.add(begintimejl);
	    	
	    	begintimejtf.setBounds(400,40,100,30);
	    	begintimejtf.setText(begintime+"");
	    	this.add(begintimejtf);
	    	
	    	
	    	endtimejl.setBounds(300,120,200,30);
	    	endtimejl.setFont(font);
	    	this.add(endtimejl);
	    	
	    	endtimejtf.setBounds(400,120,100,30);
	    	endtimejtf.setText(endtime+"");
	    	this.add(endtimejtf);
	    	
	    	
	    	countjl.setBounds(300,200,200,30);
	    	countjl.setFont(font);
	    	this.add(countjl);
	    	
	    	countjtf.setBounds(400,200,100,30);
	    	countjtf.setText(count+"");
	    	this.add(countjtf);
	    	
	    	
	    	
	    }
	
	
}
