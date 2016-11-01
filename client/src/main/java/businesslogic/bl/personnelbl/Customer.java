package businesslogic.bl.personnelbl;

import java.util.Date;

import javax.swing.ImageIcon;

import util.Password;
import util.ResultMessage;
import util.Telephone;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 顾客详细信息
 * @author cy
 * @version 1.0
 * 
 */
public class Customer implements Person {
	       
	   
	//头像
	private ImageIcon userImage;
	//用户名
	private String name;
	//联系方式11位
	private Telephone telephone;
	//密码
	private Password password;
	//用户编号
	private String id;
		//信用值
		private int credit;
		//生日
		private Date birthday;
		//企业名称
		private String enterpriseName;
		//会员等级
		private int VIPgrade;
		//会员类型（企业会员和普通会员两种）
		private UserType VIPType;
		 public Customer(){
		    	
		    } 
		    public Customer(ImageIcon userImage,String name,Telephone telephone,Password password,String id,int credit,Date birthday,String enterpriseName,int VIPgrade,UserType VIPType){
		    	this.userImage=userImage;
				this.name=name;
				this.telephone=telephone;
				this.password=password;
				this.id=id;
				this.credit=credit;
				this.birthday=birthday;
				this.enterpriseName=enterpriseName;
				this.VIPgrade=VIPgrade;
				this.VIPType=VIPType;
				
				
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
		    
