package presentation.ui.hotelstrategyui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.creditui.view.ClientDepositeSearch_JPanel;
import presentation.ui.hotelstrategyui.viewcontroller.HotelStrategyViewControllerImpl;

/**
 * 酒店策略的总界面
 * 
 * @author csy
 *
 */

public class HotelStrategyPanel extends JPanel {
	private String hotelID;
	private ChooseHotelStr_JPanel chooseHotelStr_JPanel;
	private HotelBirthStr_JPanel hotelBirthStr_JPanel;
	private HotelEnterpriseStr_JPanel hotelEnterpriseStr_JPanel;
	private HotelOverThreeStr_Jpanel hotelOverThreeStr_Jpanel;
	private HotelSpecialTimeStr_JPanel hotelSpecialTimeStr_JPanel;
	private HotelStrategyViewControllerImpl hotelStrategyViewControllerImpl=HotelStrategyViewControllerImpl.getInstance(this);
	
	private static HotelStrategyPanel hotelStrategyPanel;
	
	public static HotelStrategyPanel getInstance(String hotelID) {
         if(hotelStrategyPanel==null){
        	 hotelStrategyPanel=new HotelStrategyPanel(hotelID);
         }return hotelStrategyPanel;
	}
	
	private HotelStrategyPanel(String hotelID) {
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		changeToChooseHotelStrPanel();
		
	}
	
	/**
	 * 跳到选择策略的界面
	 */
	public void changeToChooseHotelStrPanel() {
		this.removeAll();
        chooseHotelStr_JPanel=new ChooseHotelStr_JPanel();
        this.add(chooseHotelStr_JPanel);
        this.updateUI();
	}
	
	
	
	/**
	 * 跳到制定酒店生日特惠策略的界面
	 */
	public void changeToHotelBirthStrPanel(){
		this.removeAll();
        hotelBirthStr_JPanel=new HotelBirthStr_JPanel(hotelID);
        this.add(hotelBirthStr_JPanel);
        this.updateUI();
	}
	
	/**
	 * 跳到制定酒店合作企业策略的界面
	 */
	public void changeToHotelEnterpriseStrPanel() {
		this.removeAll();
        hotelEnterpriseStr_JPanel=new HotelEnterpriseStr_JPanel(hotelID);
        this.add(hotelEnterpriseStr_JPanel);
        this.updateUI();
	}
	
	/**
	 * 跳到制定酒店三间以上策略的界面
	 */
	
	public void changeToHotelOverThreeStrPanel() {
		this.removeAll();
        hotelOverThreeStr_Jpanel=new HotelOverThreeStr_Jpanel(hotelID);
        this.add(hotelOverThreeStr_Jpanel);
        this.updateUI();
	}
	
	/**
	 * 跳到制定酒店特定节日特惠策略的界面
	 */
	public void changeToHotelSpecialTimeStrPanel() {
		this.removeAll();
        hotelSpecialTimeStr_JPanel=new HotelSpecialTimeStr_JPanel(hotelID);
        this.add(hotelSpecialTimeStr_JPanel);
        this.updateUI();
	}
	
}
