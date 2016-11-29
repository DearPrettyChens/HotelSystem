package presentation.ui.tools;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 进行信用充值搜索出来的顾客列表信息
 * @author cy
 * @version 1.0
 * 
 */
public class Clientdepositelistinfo_JPanel extends JPanel {
	private JLabel imagejl=new JLabel();
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private  JLabel idjl=new JLabel();
	private  JLabel namejl=new JLabel();
	private  JLabel teljl=new JLabel();
	
	
	JLabel backjl=new JLabel();
	
	
	
	private  String id;
	private  String name;
	private  String tel;
	
	private  String credit;
	
	
	private  MyButton depositjb=new MyButton();
	
	private Clientdetailinfo_JFrame detailinfojp;
	
	public Clientdepositelistinfo_JPanel(String id,String name,String tel, String credit){
		
		this.id=id;
		this.name=name;
		this.tel=tel;
		
		this.credit=credit;
		
		//detailinfojp=new Clientdetailinfo_JFrame(id,name,tel,type,password);
		this.setBackground(Color.white);
		
		this.setLayout(null);
		addComp();
		setListener();
		
		
		
		
		
	}
	
	
	
	
	
	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	

		
		
		
		
		idjl.setText("I   D:   "+id);
		idjl.setFont(font);
		idjl.setBounds(120,10,200,30);
		this.add(idjl);
		
		namejl.setText("姓名:   "+name);
		namejl.setFont(font);
		namejl.setBounds(120,50,200,30);
		this.add(namejl);
		
		teljl.setText("电话:   "+tel);
		teljl.setFont(font);
		teljl.setBounds(320,10,200,30);
		this.add(teljl);
		
		depositjb.setText("充值");
		depositjb.setBounds(450,30,130,30);
		this.add(depositjb);
		
		ImageIcon iconback=new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0,0,600,90);
		this.add(backjl);
    	
		
		//detailinfojp.setBounds(600,300,350,350);
		//detailinfojp.setVisible(true);
		//this.add(detailinfojp);
		
    }
	
   
    public void setListener(){
    	
    	
    	depositjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//未写
			}
    		
    	});
    	
    	
    	
    }

}
