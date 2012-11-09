package control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTree;
import javax.swing.JSeparator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

import dataStructure.BufferEntry;
import dataStructure.NonUser;
import exceptions.PENException;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class NewDesktopUI extends JFrame implements IUserInterface {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTree tree;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane txtpnVb;
	final IController controller;
	
	
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDesktopUI frame = new NewDesktopUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	public NewDesktopUI(final IController controller) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// Close the database
				controller.close();
			}
		});
		this.controller = controller;
		
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewDesktopUI.class.getResource("/javagui/resources/Notebook-icon.png")));
		setTitle("Programmer's Examples Notebook (PEN) 1.1");
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddNewEntry = new JMenuItem("Add New Entry");
		mntmAddNewEntry.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnEdit.add(mntmAddNewEntry);
		
		JMenuItem mntmDeleteEntry = new JMenuItem("Delete Entry");
		mntmDeleteEntry.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnEdit.add(mntmDeleteEntry);
		
		JMenuItem mntmAddCategory = new JMenuItem("Add Category");
		mntmAddCategory.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		mnEdit.add(mntmAddCategory);
		
		JMenuItem mntmDeleteCategory = new JMenuItem("Delete Category");
		mntmDeleteCategory.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnEdit.add(mntmDeleteCategory);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(mnHelp);
		
		JMenuItem mntmWelcome = new JMenuItem("Welcome");
		mntmWelcome.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnHelp.add(mntmWelcome);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About PEN 1.1...");
		mntmAbout.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnHelp.add(mntmAbout);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.BLACK);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JLabel lblCategories = new JLabel("Categories:");
		lblCategories.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addContainerGap(211, Short.MAX_VALUE))
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTitle)
						.addComponent(lblCategories)
						.addComponent(lblAuthor)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTags)
							.addComponent(lblType)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTags)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategories)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(label)
					.addContainerGap(418, Short.MAX_VALUE))
		);
		panel_4.setLayout(null);
		
		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setForeground(UIManager.getColor("text"));
		lblProperties.setBounds(77, 9, 78, 17);
		lblProperties.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblProperties);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewButton = new JButton("Add Category ");
		btnNewButton.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/category.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(Color.BLACK);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BufferEntry buf = NewDesktopUI.this.getBufferEntry();
				try {
					NewDesktopUI.this.controller.addBasicExample(buf);
				} catch (PENException exception) {
					System.out.println(exception.getMessage());
				}
				//TODO: Update left-panel tree
		}});
		btnSave.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/save.png")));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Verdana", Font.BOLD, 11));
		btnSave.setBackground(Color.BLACK);
		
		JButton btnNewButton_1 = new JButton("Delete Entry");
		btnNewButton_1.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/delete.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.BLACK);
		
		JButton btnDeleteCategory = new JButton("Delete Category ");
		btnDeleteCategory.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/delete-2.png")));
		btnDeleteCategory.setForeground(Color.WHITE);
		btnDeleteCategory.setFont(new Font("Verdana", Font.BOLD, 11));
		btnDeleteCategory.setBackground(Color.BLACK);
		
		JButton btnNewButton_2 = new JButton("Undo");
		btnNewButton_2.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/undo.png")));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_2.setBackground(Color.BLACK);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/redo.png")));
		btnRedo.setForeground(Color.WHITE);
		btnRedo.setFont(new Font("Verdana", Font.BOLD, 11));
		btnRedo.setBackground(Color.BLACK);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/attachment (1).png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("scrollbar"));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 45, 85, 20);
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setBounds(11, 47, 48, 15);
		lblSortBy.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 180, 33);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.BLACK);
		
		tree = new JTree();
		tree.setBounds(11, 71, 159, 466);
		tree.setFont(new Font("Verdana", Font.PLAIN, 11));
		tree.setForeground(Color.WHITE);
		tree.setBackground(UIManager.getColor("text"));
		tree.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		tree.setShowsRootHandles(true);
		tree.setEditable(true);
		panel_3.setLayout(null);
		
		JLabel lblExampleCode = new JLabel("My Examples");
		lblExampleCode.setForeground(UIManager.getColor("text"));
		lblExampleCode.setBounds(40, 8, 100, 17);
		lblExampleCode.setFont(new Font("Verdana", Font.BOLD, 14));
		panel_3.add(lblExampleCode);
		panel.setLayout(null);
		panel.add(lblSortBy);
		panel.add(comboBox);
		panel.add(tree);
		panel.add(panel_3);
		
		JButton btnAddEntry = new JButton("Add Entry");		
		btnAddEntry.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/add-icon.png")));
		btnAddEntry.setForeground(Color.WHITE);
		btnAddEntry.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAddEntry.setBackground(Color.BLACK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAddEntry, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDeleteCategory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(653))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 912, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDeleteCategory, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAddEntry, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(506))))
		);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Verdana", Font.PLAIN, 11));
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setBounds(10, 0, 902, 443);
		desktopPane.add(tabbedPane);
		
		txtpnVb = new JTextPane();
		txtpnVb.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtpnVb.setForeground(Color.BLACK);
		tabbedPane.addTab("New Example*", null, txtpnVb, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 454, 902, 93);
		desktopPane.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setLayout(null);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setFont(new Font("Verdana", Font.BOLD, 11));
		lblConsole.setBounds(11, 8, 63, 14);
		panel_1.add(lblConsole);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferEntry getBufferEntry()
	{
		BufferEntry e = new BufferEntry();
		String code = txtpnVb.getText();
		String title = textField.getText();
		String author = textField_1.getText();

		if(code.length()==0)
		{
			System.out.println("Invalid code. Please try again");
			return null;
		}
		else e.setCode(code);

		if(title.length()==0)
		{
			System.out.println("Invalid title. Please try again");
			return null;
		}
		else e.setTitle(title);
		if(author.length()==0)
		{
			System.out.println("Invalid author. Please try again");
			return null;
		}
		else e.addAuthor(new NonUser(author));

		e.setLanguage(textField_2.getText());
		//TODO: Set category
		return e;
	}
}
