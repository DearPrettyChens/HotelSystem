package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.personnelui.viewcontroller.PersonnelControllerImpl;
import presentation.ui.tools.RightContainerPanel;
import presentation.ui.tools.NewClient_JLabel;
import util.UserType;

/**
 * 网站管理人员选择搜索浏览或添加用户的面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Searchoradd_JPanel extends JPanel {

	private ManagePanel managePanel;
	public JLabel searchjl = new JLabel("搜索");
	public JLabel addjl = new JLabel("添加");
	public JLabel backjl = new JLabel();

	public Font font = new Font("宋体", Font.BOLD, 16);
	public Color color = new Color(148, 221, 184);

	private UserType userType;// 代表时哪种类型的人的列表

	private PersonnelControllerImpl personnelControllerImpl = new PersonnelControllerImpl(null);

	public Searchoradd_JPanel(ManagePanel managePanel) {
		// this.userType=type;
		// this.setBackground(Color.white);
		this.setLayout(null);
		this.setBackground(Color.white);

		addComp();
		this.managePanel = managePanel;

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {
		searchjl.setFont(font);
		searchjl.setForeground(color);
		searchjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				addjl.setForeground(Color.gray);
				searchjl.setForeground(color);

				// 逻辑处理部分
				personnelControllerImpl.jumpToSearchPanel(managePanel);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// searchjl.setFont(new Font("宋体",Font.BOLD, 16));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				searchjl.setFont(new Font("宋体", Font.BOLD, 18));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				searchjl.setFont(new Font("宋体", Font.BOLD, 16));
			}

		});
		searchjl.setBounds(150, 10, 100, 30);
		this.add(searchjl);

		addjl.setFont(font);
		addjl.setForeground(Color.gray);
		addjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setForeground(color);
				searchjl.setForeground(Color.gray);

				// 逻辑处理部分
				personnelControllerImpl.jumpToAddPanel(managePanel);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// addjl.setFont(new Font("宋体",Font.BOLD, 16));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setFont(new Font("宋体", Font.BOLD, 18));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				addjl.setFont(new Font("宋体", Font.BOLD, 16));
			}

		});
		addjl.setBounds(550, 10, 100, 30);
		this.add(addjl);

		ImageIcon icon = new ImageIcon(Searchoradd_JPanel.class.getResource("searchoradd.png"));
		backjl.setIcon(icon);
		backjl.setBounds(0, 0, 800, 50);
		this.add(backjl);

	}

}
