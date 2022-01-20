import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//google Menus in java
//add a menu to you your window with the options: Books, Journals, Members, Loans

public class AddBookGui extends JFrame implements ActionListener{
	// declare all components as attributes of your class
	Library library;

	JFrame frame;
	JMenuBar menuBar;
	JMenu menu, menu2, menu3, menu4;
	JMenuItem menuItem;

	JPanel contentPanel;
	JPanel menuPanel;
	JPanel mainPanel;
	JPanel buttonsPanel;

	JButton bt1;
	JButton bt2;
	JButton bt3;

	JTextField tf1;
	JTextField tf2;
	JTextField tf3;

	JComboBox cb1;

	JLabel lb1;
	JLabel lb2;
	JLabel lb3;

	AddBookGui() {
		library = new Library();
		
		// set the title for your window
		this.setTitle("Add New Book");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The contentPanel (which is of BorderLayout) is the
		// only component we do not create:
		// we get it from the frame
		contentPanel = (JPanel) this.getContentPane();

		menuPanel = new JPanel();
		menuBar = new JMenuBar();

		menu = new JMenu("Books");
		menuBar.add(menu);

		menu2 = new JMenu("Journals");
		menuBar.add(menu2);

		menu3 = new JMenu("Members");
		menuBar.add(menu3);

		menu4 = new JMenu("Loans");
		menuBar.add(menu4);

		// CREATE ALL OTHER COMPONENTS AND CONTAINERS
		// create the other panels
		mainPanel = new JPanel();
		buttonsPanel = new JPanel();
		// create the components
		lb1 = new JLabel("Id:");
		lb2 = new JLabel("Title:");
		lb3 = new JLabel("Author:");
		tf1 = new JTextField("", 20);
		tf2 = new JTextField("", 20);
		tf3 = new JTextField("", 20);
		cb1 = new JComboBox();

		bt1 = new JButton("View All");
		bt1.addActionListener(this);
		bt2 = new JButton("Clear Fields");
		bt2.addActionListener(this);
		bt3 = new JButton("Add Book");
		bt3.addActionListener(this);
		

		// SETTING LAYOUT MANAGERS FOR CONTAINERS
		// set the mainPanel to be of GridLayout
		mainPanel.setLayout(new GridLayout(3, 2));

		// set the buttonsPanel to be of FlowLayout
		// Because FlowLayout is the default for created
		// panels, we actually do not need to specify anything

		// ADDING COMPONENTS TO CONTAINERS
		// add the 4 components of the mainPanel in the order
		// we want them to appear
		mainPanel.add(lb1);
		mainPanel.add(tf1);
		mainPanel.add(lb2);
		mainPanel.add(tf2);
		mainPanel.add(lb3);
		mainPanel.add(tf3);

		// add the 2 components of the buttonsPanel in the
		// order we want them to appear
		buttonsPanel.add(bt1);
		buttonsPanel.add(bt2);
		buttonsPanel.add(bt3);

		menuPanel.add(menu);
		menuPanel.add(menu2);
		menuPanel.add(menu3);
		menuPanel.add(menu4);

		menuBar = new JMenuBar();

		menuPanel.add(menu);

		// ADDING CONTAINERS TO THE CONTENT PANEL
		// add the mainPanel to the centre area of the
		// contentPanel
		contentPanel.add(mainPanel, BorderLayout.CENTER);
		// add the buttonsPanel to the south area of the
		// contentPanel
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);
		contentPanel.add(menuPanel, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		
		if(action.equals("View All")) {
			library.getAllBooksInfo();
			JFrame allBooks = new ViewAllGUI(library.getAllBooksInfo());
			//allBooks.pack();
			allBooks.setVisible(true);
			
		}
		else if(action.equals("Clear Fields")) {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		}
		else if(action.equals("Add Book")) {
			int id = Integer.parseInt(tf1.getText());
			String title = tf2.getText();
			String author = tf3.getText();
			
			library.addTitle(new Book(id, title, author));
		}
		
	}
}
