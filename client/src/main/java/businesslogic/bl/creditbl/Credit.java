package businesslogic.bl.creditbl;

import java.util.ArrayList;

import dataservice.availableroomdataservice.AvailableRoomDataService;
import util.ResultMessage;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
/**
 * credit模块的领域类
 * @author CLL
 * @version 1.0
 */
public class Credit {
	//数据层的引用
	private AvailableRoomDataService availableRoomDataService;
	//单条信用记录
	private String creditInfo;
	//信用值
	private int credit;
	//信用记录列表
	private ArrayList<String> creditInfoList;
	//顾客编号
	private String customerID;
	public Credit(){
		
	}
	public Credit(String customerID){
		this.customerID=customerID;
	}
	/**
	 * 获得该顾客的信用记录
	 * @param customerID
	 * @return CreditInfoVO
	 */
	public CreditInfoVO getCreditInfo(String customerID) {
		// TODO 
		return null;
	}
	/**
	 * 新增一条顾客的信用记录并增加顾客的信用值
	 * @param creditVO
	 * @return ResultMessage
	 */
	public ResultMessage addCredit(CreditVO creditVO) {
		// TODO 
		return null;
	}
	/**
	 * 新增一条顾客的信用记录并扣除顾客的信用值
	 * @param creditVO
	 * @return ResultMessage
	 */
	public ResultMessage cutCredit(CreditVO creditVO) {
		// TODO 
		return null;
	}
	/**
	 * 新增一条顾客的信用记录并充值顾客的信用值
	 * @param money
	 * @param customerName
	 * @return ResultMessage
	 */
	public ResultMessage confirmCreditDeposit(double money, String customerName) {
		// TODO 
		return null;
	}
	//以下get,set都是和数据层的交互
	private String getCustomerID() {
		return null;
	}

	private ArrayList<String> getCreditInfoList() {
		return null;
	}

	private ResultMessage setCreditInfoList(ArrayList<String> creditInfoList) {
		return null;
		
	}

	private int getCredit() {
		return 0;
	}

	private ResultMessage setCredit(int credit) {
		return null;
		
	}

	private String getCreditInfo() {
		return null;
	}

	private ResultMessage setCreditInfo(String creditInfo) {
		return null;
		
	}
}
