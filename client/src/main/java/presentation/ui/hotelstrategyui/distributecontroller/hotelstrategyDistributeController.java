package presentation.ui.hotelstrategyui.distributecontroller;

import businesslogic.bl.hotelstrategybl.HotelStrategyController;
import businesslogic.blservice.hotelstrategyblservice.HotelStrategyBLService;
import util.HotelStrategyType;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;
/**
 * hotelStrategy界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class HotelStrategyDistributeController {
	private static HotelStrategyDistributeController controller=null;
	private HotelStrategyBLService hotelStrategyBLService;
	private HotelStrategyDistributeController(){
		hotelStrategyBLService=HotelStrategyController.getInstance();
	}
	public static HotelStrategyDistributeController getInstance(){
		if(controller==null){
			controller=new HotelStrategyDistributeController();
		}
		return controller;
	}
	
	/**
	 * 获取最佳酒店策略
	 * @param orderProvidedVO OrderProvidedVO型，传递订单涉及到策略需要的信息
	 * @return HotelBestStrVO ，将最佳酒店策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO){
		return hotelStrategyBLService.getBestHotelStrategy(orderProvidedVO);
	}
	
	/**
	 * 获取特定类型的酒店策略
	 * @param hotelID String型,type HotelStrategyType 型，传递酒店编号和策略类型
	 * @return HotelStrVO ，将特定酒店策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public HotelStrVO getHotelStrategy(String hotelID,HotelStrategyType type){
		return hotelStrategyBLService.getHotelStrategy(hotelID, type);
	}
	
	/**
	 * 保存酒店策略信息
	 * @param hotelStrVO HotelStrVO型，界面传递过来的酒店策略信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO){
		return hotelStrategyBLService.confirmHotelStrategy(hotelStrVO);
	}
}
