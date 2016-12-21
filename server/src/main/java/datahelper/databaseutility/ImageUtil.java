package datahelper.databaseutility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import util.ImageType;

public final class ImageUtil {
	private static String saveSource;
	private static URL address;
	private static SimpleDateFormat simpleDateFormat;
	static {
		saveSource = "./UserImage/image/";
//		address=ImageUtil.class.getResource("UserImage/image/");
		simpleDateFormat = new SimpleDateFormat("YYYYMMDD");
	}

	private ImageUtil() {
	}

	private static String getDateString() {
		Date date = new Date();
		String dateString = simpleDateFormat.format(date);
		return "/" + dateString + "/";
	}

	public static String SaveImage(ImageIcon image, ImageType imageType) {
		if (image == null || imageType == null) {
			return null;
		}
		long name = new Date().getTime();
		String filePath = imageType.getString() + getDateString() + name + ".png";
		address = ImageUtil.class.getResource(saveSource+filePath);
//		File newFile = new File(saveSource + filePath);
		File newFile;
		try {
			newFile = new File(address.toURI());
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			
			BufferedImage bi = ImageTool.toBufferedImage(image.getImage());
//			Graphics2D g2d = bi.createGraphics();
//			g2d.drawImage;
			ImageIO.write(bi,"png",new File(saveSource + filePath));
//			g2d.dispose();
			
			
//			ImageIO.write((RenderedImage) image.getImage(), "png", new File(saveSource + filePath));
//			ImageIO.write((RenderedImage) image.getImage(), "png", new File(saveSource + filePath));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return filePath;
	}

	public static ImageIcon getImage(String path) {
		Image image = null;
		if (path == null) {
			return null;
		}
		address = ImageUtil.class.getResource(saveSource + path);
	
//		File newFile = new File(saveSource + path);
//		if (!newFile.exists()) {
//			return null;
//		}
		try {
			image = ImageIO.read(address.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ImageIcon(image);
	}
}
