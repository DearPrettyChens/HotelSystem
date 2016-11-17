package vo.personnelvo;

import javax.swing.ImageIcon;

import po.PersonListPO;

public class PersonListVO {

	/**
	 * 用户列表信息的vo类，职责为实现逻辑层和界面层之间顾客详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	private String Id;
	// 用户名名称
	private String Name;
	// 头像
	private ImageIcon Image;
	// 联系方式11位
	private String telephone;
	// 所在酒店名称
	private String hotelName;
	//tab
	private String tab;
	

	public PersonListVO() {

	}
	public PersonListVO(PersonListPO po) {
		this.setId(idToString(po.getId()));
		this.setName(po.getName());
		this.setImage(po.getImage());
		this.setTelephone(po.getTelephone());
		this.setHotelName(po.getHotelName());
	}

	public PersonListVO(String Id, String Name, ImageIcon Image, String telephone, String hotelName,String tab) {
		this.Id = Id;
		this.Name = Name;
		this.Image = Image;
		this.telephone = telephone;
		this.hotelName = hotelName;
		this.tab=tab;
		

	}

	public PersonListPO toPO(){
		return new PersonListPO(idToInt(Id),Name,Image,telephone,hotelName,tab);
	}
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ImageIcon getImage() {
		return Image;
	}

	public void setImage(ImageIcon image) {
		Image = image;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
