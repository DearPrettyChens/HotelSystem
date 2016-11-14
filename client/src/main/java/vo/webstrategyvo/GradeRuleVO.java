package vo.webstrategyvo;

import po.GradeRulePO;

/**
 * 等级规则vo
 * @author CYF
 * @version 1.0
 */
public class GradeRuleVO {
	
	//上升一个等级所需的信用值
	private int value;
	public GradeRuleVO(){
	}
	public GradeRuleVO(int value){
		
		this.setValue(value);
	}
	/**
	 * po to vo
	 * @param gradeRulePO
	 */
	public GradeRuleVO(GradeRulePO gradeRulePO){
	    this.setValue(gradeRulePO.getCredit());
	}
	
	/**
	 * vo to po
	 * @return GradeRulePO
	 */
	public GradeRulePO toPO() {
		return new GradeRulePO(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
