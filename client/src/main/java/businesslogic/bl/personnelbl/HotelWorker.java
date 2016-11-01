package businesslogic.bl.personnelbl;

import javax.swing.ImageIcon;

import util.Password;
import util.ResultMessage;
import util.Telephone;
import vo.personnelvo.PersonDetailVO;


/**
 * 酒店工作人员
 * @author cy
 * @version 1.0
 * 
 */
public class HotelWorker implements  Person  {
	//头像
			ImageIcon userImage;
			//用户名
			String name;
			//联系方式11位
			Telephone telephone;
			//密码
			Password password;
			//酒店编号
			String id;
		    //所在酒店名称
		private String hotelName;
		
		    public HotelWorker(){
		    	
		    } 
		    public HotelWorker(ImageIcon userImage,String name,Telephone telephone,Password password,String id,String hotelName){
		    	this.userImage=userImage;
				this.name=name;
				this.telephone=telephone;
				this.password=password;
				this.id=id;
				this.hotelName=hotelName;
				
				
		    }
			@Override
			public ResultMessage addPerson(PersonDetailVO personDetailVO) {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public PersonDetailVO getDetail() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public ResultMessage setPerson(PersonDetailVO personDetailVO) {
				// TODO Auto-generated method stub
				return null;
			}
		    
		

}
