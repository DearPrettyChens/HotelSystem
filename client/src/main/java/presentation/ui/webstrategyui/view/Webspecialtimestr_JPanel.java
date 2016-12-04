package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import presentation.ui.tools.MyButton;
import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;

/**
 * 
 * 
 * 制定网站营销策略时，包含所有的特殊商圈策略面板
 * 
 * 确认和取消按钮还没加监听
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Webspecialtimestr_JPanel  extends JPanel{
	
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();
    private Singlewebspecialtimestr_JPanel singlewebspecialtimestr_JPanel;
	private WebstrategyDistributionController webstrategyDistributionController=WebstrategyDistributionController.getInstance(); 
	
	
	public Webspecialtimestr_JPanel(){
		//this.singleinfo; 向逻辑层要
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,500);
		
		addComp();
	}
	
	
	/**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    
	    WebStrVO webStrVO=webstrategyDistributionController.getWebStrategy(WebStrategyType.SPECIALTIME);
	    	
	    singlewebspecialtimestr_JPanel=new Singlewebspecialtimestr_JPanel(webStrVO);	
	    this.add(singlewebspecialtimestr_JPanel);
	    
	    canclejb.setText("取消");
	    canclejb.setBounds(420,300,80,30);
	    this.add(canclejb);
	    
	    	
	    confirmjb.setText("确认");
	    confirmjb.setBounds(300,300,80,30);
	    this.add(confirmjb);
	    confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				
			}
	    	
	    	
	    });
	    }
	
	

}
