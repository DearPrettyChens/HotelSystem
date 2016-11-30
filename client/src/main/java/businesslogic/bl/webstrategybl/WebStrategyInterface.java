package businesslogic.bl.webstrategybl;

import exception.NotIntException;
import vo.webstrategyvo.WebStrVO;
/**
 * 网站策略接口类
 * @author CYF
 * @version 1.0
 */
public interface WebStrategyInterface {
	/**
	 * 获取策略折扣
	 * @return WebStrVO
	 */
	public WebStrVO getWebStrategy() ;

	
	/**
	 * 根据传过来的条件获取折扣值
	 * @param info
	 * @return double
	 * @throws NotIntException 
	 */
	public double getDiscount(String info) throws NotIntException;
}
