package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_credit3")
public class CreditPO implements Serializable {

	/**
	 * 记录用户信用值： 1)用户名 2）用户编号 3）当前信用值
	 * 
	 * @author Cy
	 * @virsion 1.0
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "change_id")
	private int changeID;
	@Column(name = "user_name")
	private String name;// 用户名
	@Column(name = "user_id")
	private int ID;// 编号
	@Column(name = "current_credit")
	private int credit;// 信用值
	@Column(name = "credit_change")
	private int CreditChange;// 信用值变化
	@Column(name = "change_reason")
	private String reason;// 原因
	@Column(name = "change_time")
	private java.sql.Timestamp timestamp;// 时间
	@Version
	@Column(name = "version")
	private int version;
	public CreditPO() {
	}

	public CreditPO(String name, int ID, int credit, int creditChange, String reason, Date time) {
		this.setCredit(credit);
		this.setCreditChange(creditChange);
		this.setName(name);
		this.setTime(time);
		this.setReason(reason);
		this.setID(ID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCreditChange() {
		return CreditChange;
	}

	public void setCreditChange(int creditChange) {
		CreditChange = creditChange;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getTime() {
		if (timestamp == null)
			return null;
		return new Date(timestamp.getTime());
	}

	public void setTime(Date time) {
		if (time != null)
			this.timestamp = new java.sql.Timestamp(time.getTime());
	}

	public CreditPO copy() {
		return new CreditPO(this.getName(), this.getID(), this.getCredit(), this.getCreditChange(), this.getReason(),
				this.getTime());
	}
}