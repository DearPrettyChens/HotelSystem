package presentation.ui.personnelui.view.webmarketman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.Personlistinfo_JPanel;
import presentation.ui.personnelui.view.UserHeadPanel;
import presentation.ui.personnelui.viewcontroller.PersonnelControllerImpl;
import presentation.ui.tools.MyButton;
import util.UserType;
import vo.personnelvo.PersonListVO;

/**
 * 网站营销人员列表信息面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Webmarketmanlistinfo_JPanel extends Personlistinfo_JPanel {
	private JLabel imagejl = new JLabel();

	private Font font = new Font("宋体", Font.BOLD, 16);

	private JLabel idjl = new JLabel();
	private JLabel namejl = new JLabel();
	private JLabel teljl = new JLabel();
	private JLabel typejl = new JLabel();
	private JLabel passwordjl = new JLabel();
	JLabel backjl = new JLabel();

	private ImageIcon image;
	private UserHeadPanel headPanel;
	private String id;
	private String name;
	private String tel;
	private UserType type;
	private String password;

	private MyButton moreinfojb = new MyButton();

	private Webmarketmandetailinfo_JFrame detailinfojp;

	private PersonnelControllerImpl personnelControllerImpl = new PersonnelControllerImpl(this);

	public Webmarketmanlistinfo_JPanel(PersonListVO personListVO) {
		this.image = personListVO.getImage();
		this.id = personListVO.getId();
		this.name = personListVO.getName();
		this.tel = personListVO.getTelephone();
		this.type = personListVO.getUserType();

		this.setBackground(Color.white);

		// setBak();
		addComp();
		setListener();

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		headPanel = new UserHeadPanel(image, UserType.HotelWorker);
		headPanel.setBounds(25, 10, 60, 60);
		this.add(headPanel);

		typejl.setText("职务:   " + "营销人员");
		typejl.setFont(font);
		typejl.setBounds(120, 20, 200, 20);
		this.add(typejl);

		idjl.setText("I   D:   " + id);
		idjl.setFont(font);
		idjl.setBounds(120, 50, 200, 20);
		this.add(idjl);

		namejl.setText("姓名:   " + name);
		namejl.setFont(font);
		namejl.setBounds(280, 20, 200, 20);
		this.add(namejl);

		teljl.setText("电话:   " + tel);
		teljl.setFont(font);
		teljl.setBounds(280, 50, 200, 20);
		this.add(teljl);

		moreinfojb.setText("更多信息");
		moreinfojb.setBounds(470, 30, 110, 30);
		this.add(moreinfojb);

		ImageIcon iconback = new ImageIcon(Webmarketmanlistinfo_JPanel.class.getResource("listback.png"));
		backjl.setIcon(iconback);
		backjl.setBounds(0, 0, 600, 90);
		this.add(backjl);

	}

	public void setListener() {

		moreinfojb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				personnelControllerImpl.showWebMarketManDetailInfo(id);

			}

		});

	}

}
