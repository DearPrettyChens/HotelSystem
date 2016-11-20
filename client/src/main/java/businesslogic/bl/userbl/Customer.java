package businesslogic.bl.userbl;

import businesslogic.bl.personnelbl.Personnel;
import businesslogic.bl.webstrategybl.WebGradeRule;
import util.ResultMessage;
import util.Telephone;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.uservo.BasicInfoVO;
import vo.webstrategyvo.GradeRuleVO;
/**
 * Customer类
 * @author CYF
 * @version 1.0
 */
public class Customer {

	private int grade;//用户等级
	private Personnel personnel;
	private PersonDetailVO personDetailVO;
	private WebGradeRule webGradeRule;
	private static Customer customer;
	
	private Customer(){
		personnel=Personnel.getInstance();
		webGradeRule=WebGradeRule.getInstance();
	}
	
	public static Customer getInstance() {
		if(customer==null){
			customer=new Customer();
		}
		return customer;
	}
	
	/**
	 * 获得用户等级方法
	 * @param name
	 * @return int
	 */
	public int getGrade(String personID){
		personDetailVO=getDetailInfo(personID);
		int credit=personDetailVO.getCredit();//得到用户信用值
		
		GradeRuleVO gradeRuleVO=webGradeRule.getGradeRule();
		int gradeCredit=gradeRuleVO.getValue();//得到计算等级的策略
		
		if(gradeCredit==0){
			return 0;
		}
		grade=credit/gradeCredit;//计算用户等级
    	return grade;
	}
	
	/**
	 * 获得用户详细信息
	 * @param name
	 * @return DetailInfoVO
	 */
	public PersonDetailVO getDetailInfo(String personID){
		personDetailVO= personnel.getPersonDetail(personID);
		return personDetailVO;
	}
	
	/**
     * 检查联系方式格式 委托给telephone
     * @param tel
     * @return ResultMessage
     */
  	public ResultMessage checkTel(Telephone tel) {
		return tel.checkValid();
	}
 
	/**
	 * 修改用户详细信息
	 * @param detailInfoVO
	 * @return ResultMessage
	 */
	public ResultMessage modifyDetailInfo(PersonDetailVO detailInfoVO){
		personDetailVO=detailInfoVO;
		return personnel.setPerson(personDetailVO);
	}
	
	/**
     * 获得顾客基本信息
     * @param name
     * @return BasicInfoVO
     */
	public BasicInfoVO getBasicInfo(String personID) {
		personDetailVO=getDetailInfo(personID);
		return new BasicInfoVO(personDetailVO.getName(), personDetailVO.getImage(), personDetailVO.getId(), UserType.Customer);
	}
}
