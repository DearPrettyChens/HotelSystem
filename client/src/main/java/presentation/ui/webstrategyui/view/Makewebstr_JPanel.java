package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.newclient_JLabel;
import presentation.ui.webstrategyui.viewcontroller.WebStrategyViewControllerImpl;
import util.WebStrategyType;


/**
 * 
 * 用于选择策略的面板
 * @author cy
 *
 */
public class Makewebstr_JPanel extends JPanel {

	private ChooseStrategy_JPanel chooseStrategy_JPanel = new ChooseStrategy_JPanel();
	private JLabel vipareastrjl = new JLabel("特定商圈折扣策略");
	private JLabel clientlevelstrjl = new JLabel("会员等级折扣策略");
	private JLabel specialtimestrjl = new JLabel("特殊时期折扣策略");

	private JLabel hengline = new JLabel(new ImageIcon(Makewebstr_JPanel.class.getResource("hengline.png")));
	private JLabel shuline1 = new JLabel(new ImageIcon(Makewebstr_JPanel.class.getResource("shuline.png")));
	private JLabel shuline2 = new JLabel(new ImageIcon(Makewebstr_JPanel.class.getResource("shuline.png")));

	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color lightcolor = new Color(149, 222, 184);
	// private Color dackcolor=new Color(146,182,163);
	private Color dackcolor = new Color(0, 0, 0);

	//为什么传入参数是空？
	private WebStrategyViewControllerImpl webStrategyViewControllerImpl = new WebStrategyViewControllerImpl(null);

	public Makewebstr_JPanel() {

		this.setBackground(Color.white);
		this.setSize(800, 600);
		this.setLayout(null);
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

		this.add(chooseStrategy_JPanel);

		vipareastrjl.setFont(font);
		vipareastrjl.setForeground(lightcolor);
		vipareastrjl.setBounds(100, 28, 150, 30);
		this.add(vipareastrjl);

		vipareastrjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				vipareastrjl.setForeground(lightcolor);
				clientlevelstrjl.setForeground(dackcolor);
				specialtimestrjl.setForeground(dackcolor);
				webStrategyViewControllerImpl.selectStrategyType(WebStrategyType.SPECIALAREA, chooseStrategy_JPanel);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		clientlevelstrjl.setFont(font);
		clientlevelstrjl.setForeground(dackcolor);
		clientlevelstrjl.setBounds(330, 28, 150, 30);
		clientlevelstrjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				vipareastrjl.setForeground(dackcolor);
				clientlevelstrjl.setForeground(lightcolor);
				specialtimestrjl.setForeground(dackcolor);
				webStrategyViewControllerImpl.selectStrategyType(WebStrategyType.VIP, chooseStrategy_JPanel);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		this.add(clientlevelstrjl);

		specialtimestrjl.setFont(font);
		specialtimestrjl.setForeground(dackcolor);
		specialtimestrjl.setBounds(570, 28, 150, 30);
		specialtimestrjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				vipareastrjl.setForeground(dackcolor);
				clientlevelstrjl.setForeground(dackcolor);
				specialtimestrjl.setForeground(lightcolor);
				webStrategyViewControllerImpl.selectStrategyType(WebStrategyType.SPECIALTIME, chooseStrategy_JPanel);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		this.add(specialtimestrjl);

		shuline1.setBounds(265, 28, 30, 30);
		this.add(shuline1);

		shuline2.setBounds(500, 28, 30, 30);
		this.add(shuline2);

		hengline.setBounds(50, 50, 700, 30);
		this.add(hengline);
	}

}
