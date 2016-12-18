package vo.personnelvo;

import javax.swing.ImageIcon;

/**
 * 新增一个网站营销人员的vo类
 * @author CLL
 * @version 1.0
 */
public class WebMarketManVO {
	//头像
	private ImageIcon userImage;
	//用户名（真实姓名）
	private String name;
	//初始密码
	private String password;
	//联系方式11位
	private String telephone;
	
	public WebMarketManVO(){
		
	}
	
	public WebMarketManVO(ImageIcon userImage,String name,String password,String telephone){
		this.setUserImage(userImage);
		this.setName(name);
		this.setPassword(password);
		this.setTelephone(telephone);
	}

	public ImageIcon getUserImage() {
		return userImage;
	}

	public void setUserImage(ImageIcon userImage) {
		this.userImage = userImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
