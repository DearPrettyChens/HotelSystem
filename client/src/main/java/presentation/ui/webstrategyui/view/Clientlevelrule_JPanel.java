package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.ResultMessage;
import vo.webstrategyvo.GradeRuleVO;

/**
 * 
 * 制定会员等级制度面板
 * 
 * 还未给确认增加监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Clientlevelrule_JPanel extends JPanel {

	private int number;
	private int credit;

	private Font font = new Font("宋体", Font.BOLD, 16);
	// private JLabel title=new JLabel(new
	// ImageIcon("image//clientruletitle.png"));
	// private JLabel numberjl=new JLabel("等级数量：");
	private JLabel creditjl = new JLabel("到达下一等级所需信用值：");
	// private MyTextfield numberjtf;
	private MyTextfield creditjtf;

	private MyButton confirm = new MyButton();

	private WebstrategyDistributionController webstrategyDistributionController;

	public Clientlevelrule_JPanel() {

		/**
		 * number,credit应该通过控件监听得到, 一开始应该显示当前的规则，通过distributecontroller向逻辑层取得
		 */
		webstrategyDistributionController = WebstrategyDistributionController.getInstance();
		credit = webstrategyDistributionController.getGradeRule().getValue();

		// numberjtf=new MyTextfield(""+number);
		creditjtf = new MyTextfield("" + credit);

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
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

		// title.setBounds(0,0,800,100);
		// this.add(title);

		// numberjl.setFont(font);
		// numberjl.setBounds(310,150,200,50);
		// this.add(numberjl);

		// numberjtf.setBounds(400,150,200,50);
		// this.add(numberjtf);

		creditjl.setFont(font);
//		creditjl.setBounds(200, 250, 200, 50);
		creditjl.setBounds(200, 200, 200, 50);
		this.add(creditjl);

//		creditjtf.setBounds(400, 250, 200, 50);
		creditjtf.setBounds(400, 200, 200, 50);
		this.add(creditjtf);

		confirm.setBounds(500, 380, 100, 30);
		confirm.setText("确认");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int newValue = Integer.parseInt(creditjtf.getText());
				if(newValue<=0){
					SaveFail_JFrame frame=new SaveFail_JFrame();
					frame.setLableText("信用值必须为正哟～");
				}
				if (newValue>0) {
					GradeRuleVO vo = new GradeRuleVO(newValue);
					if(webstrategyDistributionController.confirmGradeRule(vo)==ResultMessage.SUCCESS){
						new SaveSuccess_JFrame();
					}
					else{
						new SaveFail_JFrame();
					}
				}
			}
		});
		this.add(confirm);

	}

}
