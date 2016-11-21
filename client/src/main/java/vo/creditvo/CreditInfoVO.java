package vo.creditvo;

import java.util.ArrayList;
import java.util.List;

import po.CreditInfoPO;
import po.CreditPO;
import util.TransHelper;

public class CreditInfoVO {
	/**信用记录信息
	1)用户名
	2）用户编号
	3）当前信用值
	4)信用记录
	@author Cy
	@virsion 1.0
	*/
	private String name;//用户名
	private String customerNumber;//用户编号
	private int credit;//当前信用值
	private ArrayList<CreditVO> credits;//信用记录
	public CreditInfoVO(CreditInfoPO po){
		CreditVO  tempCreditVO;
		ArrayList<CreditVO> tempcreditsvo = new ArrayList<CreditVO>();
		ArrayList<CreditPO> tempcredits=(ArrayList<CreditPO>) po.getCreditRecords();
		for(int i=0;i<tempcredits.size();i++){
			tempCreditVO=new CreditVO(tempcredits.get(i));
			tempcreditsvo.add(tempCreditVO);
	
		}
		this.credits=tempcreditsvo;
		this.name=tempcredits.get(0).getName();
		this.customerNumber=TransHelper.idToString(tempcredits.get(0).getID(), 6);
		this.credit=(int) tempcredits.get(tempcredits.size()-1).getCredit();
	
	}
	public CreditInfoVO(){
	}
	public CreditInfoVO(String name,String customerNumber,int credit,ArrayList<CreditVO> credits){
		this.name=name;
		this.customerNumber=customerNumber;
		this.credits=credits;
		this.credit=credit;
	
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomernumber() {
		return customerNumber;
	}
	public void setCustomernumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public ArrayList<CreditVO> getCreditinfo() {
		return credits;
	}

    public void setCreditinfo(ArrayList<CreditVO> creditinfo) {
		this.credits = creditinfo;
	}

	public CreditInfoPO votopo(){
		List<CreditPO> creditRecords=new ArrayList <CreditPO> ();
		CreditPO tempPO=new CreditPO();
		
		for(int i=0;i<credits.size();i++){
			tempPO=credits.get(i).votopo();
			creditRecords.add(tempPO);
			
		}
		
		CreditInfoPO CreditInfoPO=new CreditInfoPO();
		
		CreditInfoPO.setCreditRecords(creditRecords);
		return CreditInfoPO;
		
	}

}


