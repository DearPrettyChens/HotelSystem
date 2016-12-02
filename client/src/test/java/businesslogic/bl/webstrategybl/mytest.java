package businesslogic.bl.webstrategybl;


import java.util.Date;


import util.TradingArea;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;

public class mytest {
	public static void main(String[] args) {
		WebStrategy webStrategy = WebStrategy.getInstance();
		WebStrVO vo1 = new WebStrVO();
		WebStrVO vo2 = new WebStrVO();
		WebProvidedVO webProvidedVO = new WebProvidedVO("1", TradingArea.XINJIEKOU, new Date(1997, 4, 14));
//		System.out.println(
				webStrategy.getWebBestStrategy(webProvidedVO).getDiscount();
//				);
	}
}
