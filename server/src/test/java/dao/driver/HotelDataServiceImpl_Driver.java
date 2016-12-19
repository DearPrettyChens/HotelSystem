package dao.driver;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
		// String path = ImageUtil.SaveImage(new ImageIcon(image),
		// ImageType.userImage);
		// ImageIcon imageIcon = ImageUtil.getImage(path);

		// HotelBasicInfoPO po = new HotelBasicInfoPO(5, "AAAAA", new
		// ImageIcon(image), "AAAAA", "12345678910", 4, 0, 590, "SSS", "AAA",
		// "AAA", "SSS", "RM", null, City.NANJING, TradingArea.HUNANLU);
		// System.out.println(dao.addHotelBasicInfo(po));

		HotelBasicInfoPO po = dao.getHotelBasicInfo("5");
		System.out.println("After add :" + po.getHotelID() + " " + po.getActivityFacility() + " " + po.getAddress()
				+ " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		// RemarkPO remarkPO = new RemarkPO("5", "111", "2", 4.5, "ddd");
		// System.out.println(dao.addRemarkInfo(remarkPO));
		// po = dao.getHotelBasicInfo("5");
		// System.out.println("After add remark :" + po.getHotelID() + " " +
		// po.getActivityFacility() + " "
		// + po.getAddress() + " " + po.getLowestPrice() + " " +
		// po.getRemarkOrderNumber() + " " + po.getScore());
		//
		// HotelBestPricePO hotelBestPricePO = new HotelBestPricePO(5, 720);
		// dao.setBestPrice(hotelBestPricePO);
		// po = dao.getHotelBasicInfo("5");
		// System.out.println("After set best price :" + po.getHotelID() + " " +
		// po.getActivityFacility() + " "
		// + po.getAddress() + " " + po.getLowestPrice() + " " +
		// po.getRemarkOrderNumber() + " " + po.getScore());
		//
		// po.setAddress("NANJING");
		// System.out.println(dao.setHotelBasicInfo(po));
		// po = dao.getHotelBasicInfo("5");
		// System.out.println("After set basic info :" + po.getHotelID() + " " +
		// po.getActivityFacility() + " "
		// + po.getAddress() + " " + po.getLowestPrice() + " " +
		// po.getRemarkOrderNumber() + " " + po.getScore());

	}

	public void runClientCode(HotelDao dao) throws RemoteException {
		System.out.println(dao.getHotelBasicInfo("0005").getName());
	}
	
	ArrayList<HotelBasicInfoPO> pos = new ArrayList<HotelBasicInfoPO>(){
		{
//			add(new HotelBasicInfoPO(0, "南京大学招待所", null,"南京市鼓楼区汉口路22号", "02583592603", 4, 0, 210,
//					"南京大学招待所位于南京大学南园，拥有各类客房90多间，价格适中，环境整洁，为广大师生提供了安全、舒适的居住环境。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.GULOU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "南京万达希尔顿酒店", null,"南京市建邺区江东中路100号", "02586658888", 5, 0, 699,
//					"南京万达希尔顿坐落于南京市建邺区核心商圈，紧邻世界购物中心、高档餐厅以及南京市唯一的豪华IMAX影城等娱乐区域。"
//					+ "酒店交通便捷，距地铁站步行仅2分钟；距奥体中心及国际博览中心为5分钟车程；到市中心也仅需10分钟；距离南京禄口国际机场32公里，"
//					+ "40分钟可方便抵达；距南京高铁南站8.6公里，只需15分钟。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.ZHUJIANGLU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "7天优品南京新街口地铁站店", null,"南京秦淮区洪武路38号正洪大厦", "02552250777", 3, 0, 187,
//					"南京市第一家7天优品标准店：新街口步行街唯一一家品牌高端经济型酒店；楼下有两条地铁路线，贯穿南京东西南北，交通便利，"
//					+ "酒店提供免费现磨咖啡，红茶，绿茶，矿泉水，极速wifi；酒店设有休闲咖啡区，自主上网区，休闲沙发，超大液晶电视；"
//					+ "分店在南京市中心步行街正洪大厦7-8楼黄金位置，有部分步行街全景景观房，与多家航空公司，知名企业合作。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.XINJIEKOU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "布丁酒店", null,"南京鼓楼区苏州路17号", "02585038666", 4, 0, 210,
//					"布丁酒店连锁-南京宁海路南师大店位于宁海路和苏州路的交叉口，交通极其便利，20余路公交线路可直达南京火车站、汽车站、南京各大风景区和主要商业圈。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.GULOU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "南京涵田城市酒店", null,"南京市白下区建康路3号", "02588880018", 5, 0, 444,
//					"南京涵田城市酒店位于夫子庙景区，是“水平方”商业综合体的重要组成部分，住、吃、购、游、娱一应俱全，紧临南京“水游城”商业综合体，地理位置优越，"
//					+ "近新街口市中心，毗邻地铁一号线，酒店周边有多条公交线路可直达中山陵、总统府、雨花台等著名景点。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING ,TradingArea.FUZIMIAO, "南京大学"));
//			add(new HotelBasicInfoPO(0, "南京金鹰国际酒店", null,"南京市秦淮区汉中路101号", "02586678888", 4, 0, 210,
//					"2016年开业 2016年最后一次装修 340间客房",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.XINJIEKOU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "布丁酒店南京中山陵景区九华山店", null,"南京玄武区太平门街7号新月公寓二楼", "02566981588", 3, 0, 96,
//					"布丁酒店南京中山陵景区九华山店（原紫金山白马公园店）位于太平门大街1号月新大厦2楼（玄武高级中学旁）靠近南京国际展览中心，林业大学，师范大学。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.QIXIA, "南京大学"));
//			add(new HotelBasicInfoPO(0, "南京怡华酒店", null,"南京市鼓楼区中山北路45号", "02583592603", 4, 0, 486,
//					"南京怡华酒店风格典雅、设施齐全、设备豪华、交通便捷的经典商务型酒店，位于南京市中山北路政治、文化、金融中心，紧邻鼓楼广场、"
//					+ "湖南路商业街、地铁鼓楼站、省市党政机关、南京大学、东南大学、鼓楼医院、省广电总台，据南京火车站约6公里、"
//					+ "火车南京南站约20公里、南京禄口机场约35公里。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.HUNANLU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "南京流年青年客栈新街口店", null,"南京秦淮区新街口石鼓路193号", "02585589069", 1, 0, 80,
//					"南京流年青年客栈位于石鼓路，秦淮区地铁二号线上海路站3号出口，地铁直达南京最繁华地区新街口、夫子庙及湖南路狮子桥美食街等。"
//					+ "地处夫子庙和新街口双商圈，靠近南京妇幼保健医院，位于石鼓街美食城内。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.XINJIEKOU, "南京大学"));
//			add(new HotelBasicInfoPO(0, "如家快捷南京新街口珠江路地铁站德基广场店", null,"南京玄武区中山路韩家巷10号", "02583592603", 4, 0, 194,
//					"如家快捷南京新街口珠江路地铁站德基广场店位于中山路韩家巷10号（距珠江路地铁站南200米，距离新街口地铁站500米），"
//					+ "酒店座落于南京市内繁盛地区金融、商业、文化、娱乐中心新街口地段，全国著名的商业街中山路和电子一条街珠江路，酒店紧靠南京大学、东南大学两大著名学府。",
//					"酒店提供收费停车位 酒店各处提供wifi", "西式餐厅 中式餐厅 残疾人设施 室外游泳池", "接站服务 接机服务 洗衣服务"
//							+ " 行李寄存 看护小孩服务 租车",
//					"宽带上网 空调 国际长途电话 吹风机 24小时热水 暖气", null, City.NANJING, TradingArea.XINJIEKOU, "南京大学"));
		}
	};
	
	public void addDataToDatabase(HotelDao dao) throws RemoteException{
		for(HotelBasicInfoPO each:pos){
			dao.addHotelBasicInfo(each);
		}
	}

	public static void main(String[] args) throws RemoteException {
		try {
//			new HotelDataServiceImpl_Driver().drive(HotelDaoImpl.getInstance());
			new HotelDataServiceImpl_Driver().addDataToDatabase(HotelDaoImpl.getInstance());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
