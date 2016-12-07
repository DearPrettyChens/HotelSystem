package presentation.ui.creditui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import presentation.ui.creditui.distributecontroller.CreditDistributionController;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;

/**
 * 顾客用来存放单条信用记录的面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ClientCreditInfos_JPanel extends JPanel {

	private ArrayList<SingleCreditinfo_JPanel> singleinfos = new ArrayList<SingleCreditinfo_JPanel>();

	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private String userID;

	private CreditDistributionController controller;

	public ClientCreditInfos_JPanel(String userID) {
		this.userID = userID;
		controller = CreditDistributionController.getInstance(userID);

		this.setBounds(0,0, 800, 600);
		this.setBackground(Color.white);
		this.setLayout(null);
		addComp();

	}

	public void addComp() {
		scrollPane.setBounds(15, 15, 800, 600);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		// 获取信用记录信息
		CreditInfoVO creditInfoVO = controller.getCreditInfo();
		ArrayList<CreditVO> creditVOs = creditInfoVO.getCreditinfo();
		for (CreditVO creditVO : creditVOs) {
			SingleCreditinfo_JPanel singleCreditinfo_JPanel = new SingleCreditinfo_JPanel(creditVO);
			singleinfos.add(singleCreditinfo_JPanel);
		}

		// 设置单条信用记录位置
		int size = singleinfos.size();

		for (int i = 0; i < size; i++) {
			int locy = i / 2;
			int locx = i % 2;

			SingleCreditinfo_JPanel tempinfo = singleinfos.get(i);
			tempinfo.setBounds(locx * 370, locy * 280, 400, 300);
			panel.add(tempinfo);
		}

		int panelSize = (singleinfos.size() + 1) / 2;
		panel.setPreferredSize(new Dimension(780, 50 + 300 * panelSize));
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

}
