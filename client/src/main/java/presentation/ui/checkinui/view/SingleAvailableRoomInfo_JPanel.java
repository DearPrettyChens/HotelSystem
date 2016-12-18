package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import presentation.ui.availableroomui.view.SingleRoomInfo_JPanel;
import presentation.ui.checkinui.distributecontroller.CheckinDistributionController;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

/**
 * 单条的可用客房信息，用来进行用户线下入住退房
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleAvailableRoomInfo_JPanel extends JPanel {

	private String bedtype;
	 private String roomtype;
	private int number;
	private String hotelID;

	private BedType bedType2;

	private Font font = new Font("宋体", Font.BOLD, 16);

	private Font errorfont=new Font("宋体",Font.BOLD, 10);
	
	private JLabel bedtypejl = new JLabel("床型：");
	private JLabel roomtypejl = new JLabel("房型：");
	private JLabel numberjl = new JLabel("数量：");

	JLabel saveError=new JLabel("不能为空");

	JLabel numError=new JLabel("请输入正数");
	
	
	private JTextField numberjtf = new JTextField();
	private CheckinDistributionController controller=CheckinDistributionController.getInstance();

	public SingleAvailableRoomInfo_JPanel(AvailableRoomInfoVO availableRoomInfoVO) {

		this.bedType2 = availableRoomInfoVO.getBedType();
		this.bedtype = bedType2.toChinese();

		this.hotelID=availableRoomInfoVO.getHotelNumber();
		 this.roomtype=availableRoomInfoVO.getRoomType();
		this.number = availableRoomInfoVO.getCurrentNumber();
        numError.setText("请输入0～"+number+"之间的数");
		
		bedtypejl.setText("床型："+bedtype);

		roomtypejl.setText("房型："+roomtype);

		numberjtf.setText(number + "");

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800, 50);
		addComp();

	}

	public SingleAvailableRoomInfo_JPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800, 50);
		addComp();

	}

	public void addComp() {

		bedtypejl.setFont(font);
		bedtypejl.setBounds(60, 10, 120, 30);
		this.add(bedtypejl);

		roomtypejl.setFont(font);
		roomtypejl.setBounds(260, 10, 120, 30);
		this.add(roomtypejl);

		numberjl.setFont(font);
		numberjl.setBounds(460, 10, 80, 30);
		this.add(numberjl);

		numberjtf.setFont(font);
		numberjtf.setBounds(520, 10, 80, 30);
		this.add(numberjtf);

		this.setLayout(null);
		
		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(600,15,100,20);
		this.add(saveError);
		saveError.setVisible(false);
		
		numError.setForeground(Color.RED);
		numError.setFont(errorfont);
		numError.setBounds(600, 15, 200, 20);
		this.add(numError);
		numError.setVisible(false);

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
	
	public void recoverRoom(){
		numberjtf.setText(number + "");
	}
	
	public ResultMessage saveRoom(){
		if(numberjtf.getText().equals("")){
			saveError.setVisible(true);
			return ResultMessage.FAIL;
		}else if(!numberjtf.getText().matches("[0-9]*")){
			numError.setVisible(true);
			return ResultMessage.FAIL;
		}
		else{
			AvailableRoomNumberVO info=new AvailableRoomNumberVO(Integer.parseInt(numberjtf.getText()),
					this.bedType2,new Date(),hotelID);
			if(controller.confirmAvailableRoomNumber(info)==ResultMessage.SUCCESS){
				return ResultMessage.SUCCESS;
			}
			else{
				//保存失败
				return ResultMessage.FAIL;
			}
		}
	}
}
