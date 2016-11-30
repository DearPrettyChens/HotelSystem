package util;

public enum ResultMessage {
	//登录的时候返回的是resultMessage,需要知道是哪种人方便跳到哪个界面
	HotelWorker,
	Customer,
	WebMarketMan,
	Manager,
	
	
	USEREXISTED,//用户名已存在
	USERNOTEXIST,//用户名不存在
	USERNOTNULL,//输入用户名不能为空
	USERFORMATERROR,//用户名格式错误
	PASSWORDERROR,//密码错误
	PASSWORDNOTNULL,//输入密码不能为空
	USERTELFORMATERROR,//用户联系方式格式错误
	PASSWORDFORMATERROR,//设置的密码格式错误
	PASSWORDNOTSAME,//新密码输入两次不一致
	HOTELTELFORMATERROR,//酒店联系方式格式错误
	
	IDFORMATERROR,//身份证号格式错误
	ORDERIDERROR,//订单编号错误
	HOTELIDERROR,//酒店编号错误
	USERIDERROR,//用户编号错误
	
	NOTENOUGHAVAILABLEROOM,//没有足够的可用客房
	
	LACKOFCREDIT,//信用值小于0，不能生成订单
	
	daoFORMATERROR,//日期格式错误
	
	ORDERIDHASEXISTED,//存储订单时,订单编号已存在
	
	LISTSIZE0, //数据库无信息
	
	SUCCESS,
	FAIL,
	UnkownFormat,
	
	CONFLICTIONINSQLNEEDCOMMITAGAIN //数据库同步出错，并发问题，需要用户重新提交信息
}
