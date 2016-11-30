package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;

/**
 * 网站营销人员列表信息面板
 * @author cy
 * @version 1.0
 * 
 */
public class Webmarketmanlistinfo_JPanel extends Personlistinfo_JPanel {
	private JLabel imagejl=new JLabel();
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private  JLabel idjl=new JLabel();
	private  JLabel namejl=new JLabel();
	private  JLabel teljl=new JLabel();
	private  JLabel typejl=new JLabel();
	private  JLabel passwordjl=new JLabel();
	JLabel backjl=new JLabel();
	
	private  String image;
	
	private  String id;
	private  String name;
	private  String tel;
	private  String type;
	private  String password;
	
	private  MyButton moreinfojb=new MyButton();
	
	private Webmarketmandetailinfo_JFrame detailinfojp;
	
	public Webmarketmanlistinfo_JPanel(String image,String id,String name,String tel,String type,String password){
		this.image=image;
		this.id=id;
		this.name=name;
		this.tel=tel;
		this.type=type;
		this.password=password;
		
		detailinfojp=new Webmarketmandetailinfo_JFrame(id,name,tel,type,password);
		this.setBackground(Color.white);
		
		//setBak();
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
    	
    	

		ImageIcon icon=new ImageIcon(image);
		imagejl.setIcon(icon);
		
		typejl.setText("职务:   "+type);
		typejl.setFont(font);
		typejl.setBounds(120,10,200,30);
		this.add(typejl);
		
		idjl.setText("I   D:   "+id);
		idjl.setFont(font);
		idjl.setBounds(120,50,200,30);
		this.add(idjl);
		
		namejl.setText("姓名:   "+name);
		namejl.setFont(font);
		namejl.setBounds(320,10,200,30);
		this.add(namejl);
		
		teljl.setText("电话:   "+tel);
		teljl.setFont(font);
		teljl.setBounds(320,50,200,30);
		this.add(teljl);
		
		moreinfojb.setText("更多信息");
		moreinfojb.setBounds(450,30,130,30);
		this.add(moreinfojb);
		
		ImageIcon iconback=new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0,0,600,90);
		this.add(backjl);
    	
		
		detailinfojp.setBounds(600,300,350,350);
		detailinfojp.setVisible(true);
		//this.add(detailinfojp);
		
    }
	
   
    public void setListener(){
    	
    	
    	moreinfojb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				detailinfojp.setVisible(true);
				
			}
    		
    	});
    	
    	
    	
    }

}
