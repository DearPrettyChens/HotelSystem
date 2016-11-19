package util;

/**
 * 
 * 界面层的编号是String类型，数据层是int类型，需要进行转化
 * @author CSY
 *
 */
public class TransHelper {
	
	/**
	 * 编号string转化成int
	 */
	public static int idToInt(String id){
		while(id.charAt(0)=='0'){
			id=id.substring(1);
		}
		return Integer.parseInt(id);
	}
	
	
	/**
	 * 编号int to string
	 */
	public static String idToString(int id,int length){
		String result=String.valueOf(id);
		while(result.length()<length){
			result="0"+result;
		}
		return result;
	}
	
//	public static void main(String[]args ) {
//		System.out.println(TransHelper.idToInt("000101"));
//		System.out.println(TransHelper.idToString(208, 6));
//	}
}
