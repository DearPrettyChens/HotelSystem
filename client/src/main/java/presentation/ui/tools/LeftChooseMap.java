package presentation.ui.tools;

import java.util.HashMap;

import javax.swing.JPanel;

import businesslogic.bl.webstrategybl.WebStrategyInterface;
import presentation.ui.availableroomui.view.RoomInfo_JPanel;
import presentation.ui.checkinui.view.CheckInInfo_JPanel;
import presentation.ui.checkinui.view.CheckInPanel;
import presentation.ui.checkinui.view.CheckOutPanel;
import presentation.ui.checkinui.view.OfflineCheckIn_JPanel;
import presentation.ui.creditui.view.ClientCreditInfos_JPanel;
import presentation.ui.creditui.view.DepositPanel;
import presentation.ui.hotelstrategyui.view.HotelStrategyPanel;
import presentation.ui.hotelui.view.MaintainHotelBasicInfoPanel;
import presentation.ui.hotelui.view.client.MyFootView;
import presentation.ui.hotelui.view.client.ReserveHotelView;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.orderui.view.OrderPanelViewInHotelWorker;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.personnelui.view.client.Clientlistinfo_JPanel;
import presentation.ui.personnelui.view.client.ManageCustomerPanel;
import presentation.ui.personnelui.view.hotelworker.ManageHotelWorkerPanel;
import presentation.ui.personnelui.view.webmarketman.ManageWebMarketManPanel;
import presentation.ui.userui.view.Changemessage_JPanel;
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
	private String hotelID="";
	private String userID="";
	private String userName="";
	
	private LeftChooseMap(String userName,String userID,UserType userType) {
		this.userName=userName;
		this.userID=userID;
		this.hotelID=userID;
		map=new HashMap<String, JPanel>();
		switch(userType){
		case Customer:
//			顾客的左边栏
			map.put("预订酒店", ReserveHotelView.getInstance(userID,userName));
			map.put("我的信息", new Changemessage_JPanel(userID));
			map.put("我的密码", new Changepassword_JPanel(UserType.Customer,userID));
			map.put("我的订单", ChooseOrderTypetoClient_JPanel.getInstance(userID, hotelID));
			map.put("我的足迹", MyFootView.getInstance(userID));
			map.put("我的信用", new ClientCreditInfos_JPanel(userID));
			break;
		case HotelWorker:
//			酒店工作人员的左边栏
			map.put("● 维护酒店信息", new MaintainHotelBasicInfoPanel(hotelID));
			map.put("● 录入客房信息", new RoomInfo_JPanel(hotelID));
			map.put("● 浏览订单列表", OrderPanelViewInHotelWorker.getInstance(hotelID));
			map.put("● 制定酒店策略", HotelStrategyPanel.getInstance(hotelID));
			map.put("● 线上入住办理", CheckInPanel.getInstance(hotelID));
			map.put("● 线上退房办理", CheckOutPanel.getInstance(hotelID));
			map.put("● 线下入住退房", new OfflineCheckIn_JPanel(hotelID));
			break;
		case Manager:
			//网站管理人员的左边栏
			map.put("营销人员", ManageWebMarketManPanel.getInstance());
			map.put("顾客会员", ManageCustomerPanel.getInstance());
			map.put("酒店人员", ManageHotelWorkerPanel.getInstance());
			map.put("修改密码", new Changepassword_JPanel(UserType.Manager,userID));
			break;
		case WebMarketMan:
			//网站营销人员的左边栏
			map.put("管理订单", OrderPanelInWebMarketMan.getInstance());
			map.put("信用充值", DepositPanel.getInstance());
			map.put("会员等级", new Clientlevelrule_JPanel());
			map.put("营销策略", new Makewebstr_JPanel());
			break;
		default:
			break;
		
		}
		
		
		
		

		

	}

	public static LeftChooseMap getInstance(String userName,String userID,UserType userType) {
         if (leftChooseMap==null){
        	 leftChooseMap=new LeftChooseMap(userName,userID,userType);
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
