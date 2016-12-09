package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import presentation.ui.searchhotelui.distributecontroller.SearchhotelDistributionController;
import presentation.ui.tools.newclient_JLabel;
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
	
	public HotelListPane_JPanel(HotelSearchInfoVO hotelSearchInfoVO,ViewTag viewTag) {
		this.viewTag=viewTag;
		this.setBackground(Color.white);
		this.setLayout(null);
		addComp(hotelSearchInfoVO);
	}

	public void addComp(HotelSearchInfoVO hotelSearchInfoVO) {

		ArrayList<HotelListVO> hotelListVOs = searchhotelDistributionController.getSortedHotelList(hotelSearchInfoVO);
		for (HotelListVO hotelListVO : hotelListVOs) {
			HotelListInfo_JPanel hotelListInfo_JPanel = new HotelListInfo_JPanel(hotelListVO,viewTag);
			hotelListInfo_JPanels.add(hotelListInfo_JPanel);
		}

		for (int i = 0; i < hotelListInfo_JPanels.size(); i++) {
			HotelListInfo_JPanel hotelListInfo_JPanel = hotelListInfo_JPanels.get(i);
			hotelListInfo_JPanel.setBounds(0, 150 * i, 800, 150);
			this.add(hotelListInfo_JPanel);
		}
//		this.setPreferredSize(new Dimension(780, 50 + 150 * hotelListInfo_JPanels.size()));
	    this.setSize(800, 50 + 150 * hotelListInfo_JPanels.size());
	}

}
