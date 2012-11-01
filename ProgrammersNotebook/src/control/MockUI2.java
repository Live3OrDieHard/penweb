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

import dataStructure.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Thanaporn copied from Chrissy's UI (sorry I didn't ask before copying)
 * edited to work with DesktopGUIController
 * properties panel removed
 * the rest is the same
 */
public class MockUI2 extends JFrame implements IUserInterface {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @param desktopGUIController 
	 */
	public MockUI2(final DesktopGUIController controller) {
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
			public void actionPerformed(ActionEvent e) {
				controller.addEssay();
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
		
		JLabel label = new JLabel("2");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 99));
		label.setBounds(600, 91, 50, 107);
		contentPane.add(label);
	}


	@Override
	public IHeader getHeader() {
		return new ExampleHeader("no header","no header");
	}


	@Override
	public IContent getContent() {
		return new ExampleContent(((JTextPane) contentPane.getComponent(1)).getText());
	}


	@Override
	public IProperties getProperties() {
		return null;
	}
}
