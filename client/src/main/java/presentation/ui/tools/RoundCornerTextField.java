package presentation.ui.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
/**
 * 所有的jtextfield都换成这个
 * @author cy
 * @version 1.0
 * 
 */
public class RoundCornerTextField extends JTextField{
    private static final long serialVersionUID = -2631585163797279638L;
    private int arcH = 15 ;
    private int arcW = 15 ;
    Shape shape ;
    public RoundCornerTextField() {
        setBorder(null);
        setBackground(new Color(0, 0, 0, 0));
    }
    @Override
    public boolean contains(int x, int y) {
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight() , 15 , 15) ;
        return shape.contains(x, y);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g ;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.gray);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
        g2.setColor(new Color(0, 0, 0, 0));
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
    }

}