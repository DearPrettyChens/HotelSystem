package businesslogic.bl.availableroombl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.hotelbl.Hotel;
import businesslogic.bl.hotelstrategybl.HotelStrategy;
import dao.availableroomdao.AvailableRoomDao;
import exception.NullHotelIDException;
import init.RMIHelper;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

/**
 * AvailableRoom的领域类
 * 
 * @author CLL
 * @version 1.0
 */
public class AvailableRoom {
	// 可用住房信息列表
	private ArrayList<SingleAvailableRoomInfo> singleAvailableRoomInfoList = new ArrayList<SingleAvailableRoomInfo>();
	// 数据层的引用
	private AvailableRoomDao availableRoomDao;
	private HotelInfoAvailService hotel;

	public AvailableRoom() {
		RMIHelper.init();
		availableRoomDao = RMIHelper.getAvailableRoomDao();
		hotel = new Hotel();
		// availableRoomDao=new AvailableRoomDao_Stub();
	}

	/**
	 * 获取酒店的当日可用房间信息
	 * 
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 * @throws NullHotelIDException
	 */
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		ArrayList<AvailableRoomInfoVO> infos = new ArrayList<AvailableRoomInfoVO>();
		try {
			// 调用数据层
			ArrayList<AvailableRoomInfoPO> pos = availableRoomDao.getAvailableRoomInfo(hotelID);

			if (pos == null)
				return null;
			for (int i = 0; i < pos.size(); i++) {
				AvailableRoomInfoVO availableRoomInfoVO = new AvailableRoomInfoVO(pos.get(i));
				availableRoomInfoVO.setTag(false);
				infos.add(availableRoomInfoVO);
			}
			return infos;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 新增酒店房间信息
	 * 
	 * @param availableRoomInfoVO
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ResultMessage confirmAvailableRoomInfo(String hotelID, AvailableRoomInfoVO availableRoomInfoVO)
			throws NullHotelIDException {
		ResultMessage resultMessage=ResultMessage.FAIL;
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		// 调用数据层
		try {
			
			HotelStrategy hotelStrategy=HotelStrategy.getInstance();
			double discount=hotelStrategy.getHotelLowestDiscount(hotelID);
			double price=availableRoomInfoVO.getOriginalPrice();
			availableRoomInfoVO.setLowestPrice(price*discount);
			boolean tag = availableRoomInfoVO.isTag();
			
			if (tag == true) {
				resultMessage=availableRoomDao.addAvailableRoomInfo(availableRoomInfoVO.toPO());
			} else {
				resultMessage=availableRoomDao.modifyAvailableRoomInfo(availableRoomInfoVO.toPO());
			}
			if(resultMessage==ResultMessage.SUCCESS){
				resultMessage=setBestPrice(hotelID, discount);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * 更新可用房间数量信息
	 * 
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO)
			throws NullHotelIDException {
		if (availableRoomNumberVO.getHotelNumber() == null) {
			throw new NullHotelIDException();
		}
		// 调用数据层
		try {
			return availableRoomDao.setAvailableRoomNumber(availableRoomNumberVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 更新各种房型的最低价格
	 * 
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage setBestPrice(String hotelID, double discount) throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		try {
			ArrayList<AvailableRoomInfoPO> roomInfo = availableRoomDao.getAvailableRoomInfo(hotelID);
			// new出该酒店的所有singleavailableroom对象

			if (roomInfo == null)
				return ResultMessage.SUCCESS;

			for (int i = 0; i < roomInfo.size(); i++) {
				singleAvailableRoomInfoList
						.add(new SingleAvailableRoomInfo(TransHelper.idToString(roomInfo.get(i).getHotelNumber(), 6),
								roomInfo.get(i).getRoomType(), roomInfo.get(i).getBedType(),
								roomInfo.get(i).getOriginalPrice(), roomInfo.get(i).getLowestPrice(),
								roomInfo.get(i).getOriginalNumbers(), roomInfo.get(i).getCurrentNumber()));
			}
			// 遍历list，更新其中的房型价格
			for (int i = 0; i < singleAvailableRoomInfoList.size(); i++) {
				singleAvailableRoomInfoList.get(i).setDiscount(discount);
			}
			// 创建更新后的po
			ArrayList<AvailableRoomInfoPO> newPOs = new ArrayList<AvailableRoomInfoPO>();
			for (int i = 0; i < roomInfo.size(); i++) {
				newPOs.add(singleAvailableRoomInfoList.get(i).getAvailableRoomInfo());
			}
			double lowestPrice = 0;
			if (roomInfo.size() != 0) {
				lowestPrice = singleAvailableRoomInfoList.get(0).getLowestPrice();
			}
			for (int i = 0; i < roomInfo.size(); i++) {
				if (singleAvailableRoomInfoList.get(i).getLowestPrice() < lowestPrice) {
					lowestPrice = singleAvailableRoomInfoList.get(i).getLowestPrice();
				}
			}
			// 交给数据层更新价格
			if (availableRoomDao.setBestPrice(newPOs) != ResultMessage.SUCCESS) {
				return ResultMessage.FAIL;
			}
			return hotel.setBestPrice(lowestPrice, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	/**
	 * 系统返回该房型价格
	 * 
	 * @param hotelID
	 * @param bedType
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public double getRoomPrice(String hotelID, BedType bedType) throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		try {
			ArrayList<AvailableRoomInfoPO> roomInfo = availableRoomDao.getAvailableRoomInfo(hotelID);
			for (int i = 0; i < roomInfo.size(); i++) {
				if (bedType == roomInfo.get(i).getBedType()) {
					return roomInfo.get(i).getLowestPrice();
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//System.out.println("不存在该房间类型");
		return 0;
	}

	/**
	 * 判断是否有足够的可用客房
	 * 
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO)
			throws NullHotelIDException {
		if (availableRoomNumberVO.getHotelNumber() == null) {
			throw new NullHotelIDException();
		}
		try {
			// 调用数据层返回相应日期的可用客房信息
			AvailableRoomNumberPO roomInfo = availableRoomDao.getAvailableRoomNumber(
					availableRoomNumberVO.getHotelNumber(), availableRoomNumberVO.getDate(),
					availableRoomNumberVO.getBedType());
			// availableRoomNumberVO中传的是需要的房间数量，与数据层返回的可用房间数量进行比较
			if (roomInfo.getNumber() >= availableRoomNumberVO.getNumber()) {
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.NOTENOUGHAVAILABLEROOM;
			}
			/*
			 * ArrayList<AvailableRoomInfoPO>
			 * roomInfo=availableRoomDao.getAvailableRoomInfo(
			 * availableRoomNumberVO.getHotelNumber()); //当前可用房间数的列表 int
			 * roomNumber=0; for(int i=0;i<roomInfo.size();i++){
			 * if(roomInfo.get(i).getBedType()==availableRoomNumberVO.getBedType
			 * ()){ roomNumber=roomInfo.get(i).getCurrentNumber(); } }
			 * if(roomNumber>=availableRoomNumberVO.getNumber()){ return
			 * ResultMessage.SUCCESS; } else{ return
			 * ResultMessage.NOTENOUGHAVAILABLEROOM; }
			 */
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

}
