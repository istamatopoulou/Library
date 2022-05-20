package library.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.util.List;

public class GUIViewAll extends JFrame {

	public GUIViewAll(String[] allBooks) {
		JList<String> myList = new JList<String>(allBooks);
		this.setTitle("All Library Books");
		this.setSize(400, 300);
		JPanel panel = (JPanel) this.getContentPane();
		panel.add(myList, BorderLayout.CENTER);

	}
}
