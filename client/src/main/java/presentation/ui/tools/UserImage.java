package presentation.ui.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import rmi.RMIconfig;
import util.UserType;

public class UserImage {
	
	/**
	 * 
	 * 顾客和酒店工作人员的头像是来自数据库的，而网站管理人员和网站营销人员的头像是系统自定的。
	 * @param imageicon
	 * @param userType
	 * @return
	 */
	public static Image getUserImage(ImageIcon imageicon,UserType userType) {
		
		switch (userType) {
		case Customer:
			return getImageFromPath("image//customer.png");
//			return getImageFromImageIcon(imageicon);
		case HotelWorker:
//			return getImageFromPath("image//hotel.jpg");
			return getImageFromImageIcon(imageicon);
		case WebMarketMan:
			return getImageFromPath("image//logo.png");
		case Manager:
			return getImageFromPath("image//logo.png");
		}
		return null;
	}
	private static Image getImageFromImageIcon(ImageIcon icon) {
		Image image= icon.getImage();
		BufferedImage bufferedImage=ImageTool.toBufferedImage(image);
		image=bufferedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			
			return image;
	}
	private static Image getImageFromPath(String path) {
		BufferedImage bImage = null;
		try {
			bImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image image = bImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return image;
	}
	
}
