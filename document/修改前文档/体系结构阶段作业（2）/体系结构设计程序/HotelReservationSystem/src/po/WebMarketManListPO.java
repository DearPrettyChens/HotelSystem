package po;


import java.io.Serializable;
import java.util.ArrayList;

public class WebMarketManListPO implements Serializable {
	
	/**
	 * 
	 * 
	 * 记录酒店工作人员列表信息
	 * @author CY
	 * @virsion 1.0
	 *  
	 * 
	 */
	private String ID;
	private String name;
	
	public WebMarketManListPO (){
		
	}
    public  WebMarketManListPO(String ID,String name){
		this.ID=ID;
		this.name=name;
		
	
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}