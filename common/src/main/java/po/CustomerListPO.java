package po;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class CustomerListPO implements Serializable {

	/**
	 * 
	 * 
	 * 记录酒店工作人员列表信息
	 * 
	 * @author CY
	 * @virsion 1.0
	 * 
	 * 
	 */
	private String ID;
	private String name;
	private ImageIcon image;

	public CustomerListPO() {

	}

	public CustomerListPO(String ID, String name, ImageIcon image) {
		this.ID = ID;
		this.name = name;
		this.image = image;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

}