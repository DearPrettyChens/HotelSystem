package presentation.ui.tools;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * 登录时的密码区域
 * @author cy
 * @version 1.0
 * 
 */
public class Password_JPasswordFeild extends JPasswordField {
    private ImageIcon icon;

<<<<<<< HEAD
    public Password_JPasswordFeild() {
//        获取当前路径下的图片
=======
    public password_JPasswordFeild() {
    	//获取当前路径下的图片
>>>>>>> origin/master
        icon = new ImageIcon(getClass().getResource("image/password.png"));
        Insets insets = new Insets(0, 20, 0, 0);
        //设置文本输入距左边20
        this.setMargin(insets);
       //设置光标距离 
        this.setPreferredSize(new Dimension(200, 25));
        Border empty = new EmptyBorder(0, 50, 0, 0);
        CompoundBorder border = new CompoundBorder(this.getBorder(), empty);
        this.setBorder(border);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Insets insets = getInsets();
        super.paintComponent(g);
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int Height = this.getHeight();
        //在文本框中画上之前图片
        icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);
    }
}
