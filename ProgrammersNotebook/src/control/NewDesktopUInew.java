package control;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Panel;
import javax.swing.JSeparator;
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
import dataStructure.IEntry;
import dataStructure.NonUser;

import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;


public class NewDesktopUInew extends JFrame implements IUserInterface {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTree tree;
	DefaultMutableTreeNode root;
	DefaultTreeModel model;
	private JTabbedPane tabbedPane;
	private JTextField titleText;
	private JTextField authorText;
	private JTextField langText;
	private JTextField sourceText;
	private JTextField categoryText;
	private JTextPane codeText;
	final Controller controller;
	private BasicExample bx;
	int entry = 0;
	LinkedList<BasicExample> bxList = new LinkedList<BasicExample>();
	static LinkedList<DefaultMutableTreeNode> list = new LinkedList<DefaultMutableTreeNode>();
	LinkedList<DefaultMutableTreeNode> catList = new LinkedList<DefaultMutableTreeNode>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDesktopUInew frame = new NewDesktopUInew(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public NewDesktopUInew(final Controller controller) {
		this.controller = controller;
		root = new DefaultMutableTreeNode();
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.close();
			}
		});
		//public NewDesktopUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewDesktopUInew.class.getResource("/javagui/resources/Notebook-icon.png")));
		setTitle("Personal Example Notebook (PEN)");
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 625);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmAddNewEntry = new JMenuItem("Add New Entry");
		mnEdit.add(mntmAddNewEntry);

		JMenuItem mntmDeleteEntry = new JMenuItem("Delete Entry ");
		mnEdit.add(mntmDeleteEntry);

		JMenuItem mntmAddCategory = new JMenuItem("Add Category ");
		mnEdit.add(mntmAddCategory);

		JMenuItem mntmDeleteCategory = new JMenuItem("Delete Category");
		mnEdit.add(mntmDeleteCategory);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmWelcome = new JMenuItem("Welcome");
		mnHelp.add(mntmWelcome);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.inactiveCaption);
		JButton btnAddEntry = new JButton("Add Entry ");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode n = new DefaultMutableTreeNode("haha");
				list.add(n);
				clearFields();
				//root.add(n);
			}
		});
		btnAddEntry.setBackground(SystemColor.inactiveCaption);
		btnAddEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnAddEntry.setIcon(new ImageIcon(NewDesktopUInew.class.getResource("/javagui/resources/add-icon.png")));
		toolBar.add(btnAddEntry);

		JButton btnNewButton = new JButton("Add Category ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode newc = new DefaultMutableTreeNode("cat");
				catList.add(newc);
				root.add(newc);
				model.reload(root);
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnNewButton);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BufferEntry buf = NewDesktopUInew.this.getBufferEntry();
				bx = controller.addBasicExample(buf);
				bxList.add(bx);
				((DefaultMutableTreeNode) list.get(entry)).setUserObject(bx.getTitle());
				int i  = 0;
			  while(!catList.get(i).toString().equals(bx.getCategory())){
					i++;
				}
				System.out.println(catList.get(i).toString());
				catList.get(i).add(list.get(entry));
				entry++;	
				model.reload(root);
			}
		});
		btnSave.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnSave);

		JButton btnNewButton_1 = new JButton("Delete Entry");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnNewButton_1);

		JButton btnDeleteCategory = new JButton("Delete Category ");
		btnDeleteCategory.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnDeleteCategory);

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBackground(SystemColor.inactiveCaption);
		toolBar.add(toolBar_1);

		JButton btnNewButton_2 = new JButton("Undo");
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		toolBar_1.add(btnNewButton_2);

		JButton btnRedo = new JButton("Redo");
		btnRedo.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnRedo);

		JSeparator separator = new JSeparator();

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(desktopPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
								.addComponent(toolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addContainerGap(64, Short.MAX_VALUE)
										.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
										.addGap(861)))
										.addGap(0))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(4))
				);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(10, 11, 149, 500);
		desktopPane.add(panel);

		JComboBox comboBox = new JComboBox();

		JLabel lblSortBy = new JLabel("Sort By:");

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.inactiveCaption);
		
		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//root.getIndex();
				doMouseClicked(arg0);
				if(bx!=null){
				titleText.setText(bx.getTitle());
				codeText.setText(bx.getCode());
				authorText.setText(bx.getAuthors().get(0).getName());
				langText.setText(bx.getProperties().getLanguage());
					sourceText.setText(bx.getProperties().getSource());
				categoryText.setText(bx.getCategory());	
				}
			}
		});
		tree.setForeground(Color.WHITE);
		tree.setBackground(Color.WHITE);
		tree.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		tree.setShowsRootHandles(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSortBy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tree, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSortBy)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tree, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel lblExampleCode = new JLabel("Example Code");
		lblExampleCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGap(20)
						.addComponent(lblExampleCode)
						.addContainerGap(23, Short.MAX_VALUE))
				);
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblExampleCode))
				);
		panel_3.setLayout(gl_panel_3);
		panel.setLayout(gl_panel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		tabbedPane.setBounds(157, 11, 519, 398);
		desktopPane.add(tabbedPane);

		codeText = new JTextPane();
		tabbedPane.addTab("New tab", null, codeText, null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(157, 409, 539, 102);
		desktopPane.add(panel_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 595, Short.MAX_VALUE)
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 102, Short.MAX_VALUE)
				);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBounds(696, 11, 220, 500);
		desktopPane.add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.inactiveCaption);

		final JLabel lblAuthor = new JLabel("Author:");

		JLabel lblType = new JLabel("Language:");

		final JLabel lblTitle = new JLabel("Title:");

		JLabel lblTags = new JLabel("Source");

		JLabel lblCategories = new JLabel("Categories:");

		titleText = new JTextField();
		titleText.setColumns(10);

		authorText = new JTextField();
		authorText.setColumns(10);

		langText = new JTextField();
		langText.setColumns(10);

		sourceText = new JTextField();
		sourceText.setColumns(10);

		categoryText = new JTextField();
		categoryText.setColumns(10);

		JLabel label = new JLabel("");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblCategories)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(categoryText, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
														.addComponent(lblAuthor)
														.addComponent(lblType)
														.addComponent(lblTags)
														.addComponent(lblTitle))
														.addGap(23)
														.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
																.addComponent(titleText, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
																.addComponent(sourceText, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
																.addComponent(langText, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
																.addComponent(authorText, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
																.addContainerGap())
																.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
																.addGroup(gl_panel_2.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(label)
																		.addContainerGap(158, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(19)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitle)
								.addComponent(titleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAuthor)
										.addComponent(authorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblType)
												.addComponent(langText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblTags)
														.addComponent(sourceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCategories)
																.addComponent(categoryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGap(18)
																.addComponent(label)
																.addContainerGap(277, Short.MAX_VALUE))
				);

		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
						.addContainerGap(72, Short.MAX_VALUE)
						.addComponent(lblProperties)
						.addGap(69))
				);
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
						.addContainerGap(12, Short.MAX_VALUE)
						.addComponent(lblProperties))
				);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(679, 11, 17, 398);
		desktopPane.add(scrollBar);
		contentPane.setLayout(gl_contentPane);

		model = (DefaultTreeModel)tree.getModel();




	}

	public BufferEntry getBufferEntry()
	{
		BufferEntry e = new BufferEntry();
		String code = codeText.getText();
		String title = titleText.getText();
		String author = authorText.getText();
		String category = categoryText.getText();

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

		if(category.length() == 0){
			System.out.println("Invalid author. Please try again");
			return null;
		}
		else e.setCategory(category);
		
		e.setLanguage(langText.getText());
		e.setSource(sourceText.getText());
		return e;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public void clearFields() 
	{
		codeText.setText("");
		titleText.setText("");
		langText.setText("");
		authorText.setText("");
        sourceText.setText("");
        categoryText.setText("");
	}
	
	public void doMouseClicked(MouseEvent me){
		TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
		if(tp!=null){
			for(int i=0;i<list.size();i++){
				if(tp.getLastPathComponent().equals(list.get(i))){
					bx = bxList.get(i);
					//System.out.println(tp.toString());
					break;	
				}
				System.out.println(tp.getLastPathComponent().toString());
			}		
	}	
	}
	
}


