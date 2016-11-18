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
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) {
		//调用数据层
		ArrayList<AvailableRoomInfoVO> infos=new ArrayList<AvailableRoomInfoVO>();
		try {
			ArrayList<AvailableRoomInfoPO> pos=availableRoomDao.getAvailableRoomInfo(hotelID);
			for(int i=0;i<pos.size();i++){
				infos.add(new AvailableRoomInfoVO(pos.get(i)));
			}
			return infos;
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
			ArrayList<AvailableRoomInfoPO> roomInfo=availableRoomDao.getAvailableRoomInfo(hotelID);
			//new出该酒店的所有singleavailableroom对象
			for(int i=0;i<roomInfo.size();i++){
				singleAvailableRoomInfoList.add(new SingleAvailableRoomInfo(idToString(roomInfo.get(i).
						getHotelNumber()),roomInfo.get(i).getRoomType(),roomInfo.get(i).getBedType(),
						roomInfo.get(i).getOriginalPrice(),roomInfo.get(i).getLowestPrice(),
						roomInfo.get(i).getOriginalNumbers()));
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
			roomInfo=new AvailableRoomInfoPO(roomInfo.getHotelNumber(),
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
			ArrayList<AvailableRoomInfoPO> roomInfo=availableRoomDao.getAvailableRoomInfo(hotelID);
			for(int i=0;i<roomInfo.size();i++){
				if(bedType==roomInfo.get(i).getBedType()){
					return roomInfo.get(i).getLowestPrice();
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
			ArrayList<AvailableRoomInfoPO> roomInfo=availableRoomDao.getAvailableRoomInfo(availableRoomNumberVO.getHotelNumber());
			//当前可用房间数的列表
			int roomNumber=0;
			for(int i=0;i<roomInfo.size();i++){
				if(roomInfo.get(i).getBedType()==availableRoomNumberVO.getBedType()){
					roomNumber=roomInfo.get(i).getCurrentNumber();
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
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		String temp="";
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				temp=temp+id.charAt(i);
			}
		}
		return Integer.parseInt(temp);
	}
	/**
	 * id to string
	 */
	private static String idToString(int id){
		String result=String.valueOf(id);
		while(result.length()<6){
			result="0"+result;
		}
		return result;
	}
}
