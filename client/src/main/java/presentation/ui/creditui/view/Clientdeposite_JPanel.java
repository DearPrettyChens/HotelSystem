package presentation.ui.creditui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.creditui.distributecontroller.CreditDistributionController;
import presentation.ui.creditui.viewcontroller.DepositCreditViewControllerImpl;
import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import vo.personnelvo.PersonDetailVO;

/**
 * 进行信用充值的界面
 * 
 * 确认按钮还未设置监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Clientdeposite_JPanel extends JPanel {
	private Font font = new Font("宋体", Font.BOLD, 16);

	private JLabel idjl = new JLabel();
	private JLabel namejl = new JLabel();
	private JLabel teljl = new JLabel();
	private JLabel creditjl = new JLabel();
	private JLabel depositjl = new JLabel("充值信用值");
	private JLabel depositinfojl = new JLabel("(充值信用值=金额*100)");

	private JTextField depositenumberjtf = new JTextField();

	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	private CreditDistributionController creditDistributionController;
	/**
	 * 应该设置控件往里面填吧，通过监听获取
	 */
	private String id;
	private String name;
	private String tel;
	private String credit;

	private MyButton confirmjb = new MyButton();
	private MyButton canclejb = new MyButton();

	private DepositCreditViewControllerImpl depositCreditViewControllerImpl = DepositCreditViewControllerImpl
			.getInstance(null);

	public Clientdeposite_JPanel(String id) {
		setPersonDetailInfo(id);
		creditDistributionController = CreditDistributionController.getInstance(id);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();

		this.setBounds(0, 0, 800, 600);

	}

	private void setPersonDetailInfo(String id) {
		PersonDetailVO personDetailVO = personnelDistributionController.getPersonDetail(id);
		this.id = personDetailVO.getId();
		this.name = personDetailVO.getName();
		this.tel = personDetailVO.getTelephone();
		this.credit = String.valueOf(personDetailVO.getCredit());
	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		idjl.setText("I   D:       " + id);
		idjl.setFont(font);
		idjl.setBounds(300, 80, 200, 30);
		this.add(idjl);

		namejl.setText("姓名:       " + name);
		namejl.setFont(font);
		namejl.setBounds(300, 140, 200, 30);
		this.add(namejl);

		teljl.setText("电话:       " + tel);
		teljl.setFont(font);
		teljl.setBounds(300, 200, 200, 30);
		this.add(teljl);

		creditjl.setText("信用：     " + credit);
		creditjl.setFont(font);
		creditjl.setBounds(300, 260, 200, 30);
		this.add(creditjl);

		depositjl.setFont(font);
		depositjl.setBounds(260, 330, 200, 30);
		this.add(depositjl);

		depositenumberjtf.setBounds(370, 330, 120, 30);

		this.add(depositenumberjtf);

		depositinfojl.setFont(font);
		depositinfojl.setBounds(280, 370, 400, 30);
		this.add(depositinfojl);

		confirmjb.setText("确认");
		confirmjb.setBounds(280, 460, 80, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 钱还是信用值？
				// 正整数
				if (depositenumberjtf.getText().matches("^\\+?[1-9][0-9]*$")) {
					creditDistributionController.confirmCreditDeposit(Double.parseDouble(depositenumberjtf.getText()),
							id);
				}
			}
		});

		canclejb.setText("取消");
		canclejb.setBounds(380, 460, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				depositCreditViewControllerImpl.jumpToSearchPanel();

			}
		});

	}

}
