package presentation.ui.availableroomui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.availableroomui.distributecontroller.AvailableroomDistributionController;
import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * 
 * 单条的房间信息，在酒店工作人员录入客房信息时作用
 * @author cy
 * @version 1.0
 * 
 */
public class SingleRoomInfo_JPanel  extends JPanel{
	private String hotelID;
	private String bedtype;
	private String roomtype;
	private int number;
	private double price;
	private double lowestPrice;
	private int currentNum;
	
	private BedType bedType2;
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel bedtypejl=new JLabel("床型：");
	private JLabel roomtypejl=new JLabel("房型：");
	private JLabel numberjl=new JLabel("数量：");
	private JLabel pricejl=new JLabel("价格：");
	
	private JTextField bedtypejtf=new JTextField();
	private JTextField roomtypejtf=new JTextField();
	private JTextField numberjtf=new JTextField();
	private JTextField pricejtf=new JTextField();
	
	JLabel saveError=new JLabel("不能为空");
	
	private AvailableroomDistributionController controller=AvailableroomDistributionController.getInstance();
	
	public SingleRoomInfo_JPanel(AvailableRoomInfoVO availableRoomInfoVO){
		this.bedType2=availableRoomInfoVO.getBedType();
		this.bedtype=bedType2.toChinese();
		this.roomtype=availableRoomInfoVO.getRoomType();
		this.number=availableRoomInfoVO.getOriginalNumbers();
		this.price=availableRoomInfoVO.getOriginalPrice();
		this.hotelID=availableRoomInfoVO.getHotelNumber();
		this.lowestPrice=availableRoomInfoVO.getLowestPrice();
		this.currentNum=availableRoomInfoVO.getCurrentNumber();
		
		
		bedtypejtf.setText(bedtype);
		roomtypejtf.setText(roomtype);
		numberjtf.setText(number+"");
		pricejtf.setText(price+"");
		
		
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
		
		
	}

	public SingleRoomInfo_JPanel(){
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
	}
	
	
	
	public void addComp(){
		
		bedtypejl.setFont(font);
		bedtypejl.setBounds(20,10,80,30);
		this.add(bedtypejl);
		
		bedtypejtf.setFont(font);
		bedtypejtf.setBounds(70,10,100,30);
		this.add(bedtypejtf);
		
		roomtypejl.setFont(font);
		roomtypejl.setBounds(190,10,80,30);
		this.add(roomtypejl);
		
		roomtypejtf.setFont(font);
		roomtypejtf.setBounds(240,10,100,30);
		this.add(roomtypejtf);
		
		numberjl.setFont(font);
		numberjl.setBounds(360,10,80,30);
		this.add(numberjl);
		
		numberjtf.setFont(font);
		numberjtf.setBounds(410,10,100,30);
		this.add(numberjtf);
		
		pricejl.setFont(font);
		pricejl.setBounds(530,10,80,30);
		this.add(pricejl);
		
		pricejtf.setFont(font);
		pricejtf.setBounds(580,10,80,30);
		this.add(pricejtf);
		
		
		this.setLayout(null);
		
		

		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(730,10,40,10);
		SingleRoomInfo_JPanel.this.add(saveError);
		saveError.setVisible(false);
		
	}
	/**
	 * 保存房间信息
	 * @return
	 */
	public ResultMessage saveRoom(){
		if(roomtypejtf.getText().equals("")||bedtypejtf.getText().equals("")||pricejtf.getText().equals("")
				||numberjtf.getText().equals("")){
			saveError.setVisible(true);
			return ResultMessage.FAIL;
		}
		AvailableRoomInfoVO room=new AvailableRoomInfoVO(hotelID,roomtypejtf.getText(),
				BedType.toBedType(bedtypejtf.getText()),Double.parseDouble(pricejtf.getText()),
						lowestPrice,Integer.parseInt(numberjtf.getText()));
		return controller.confirmAvailableRoomInfo(hotelID, room);
	}
	
}
