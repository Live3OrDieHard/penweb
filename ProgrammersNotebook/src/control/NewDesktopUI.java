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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JTextPane;

import dataStructure.BasicExample;
import dataStructure.BufferEntry;
import dataStructure.ICategory;
import dataStructure.IExample;
import dataStructure.NonUser;
import exceptions.PENException;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class NewDesktopUI extends JFrame implements IUserInterface {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTree tree;
	private JTabbedPane tabbedPane;
	private JTextPane consolePanel;
	final IController controller;
	private DefaultTreeModel model;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	ArrayList<DefaultMutableTreeNode> nodelist = new ArrayList<DefaultMutableTreeNode>();
	ArrayList<DefaultMutableTreeNode> leaflist = new ArrayList<DefaultMutableTreeNode>();
	ArrayList<IExample> Examplelist = new ArrayList<IExample>();
	
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
		setBounds(0, 0,1131,709);
		
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
		
		JButton btnNewButton = new JButton("Add Category ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CategoryPanel p = new CategoryPanel();
				tabbedPane.addTab("New Category", p);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(NewDesktopUI.class.getResource("/javagui/resources/category.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(Color.BLACK);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component comp = tabbedPane.getSelectedComponent();
				if (comp instanceof CategoryPanel) {
					CategoryPanel p = (CategoryPanel) comp;
					BufferEntry bx = new BufferEntry();
					bx.setTitle(p.getTitle());
					bx.setDescription(p.getDescription());
					try {
						controller.addCategory(bx);
						NewDesktopUI.this
								.displayMessage("Category added. Title: \""
										+ bx.getTitle() + "\". Description: \""
										+ bx.getDescription() + "\"");
						tabbedPane.remove(tabbedPane.getSelectedIndex());
						DefaultMutableTreeNode child = new DefaultMutableTreeNode();
						child.setUserObject(bx.getTitle());
						root.add(child);
						nodelist.add(child);
						model.reload(root);
					} catch (PENException exception) {
						NewDesktopUI.this.displayMessage(exception
								.getMessage());
					}
				}
				else if (comp instanceof ExamplePanel) {
					ExamplePanel p = (ExamplePanel) comp;
					BufferEntry buf = p.getBufferEntry();
					try {
						BasicExample example = controller.addBasicExample(buf);
						NewDesktopUI.this.displayMessage("Example added");
						tabbedPane.remove(tabbedPane.getSelectedIndex());
						DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(buf.getTitle());
						
						String categoryName = buf.getCategoryName();
						if(categoryName.equals("")){
							root.add(leaf);
							leaflist.add(leaf);
							Examplelist.add(example);
							model.reload();
						}
						else{
						List<ICategory> listCategory = controller.getAllCategoryinDB();
						for(int i=0;i<listCategory.size();i++)
						{
							ICategory category = listCategory.get(i);
							ArrayList<String> categoryNamesFromInput = p.interpretCategories(categoryName);
							for(int c=0;c<categoryNamesFromInput.size();c++){
								if(categoryNamesFromInput.get(c).equals(category.getTitle())) {
									category.addCodeExample(example);
									for(int j=0;j<nodelist.size();j++)
									{
										if(nodelist.get(j).toString().equals(categoryNamesFromInput.get(c)))
										{
											nodelist.get(j).add(leaf);
											System.out.println("yes");
											model.reload();
										}
										System.out.println("no");
									}
									
								}
								leaf = new DefaultMutableTreeNode(buf.getTitle());
								leaflist.add(leaf);
								Examplelist.add(example);
							}
							leaflist.add(leaf);
							Examplelist.add(example);
							/*
							if(category.getTitle().equals(categoryName))
							{
								category.addCodeExample(example);
								for(int j=0;j<nodelist.size();j++)
								{
									if(nodelist.get(j).equals(categoryName))
									{
										nodelist.get(j).add(leaf);
									}
								}
								model.reload();
							}
							*/
							
						}
						}
					} catch (PENException exception) {
						NewDesktopUI.this.displayMessage(exception
								.getMessage());
					}
				}				
			}
		});
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
		
		tree = new JTree(root);
		tree.setBounds(11, 71, 159, 457);
		tree.setFont(new Font("Verdana", Font.PLAIN, 11));
		tree.setForeground(Color.WHITE);
		tree.setBackground(UIManager.getColor("text"));
		tree.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		tree.setShowsRootHandles(true);
		tree.setEditable(true);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IExample example = doMouseClicked(e);
				
				if(example==null)
					return;
				ExamplePanel pane = new ExamplePanel();
				pane.displayExample(example);
				tabbedPane.addTab(example.getTitle(), pane);
				}
		});
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
		btnAddEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExamplePanel ex = new ExamplePanel();
				tabbedPane.addTab("New Example", ex);
			}
		});
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
							.addComponent(btnAddEntry, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDeleteCategory)
							.addGap(240))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(653))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 912, GroupLayout.PREFERRED_SIZE)
							.addGap(220)))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAddEntry, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDeleteCategory, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(506))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Verdana", Font.PLAIN, 11));
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setBounds(10, 0, 881, 443);
		desktopPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 447, 902, 93);
		desktopPane.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setLayout(null);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setFont(new Font("Verdana", Font.BOLD, 11));
		lblConsole.setBounds(11, 8, 63, 14);
		panel_1.add(lblConsole);
		
		consolePanel = new JTextPane();
		consolePanel.setToolTipText("Errors and status messages printed here.");
		consolePanel.setBounds(10, 24, 882, 58);
		panel_1.add(consolePanel);
		contentPane.setLayout(gl_contentPane);
		model = (DefaultTreeModel)tree.getModel();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferEntry getBufferEntry()
	{
		ExamplePanel ex = (ExamplePanel) tabbedPane.getSelectedComponent();
		return ex.getBufferEntry();
	}

	public void displayMessage(String message) {
		this.consolePanel.setText(message);
	}


	public IExample doMouseClicked(MouseEvent me){
		if(me.getClickCount() == 2){
			TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
			//List<IExample> list = controller.getAllExampleinDB();
			if(tp!=null){
				for(int i=0;i<leaflist.size();i++){
					if(tp.getLastPathComponent().equals(leaflist.get(i))){
						IExample bx = Examplelist.get(i);
						//ExamplePanel p = new ExamplePanel();
						//p.displayExample(bx);
						//tabbedPane.addTab(bx.getTitle(), p);
						//System.out.println(tp.toString());
						return bx;
					}
					System.out.println(tp.getLastPathComponent().toString());
				}		
			}
		}
		return null;
	}	

}
