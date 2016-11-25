package data.datahelperimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");

	@Override
	public GradeRulePO getGradeRule() throws RemoteException {
		File gradeRuleFile = new File("/Users/chengyunfei/Desktop/webstrategy/graderule.txt");
		GradeRulePO gradeRulePO = null;
		if (!gradeRuleFile.exists()) {
			return gradeRulePO;
		}
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(gradeRuleFile), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
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
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/specialtime.txt");
		WebStrPO po = null;
		if (!file.exists()) {
			return po;
		}
		// ArrayList<WebStrPO> dateList = new ArrayList<WebStrPO>();

		Date[] dates = new Date[2];
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);

			String str = br.readLine();

			// while (str != null) {
			String[] data = str.split(" ");
			if (data.length != 3) {
				// break;
				return null;
			}
			Date date1 = simpleDateFormat.parse(data[0]);
			Date date2 = simpleDateFormat.parse(data[1]);
			dates[0] = date1;
			dates[1] = date2;
			double discount = Double.parseDouble(data[2]);
			po = new WebStrPO(dates, discount);
			// dateList.add(po);
			// str = br.readLine();
			// }

			br.close();

			// return dateList.get(0);
			return po;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebStrPO getSpecialAreaStrategy() {
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/specialarea.txt");
		WebStrPO po = null;
		if (!file.exists()) {
			return po;
		}
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);

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
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/vip.txt");
		WebStrPO po = null;
		if (!file.exists()) {
			return po;
		}
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);

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
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/graderule.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
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

	public ResultMessage setVIP(WebStrPO po) {
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/vip.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
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

	public ResultMessage setSpecialTime(WebStrPO po) {
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/specialtime.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
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

	public ResultMessage setSpecialArea(WebStrPO po) {
		File file = new File("/Users/chengyunfei/Desktop/webstrategy/specialarea.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
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