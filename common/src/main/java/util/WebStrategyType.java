package util;

public enum WebStrategyType {
      SPECIALTIME,
      SPECIALAREA,
      VIP;
      
      public String toChinese() {
  		String string = null;
  		switch (this) {
  		case SPECIALTIME:
  			string = "今天是个好日子，大量优惠回馈给您！";
  			break;
  		case SPECIALAREA:
  			string = "您预订的商圈特惠，您享有大量优惠！";
  			break;
  		case VIP:
  			string = "您好，我们的VIP！您特享大量优惠！";
  			break;
  		default:
  			break;
  		}
  		return string;
  	}
}
