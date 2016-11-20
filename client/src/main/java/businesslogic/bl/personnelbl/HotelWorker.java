package businesslogic.bl.personnelbl;

import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;

/**
 * 酒店工作人员
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelWorker implements Person {
//	// 用户名
//	String name;
//	// 联系方式11位
//	Telephone telephone;
//	// 密码
//	Password password;
//	// 酒店编号
//	String id;
//	// 所在酒店名称
//	private String hotelName;

	private static Person hotelWorker;
	private HotelWorker() {

	}
	public static Person getInstance() {
		if(hotelWorker==null){
			hotelWorker=new HotelWorker();
		}
		return hotelWorker;
	}

	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDetailVO getDetail(String hotelWorkerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
