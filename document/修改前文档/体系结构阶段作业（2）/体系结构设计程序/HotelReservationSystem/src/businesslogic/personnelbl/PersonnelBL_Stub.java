package businesslogic.personnelbl;

import java.util.ArrayList;

import blservice.personnelblservice.PersonnelBLService;
import common.ResultMessage;
import vo.personnelvo.CustomerDetailVO;
import vo.personnelvo.CustomerListVO;
import vo.personnelvo.HotelWorkerDetailVO;
import vo.personnelvo.HotelWorkerListVO;
import vo.personnelvo.WebMarketManDetailVO;
import vo.personnelvo.WebMarketManListVO;

/**
 * 模拟管理人员模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class PersonnelBL_Stub implements PersonnelBLService{

	@Override
	public ResultMessage checkUserName(String userName) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkUserTel(String userTel) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkHotelTel(String hotelTel) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkPassword(String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmRegister(CustomerDetailVO customerDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelWorker(HotelWorkerDetailVO hotelWorkerDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addWebMarketMan(WebMarketManDetailVO webMarketManDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HotelWorkerListVO> getHotelWorkerList() {
		// TODO Auto-generated method stub
		return new ArrayList<HotelWorkerListVO>();
	}

	@Override
	public ArrayList<WebMarketManListVO> getWebMarketManList() {
		// TODO Auto-generated method stub
		return new ArrayList<WebMarketManListVO>();
	}

	@Override
	public ArrayList<CustomerListVO> getCustomerList() {
		// TODO Auto-generated method stub
		return new ArrayList<CustomerListVO>();
	}

	@Override
	public HotelWorkerDetailVO getHotelWorkerDetail(String hotelID) {
		// TODO Auto-generated method stub
		return new HotelWorkerDetailVO();
	}

	@Override
	public WebMarketManDetailVO getWebWorkerManDetail(String webWorkerManID) {
		// TODO Auto-generated method stub
		return new WebMarketManDetailVO();
	}

	@Override
	public CustomerDetailVO getCustomerDetail(String customerID) {
		// TODO Auto-generated method stub
		return new CustomerDetailVO();
	}

	@Override
	public ResultMessage modifyHotelworker(HotelWorkerDetailVO hotelWorkerDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyWebMarketMan(WebMarketManDetailVO webMarketManDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyCustomer(CustomerDetailVO customerDetailVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
