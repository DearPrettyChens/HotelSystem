package presentation.uitools;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.support.StaticApplicationContext;
 
public class TestTT {
    public static void main(String[] args) throws IOException {
    	Color backcolor = new Color(148, 221, 184);
        BufferedImage bi1 = ImageIO.read(new File("image//dou.png"));
 
        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
                BufferedImage.TYPE_INT_RGB);
 
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
                .getHeight());
 
        Graphics2D g2 = bi2.createGraphics();
        g2.setBackground(backcolor);
        g2.fill(new Rectangle(bi2.getWidth(), bi2.getHeight()));
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();
 
        try {
            ImageIO.write(bi2, "jpg", new File("image//dou.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JButton jButton=new JButton(new ImageIcon(bi2));
        jButton.setBackground(Color.BLACK);
        JFrame jFrame=new JFrame();
        
		jFrame.setLocation
        ( 
           (int) (Toolkit.getDefaultToolkit().getScreenSize().
                  getWidth() - 1000) / 2,
           (int) (Toolkit.getDefaultToolkit().getScreenSize().
                  getHeight() - 700) / 2
            ); //定位框架位置
	      jFrame.setSize(1000, 700);
	     jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	      jFrame.getContentPane().add(jButton);
	      jFrame.setVisible(true);
    }
}
