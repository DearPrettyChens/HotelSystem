package businesslogic.bl.webstrategybl;

import util.ResultMessage;
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
	 * 设置策略折扣
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage setWebStrategy(WebStrVO vo);
	
}
