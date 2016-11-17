package businesslogic.bl.availableroombl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.availableroomdao.AvailableRoomDao;
import init.RMIHelper;
import po.AvailableRoomInfoPO;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * AvailableRoom的领域类
 * @author CLL
 * @version 1.0
 */
public class AvailableRoom {
	//可用住房信息列表
	private ArrayList<SingleAvailableRoomInfo> singleAvailableRoomInfoList;
	//数据层的引用
	private AvailableRoomDao availableRoomDao;
	public AvailableRoom(){
		availableRoomDao=RMIHelper.getAvailableRoomDao();
	}
	
	/**
	 * 获取酒店的可用房间信息
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		//调用数据层
		try {
			return new AvailableRoomInfoVO(availableRoomDao.getAvailableRoomInfo(hotelID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 新增酒店房间信息
	 * @param availableRoomInfoVO
	 * @return ResultMessage
	 */
	public ResultMessage confirmAvailableRoomInfo(String hotelID,AvailableRoomInfoVO availableRoomInfoVO) {
		//调用数据层
		try {
			return availableRoomDao.modifyAvailableRoomInfo(availableRoomInfoVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	/**
	 * 更新可用房间数量信息
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 */
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		//调用数据层
		try {
			return availableRoomDao.setAvailableRoomNumber(availableRoomNumberVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	/**
	 * 更新各种房型的最低价格
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage setBestPrice(String hotelID,double discount) { 
		try {
			AvailableRoomInfoPO roomInfo=availableRoomDao.getAvailableRoomInfo(hotelID);
			//new出该酒店的所有singleavailableroom对象
			for(int i=0;i<roomInfo.getRoomType().length;i++){
				singleAvailableRoomInfoList.add(new SingleAvailableRoomInfo(roomInfo.
						getHotelNumber(),roomInfo.getRoomType()[i],roomInfo.getBedType()[i],
						roomInfo.getOriginalPrice()[i],roomInfo.getLowestPrice()[i],
						roomInfo.getOriginalNumbers()[i]));
			}
			//遍历list，更新其中的房型价格
			for(int i=0;i<singleAvailableRoomInfoList.size();i++){
				singleAvailableRoomInfoList.get(i).setDiscount(discount);
			}
			//创建更新后的po
			double[] lowestPrice=new double[singleAvailableRoomInfoList.size()];
			for(int i=0;i<singleAvailableRoomInfoList.size();i++){
				lowestPrice[i]=singleAvailableRoomInfoList.get(i).getLowestPrice();
			}
			roomInfo=new AvailableRoomInfoPO(roomInfo.getHotelNumber(),roomInfo.getHotelName(),
					roomInfo.getRoomType(),roomInfo.getBedType(),roomInfo.getOriginalPrice(),
					lowestPrice,roomInfo.getOriginalNumbers());
			//交给数据层更新价格
			availableRoomDao.setBestPrice(roomInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	/**
	 * 系统返回该房型价格
	 * @param hotelID
	 * @param bedType
	 * @return ResultMessage
	 */
	public double getRoomPrice(String hotelID, BedType bedType) {
		try {
			AvailableRoomInfoPO roomInfo=availableRoomDao.getAvailableRoomInfo(hotelID);
			BedType[] bedList=roomInfo.getBedType();
			for(int i=0;i<bedList.length;i++){
				if(bedType==bedList[i]){
					return roomInfo.getLowestPrice()[i];
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 判断是否有足够的可用客房
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 */
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		try {
			AvailableRoomInfoPO roomInfo=availableRoomDao.getAvailableRoomInfo(availableRoomNumberVO.getHotelNumber());
			//当前可用房间数的列表
			int[] roomNumberList=roomInfo.getOriginalNumbers();
			BedType[] bedList=roomInfo.getBedType();
			int roomNumber=0;
			for(int i=0;i<roomNumberList.length;i++){
				if(bedList[i]==availableRoomNumberVO.getBedType()){
					roomNumber=roomNumberList[i];
				}
			}
			if(roomNumber>availableRoomNumberVO.getNumber()){
				return ResultMessage.SUCCESS;
			}
			else{
				return ResultMessage.NOTENOUGHAVAILABLEROOM;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}
}
