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
		
		CreditVO vo1=new CreditVO("小俐俐","20160820000820000001",100,100,"信用充值",new Date());
		CreditVO vo2=new CreditVO("小菲菲","20160414000414000002",200,-100,"订单异常",new Date());
		CreditVO vo3=new CreditVO("陈小豆","20160305000305000003",100,100,"信用充值",new Date());
		CreditVO vo4=new CreditVO("小悦悦","20161409000409000004",200,100,"订单执行",new Date());
		CreditVO vo5=new CreditVO("小豆豆","20160525000525000005",300,-200,"订单异常",new Date());
		CreditVO vo6=new CreditVO("小豆豆","20160525000525000005",300,-200,"订单异常",new Date());
		CreditVO vo7=new CreditVO("小豆豆","20160525000525000005",300,-200,"订单异常",new Date());
		CreditVO vo8=new CreditVO("小豆豆","20160525000525000005",300,-200,"订单异常",new Date());
		
		
		vos.add(vo1);
		vos.add(vo2);
		vos.add(vo3);
		vos.add(vo4);
		vos.add(vo5);
		vos.add(vo6);
		vos.add(vo7);
		vos.add(vo8);
		
		CreditInfoVO vo=new CreditInfoVO("chen","000001",100,vos);
		return vo;
	}

}
