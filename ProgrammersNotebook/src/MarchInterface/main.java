package MarchInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Hashtable;

import javax.swing.JTable;

import dataStructure.BasicExample;
import dataStructure.ExampleContent;
import dataStructure.ExampleHeader;
import dataStructure.ExampleProperties;
import dataStructure.IExample;
import database.*;

public class main extends JFrame {

	private JPanel contentPane;
	private static Db4oDatabase db;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		File f1 = new File("haha");
		f1.delete();
		db = new Db4oDatabase("haha");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		final DefaultListModel lm = new DefaultListModel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBounds(280, 206, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String head = ((JTextPane) contentPane.getComponent(2)).getText();
				String x = ((JTextPane) contentPane.getComponent(3)).getText();
				db.store(BasicExample.makeBasicExample(new ExampleHeader(head,null), new ExampleContent(x), new ExampleProperties()));
				lm.addElement(head);
				}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		ExampleHeader h = new ExampleHeader("haha","man1");
		ExampleContent c = new ExampleContent("Good content");
		ExampleProperties p = new ExampleProperties();
		p.addTag("haha");
		p.addTag("testing");
		lm.addElement(h.getTitle());
		db.store(BasicExample.makeBasicExample(h,c,p));
		
		final JList list = new JList(lm);
		list.setBounds(25, 48, 52, 144);
		list.setSelectedIndices(new int[] {1});
		list.setSelectedIndex(0);
		contentPane.add(list);
		
		final JTextPane textPaneHeader = new JTextPane();
		textPaneHeader.setBounds(103, 50, 266, 20);
		contentPane.add(textPaneHeader);
		
		final JTextPane textPaneContent = new JTextPane();
		textPaneContent.setBounds(107, 81, 262, 111);
		contentPane.add(textPaneContent);
		
		JButton btnRetrieve = new JButton("retrieve");
		btnRetrieve.setBounds(25, 206, 71, 23);
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if(index==-1)
				{
					
				}
				else
				{
					BasicExample be = (BasicExample) db.getAll().get(index);
		
					textPaneHeader.setText(be.getHeader().getTitle());
					
					textPaneContent.setText(((ExampleContent) be.getContent()).getCode());
				}
				
			}
		});
		contentPane.add(btnRetrieve);
		
		JButton btnOpenBox = new JButton("open box");
		btnOpenBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				form1 f1 = new form1();
				f1.show();
			}
		});
		btnOpenBox.setBounds(119, 216, 89, 23);
		contentPane.add(btnOpenBox);
	}
}
