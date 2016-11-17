package vo.availableroomvo;

import java.io.Serializable;
import java.util.Date;

import po.AvailableRoomNumberPO;
import util.BedType;

public class AvailableRoomNumberVO  implements Serializable{
	/**
	 * 
	 * 
	 * 实现对某一天房间类型的修改
	 * @author Cy
	 * @virsion 1.0
	 */
	
	private int number;//房间数量
	private BedType bedType;//床型
	private Date date;//日期
	private String hotelNumber;//酒店编号
	//private String hotelName;//酒店名字
	
	
	
	
	public AvailableRoomNumberVO(){
		
	}
    public AvailableRoomNumberVO(int number,BedType bedType,Date date,String hotelNumber){
		this.number=number;
		this.bedType=bedType;
		this.date=date;
		this.hotelNumber=hotelNumber;
		//this.hotelName=hotelName;
	}
    /**
     * po to vo
     * @param availableRoomNumberPO
     */
    public AvailableRoomNumberVO(AvailableRoomNumberPO availableRoomNumberPO){
    	this.number=availableRoomNumberPO.getNumber();
    	this.bedType=availableRoomNumberPO.getBedType();
    	this.date=availableRoomNumberPO.getDate();
    	this.hotelNumber=idToString(availableRoomNumberPO.getHotelNumber());
    	//this.hotelName=availableRoomNumberPO.getHotelName();
    }
    /**
     * vo to po
     * @return AvailableRoomNumberPO
     */
    public AvailableRoomNumberPO toPO(){
    	return new AvailableRoomNumberPO(this.number,this.bedType,this.date,
    			idToInt(this.hotelNumber));
    }
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
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
	/*public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}*/
	
	 
	
}
