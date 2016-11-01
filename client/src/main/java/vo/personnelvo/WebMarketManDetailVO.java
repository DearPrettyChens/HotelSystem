package vo.personnelvo;

import javax.swing.ImageIcon;
/**
 * 网站营销人员详细信息的vo类，职责为实现逻辑层和界面层之间网站营销人员详细信息的交互
 * @author CLL
 * @version 1.0
 */
public class WebMarketManDetailVO {
	//头像
	private ImageIcon userImage;
	//用户名（真实姓名）
	private String name; 
	//联系方式11位
	private String telephone;
	//密码
	private String password;
	//用户编号
	private String id;
	//制定过的策略列表
	
	
	public WebMarketManDetailVO(){
		
	}
	
	public WebMarketManDetailVO(ImageIcon userImage,String name,String telephone,String password,String id){
		this.setUserImage(userImage);
		this.setName(name);
		this.setTelephone(telephone);
		this.setPassword(password);
		this.setId(id);

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
