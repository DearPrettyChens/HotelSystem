package dao.driver;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import dao.hoteldao.HotelDao;
import dao.impl.HotelDaoImpl;
import datahelper.databaseutility.ImageUtil;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.City;
import util.ImageType;
import util.TradingArea;

public class HotelDataServiceImpl_Driver {
	public void drive(HotelDao dao) throws IOException {
		Image image = ImageIO.read(new File("/Users/chengyunfei/Documents/红楼/水墨红楼(最好看的一版)/黛玉.jpg"));
	//	String path = ImageUtil.SaveImage(new ImageIcon(image), ImageType.userImage);
	//	ImageIcon imageIcon = ImageUtil.getImage(path);
		
		HotelBasicInfoPO po = new HotelBasicInfoPO(5, "AAAAA", new ImageIcon(image), "AAAAA", "12345678910", 4, 0, 590, "SSS", "AAA",
				"AAA", "SSS", "RM", null, City.NANJING, TradingArea.HUNANLU);
		System.out.println(dao.addHotelBasicInfo(po));

		po = dao.getHotelBasicInfo("5");
		System.out.println("After add :" + po.getHotelID() + " " + po.getActivityFacility() + " " + po.getAddress()
				+ " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		RemarkPO remarkPO = new RemarkPO("5", "111", "2", 4.5, "ddd");
		System.out.println(dao.addRemarkInfo(remarkPO));
		po = dao.getHotelBasicInfo("5");
		System.out.println("After add remark :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		HotelBestPricePO hotelBestPricePO = new HotelBestPricePO(5, 720);
		dao.setBestPrice(hotelBestPricePO);
		po = dao.getHotelBasicInfo("5");
		System.out.println("After set best price :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		po.setAddress("NANJING");
		System.out.println(dao.setHotelBasicInfo(po));
		po = dao.getHotelBasicInfo("5");
		System.out.println("After set basic info :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

	}

	public static void main(String[] args) throws RemoteException {
		try {
			new HotelDataServiceImpl_Driver().drive(HotelDaoImpl.getInstance());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
