package businesslogic.bl.creditbl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dao.creditdao.CreditDao;
import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;
import util.TransHelper;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
/**
 * credit模块的领域类
 * @author CLL
 * @version 1.0
 */
public class Credit {
	//数据层的引用
	private CreditDao creditDao;
	//顾客编号
	private String customerID;
	//充值比例
	private static final int DEPOSIT_RATIO=100;
	//单例模式 持有user对象引用
//	private User user;
/*	public Credit(){
		creditDao=RMIHelper.getCreditDao();
	}*/
	public Credit(String customerID){
		this.customerID=customerID;
//		creditDao=RMIHelper.getCreditDao();
		creditDao=new CreditDao_Stub();
	}
	/**
	 * 获得该顾客的信用记录
	 * @param customerID
	 * @return CreditInfoVO
	 */
	public CreditInfoVO getUserCreditInfoList() {
		try {
			CreditInfoPO po=creditDao.getCreditInfo(this.customerID);
			return new CreditInfoVO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 新增一条顾客的信用记录并增加顾客的信用值
	 * @param creditVO
	 * @return ResultMessage
	 */
	public ResultMessage addCredit(CreditVO creditVO) {
		//changecredit统一为正的，增为加，扣为减
		int changeCredit=creditVO.getCreditChange();
		int nowCredit=changeCredit+creditVO.getCredit();
		//传给数据层的是变化后的credit值
		CreditPO po=new CreditPO(creditVO.getName(),TransHelper.idToInt(creditVO.getID()),nowCredit,changeCredit,
				creditVO.getReason(),creditVO.getTime());
		try {
			creditDao.setCredit(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	/**
	 * 新增一条顾客的信用记录并扣除顾客的信用值
	 * @param creditVO
	 * @return ResultMessage
	 */
	public ResultMessage cutCredit(CreditVO creditVO) {
		int changeCredit=creditVO.getCreditChange();
		int nowCredit=changeCredit-creditVO.getCredit();
		//传给数据层的是变化后的credit值
		CreditPO po=new CreditPO(creditVO.getName(),TransHelper.idToInt(creditVO.getID()),nowCredit,-changeCredit,
				creditVO.getReason(),creditVO.getTime());
		try {
			creditDao.setCredit(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	/**
	 * 新增一条顾客的信用记录并充值顾客的信用值
	 * @param money
	 * @param customerName
	 * @return ResultMessage
	 */
	public ResultMessage confirmCreditDeposit(double money, String customerId) {
		try {
			CreditInfoPO po=creditDao.getCreditInfo(customerId);
			List<CreditPO> creditInfoList=po.getCreditRecords();
			//充值之前的信用值
			int preCredit=creditInfoList.get(creditInfoList.size()-1).getCredit();
			//充值之后的信用值
			int nowCredit=preCredit+(int)money*DEPOSIT_RATIO;
			CreditPO newPO=new CreditPO(customerId,creditInfoList.get(creditInfoList.size()-1)
					.getID(),nowCredit,(int)money*DEPOSIT_RATIO,"线下充值",new Date());
			//CreditPO newPO=new CreditPO(customerName,null,money*100,"线下充值",new Date());
			creditDao.setCredit(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	/**
	 * 获得当前credit的顾客id
	 * @return String
	 */
	public String getCustomerID() {
		return customerID;
	}


}
