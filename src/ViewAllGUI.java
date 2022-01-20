import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.util.List;

public class ViewAllGUI extends JFrame {
	
	public ViewAllGUI(String[] allBooks) {
		//Object[] display = allBooks.toArray();
		JList<String> myList = new JList<String>(allBooks);
		this.setTitle("All Library Books");
		this.setSize(400, 300);
		JPanel panel = (JPanel)this.getContentPane();
		panel.add(myList, BorderLayout.CENTER);
		
	}
}
