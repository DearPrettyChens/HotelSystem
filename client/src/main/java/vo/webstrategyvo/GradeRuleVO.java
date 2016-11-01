package vo.webstrategyvo;

/**
 * 等级规则vo
 * @author CYF
 * @version 1.0
 */
public class GradeRuleVO {
	//所有等级的数量
	private int gradeNumber;
	//上升一个等级所需的信用值
	private int value;
	public GradeRuleVO(){
	}
	public GradeRuleVO(int gradeNumber,int value){
		this.setGradeNumber(gradeNumber);
		this.setValue(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getGradeNumber() {
		return gradeNumber;
	}
	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}
	
}
