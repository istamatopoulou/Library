package library.gui;
import javax.swing.*;
import library.Book;
import library.core.LibraryMaps;
import java.awt.*;
import java.awt.event.*;

//google Menus in java
//add a menu to your window with the options: Books, Journals, Members, Loans

public class GUILibrary extends JFrame implements ActionListener{
	// declare all components as attributes of your class
	LibraryMaps library;

	JFrame frame;
	JMenuBar menuBar;
	JMenu booksMn, journalsMn, membersMn, loansMn;
	JMenuItem menuItem;

	JPanel contentPanel;
	JPanel mainPanel;
	JPanel buttonsPanel;

	JButton viewAllBt;
	JButton clearBt;
	JButton addBt;

	JTextField idTf;
	JTextField titleTf;
	JTextField authorTf;

	JLabel idLb;
	JLabel titleLb;
	JLabel authorLb;

	GUILibrary() {
		library = new LibraryMaps();

		// set the title for your window
		this.setTitle("Library System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The contentPanel (which is of BorderLayout) is the
		// only component we do not create:
		// we get it from the frame
		contentPanel = (JPanel) this.getContentPane();

		// CREATE ALL OTHER CONTAINERS
		// AND SET THEIR LAYOUT MANAGERS
		mainPanel = new JPanel();
		// set the mainPanel to be of GridLayout
		mainPanel.setLayout(new GridLayout(3, 2));

		// we want the buttonsPanel to be of FlowLayout
		// Because FlowLayout is the default for newly created
		// panels, we actually do not need to specify anything
		buttonsPanel = new JPanel();

		// CREATE ALL OTHER COMPONENTS
		menuBar = new JMenuBar();

		booksMn = new JMenu("Books");
		menuBar.add(booksMn);

		journalsMn = new JMenu("Journals");
		menuBar.add(journalsMn);

		membersMn = new JMenu("Members");
		menuBar.add(membersMn);

		loansMn = new JMenu("Loans");
		menuBar.add(loansMn);

		idLb = new JLabel("Id:");
		titleLb = new JLabel("Title:");
		authorLb = new JLabel("Author:");

		idTf = new JTextField("", 20);
		titleTf = new JTextField("", 20);
		authorTf = new JTextField("", 20);

		viewAllBt = new JButton("View All");
		viewAllBt.addActionListener(this);
		clearBt = new JButton("Clear Fields");
		clearBt.addActionListener(this);
		addBt = new JButton("Add Book");
		addBt.addActionListener(this);

		// ADDING COMPONENTS TO CONTAINERS
		// add the 4 components of the mainPanel in the order
		// we want them to appear
		mainPanel.add(idLb);
		mainPanel.add(idTf);
		mainPanel.add(titleLb);
		mainPanel.add(titleTf);
		mainPanel.add(authorLb);
		mainPanel.add(authorTf);

		// add the 2 components of the buttonsPanel in the
		// order we want them to appear
		buttonsPanel.add(viewAllBt);
		buttonsPanel.add(clearBt);
		buttonsPanel.add(addBt);



		// ADDING CONTAINERS TO THE CONTENT PANEL
		contentPanel.add(menuBar, BorderLayout.NORTH);
		// add the mainPanel to the centre area of the
		// contentPanel
		contentPanel.add(mainPanel, BorderLayout.CENTER);
		// add the buttonsPanel to the south area of the
		// contentPanel
		contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();

		if(action.equals("View All")) {
			library.getAllBooksInfo();
			JFrame allBooks = new GUIViewAll(library.getAllBooksInfo());
			allBooks.setVisible(true);

		}
		else if(action.equals("Clear Fields")) {
			idTf.setText("");
			titleTf.setText("");
			authorTf.setText("");
		}
		else if(action.equals("Add Book")) {
			int id = Integer.parseInt(idTf.getText());
			String title = titleTf.getText();
			String author = authorTf.getText();

			library.addTitle(new Book(id, title, author));
		}

	}
}
