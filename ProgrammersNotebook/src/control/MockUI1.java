package control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

import dataStructure.*;

/**
 * 
 * @author Thanaporn copied from Chrissy's UI (sorry I didn't ask before copying)
 * edited to work with DesktopGUIController
 * the rest is the same
 */
public class MockUI1 extends JFrame implements IUserInterface {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtTagsKeywords;
	private JTextField txtDescription;


	/**
	 * Create the frame.
	 * @param desktopGUIController 
	 */
	public MockUI1(final DesktopGUIController controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 140, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JLabel lblExamples = new JLabel("Examples");
		lblExamples.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExamples.setBounds(39, 11, 71, 14);
		panel.add(lblExamples);
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setBounds(10, 36, 39, 14);
		panel.add(lblSortBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Flat", "Category", "Language"}));
		comboBox.setBounds(59, 35, 71, 17);
		panel.add(comboBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(1, 193, 138, 2);
		panel.add(separator_1);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addBasicExample();
			}
		});
		btnAddEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblExamples.setText("haha");
			}
		});
		btnAddEntry.setBounds(28, 206, 89, 23);
		panel.add(btnAddEntry);
		
		JList list = new JList();
		list.setBorder(new LineBorder(Color.LIGHT_GRAY));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Entry 1", "Entry 2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(11, 61, 119, 119);
		panel.add(list);
		
		JButton btnAddEssay = new JButton("add essay");
		btnAddEssay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addEssay();
			}
		});
		btnAddEssay.setBounds(28, 236, 89, 23);
		panel.add(btnAddEssay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(565, 0, 139, 355);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Properties");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(32, 11, 84, 14);
		panel_1.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setText("Entry Name");
		txtName.setBounds(9, 52, 86, 20);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JCheckBox chckbxPublic = new JCheckBox("Public");
		chckbxPublic.setBounds(9, 234, 97, 23);
		panel_1.add(chckbxPublic);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 279, 138, 2);
		panel_1.add(separator_2);
		
		JButton btnAddCategory = new JButton("Add Category");
		btnAddCategory.setBounds(9, 292, 120, 23);
		panel_1.add(btnAddCategory);
		
		txtAuthor = new JTextField();
		txtAuthor.setText("Author");
		txtAuthor.setBounds(9, 100, 86, 20);
		panel_1.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtTagsKeywords = new JTextField();
		txtTagsKeywords.setText("Tags / Keywords");
		txtTagsKeywords.setBounds(9, 149, 86, 20);
		panel_1.add(txtTagsKeywords);
		txtTagsKeywords.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setText("Description");
		txtDescription.setBounds(9, 198, 86, 20);
		panel_1.add(txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblEntryName = new JLabel("Entry Name");
		lblEntryName.setBounds(10, 36, 85, 14);
		panel_1.add(lblEntryName);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(9, 85, 46, 14);
		panel_1.add(lblAuthor);
		
		JLabel lblTagsKeywords = new JLabel("Tags / Keywords:");
		lblTagsKeywords.setBounds(9, 133, 86, 14);
		panel_1.add(lblTagsKeywords);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(9, 182, 85, 14);
		panel_1.add(lblDescription);
		
		JTextPane txtpnCodeGoesHere = new JTextPane();
		txtpnCodeGoesHere.setFont(new Font("Courier New", Font.PLAIN, 12));
		txtpnCodeGoesHere.setText("Code goes here...");
		txtpnCodeGoesHere.setBounds(139, 0, 410, 354);
		contentPane.add(txtpnCodeGoesHere);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(139, 354, 565, 88);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(10, 5, 46, 14);
		panel_2.add(lblConsole);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 22, 544, 55);
		panel_2.add(textPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(548, 0, 17, 354);
		contentPane.add(scrollBar);
	}



	@Override
	public IHeader getHeader() {
		String personname = ((JTextField) (((JPanel) contentPane.getComponent(1)).getComponent(5))).getText();
		String entryname = ((JTextField) (((JPanel) contentPane.getComponent(1)).getComponent(1))).getText();
		return new ExampleHeader(entryname,personname);
	}


	@Override
	public IContent getContent() {
		return new ExampleContent(((JTextPane) contentPane.getComponent(2)).getText());
	}


	@Override
	public IProperties getProperties() {
		String tag = ((JTextField) (((JPanel) contentPane.getComponent(1)).getComponent(6))).getText();
		ExampleProperties p = new ExampleProperties();
		p.addTag(tag);
		return p;
	}
}
