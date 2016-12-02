package businesslogic.bl.hotelstrategybl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import vo.ordervo.OrderProvidedVO;

public class mytest {
	public static void main(String[] args) {
		OrderProvidedVO orderProvidedVO=new OrderProvidedVO("000002", 5, null, new Date(), "000005");
		System.out.println(HotelStrategy.getInstance().getBestHotelStrategy(orderProvidedVO).getDiscount());
	}
}
