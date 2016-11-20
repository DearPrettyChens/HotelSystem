package businesslogic.bl.personnelbl;

import java.util.EnumMap;

import util.UserType;

/**
 * 
 * 用于personVO中的usertype和每种人的class对应
 * @author CSY
 *
 */
public class PersonMap {
    private static PersonMap personMap;
    private EnumMap<UserType, Person> enumMap;
	private PersonMap() {
		enumMap=new EnumMap<UserType, Person>(UserType.class);
	    enumMap.put(UserType.Customer, Customer.getInstance());
	    enumMap.put(UserType.HotelWorker, HotelWorker.getInstance());
	    enumMap.put(UserType.WebMarketMan, WebMarketMan.getInstance());    
	}

	public static PersonMap getInstance(){
		if(personMap==null){
			personMap=new PersonMap();
		}
		return personMap;
	}
	
	/**
	 * 返回对应的Person
	 * @param userType
	 * @return Person
	 */
	public Person get(UserType userType){
		return enumMap.get(userType);
	}
}
