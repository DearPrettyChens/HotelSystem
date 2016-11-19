package businesslogic.bl.userbl;

import java.util.EnumMap;

import util.ResultMessage;
import util.UserType;

/**
 * 
 * 用于数据层返回的clientpo中的usertype和result里面的人员种类对应
 * @author CSY
 *
 */
public class PersonMap {
    private static PersonMap personMap;
    private EnumMap<UserType, ResultMessage> enumMap;
	private PersonMap() {
		enumMap=new EnumMap<UserType, ResultMessage>(UserType.class);
	    enumMap.put(UserType.Customer, ResultMessage.Customer);
	    enumMap.put(UserType.HotelWorker, ResultMessage.HotelWorker);
	    enumMap.put(UserType.Manager, ResultMessage.Manager);
	    enumMap.put(UserType.WebMarketMan, ResultMessage.WebMarketMan);    
	}

	public static PersonMap getInstance(){
		if(personMap==null){
			personMap=new PersonMap();
		}
		return personMap;
	}
	
	/**
	 * 返回对应的resultmessage
	 * @param userType
	 * @return ResultMessage
	 */
	public ResultMessage get(UserType userType){
		return enumMap.get(userType);
	}
}
