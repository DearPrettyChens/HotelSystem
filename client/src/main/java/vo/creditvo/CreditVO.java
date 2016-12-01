package vo.creditvo;

import java.io.Serializable;
import java.util.Date;

import po.CreditPO;
import util.TransHelper;

public class CreditVO  implements Serializable{
	
	
	
	/**记录用户每条信用值：
	
	 * @author Cy
	 * @virsion 1.0
     */
	private String name;//用户名
	private String ID;//编号
	private int credit;//信用值
	private int CreditChange;//信用值变化
	private String reason;//原因
	private Date time;//时间
	
	public CreditVO(){
		
	}
    public CreditVO(CreditPO po){
    	this.name=po.getName();
    	this.ID=TransHelper.idToString(po.getID(),6);
    	//this.credit=po.getCredit();
    	this.CreditChange=po.getCreditChange();
    	this.reason=po.getReason();
    	this.time=po.getTime();
    	
		
	}
    public CreditVO(String name,String ID,int credit,int CreditChange,String reason,Date time){
    	this.name=name;
		this.credit=credit;
		this.CreditChange=CreditChange;
		this.reason=reason;
		this.time=time;
		this.ID=ID;
		
		
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCreditChange() {
		return CreditChange;
	}
	public void setCreditChange(int creditChange) {
		CreditChange = creditChange;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	
	
	
	
	}
 public CreditPO votopo(){
	 return new CreditPO(this.name,TransHelper.idToInt(this.ID),this.credit,this.CreditChange,this.reason,this.time);
	 
 }


}
