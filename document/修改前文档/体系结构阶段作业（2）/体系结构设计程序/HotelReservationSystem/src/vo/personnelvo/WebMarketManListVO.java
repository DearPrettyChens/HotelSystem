package vo.personnelvo;

/**
 * 网站营销人员列表信息的vo类，职责为实现逻辑层和界面层之间网站营销人员列表信息的交互
 * @author CLL
 * @version 1.0
 */
public class WebMarketManListVO {
	//用户名（真实姓名）
	private String name;
	//联系方式11位
	private String telephone;
	//用户编号
	private String id;
	
	public WebMarketManListVO(){
		
	}
	
	public WebMarketManListVO(String name,String telephone,String id){
		this.setName(name);
		this.setTelephone(telephone);
		this.setId(id);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
