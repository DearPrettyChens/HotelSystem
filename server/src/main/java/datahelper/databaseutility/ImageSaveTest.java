package datahelper.databaseutility;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import util.ImageType;

public class ImageSaveTest {
	public static void main(String[] args) {
		try {
			Image image = ImageIO.read(new File("/Users/chengyunfei/Documents/红楼/水墨红楼(最好看的一版)/黛玉.jpg"));
			String path = ImageUtil.SaveImage(new ImageIcon(image), ImageType.userImage);
			System.out.println(path);
			ImageIcon imageIcon = ImageUtil.getImage(path);
			String path2 = ImageUtil.SaveImage(imageIcon, ImageType.hotelImage);
			System.out.println(path2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
