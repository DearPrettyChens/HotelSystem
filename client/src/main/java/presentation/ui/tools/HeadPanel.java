package presentation.ui.tools;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import util.UserType;

public class HeadPanel extends JPanel {
    private Image image;
	public HeadPanel(ImageIcon imageicon,UserType userType) {
		image = UserImage.getUserImage(imageicon,userType);
		repaint();
	}
	
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.setBackground(new Color(148, 221, 184));

		int x = 5;
		int y = 5;
		int size = 50;

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(198, 237, 217));
		g.fillRoundRect(x, y, size + 6, size + 6, size + 6, size + 6);	
		g.drawImage(getRenderedImage(ImageTool.toBufferedImage(image), 0, 0, size), x + 3, y + 3, this);

	}

	/**
	 * 为了绘制头像内容
	 * 
	 * @param img
	 * @param x
	 * @param y
	 * @param size
	 * @return
	 */
	private BufferedImage getRenderedImage(BufferedImage img, int x, int y, int size) {

		BufferedImage result = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = result.createGraphics();
		g.translate(-x, -y);
		g.drawImage(img, 0, 0, null);
		g.translate(x, y);

		RoundRectangle2D round = new RoundRectangle2D.Double(0, 0, size, size, size, size);
		Area clear = new Area(new Rectangle(0, 0, size, size));
		clear.subtract(new Area(round));
		g.setComposite(AlphaComposite.Clear);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fill(clear);
		g.dispose();
		return result;
	}
}
