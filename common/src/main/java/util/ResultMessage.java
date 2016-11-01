package util;

public enum ResultMessage {
	USEREXISTED,//用户名已存在
	USERNOTEXIST,//用户名不存在
	USERFORMATERROR,//用户名格式错误
	PASSWORDERROR,//密码错误
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
	
	DATAFORMATERROR,//日期格式错误
	
	SUCCESS,
	FAIL,
	UnkownFormat
}
