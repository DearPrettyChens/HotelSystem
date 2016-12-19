package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.viewcontroller.PersonnelControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.newclient_JLabel;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 网站管理人员搜索的面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Searchperson_JPanel extends JPanel {
	private JButton searchjb = new JButton();
	// private MyButton searchjb=new MyButton();
	private MyTextfield searchjtf = new MyTextfield("用户名/编号");
	private UserType userType;
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();
	private SearchInterface personPanel;

	public Searchperson_JPanel(UserType userType, SearchInterface personPanel) {
		// this.setBackground(new Color(148,221,184));
		this.setBackground(Color.WHITE);
		this.setSize(600, 50);
		this.setLayout(null);
		this.userType = userType;
		this.personPanel = personPanel;
		addComp();
	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		searchjtf.setBounds(120, 25, 550, 40);
		this.add(searchjtf);

		searchjb.setBounds(650, 25, 100, 40);
		ImageIcon icon5 = new ImageIcon(Searchperson_JPanel.class.getResource("search1.png"));
		searchjb.setIcon(icon5);

		searchjb.setBorderPainted(false);
		searchjb.setOpaque(false);
		// searchjb.setForeground(new Color(148,221,184));
		// searchjb.setBackground(new Color(148,221,184));

		searchjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String keyWord = searchjtf.getText();
				//逻辑处理部分
				ArrayList<PersonListVO> personListVOs = personnelDistributionController.getPersonList(userType,
						keyWord);
				personPanel.changeScrollPane(personListVOs);
			}

		});

		this.add(searchjb);

	}

}
