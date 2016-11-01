package businesslogic.bl.personnelbl;

import java.util.ArrayList;

import vo.personnelvo.PersonListVO;

/**
 *某种人员列表信息集合
 * @author cy
 * @version 1.0
 * 
 */
public class PersonnelList {
    private ArrayList<PersonListVO> personlistvo;
    public PersonnelList(){
    	
    }
    public PersonnelList(ArrayList<PersonListVO> personlistvo){
    	this.personlistvo=personlistvo;
    	
    	
    }	
    
    /**初始化
     * @param keyWord
     * @return  ArrayList<PersonListVO>
     * @throws 未定
     * 需接口：PersonnelDataService.getHotelWorkerList
     * PersonnelDataService.getWebMarketManList
     * PersonnelDataService.getCustomerList
     */
    public ArrayList<PersonListVO> init(String keyWord){
    	return null;
    }
    
    /**
     * 得到用户具体信息
     * @param personID
     * @return Person
     * @throws 未定
     * 
     */
    public Person getPerson (String personID){
    	return null;
    }
}
