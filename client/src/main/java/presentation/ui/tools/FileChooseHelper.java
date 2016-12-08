package presentation.ui.tools;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class FileChooseHelper {
	public static String fileChoose() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.showDialog(new JLabel(), "选择");
		if (jfc.getSelectedFile() == null) {
			return null;
		}
		File file = jfc.getSelectedFile();

		return file.getAbsolutePath();

	}
}