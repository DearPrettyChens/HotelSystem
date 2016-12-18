package common;
/**
 * 制定会员等级类
 * @author CLL
 *
 */
public class WebGradeRule {
	//每升一级所需的信用值
	private int credit;
	
	public WebGradeRule(int credit){
		this.credit=credit;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
