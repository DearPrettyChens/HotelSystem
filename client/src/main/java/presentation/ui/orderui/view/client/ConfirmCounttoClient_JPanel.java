package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.JLabelTool;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.StrategyVO;
import vo.webstrategyvo.WebBestStrVO;

/**
 * 
 * 顾客确认优惠信息的面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ConfirmCounttoClient_JPanel extends JPanel {

	private String webStrName = "";
	private double webDiscount = 0;

	private double hotelDiscount = 0;;
	private String hotelStrName = "";
	private double price = 0;

	private JLabel hotelcountjl = new JLabel();
	private JLabel hotelstrnamejl = new JLabel();
	private JLabel webcountjl = new JLabel();
	private JLabel webstrnamejl = new JLabel();
	private JLabel pricejl = new JLabel();
	private JLabel hoteljl = new JLabel("酒店优惠");
	private JLabel webjl = new JLabel("网站优惠");
	private JLabel pricetittlejl = new JLabel("订单价格");

	private Font font = new Font("宋体", Font.BOLD, 18);
	private Color color = new Color(148, 221, 184);

	private HotelBestStrVO hotelBestStrVO;
	private WebBestStrVO webBestStrVO;

	public ConfirmCounttoClient_JPanel(StrategyVO strategyVO) {
		if (strategyVO != null) {
			hotelBestStrVO = strategyVO.getHotelBestStrVO();
			webBestStrVO = strategyVO.getWebBestStrVO();

			this.hotelStrName = hotelBestStrVO.getType().toChinese();
			this.hotelDiscount = hotelBestStrVO.getDiscount();
			this.webStrName = webBestStrVO.getWebStrategyType().toChinese();
			this.webDiscount = webBestStrVO.getDiscount();

			this.price = strategyVO.getPrice();
		}

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 300);
		addComp();

	}

	public void addComp() {

		hoteljl.setBounds(200, 40, 200, 30);
		hoteljl.setFont(new Font("宋体", Font.BOLD, 20));
		hoteljl.setForeground(color);
		this.add(hoteljl);

		hotelstrnamejl.setText(hotelStrName);
		hotelcountjl.setText("您将享受" + hotelDiscount + "折优惠,");

		hotelstrnamejl.setBounds(300, 40, 400, 30);
		hotelstrnamejl.setFont(font);
		this.add(hotelstrnamejl);

		hotelcountjl.setBounds(300, 70, 200, 30);
		hotelcountjl.setFont(font);
		this.add(hotelcountjl);

		webjl.setBounds(200, 120, 200, 30);
		webjl.setFont(new Font("宋体", Font.BOLD, 20));
		webjl.setForeground(color);
		this.add(webjl);

		webstrnamejl.setText(webStrName);
		webcountjl.setText("您将享受" + webDiscount + "折优惠,");

		webstrnamejl.setBounds(300, 120, 400, 30);
		webstrnamejl.setFont(font);
		this.add(webstrnamejl);

		webcountjl.setBounds(300, 150, 200, 30);
		webcountjl.setFont(font);
		this.add(webcountjl);

		pricetittlejl.setBounds(200, 200, 200, 30);
		pricetittlejl.setFont(new Font("宋体", Font.BOLD, 20));
		pricetittlejl.setForeground(color);
		this.add(pricetittlejl);

		pricejl.setText(price + "元。");
		pricejl.setBounds(300, 200, 200, 30);
		pricejl.setFont(font);
		this.add(pricejl);

	}

}
