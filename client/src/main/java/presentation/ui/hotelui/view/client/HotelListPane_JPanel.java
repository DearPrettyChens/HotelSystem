package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import businesslogic.bl.searchhotelbl.CheckHotel;
import presentation.ui.searchhotelui.distributecontroller.SearchhotelDistributionController;
import presentation.ui.tools.NewClient_JLabel;
import util.HotelSortType;
import util.OrderState;
import util.ViewTag;
import vo.ordervo.TypeInfoVO;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 
 * 放所有酒店列表信息的面板
 * 
 * @author csy
 *
 */
public class HotelListPane_JPanel extends JPanel {
	ArrayList<HotelListInfo_JPanel> hotelListInfo_JPanels = new ArrayList<HotelListInfo_JPanel>();
	private SearchhotelDistributionController searchhotelDistributionController = SearchhotelDistributionController
			.getInstance();

	private ViewTag viewTag;
	private ArrayList<HotelListVO> hotelListVOs;
	// private ArrayList<HotelListVO> showList;

	private ArrayList<HotelListVO> hotelAllListVOs;

	public HotelListPane_JPanel(HotelSearchInfoVO hotelSearchInfoVO, ViewTag viewTag) {
		this.viewTag = viewTag;
		this.setBackground(Color.white);
		this.setLayout(null);
		switch (viewTag) {
		case HOTELRESERVERSION:
			addComp(hotelSearchInfoVO);
			break;
		case MYHOTEL:
			addMyHotel(hotelSearchInfoVO);
			break;
		}
		// addComp(hotelSearchInfoVO);
	}

	public void addComp(HotelSearchInfoVO hotelSearchInfoVO) {

		hotelListVOs = searchhotelDistributionController.getSortedHotelList(hotelSearchInfoVO);
		HotelSearchInfoVO vo=new HotelSearchInfoVO();
	//	vo.setOrderStates(hotelSearchInfoVO.getOrderStates());
		vo.setCustomerID(hotelSearchInfoVO.getCustomerID());
		hotelAllListVOs=searchhotelDistributionController.getSortedHotelList(vo);
		// CustomerHotelList(hotelSearchInfoVO.getCustomerID());
		// System.out.println("hotellistpanepanel:"+hotelListVOs.size());
		// showList = new ArrayList<HotelListInfo_JPanel>();
		for (HotelListVO hotelListVO : hotelListVOs) {
			HotelListInfo_JPanel hotelListInfo_JPanel = new HotelListInfo_JPanel(hotelListVO, viewTag);
			hotelListInfo_JPanels.add(hotelListInfo_JPanel);
		}

		for (int i = 0; i < hotelListInfo_JPanels.size(); i++) {
			HotelListInfo_JPanel hotelListInfo_JPanel = hotelListInfo_JPanels.get(i);
			hotelListInfo_JPanel.setBounds(0, 150 * i, 800, 150);
			this.add(hotelListInfo_JPanel);
		}
		// this.setPreferredSize(new Dimension(780, 50 + 150 *
		// hotelListInfo_JPanels.size()));
		this.setSize(800, 50 + 150 * hotelListInfo_JPanels.size());
	}

	public void addMyHotel(HotelSearchInfoVO hotelSearchInfoVO) {
		hotelListVOs = searchhotelDistributionController.getCustomerHotelList(hotelSearchInfoVO.getCustomerID());
		// System.out.println("hotellistpanepanel:"+hotelListVOs.size());
		// showList = new ArrayList<HotelListInfo_JPanel>();
		for (HotelListVO hotelListVO : hotelListVOs) {
			HotelListInfo_JPanel hotelListInfo_JPanel = new HotelListInfo_JPanel(hotelListVO, viewTag);
			hotelListInfo_JPanels.add(hotelListInfo_JPanel);
		}

		for (int i = 0; i < hotelListInfo_JPanels.size(); i++) {
			HotelListInfo_JPanel hotelListInfo_JPanel = hotelListInfo_JPanels.get(i);
			hotelListInfo_JPanel.setBounds(0, 150 * i, 800, 150);
			this.add(hotelListInfo_JPanel);
		}
		// this.setPreferredSize(new Dimension(780, 50 + 150 *
		// hotelListInfo_JPanels.size()));
		this.setSize(800, 50 + 150 * hotelListInfo_JPanels.size());
	}

	public void changeHotelList(HotelSearchInfoVO vo) {
		for (HotelListInfo_JPanel each : hotelListInfo_JPanels) {
			this.remove(each);
		}
		hotelListInfo_JPanels.clear();
		// showList.clear();
		ArrayList<HotelListVO> showList = new ArrayList<HotelListVO>();
		ArrayList<OrderState> list = vo.getOrderStates();
		for (OrderState each : list) {
			for (HotelListVO listVO : hotelListVOs) {
				if (listVO.getOrderStates().contains(each) && (!showList.contains(listVO))) {
					showList.add(listVO);
					// hotelListInfo_JPanels.add(listVO);
				}
			}
		}
		for (HotelListVO hotelListVO : showList) {
			HotelListInfo_JPanel hotelListInfo_JPanel = new HotelListInfo_JPanel(hotelListVO, viewTag);
			hotelListInfo_JPanels.add(hotelListInfo_JPanel);
		}
		for (int i = 0; i < hotelListInfo_JPanels.size(); i++) {
			HotelListInfo_JPanel hotelListInfo_JPanel = hotelListInfo_JPanels.get(i);
			hotelListInfo_JPanel.setBounds(0, 150 * i, 800, 150);
			this.add(hotelListInfo_JPanel);
		}

		this.repaint();
	}

//	public void change(HotelSearchInfoVO hotelSearchInfoVO) {
//		this.removeAll();
//		hotelListInfo_JPanels.clear();
//		if (hotelSearchInfoVO.getHotelSortType() != null) {
//			HotelSearchInfoVO searchInfoVO = new HotelSearchInfoVO();
//			searchInfoVO.setHotelSortType(hotelSearchInfoVO.getHotelSortType());
//			hotelAllListVOs = searchhotelDistributionController.getSortedHotelList(searchInfoVO);
//			hotelListVOs = hotelAllListVOs;
//		} else {
//			CheckHotel checkHotel = new CheckHotel(hotelAllListVOs, hotelSearchInfoVO);
//			hotelListVOs = checkHotel.check();
//		}
//		for (HotelListVO hotelListVO : hotelListVOs) {
//			HotelListInfo_JPanel hotelListInfo_JPanel = new HotelListInfo_JPanel(hotelListVO, viewTag);
//			hotelListInfo_JPanels.add(hotelListInfo_JPanel);
//		}
//
//		for (int i = 0; i < hotelListInfo_JPanels.size(); i++) {
//			HotelListInfo_JPanel hotelListInfo_JPanel = hotelListInfo_JPanels.get(i);
//			hotelListInfo_JPanel.setBounds(0, 150 * i, 800, 150);
//			this.add(hotelListInfo_JPanel);
//		}
//		// this.setPreferredSize(new Dimension(780, 50 + 150 *
//		// hotelListInfo_JPanels.size()));
//		this.setSize(800, 50 + 150 * hotelListInfo_JPanels.size());
//		this.repaint();
//	}
}
