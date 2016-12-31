package vo.availableroomvo;

import java.io.Serializable;
import java.util.Date;

import po.AvailableRoomNumberPO;
import util.BedType;
import util.TransHelper;

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
	
	
	
	
	public AvailableRoomNumberVO(){
		
	}
    public AvailableRoomNumberVO(int number,BedType bedType,Date date,String hotelNumber){
		this.number=number;
		this.bedType=bedType;
		this.date=date;
		this.hotelNumber=hotelNumber;
	}
    /**
     * po to vo
     * @param availableRoomNumberPO
     */
    public AvailableRoomNumberVO(AvailableRoomNumberPO availableRoomNumberPO){
    	this.number=availableRoomNumberPO.getNumber();
    	this.bedType=availableRoomNumberPO.getBedType();
    	this.date=availableRoomNumberPO.getDate();
    	this.hotelNumber=TransHelper.idToString(availableRoomNumberPO.getHotelNumber(),6);
   
    }
    /**
     * vo to po
     * @return AvailableRoomNumberPO
     */
    public AvailableRoomNumberPO toPO(){
    	return new AvailableRoomNumberPO(this.number,this.bedType,this.date,
    			TransHelper.idToInt(this.hotelNumber));
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
	 
	
}
