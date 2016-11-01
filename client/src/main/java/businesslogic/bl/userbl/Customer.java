package businesslogic.bl.userbl;

import util.ResultMessage;
import util.Telephone;
import vo.uservo.DetailInfoVO;
/**
 * Customer类
 * @author CYF
 * @version 1.0
 */
public class Customer {
	//等级
	private int grade;
	//构造方法
	public Customer(){
	}
	/**
	 * 获得用户等级方法
	 * @param name
	 * @return int
	 */
	public int getGrade(String name){
		return 0;
	}
	/**
	 * 获得用户详细信息
	 * @param name
	 * @return DetailInfoVO
	 */
	public DetailInfoVO getDetailInfo(String name){
		return null;
	}
	 /**
     * 检查联系方式格式 委托给telephone
     * @param tel
     * @return ResultMessage
     */
  	public ResultMessage checkTel(Telephone tel) {
		return tel.checkValid();
	}
    /**
     * 检查旧密码是否输入正确
     * @param name
     * @param password
     * @return ResultMessage
     */
	/**
	 * 修改用户详细信息
	 * @param detailInfoVO
	 * @return ResultMessage
	 */
	public ResultMessage modifyDetailInfo(DetailInfoVO detailInfoVO){
		return null;
	}
}
