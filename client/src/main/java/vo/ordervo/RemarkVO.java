package vo.ordervo;

import po.RemarkPO;

/**
 * 订单评价信息的vo类
 * @author CLL
 * @version 1.0
 */
public class RemarkVO {
	//订单编号
	private String orderId;
	//酒店编号
	private String hotelId;
	//用户id
	private String customerID;
	//评分
	private double remarkGrade;
	//评价
	private String remarkInfo;
	
	public RemarkVO(){
		
	}
	
	public RemarkVO(String orderId,String hotelId,double remarkGrade,String remarkInfo){
		this.setHotelId(hotelId);
		this.setOrderId(orderId);
		this.setRemarkGrade(remarkGrade);
		this.setRemarkInfo(remarkInfo);
	}
	/**
	 * po to vo
	 * @param po
	 */
	public RemarkVO(RemarkPO po){
		this.orderId=po.getOrderID();
		this.hotelId=idToString(po.getHotelID());
		this.remarkGrade=po.getScore();
		this.remarkInfo=po.getRemark();
	}
	/**
	 * vo to po
	 * @return RemarkPO
	 */
	public RemarkPO toPO(){
		return new RemarkPO(idToInt(this.hotelId),this.orderId,idToInt(this.customerID),this.remarkGrade,this.remarkInfo);
	}
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public double getRemarkGrade() {
		return remarkGrade;
	}

	public void setRemarkGrade(double remarkGrade) {
		this.remarkGrade = remarkGrade;
	}

	public String getRemarkInfo() {
		return remarkInfo;
	}

	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		String temp="";
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				temp=temp+id.charAt(i);
			}
		}
		return Integer.parseInt(temp);
	}
	/**
	 * id to string
	 */
	private static String idToString(int id){
		String result=String.valueOf(id);
		while(result.length()<6){
			result="0"+result;
		}
		return result;
	}
}
