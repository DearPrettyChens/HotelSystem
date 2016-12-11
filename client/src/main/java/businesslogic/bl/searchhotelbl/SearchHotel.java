package businesslogic.bl.searchhotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.hotelbl.Hotel;

import businesslogic.bl.orderbl.OrderList;
import businesslogic.bl.searchhotelbl.SearchHotelmock.MockHotel;
import businesslogic.bl.searchhotelbl.SearchHotelmock.MockOrderList;
import dao.searchhoteldao.SearchHotelDao;
import exception.NotFoundHotelException;
import init.RMIHelper;
import po.HotelListPO;
import util.HotelSortType;
import util.OrderState;
import util.UserType;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 搜索酒店的领域类
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotel {

	private ArrayList<HotelListVO> hotelListVOs;//维护VO信息是为了进行筛选
	private ArrayList<HotelListPO> hotelListPOs;
	private HotelSearchInfoVO hotelSearchInfoVO;
	private SearchHotelDao searchHotelDao;

	/**
	 * 
	 * 在这个类初始化的时候就根据排序类型去数据库去酒店列表信息
	 * @param hotelSearchInfoVO
	 */
	public SearchHotel(HotelSearchInfoVO hotelSearchInfoVO) {
		this.hotelSearchInfoVO=hotelSearchInfoVO;
		HotelSortType hotelSortType = hotelSearchInfoVO.getHotelSortType();
		try {
			RMIHelper.init();
			searchHotelDao = RMIHelper.getSearchHotelDao();
//			searchHotelDao=new SearchHotelDao_Stub();
			if (hotelSortType == null) {
				hotelListPOs = searchHotelDao.getHotelList();
			} else {
				hotelListPOs = searchHotelDao.getSortedHotelList(hotelSortType);
			}
			for (HotelListPO hotelListPO : hotelListPOs) {
				HotelListVO hotelListVO = new HotelListVO(hotelListPO);
				hotelListVOs=new ArrayList<HotelListVO>();
				System.out.println(hotelListVOs.size());
				hotelListVOs.add(hotelListVO);
			}
			addStrToVO(hotelSearchInfoVO.getCustomerID());
			addOrderToVO(hotelSearchInfoVO.getCustomerID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 在列表信息中增添酒店策略
	 * @param customerID
	 */
	private void addStrToVO(String customerID) {
		for (HotelListVO hotelListVO : hotelListVOs) {
			String hotelID = hotelListVO.getHotelID();
			Hotel hotel = new Hotel();
//			MockHotel  hotel=new MockHotel();
			ArrayList<HotelStrVO> hotelStrVOs=new ArrayList<HotelStrVO>();
			try {
				hotelStrVOs = hotel.getHotelDetailInfo(hotelID, customerID).getHotelStrVO();
			} catch (NotFoundHotelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hotelListVO.setHotelStrVO(hotelStrVOs);
		}

	}
	
	/**
	 * 在列表信息中增添订单状态
	 * @param customerID
	 */
	private void addOrderToVO(String customerID){
		//遍历每一个酒店
		for(HotelListVO hotelListVO: hotelListVOs){
			String hotelID=hotelListVO.getHotelID();
			ArrayList<OrderState> orderStates=new ArrayList<OrderState>();
			
//			MockOrderList orderList=new MockOrderList();
			OrderList orderList=new OrderList();
			//遍历顾客的订单，获得顾客在该酒店的订单状态
			System.out.println(customerID);
			ArrayList<OrderListVO> orderListVOs=orderList.getOrderList(new TypeInfoVO(UserType.Customer, null, customerID));
			for(OrderListVO orderListVO:orderListVOs){
				String orderHotelID=orderListVO.getHotelID();
				if(orderHotelID.equals(hotelID)){
					orderStates.add(orderListVO.getState());
				}
			}
			
			hotelListVO.setOrderStates(orderStates);
		}
	}
	
	/**
	 * 得到所有酒店列表信息
	 * 
	 * @param null
	 * @return ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getHotelList() {
//		if()
		CheckHotel checkHotel=new CheckHotel(hotelListVOs,hotelSearchInfoVO);
		return checkHotel.check();
	}

}
