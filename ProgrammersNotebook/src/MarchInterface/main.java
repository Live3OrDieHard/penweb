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
import java.util.Hashtable;

import javax.swing.JTable;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		final DefaultListModel<String> lm = new DefaultListModel<String>();
		final Hashtable<String, Example> ht = new Hashtable<String, Example>();
		
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
				int index = ((JList<String>) contentPane.getComponent(1)).getSelectedIndex();
				ht.put(head, new Example(head,x));
				if(index==-1)
				{
					lm.addElement(head);
				}
				else
				{
					lm.set(index, head);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		lm.addElement("haha");
		ht.put("haha", new Example("haha","huhu"));
		lm.addElement("well");
		ht.put("well", new Example("well","well"));
		
		JList<String> list = new JList<String>(lm);
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
				int index = ((JList<String>) contentPane.getComponent(1)).getSelectedIndex();
				if(index==-1)
				{
					
				}
				else
				{
					String head = lm.get(index);
					Example code = ht.get(head);
		
					textPaneHeader.setText(head);
					textPaneContent.setText(code.content);
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
