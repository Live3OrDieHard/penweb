package MarchInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Thanaporn
 * here is the new window-thing
 * How to: create a JFrame then delete its main function
 * How to "show" in main program: create an instance of it and use show()
 * --in the main program/GUI/interface--
 * form1 f1 = new form1();
 * f1.show();
 */
public class form1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 82);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOkay = new JButton("okay");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOkay.setBounds(10, 11, 89, 23);
		contentPane.add(btnOkay);
		
		JButton btnSeparate = new JButton("separate");
		btnSeparate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form1 f1 = new form1();
				f1.show();
			}
		});
		btnSeparate.setBounds(126, 11, 89, 23);
		contentPane.add(btnSeparate);
	}
}
