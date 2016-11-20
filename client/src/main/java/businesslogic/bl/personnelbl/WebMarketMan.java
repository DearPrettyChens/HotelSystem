package businesslogic.bl.personnelbl;

import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;

/**
 * 网站营销人员
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class WebMarketMan implements Person {
	
//	// 用户名
//	String name;
//	// 联系方式11位
//	Telephone telephone;
//	// 密码
//	Password password;
//	// 用户编号
//	String id;

	private static Person webMarketMan;
	private WebMarketMan() {

	}
	public static Person getInstance() {
		if(webMarketMan==null){
			webMarketMan=new WebMarketMan();
		}
		return webMarketMan;
	}
	

	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDetailVO getDetail(String webMarketManID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
