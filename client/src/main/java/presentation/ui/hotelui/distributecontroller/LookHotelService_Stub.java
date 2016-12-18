package presentation.ui.hotelui.distributecontroller;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import businesslogic.blservice.hotelblservice.LookHotelService;
import exception.NotFoundHotelException;
import util.BedType;
import util.City;
import util.TradingArea;
import vo.hotelvo.HotelDetailInfoVO;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.*;

public class LookHotelService_Stub implements LookHotelService{

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID, String customerID) throws NotFoundHotelException {
		// TODO Auto-generated method stub
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		ArrayList<String> enterprises=new ArrayList<String>();
		enterprises.add("华为");
		
		ArrayList <HotelStrVO> list=new ArrayList<HotelStrVO>();
		list.add(new HotelStrVO("000005", 0.5,date));
		list.add(new HotelStrVO("000005",  0.5));
		list.add(new HotelStrVO("000005", 4, 0.5));
		list.add(new HotelStrVO("000005",0.8,enterprises));
		AvailableRoomInfoVO vo1=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo2=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo3=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo4=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo5=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		AvailableRoomInfoVO vo6=new AvailableRoomInfoVO("000005","商务房",BedType.BIGBED,680,500,10,true);
		
		ArrayList<AvailableRoomInfoVO> roomlist=new ArrayList<AvailableRoomInfoVO>();
		roomlist.add(vo1);
		roomlist.add(vo2);
		roomlist.add(vo3);
		roomlist.add(vo4);
		roomlist.add(vo5);
		roomlist.add(vo6);
		
		ArrayList<String> remarkInfos=new ArrayList<String>();
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		remarkInfos.add("2016嘉人中国风超级盛典在京举行。唐嫣罗晋公开恋情后首次合体亮相红毯，罗晋搂着唐嫣腰，大赞女友很美，唐嫣身穿红裙光彩照人，表示两人童年照很萌。");
		HotelDetailInfoVO detailvo=new HotelDetailInfoVO("绿地洲际大酒店","南京市鼓楼区",new ImageIcon("image//hotel.jpg"), TradingArea.XINJIEKOU,"12345678999"
				,5,"好","设施齐全",City.NANJING,"设施齐全","设施齐全","设施齐全","华为",list,roomlist,
				null,5,remarkInfos,500);
		return detailvo;
	}

}
