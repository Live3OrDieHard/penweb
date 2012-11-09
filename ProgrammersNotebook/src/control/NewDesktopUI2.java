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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTree;
import javax.swing.JSeparator;

import java.awt.Component;
import java.awt.Font;
import java.util.List;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.TreePath;
import javax.swing.JTextPane;

import dataStructure.BasicExample;
import dataStructure.BufferEntry;
import dataStructure.IExample;
import exceptions.PENException;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListModel;

/**
 * Iva has this "working" copy. I make a copy so it doesn't colide
 * 
 */
public class NewDesktopUI2 extends JFrame implements IUserInterface {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTabbedPane tabbedPane;
	JTextPane consolePane;
	private JList listEx;
	DefaultListModel listModel;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { NewDesktopUI frame = new
	 * NewDesktopUI(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public NewDesktopUI2(final Controller controller) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("#of Categ "+controller.getAllCategoryinDB().size());
				System.out.println("#of Examp "+controller.getAllExampleinDB().size());
				controller.close();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				NewDesktopUI2.class
						.getResource("/javagui/resources/Notebook-icon.png")));
		setTitle("Personal Example Notebook (PEN)");
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 620);

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

		JButton btnAddEntry = new JButton("New Entry ");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.addTab("New Example", new ExamplePanel());
			}
		});
		btnAddEntry.setBackground(SystemColor.inactiveCaption);
		btnAddEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnAddEntry.setIcon(new ImageIcon(NewDesktopUI2.class
				.getResource("/javagui/resources/add-icon.png")));
		toolBar.add(btnAddEntry);

		JButton btnNewButton = new JButton("New Category ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.addTab("New Category", new CategoryPanel());
				tabbedPane.repaint();
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnNewButton);

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
						NewDesktopUI2.this
								.displayMessage("Category added. Title: \""
										+ bx.getTitle() + "\". Description: \""
										+ bx.getDescription() + "\"");
						tabbedPane.remove(tabbedPane.getSelectedIndex());
					} catch (PENException exception) {
						NewDesktopUI2.this.displayMessage(exception
								.getMessage());
					}
				}
				else if (comp instanceof ExamplePanel) {
					ExamplePanel p = (ExamplePanel) comp;
					BufferEntry bx = p.getBufferEntry();
					try {
						controller.addBasicExample(bx);
						NewDesktopUI2.this.displayMessage("Example added");
						tabbedPane.remove(tabbedPane.getSelectedIndex());
					} catch (PENException exception) {
						NewDesktopUI2.this.displayMessage(exception
								.getMessage());
					}
				}				
			}
		});
		btnSave.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnSave);

		JButton btnNewButton_1 = new JButton("Discard");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedIndex());
			}
		});
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnNewButton_1);

		JButton btnRedo = new JButton("SetCategory");
		btnRedo.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnRedo);

		JSeparator separator = new JSeparator();

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(156, Short.MAX_VALUE)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE, 1,
												GroupLayout.PREFERRED_SIZE)
										.addGap(861))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addComponent(
																toolBar,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																desktopPane,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																973,
																Short.MAX_VALUE))
										.addContainerGap(45, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane
						.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE,
								522, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGap(4)));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 149, 500);
		desktopPane.add(panel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.inactiveCaption);

		listModel = new DefaultListModel();
		listEx = new JList((ListModel) listModel);
		listEx.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					int index = listEx.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						List<IExample> l = controller.getAllExampleinDB();
						BasicExample bx;
						bx = (BasicExample) l.get(index);
						// tg1 = ((ExampleProperties)
						// bx.getProperties()).getTags().get(0);
						ExamplePanel ExP = new ExamplePanel();
						ExP.displayExample(bx);

					}
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 147,
						Short.MAX_VALUE)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(10)
								.addComponent(listEx,
										GroupLayout.PREFERRED_SIZE, 128,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(listEx, GroupLayout.DEFAULT_SIZE, 443,
								Short.MAX_VALUE).addContainerGap()));

		JLabel lblExampleCode = new JLabel("Example Code");
		lblExampleCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3.createSequentialGroup().addGap(20)
						.addComponent(lblExampleCode)
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(lblExampleCode)));
		panel_3.setLayout(gl_panel_3);
		panel.setLayout(gl_panel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setBounds(157, 11, 806, 386);
		/*
		 * CategoryPanel cp = new CategoryPanel(); cp.setEnabled(true);
		 * cp.setVisible(true); tabbedPane.addTab("new", cp);
		 */desktopPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(157, 409, 806, 102);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);

		consolePane = new JTextPane();
		consolePane.setEditable(false);
		consolePane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		consolePane.setBounds(10, 11, 786, 80);
		panel_1.add(consolePane);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public BufferEntry getBufferEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	public void displayMessage(String message) {
		this.consolePane.setText(message);
	}
	
}
