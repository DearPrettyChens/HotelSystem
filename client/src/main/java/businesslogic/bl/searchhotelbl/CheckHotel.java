package businesslogic.bl.searchhotelbl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.hotelbl.Hotel;
import businesslogic.bl.searchhotelbl.SearchHotelmock.MockHotel;
import exception.NotFoundHotelException;
import exception.NullCityandTradingArea;
import exception.SizeNotEqualException;
import util.BedType;
import util.City;
import util.OrderState;
import util.ResultMessage;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 
 * 根据搜索信息进行排查，得到符合条件的酒店列表
 * 
 * @author CSY
 *
 */
public class CheckHotel {
	private ArrayList<HotelListVO> hotelListVOs;// 维护VO信息是为了进行筛选
	private HotelSearchInfoVO hotelSearchInfoVO;// 酒店搜索信息
	private HotelDetailInfoVO hotelDetailInfoVO;// 获得相关的酒店信息

	public CheckHotel(ArrayList<HotelListVO> hotelListVOs, HotelSearchInfoVO hotelSearchInfoVO) {
		this.hotelListVOs = hotelListVOs;
		this.hotelSearchInfoVO = hotelSearchInfoVO;
	}

	/**
	 * 整合所有的检测
	 * 
	 * @return ArrayList<HotelListVO>
	 */
	public ArrayList<HotelListVO> check() {

		for (HotelListVO hotelListVO : hotelListVOs) {
			String hotelID = hotelListVO.getHotelID();
			String customerID = hotelSearchInfoVO.getCustomerID();
			try {
				// Hotel hotel=new Hotel();
				MockHotel hotel = new MockHotel();
				hotelDetailInfoVO = hotel.getHotelDetailInfo(hotelID, customerID);
			} catch (NotFoundHotelException e) {
				e.printStackTrace();
			}
			if (checkAll(hotelListVO) == false) {
				hotelListVOs.remove(hotelListVO);
			}
		}

		return hotelListVOs;
	}

	/**
	 * 进行一系列的检测
	 */
	private boolean checkAll(HotelListVO hotelListVO) {
		boolean check = true;
	try {
			check = checkArea(hotelDetailInfoVO.getCity(), hotelDetailInfoVO.getArea());
		} catch (NullCityandTradingArea e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		check = checkHotelName(hotelListVO.getHotelName());
		check = checkTime();
		check = checkBedType();
		check = checkStars(hotelListVO.getStar());
		try {
			check = checkPrice(hotelListVO.getLowestPrice());
			check = checkRemark(hotelListVO.getRemark());
		} catch (SizeNotEqualException e) {
			e.printStackTrace();
		}
		
		check = checkOrder(hotelListVO.getOrderStates());

		return check;
	}

	/**
	 * 检测酒店名字
	 * 
	 * @param hotelName
	 */
	private boolean checkHotelName(String hotelName) {
		String searchName = hotelSearchInfoVO.getHotelName();

		if (hotelName == null) {// 说明未搜索酒店名字
			return true;
		}

		if (hotelName.contains(searchName)) {// 只要名字里面含有关键字就满足条件
			return true;
		}
		return false;
	}

	/**
	 * 检测城市和商圈 城市和商圈在界面是必须选择的
	 * 
	 * @param city
	 * @param tradingArea
	 * @return
	 */
	private boolean checkArea(City city, TradingArea tradingArea) throws NullCityandTradingArea {
		City searchCity = hotelSearchInfoVO.getCity();
		TradingArea searchTradingArea = hotelSearchInfoVO.getTradingArea();

		if ((searchCity == null) || (searchTradingArea == null)) {
			// 抛出异常
			throw new NullCityandTradingArea("城市和商圈未选择");
		}
		if ((city == searchCity) && (tradingArea == searchTradingArea)) {
			return true;
		}
		return false;
	}

	/**
	 * 检测入住退房时间，是否酒店有房间
	 */
	private boolean checkTime() {
		ArrayList<BedType> bedTypes = hotelSearchInfoVO.getBedTypes();
		Date checkinTime = hotelSearchInfoVO.getCheckinTime();
		Date checkoutTime = hotelSearchInfoVO.getCheckoutTime();
		String hotelID = hotelDetailInfoVO.getHotelID();
		boolean check = true;// 判断当天是否有空房

		// 如果输入的床型为空就将床型设为该酒店所拥有的床型
		if (bedTypes == null) {
			bedTypes = getBedTypes();
			if(bedTypes==null){//如果该酒店没有床型，那么该酒店不能住人
				return false;
			}
		}

		// 搜索信息中时间都为空，直接返回
		if ((checkinTime == null) && (checkoutTime == null)) {
			return true;
		}

		// 如果输入入住时间为空，就将入住时间设为退房时间前一天
		if (checkinTime == null) {
			checkinTime = getDay(checkoutTime, -1);
		}
		// 如果输入退房时间为空，就将退房时间设为入住时间后一天
		if (checkoutTime == null) {
			checkoutTime = getDay(checkinTime, 1);
		}

		// 对每种床型进行遍历
		for (BedType bedType : bedTypes) {
			check = true;
			// 获得这两个日期之间的所有日期
			ArrayList<Date> dates = getDates(checkinTime, checkoutTime);

			// 如果该种床型在指定日期内只要有一天没有空房，就退出内循环，继续下一种床型
			for (Date date : dates) {
				check = checkAvailableRoom(new AvailableRoomNumberVO(1, bedType, date, hotelID));
				if (check == false) {
					break;
				}
			}

		}

		return check;
	}

	/**
	 * 根据日期获得加减后的日期
	 */
	private Date getDay(Date date, int number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // 根据日期 设置此 Calendar 的时间
		calendar.add(Calendar.DAY_OF_MONTH, number);
		return calendar.getTime();
	}

	/**
	 * 获得酒店床型
	 */
	private ArrayList<BedType> getBedTypes() {
		ArrayList<BedType> bedTypes = new ArrayList<BedType>();
		ArrayList<AvailableRoomInfoVO> availableRoomInfoVOs = hotelDetailInfoVO.getAvailableRoomInfoVO();
		
		if(availableRoomInfoVOs==null) return null;
		for (AvailableRoomInfoVO availableRoomInfoVO : availableRoomInfoVOs) {
			BedType bedType = availableRoomInfoVO.getBedType();
			bedTypes.add(bedType);
		}
		return bedTypes;
	}

	/**
	 * 根据入住和退房日期获得这个期间的日期列表
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private ArrayList<Date> getDates(Date startTime, Date endTime) {
		ArrayList<Date> dates = new ArrayList<Date>();
		dates.add(startTime);// 把开始时间加入集合
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime); // 使用给定的 Date 设置此 Calendar 的时间
		while (true) {
			// 根据日历的规则，为给定的日历字段添加一天
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endTime.after(calendar.getTime())) {
				dates.add(calendar.getTime());
			} else {
				break;
			}
		}
		dates.add(endTime);// 把结束时间加入集合
		return dates;

	}

	/**
	 * 检测是否有空房间
	 * 
	 * @param availableRoomNumberVO
	 * @return
	 */
	private boolean checkAvailableRoom(AvailableRoomNumberVO availableRoomNumberVO) {
		AvailableRoom availableRoom = new AvailableRoom();
		ResultMessage resultMessage = availableRoom.checkAvailableRoomNumber(availableRoomNumberVO);
		if (resultMessage == ResultMessage.SUCCESS) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 检测床型
	 * 
	 * @param bedType
	 * @return
	 */
	private boolean checkBedType() {
		ArrayList<BedType> searchBeds = hotelSearchInfoVO.getBedTypes();
		if (searchBeds == null) {
			return true;
		}
		ArrayList<BedType> bedTypes = getBedTypes();
		for (BedType bedType : bedTypes) {
			if (searchBeds.contains(bedType)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * 检测酒店最低价格
	 * 
	 * @param bestPrice
	 * @return
	 */
	private boolean checkPrice(double bestPrice) throws SizeNotEqualException {
		ArrayList<Integer> lowPrices = hotelSearchInfoVO.getLowPrice();
		ArrayList<Integer> highPrices = hotelSearchInfoVO.getHighPrice();
		if (lowPrices == null || highPrices == null) {
			return true;
		}
		if (lowPrices.size() != highPrices.size()) {
			// 抛出异常
			// 注：这里在界面传入的时候，如果没有上限就传入int的最大值
			throw new SizeNotEqualException("最高价格和最低价格未能一一对应");

		}
		int size = lowPrices.size();
		for (int i = 0; i < size; i++) {
			double lowPrice = lowPrices.get(i);
			double highPrice = highPrices.get(i);
			if ((lowPrice <= bestPrice) && (bestPrice <= highPrice)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 检测酒店的星级
	 * 
	 * @param star
	 * @return
	 */
	private boolean checkStars(int star) {
		ArrayList<Integer> searchStar = hotelSearchInfoVO.getStars();
		if (searchStar == null) {
			return true;
		}
		if (searchStar.contains(star)) {
			return true;
		}
		return false;
	}

	/**
	 * 检测酒店的评分
	 * 
	 * @param remarkNumber
	 * @return
	 */
	private boolean checkRemark(double remarkNumber) throws SizeNotEqualException {
		ArrayList<Double> lowRemarkNumbers = hotelSearchInfoVO.getLowRemarkNumbers();
		ArrayList<Double> highRemarkNumbers = hotelSearchInfoVO.getHighRemarkNumbers();
		if (lowRemarkNumbers == null || highRemarkNumbers == null) {
			return true;
		}
		if (lowRemarkNumbers.size() != highRemarkNumbers.size()) {
			// 抛出异常
			throw new SizeNotEqualException("最高评分和最低评分未能一一对应");
		}
		int size = lowRemarkNumbers.size();
		for (int i = 0; i < size; i++) {
			double lowRemark = lowRemarkNumbers.get(i);
			double highRemark = highRemarkNumbers.get(i);
			if ((lowRemark <= remarkNumber) && (remarkNumber <= highRemark)) {
				return true;
			}

		}
		return false;

	}

	/**
	 * 检测顾客在该酒店的订单状态
	 * 
	 * @param orderStates
	 * @return
	 */
	private boolean checkOrder(ArrayList<OrderState> orderStates) {
		ArrayList<OrderState> searchOrder = hotelSearchInfoVO.getOrderStates();
		if (searchOrder == null) {
			return true;
		}
		for (OrderState orderState : searchOrder) {

			if (orderStates.contains(orderState)) {
				return true;
			}
		}
		return false;
	}

}
