package businesslogic.bl.personnelbl;

import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;

/**
 * 
 *各种人员的接口
 * @author cy
 * @version 1.0
 * 
 */
public interface Person {
	    
		
		
        /**
         * 增加用户信息
         * @param PersonDetailVO personDetailVO
         * @return ResultMessage
         * @throws 未定
         * 需接口：PersonnelDataService.addCustomer
         * PersonnelDataService.addHotelWorker
         * PersonnelDataService.addWebMarketMan
         */
        public ResultMessage addPerson(PersonDetailVO personDetailVO);
        /**
         * 得到用户详细信息
         * @param null
         * @return PersonDetailVO
         * @throws 未定
         * 需接口：PersonnelDataService.getHotelworkerDetail
         * PersonnelDataService.getWebMarketManDetail
         * PersonnelDataService.getCustomerDetail
         */
        public PersonDetailVO getDetail ();
        /**
         * 修改用户详细信息
         * @param PersonDetailVO personDetailVO
         * @return ResultMessage
         * @throws 未定
         * 需接口：PersonnelDataService. setHotelWorker
         * PersonnelDataService. setWebMarketMan
         * PersonnelDataService. setCustomer
         */
        public ResultMessage setPerson (PersonDetailVO personDetailVO);
        
        
}
