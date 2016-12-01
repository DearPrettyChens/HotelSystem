package presentation.uitools;

import com.jhlabs.image.GaussianFilter;

import presentation.ui.tools.ImageTool;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 
 
/**
 *
 * @date   05/02/2013
 */
public class Demo extends JPanel {
   
  public static void main(String[] args) {
     
    SwingUtilities.invokeLater(new Runnable() {
 
      @Override
      public void run() {
         
        JFrame f = new JFrame("Test");
        f.setContentPane(new Demo());
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
      }
    });
  }
   
  private BufferedImage image;
  private Image small;
  private Point loc;
  private int halfScaledSize;
  Demo() {
     
    try {
       
      image = ImageIO.read(new File("image//c.png"));
      small = image.getScaledInstance(
              image.getWidth()/2, image.getHeight()/2,
              Image.SCALE_SMOOTH);
      halfScaledSize = small.getWidth(this) / 8;
      loc = new Point(0, 0);
    }
    catch(Exception e) {
       
      throw new RuntimeException(e);
    }
     
    setPreferredSize(new Dimension(small.getWidth(this), small.getHeight(this)));
     
    addMouseMotionListener(new MouseMotionAdapter() {
 
      @Override
      public void mouseMoved(MouseEvent e) {
         
        loc.x = e.getX();
        loc.y = e.getY();
        repaint();
      }
    });
  }
   
  @Override
  protected void paintComponent(Graphics g) {
     
    super.paintComponent(g);
    this.setBackground( new Color(148,221,184));
//    g.drawImage(small, 0, 0, this);
     
//    int x = loc.x - halfScaledSize;
//    int y = loc.y - halfScaledSize;
//    int size = halfScaledSize * 2;
    int x=0;
    int y=0;
    int size=80;
 
    BufferedImage shadow = getShadow(Color.BLACK, size+6, 6);
    g.drawImage(shadow, x + 3, y + 3, this);
     
    ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                     RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(new Color(215, 225, 120));
    g.fillRoundRect(x, y, size+ 6, size + 6, size + 6, size + 6);
     
    try {
    	BufferedImage bImage=ImageIO.read(new File("image//d.jpg"));
    	Image i=bImage.getScaledInstance(
                80, 80,
                Image.SCALE_SMOOTH);
    	g.drawImage(getRenderedImage(ImageTool. toBufferedImage(i) , 0, 0, size), 
	            x + 3, y + 3, this);
//		g.drawImage(getRenderedImage( ImageIO.read(new File("image//d.jpg")), loc.x * 2, loc.y * 2, size), 
//		            x + 3, y + 3, this);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
   
  private BufferedImage getShadow(Color c, int size, int blur) {
     
    int fix = blur / 2;
 
    BufferedImage result = new BufferedImage(
            size, size, BufferedImage.TYPE_INT_ARGB);
 
    Graphics2D g = result.createGraphics();
    g.setClip(new RoundRectangle2D.Double(
            fix, fix, size - blur, size - blur, size - blur, size - blur));
    g.setColor(c);
    g.fillRect(0, 0, result.getWidth(), result.getHeight());
    g.dispose();
 
    GaussianFilter filter = new GaussianFilter(blur);
    result = filter.filter(result, result);
     
    return result;
  }
   
  private BufferedImage getRenderedImage(
          BufferedImage img, int x, int y, int size) {
     
    BufferedImage result = new BufferedImage(
            size, size, BufferedImage.TYPE_INT_ARGB);
     
    Graphics2D g = result.createGraphics();
    g.translate(-x, -y);
    g.drawImage(img, 0, 0, null);
    g.translate(x, y);
     
    RoundRectangle2D round = new RoundRectangle2D.Double(0, 0, size, size, size, size);
    Area clear = new Area(new Rectangle(0, 0, size, size));
    clear.subtract(new Area(round));
    g.setComposite(AlphaComposite.Clear);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                       RenderingHints.VALUE_ANTIALIAS_ON);
    g.fill(clear);
    g.dispose();
    return result;
  }

}