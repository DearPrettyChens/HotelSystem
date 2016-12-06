package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		if(id==null){
			return 0;//这里之后最好是用exception
		}
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
	
	/**
	 * 策略中将日期转化为string
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		String str=sdf.format(date);
		return str;
	}

	/**
	 * 策略中将string转化为日期
	 * @param time
	 * @return
	 */
	public static long stringToDate(String time) {
		if(time==null){
			return 0;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date.getTime();
	}
	
	/**
	 * 策略中将精确到秒到时间转化为string
	 * @param date
	 * @return
	 */
	public static String timeToString(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str=sdf.format(date);
		return str;
	}

	/**
	 * 策略中将string转化为时间，精确到秒
	 * @param time
	 * @return
	 */
	public static long stringToTime(String time) {
		if(time==null){
			return 0;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date.getTime();
	}
	
	/**
	 * 将商圈枚举类转化为string
	 * @param tradingArea
	 * @return
	 */
	public static String areaToString(TradingArea tradingArea) {
		if(tradingArea==null){
			return null;
		}
		return tradingArea.name();
	}
	
	/**
	 * @param area
	 * @return
	 */
	public static int stringToArea (String area) {
		if(area==null){//这里之后最好是用exception
			return 0;//此处就有可能导致测试的时候是保持在第一个商圈
		}
		TradingArea tradingArea=TradingArea.valueOf(area);
		return tradingArea.ordinal();
	} 
	
	public static TradingArea intToArea (int area) {
	    TradingArea[] tradingAreas=TradingArea.values();
		return tradingAreas[area];
	} 
	
	
//	public static void main(String[]args ) {
////		System.out.println(TransHelper.idToInt("000101"));
////		System.out.println(TransHelper.idToString(208, 6));
////		stringToArea("XINJIEKOU");
//		String date="2016-12-5 23:23:23";
//		System.out.println(stringToTime(date));
//		Date date2=new Date();
//		System.out.println(timeToString(date2));
//	}
}
