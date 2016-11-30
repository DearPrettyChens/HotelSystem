package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import util.UserType;

/**
 * 获取当前用户的用户名和密码
 * 
 * @author CLL
 * @version 1.0
 */
@Entity
@Table(name = "t_user")
public class ClientPO implements Serializable {
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true)
	private int userID;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_type")
	private UserType type;
	@Version
	@Column(name = "version")
	private int version;
	class Builder {
		ClientPO po;

		public Builder() {
			this.po = new ClientPO();
		}

		public Builder userID(int userID) {
			this.po.userID = userID;
			return this;
		}

		public Builder userName(String username) {
			this.po.userName = username;
			return this;
		}

		public Builder password(String password) {
			this.po.password = password;
			return this;
		}

		public Builder type(UserType type) {
			this.po.type = type;
			return this;
		}

		public ClientPO build() {
			return this.po;
		}
	}

	public ClientPO() {

	}

	public ClientPO(String userName, String password, int userID) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
	}

	public ClientPO(String userName, String password, int userID, UserType type) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public ClientPO copy() {
		ClientPO po = new ClientPO(this.userName, this.password, this.userID, this.type);
		return po;
	}
}
