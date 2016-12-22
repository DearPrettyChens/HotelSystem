package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.JLabelTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.RemarkFail_JFrame;
import presentation.ui.userui.view.Changemessage_JPanel;
import util.ResultMessage;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.RemarkVO;

/**
 * 顾客评价酒店的面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class RemarkHoteltoClient_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);
	private Color color = new Color(148, 221, 184);

	private String hotelname;
	private String hotelID;
	private String orderID;
	private ImageIcon image;

	private JPanel titlejp = new JPanel();
	private JPanel linejp = new JPanel();
	private JLabel titlejl = new JLabel("追加评价", JLabel.CENTER);
	private JLabel hotelnamejl = new JLabel();
	private JLabel imagejl = new JLabel();
	private JLabel scorejl = new JLabel("评分：");
	private JLabel remarkjl = new JLabel("评论:");
	private MyTextfield scorejtf = new MyTextfield("5.0");
	private JTextArea remarkjtf = new JTextArea("来分享一下您的入住体验吧~");
	private MyButton confirmjb = new MyButton();
	private JLabel backjl = new JLabel("< 返回订单列表页面");

	private ImageIcon image1 = new ImageIcon(RemarkHoteltoClient_JPanel.class.getResource("image/longxuxian.png"));
	private ImageIcon image2 = new ImageIcon(RemarkHoteltoClient_JPanel.class.getResource("image/shuxuxian.png"));
	private JLabel bg = new JLabel(image1);
	private JLabel bg1 = new JLabel(image2);

	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();
	private CustomerOrderViewController customerOrderViewController = CustomerOrderViewController.getInstance(null);

	public RemarkHoteltoClient_JPanel(OrderListVO orderListVO) {

		this.hotelname = orderListVO.getHotelName();
		this.image = orderListVO.getHotelIcon();
		this.hotelID=orderListVO.getHotelID();
		this.orderID=orderListVO.getOrderNumber();

		image = ImageTool.getScaledImage(image, 135);
		imagejl.setIcon(image);

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 600);
		addComp();

	}
	
	public RemarkHoteltoClient_JPanel() {

	}


	public void addComp() {
		bg.setBounds(50, 360, 700, 5);
		this.add(bg);

		bg1.setBounds(230, 70, 10, 280);
		this.add(bg1);

		titlejp.setBounds(50, 15, 135, 30);
		titlejp.setBackground(color);
		this.add(titlejp);

		linejp.setBounds(50, 43, 700, 2);
		linejp.setBackground(color);
		this.add(linejp);

		titlejl.setForeground(Color.white);
		titlejl.setFont(font);
		titlejl.setBounds(0, 20, 200, 40);
		titlejp.add(titlejl);

		imagejl.setBounds(50, 105, 135, 135);
		this.add(imagejl);

		hotelnamejl.setBounds(50, 275, 135, 60);
		hotelnamejl.setFont(font);
		try {
			JLabelTool.JlabelSetText(hotelnamejl, hotelname);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.add(hotelnamejl);

		scorejl.setBounds(290, 105, 150, 30);
		scorejl.setFont(font);
		this.add(scorejl);

		remarkjl.setBounds(290, 155, 150, 30);
		remarkjl.setFont(font);
		this.add(remarkjl);

		scorejtf.setBounds(350, 105, 200, 30);
		scorejtf.setFont(font);
		this.add(scorejtf);

		remarkjtf.setBounds(350, 155, 350, 150);
		remarkjtf.setBorder(new LineBorder(Color.gray, 1, false));
		remarkjtf.setForeground(Color.gray);
		remarkjtf.setFont(font);
		this.add(remarkjtf);

		backjl.setForeground(color);
		backjl.setBounds(50, 410, 150, 30);
		backjl.setFont(new Font("宋体", Font.BOLD, 16));
		backjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				customerOrderViewController.returnToOrderListFromRemark();

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backjl.setFont(new Font("宋体", Font.BOLD, 16));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backjl.setFont(new Font("宋体", Font.BOLD, 15));
			}

		});
		this.add(backjl);
		
		JLabel scoreError=new JLabel("请输入0～5之间的数字");
		scoreError.setForeground(Color.RED);
		scoreError.setFont(font);
		scoreError.setBounds(550, 105, 200, 30);
		scoreError.setVisible(false);
		RemarkHoteltoClient_JPanel.this.add(scoreError);
		
		JLabel scoreError2=new JLabel("不能为空");
		scoreError2.setForeground(Color.RED);
		scoreError2.setFont(font);
		scoreError2.setBounds(550,105, 200, 30);
		RemarkHoteltoClient_JPanel.this.add(scoreError2);
		scoreError2.setVisible(false);
		
		Document scoreDoc=scorejtf.getDocument();
		scoreDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				scoreError2.setVisible(false);
				Document doc=e.getDocument();
				try {
					String s = doc.getText(0, doc.getLength());
					if(Double.parseDouble(s)<0||Double.parseDouble(s)>5.0){
						scoreError.setVisible(true);
					}
					else{
						scoreError.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				scoreError2.setVisible(false);
				Document doc=e.getDocument();
				try {
					String s = doc.getText(0, doc.getLength());
					if(Double.parseDouble(s)<0||Double.parseDouble(s)>5.0){
						scoreError.setVisible(true);
					}
					else{
						scoreError.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});

		confirmjb.setText("确认评价");
		confirmjb.setBounds(400, 410, 200, 40);
		this.add(confirmjb);

		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(scorejtf.getText().equals("")){
					scoreError2.setVisible(true);
				}
				else if(Double.parseDouble(scorejtf.getText())>=0&&Double.parseDouble(scorejtf.getText())<=5.0){
					RemarkVO remarkVO=new RemarkVO(orderID,hotelID,Double.parseDouble(scorejtf.getText()),
							remarkjtf.getText());
					if(orderDistributionController.remarkOrder(remarkVO)==ResultMessage.SUCCESS){
						customerOrderViewController.returnToOrderListFromRemark();
					}
					else{
						new RemarkFail_JFrame();
					}
				}
			}
			
		});
	}

}
