package presentation.ui.creditui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.blservice.creditblservice.CreditInfoService;
import po.CreditInfoPO;
import po.CreditPO;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;

public class CreditInfoService_Stub implements CreditInfoService{

	@Override
	public CreditInfoVO getCreditInfo() {
		// TODO Auto-generated method stub
		ArrayList<CreditVO> vos=new ArrayList<CreditVO>();
		vos.add(new CreditVO("chen","000001",100,0,null,new Date()));
		CreditInfoVO vo=new CreditInfoVO("chen","000001",100,vos);
		return vo;
	}

}
