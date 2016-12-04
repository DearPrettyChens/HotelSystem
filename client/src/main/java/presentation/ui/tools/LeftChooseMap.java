package presentation.ui.tools;

import java.util.HashMap;

import javax.swing.JPanel;

import businesslogic.bl.webstrategybl.WebStrategyInterface;
import presentation.ui.creditui.view.DepositPanel;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
import presentation.ui.personnelui.view.client.ManageCustomerPanel;
import presentation.ui.personnelui.view.hotelworker.ManageHotelWorkerPanel;
import presentation.ui.personnelui.view.webmarketman.ManageWebMarketManPanel;
import presentation.ui.userui.view.Changepassword_JPanel;
import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import util.UserType;
import util.WebStrategyType;

/**
 * 所有左边栏的对应的界面
 * @author csy
 *
 */
public class LeftChooseMap {
	private static LeftChooseMap leftChooseMap;
	private HashMap<String, JPanel> map;
	private JPanel jPanel;
	
	private LeftChooseMap() {
		map=new HashMap<String, JPanel>();
		//网站管理人员的左边栏
		map.put("营销人员", new ManageWebMarketManPanel());
		map.put("顾客会员", new ManageCustomerPanel());
		map.put("酒店人员", new ManageHotelWorkerPanel() );
		map.put("修改密码", new Changepassword_JPanel(UserType.Manager));
		
		//网站营销人员的左边栏
		map.put("管理订单", OrderPanelInWebMarketMan.getInstance());
		map.put("信用充值", DepositPanel.getInstance());
		map.put("会员等级", new Clientlevelrule_JPanel());
		map.put("营销策略", new Makewebstr_JPanel());
		
//		酒店工作人员的左边栏
		
//		顾客的左边栏
		
		
		
	}

	public static LeftChooseMap getInstance() {
         if (leftChooseMap==null){
        	 leftChooseMap=new LeftChooseMap();
         }
         return leftChooseMap;
	}
	
	/**
	 * 返回对应的面板
	 * @param info
	 * @return
	 */
	public JPanel get(String info){
		jPanel=map.get(info);
		return jPanel;
	}
 	 
 	
}
