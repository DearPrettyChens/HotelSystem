package businesslogic.bl.personnelbl;

import javax.swing.ImageIcon;

import util.Password;
import util.ResultMessage;
import util.Telephone;
import vo.personnelvo.PersonDetailVO;

/**
 * 网站营销人员
 * @author cy
 * @version 1.0
 * 
 */
public class WebMarketMan implements Person{
	
	
	
	       //头像
			ImageIcon userImage;
			//用户名
			String name;
			//联系方式11位
			Telephone telephone;
			//密码
			Password password;
			//用户编号
			String id;
    public WebMarketMan(){
    	
    } 
    public WebMarketMan(ImageIcon userImage,String name,Telephone telephone,Password password,String id){
    	this.userImage=userImage;
		this.name=name;
		this.telephone=telephone;
		this.password=password;
		this.id=id;
		
		
    }
	@Override
	public ResultMessage addPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PersonDetailVO getDetail(String webMarketManID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage setPerson(PersonDetailVO personDetailVO) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
