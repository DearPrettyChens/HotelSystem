package po;

import java.io.Serializable;
import java.util.List;
/**
 * 信用记录的po类
 * @author CYF
 * @version 1.0
 */

public class CreditInfoPO implements Serializable{
	//所有的信用记录
	private List<CreditPO> creditRecords;
	//信用记录为空
	public CreditInfoPO(){
		
	}
	//信用记录不为空
	public CreditInfoPO(List<CreditPO> creditRecords){
		this.creditRecords = creditRecords;
	}
	
	public List<CreditPO> getCreditRecords(){
		return this.creditRecords;
	}

	public void setCreditRecords(List<CreditPO> creditRecords){
		this.creditRecords = creditRecords;
	}
}
