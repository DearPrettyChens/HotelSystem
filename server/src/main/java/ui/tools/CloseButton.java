
package ui.tools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 右上角关闭按钮
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CloseButton extends JButton {
	private ImageIcon icon = new ImageIcon(CloseButton.class.getResource("close.png"));

	public CloseButton() {
		this.setIcon(icon);
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
