package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	private JLabel bedtypejl = new JLabel("床型：");
	private JLabel roomtypejl = new JLabel("房型：");
	private JLabel numberjl = new JLabel("数量：");

	JLabel saveError=new JLabel("不能为空");
	
	private JTextField numberjtf = new JTextField();
	private CheckinDistributionController controller=CheckinDistributionController.getInstance();

	public SingleAvailableRoomInfo_JPanel(AvailableRoomInfoVO availableRoomInfoVO) {

		this.bedType2 = availableRoomInfoVO.getBedType();
		this.bedtype = bedType2.toChinese();

		this.hotelID=availableRoomInfoVO.getHotelNumber();
		 this.roomtype=availableRoomInfoVO.getRoomType();
		this.number = availableRoomInfoVO.getCurrentNumber();

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
		saveError.setBounds(730,10,40,10);
		SingleAvailableRoomInfo_JPanel.this.add(saveError);
		saveError.setVisible(false);

	}
	
	public void recoverRoom(){
		numberjtf.setText(number + "");
	}
	
	public ResultMessage saveRoom(){
		if(numberjtf.getText().equals("")){
			//saveError.setVisible(true);
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
