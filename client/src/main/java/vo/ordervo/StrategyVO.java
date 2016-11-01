package vo.ordervo;

import vo.hotelstrategyvo.HotelBestStrVO;
import vo.webstrategyvo.WebBestStrVO;
/**
 * 订单优惠信息
 * @author csy
 * @version 1.0
 */
public class StrategyVO {
      private WebBestStrVO webBestStrVO;//最佳网站策略
      private HotelBestStrVO hotelBestStrVO;//最佳酒店策略
      private double price;
      
      

	public StrategyVO(WebBestStrVO webBestStrVO, HotelBestStrVO hotelBestStrVO, double price) {
		this.webBestStrVO = webBestStrVO;
		this.hotelBestStrVO = hotelBestStrVO;
		this.price = price;
	}

	public WebBestStrVO getWebBestStrVO() {
		return webBestStrVO;
	}

	public void setWebBestStrVO(WebBestStrVO webBestStrVO) {
		this.webBestStrVO = webBestStrVO;
	}

	public HotelBestStrVO getHotelBestStrVO() {
		return hotelBestStrVO;
	}

	public void setHotelBestStrVO(HotelBestStrVO hotelBestStrVO) {
		this.hotelBestStrVO = hotelBestStrVO;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
      
      
}
