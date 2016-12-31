package presentation.ui.availableroomui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import presentation.ui.availableroomui.distributecontroller.AvailableroomDistributionController;
import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import presentation.ui.hotelui.view.ModifyHotelBasicInfo_JPanel;
import presentation.ui.tools.NewClient_JLabel;
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
	private boolean tag=true;
	
	private BedType bedType2;
	
	private JComboBox  bedtypecomboBox = new JComboBox();
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Font errorfont=new Font("宋体",Font.BOLD, 10);
	
	
	private JLabel bedtypejl=new JLabel("床型：");
	private JLabel roomtypejl=new JLabel("房型：");
	private JLabel numberjl=new JLabel("数量：");
	private JLabel pricejl=new JLabel("价格：");
	
	
	private JTextField roomtypejtf=new JTextField();
	private JTextField numberjtf=new JTextField();
	private JTextField pricejtf=new JTextField();
	
	JLabel saveError=new JLabel("不能为空");
	JLabel numError=new JLabel("请输数字");
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
		this.tag=availableRoomInfoVO.isTag();
		
		
		roomtypejtf.setText(roomtype);
		numberjtf.setText(number+"");
		pricejtf.setText(price+"");
		
		
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
		
		
	}

	public SingleRoomInfo_JPanel(String hotelID){
		this.hotelID=hotelID;
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
	}
	
	
	
	public void addComp(){
		
		bedtypejl.setFont(font);
		bedtypejl.setBounds(20,10,80,30);
		this.add(bedtypejl);
		
		
		
		 bedtypecomboBox.setBounds(70,10,100,30);
		 
		for(BedType e:BedType.values()){
			 bedtypecomboBox.addItem(e.toChinese());
		}
		
		 bedtypecomboBox.setBounds(70, 10, 100, 30);
		this.add( bedtypecomboBox);
		if(bedType2!=null){
		bedtypecomboBox.setSelectedItem(bedtype);
		}
		
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
		saveError.setFont(errorfont);
		saveError.setBounds(660,20,100,10);
		SingleRoomInfo_JPanel.this.add(saveError);
		saveError.setVisible(false);
		
		numError.setForeground(Color.RED);
		numError.setFont(errorfont);
		numError.setBounds(660, 20, 100, 10);
		this.add(numError);
		numError.setVisible(false);
		
		Document roomDoc = roomtypejtf.getDocument();
		roomDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				saveError.setVisible(false);

			}

		});
		
		Document priceDoc = pricejtf.getDocument();
		priceDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

		});
		
		Document numDoc = numberjtf.getDocument();
		numDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				saveError.setVisible(false);
				numError.setVisible(false);
			}

		});
		
	}
	/**
	 * 保存房间信息
	 * @return
	 */
	public ResultMessage saveRoom(){
		if(roomtypejtf.getText().equals("")||pricejtf.getText().equals("")
				||numberjtf.getText().equals("")){
			saveError.setVisible(true);
			return ResultMessage.FAIL;
		}
		if(lowestPrice==0){
			lowestPrice=Double.parseDouble(pricejtf.getText());
			
		}
		
		if(!numberjtf.getText().matches("[0-9]*")){
			numError.setVisible(true);
			return ResultMessage.FAIL;
		}
		
		if(!pricejtf.getText().matches("[0-9]*\\.?[0]?")){
			numError.setVisible(true);
			return ResultMessage.FAIL;
		}
		
		AvailableRoomInfoVO room=new AvailableRoomInfoVO(hotelID,roomtypejtf.getText(),
				BedType.toBedType( (String) bedtypecomboBox.getSelectedItem()),Double.parseDouble(pricejtf.getText()),
						lowestPrice,Integer.parseInt(numberjtf.getText()),tag);
		ResultMessage resultMessage=controller.confirmAvailableRoomInfo(hotelID, room);
		if(resultMessage==ResultMessage.SUCCESS){
			tag=false;
		}
		return resultMessage;
	}
	
}
