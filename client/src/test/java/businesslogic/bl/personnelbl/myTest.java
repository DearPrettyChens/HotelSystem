package businesslogic.bl.personnelbl;

import java.util.Date;

import util.CustomerType;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

public class myTest {
	public static void main(String[] args) {
//		PersonDetailVO personDetailVO1=new PersonDetailVO(null, "小菲菲", "feifei", null, "12345678901",100 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
		PersonDetailVO personDetailVO2=new PersonDetailVO(null, "小俐俐",   "xiaolili", null, "12345678901",0 , null, null, null, "锦江之星大酒店", UserType.HotelWorker);
		Personnel personnel= Personnel.getInstance();
		System.out.println(personnel.addPerson(personDetailVO2));
	}
}
