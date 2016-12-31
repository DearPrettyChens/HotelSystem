package data.datahelperimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.datahelper.WebStrategyDataHelper;
import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;

public class WebStrategyDataHelperTXTImpl implements WebStrategyDataHelper {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");

	@Override
	public GradeRulePO getGradeRule() throws RemoteException {
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/graderule.txt");
		String path="/Users/green-cherry/学习/webstrategy/graderule.txt";
		GradeRulePO gradeRulePO = null;
		try {
//			InputStreamReader reader = new InputStreamReader(address.openStream(), "UTF-8");
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			int credit = Integer.parseInt(line);
			gradeRulePO = new GradeRulePO(credit);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return gradeRulePO;
	}

	@Override
	public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException {
		WebStrPO po = null;
		//按照类型分开
		switch (type) {
		case SPECIALAREA:
			po = getSpecialAreaStrategy();
			break;
		case SPECIALTIME:
			po = getSpecialTimeStrategy();
			break;
		case VIP:
			po = getVIPAreaStrategy();
			break;
		default:
			break;
		}
		return po;
	}

	public WebStrPO getSpecialTimeStrategy() {
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/specialtime.txt");
		WebStrPO po = null;

		Date[] dates = new Date[2];
		try {
			String path="/Users/green-cherry/学习/webstrategy/specialtime.txt";
//			InputStreamReader reader = new InputStreamReader(address.openStream(), "UTF-8");
			BufferedReader br = new BufferedReader(new FileReader(path));

			String str = br.readLine();

			String[] data = str.split(" ");
			if (data.length != 3) {
				return null;
			}
			//存储两个时间
			Date date1 = simpleDateFormat.parse(data[0]);
			Date date2 = simpleDateFormat.parse(data[1]);
			dates[0] = date1;
			dates[1] = date2;
			double discount = Double.parseDouble(data[2]);
			po = new WebStrPO(dates, discount);

			br.close();

			return po;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebStrPO getSpecialAreaStrategy() {
		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/specialarea.txt");
		WebStrPO po = null;
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		try {
			String path="/Users/green-cherry/学习/webstrategy/specialarea.txt";
//			InputStreamReader reader = new InputStreamReader(address.openStream(), "UTF-8");
			BufferedReader br = new BufferedReader(new FileReader(path));

			String str = br.readLine();

			while (str != null) {
				String[] data = str.split(" ");
				if (data.length != 2) {
					break;
				}
				int area = Integer.parseInt(data[0]);
				double discount = Double.parseDouble(data[1]);
				map.put(area, discount);
				str = br.readLine();
			}
			po = new WebStrPO(map, -1, WebStrategyType.SPECIALAREA);
			br.close();
			return po;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebStrPO getVIPAreaStrategy() {
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/vip.txt");
		WebStrPO po = null;
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		try {
			String path="/Users/green-cherry/学习/webstrategy/vip.txt";
//			InputStreamReader reader = new InputStreamReader(address.openStream(), "UTF-8");
			BufferedReader br = new BufferedReader(new FileReader(path));

			String str = br.readLine();

			while (str != null) {
				String[] data = str.split(" ");
				if (data.length != 2) {
					break;
				}
				int vip = Integer.parseInt(data[0]);
				double discount = Double.parseDouble(data[1]);
				map.put(vip, discount);
				str = br.readLine();
			}
			po = new WebStrPO(map, -1, WebStrategyType.VIP);
			br.close();
			return po;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException {
		// 写入数据
		//同步锁 防止同时修改
		synchronized (WebStrategyDataHelperTXTImpl.class) {
			String path="/Users/green-cherry/学习/webstrategy/graderule.txt";
			try {
//				String path=java.net.URLDecoder.decode(address.toString(),"UTF-8"); 
				FileWriter fw = new FileWriter(path);
//				FileWriter fw = new FileWriter(address.getFile());
				BufferedWriter writer = new BufferedWriter(fw);
				String string = po.getCredit() + "";
				writer.write(string);
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.FAIL;
			}
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException {
		ResultMessage resultMessage = ResultMessage.FAIL;
		switch (po.getType()) {
		case SPECIALAREA:
			resultMessage = setSpecialArea(po);
			break;
		case SPECIALTIME:
			resultMessage = setSpecialTime(po);
			break;
		case VIP:
			resultMessage = setVIP(po);
			break;
		default:
			break;
		}
		return resultMessage;
	}

	public static synchronized ResultMessage setVIP(WebStrPO po) {
		//防止同时修改
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/vip.txt");
		String path="/Users/green-cherry/学习/webstrategy/vip.txt";
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(fw);
			// 对map进行遍历
			Iterator<Map.Entry<Integer, Double>> iterator = po.getVIPOrTradingAreaStrategy().entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Double> entry = iterator.next();
				String str = entry.getKey() + " " + entry.getValue();
				writer.write(str);

				writer.write("\r\n");

			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	public static synchronized ResultMessage setSpecialTime(WebStrPO po) {
		//防止同时修改冲突
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/specialtime.txt");
		String path="/Users/green-cherry/学习/webstrategy/specialtime.txt";
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(fw);
			Date[] dates = po.getDate();
			String str = simpleDateFormat.format(dates[0]) + " " + simpleDateFormat.format(dates[1]) + " "
					+ po.getDiscount();
			writer.write(str);
			writer.write("\r\n");
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	public static synchronized ResultMessage setSpecialArea(WebStrPO po) {
		//防止同时修改冲突
//		URL address = WebStrategyDataHelperTXTImpl.class.getResource("webstrategy/specialarea.txt");
		String path="/Users/green-cherry/学习/webstrategy/specialarea.txt";
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(fw);
			// 对map进行遍历
			Iterator<Map.Entry<Integer, Double>> iterator = po.getVIPOrTradingAreaStrategy().entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Double> entry = iterator.next();
				String str = entry.getKey() + " " + entry.getValue();
				writer.write(str);
				writer.write("\r\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
}
