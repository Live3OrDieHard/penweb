package control;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLayeredPane;

import dataStructure.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 
 * @author Thanaporn original from Anjali's GUI
 * This can interact with database in repo (MarchTest.yap)
 * it can store and retrieve file from data base
 * retrieve function is still incomplete
 * user can only retrieve data from the same session
 * (up to three instances)
 * 
 * Tech Info: internal retrieving function is working
 * but lack of core-interface interaction to identify entries
 * in the list when there are more than 3 entries
 * and lack of init function that retrieves data from database
 * at the start of the program
 *
 */
public class MockUI0 extends JFrame implements IUserInterface {

	/**
	 * OMG this is so convenient
	 */
	private JPanel contentPane;
	private JTextField ttxt;
	private JTextField textField;
	private JTextField ltxt;
	private JTextField atxt;
	private JTextField stxt;
	private JTextField tgtxt;
	private JEditorPane ctxt;
	private DefaultListModel listModel;
	int counter;
	final Controller controller;
	LinkedList<String> listTitle = new LinkedList<String>();

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public MockUI0(final Controller controller) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {

				controller.close();
			}
		});
		this.controller = controller;
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MockUI0.class.getResource("/javagui/resources/Notebook-icon.png")));
		setTitle("Programmers Examples Notebook (PEN) 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		listModel = new DefaultListModel();

		final JList listEx = new JList(listModel);
		
		JLabel lblExamples = new JLabel(" Examples:");
		lblExamples.setBounds(15, 16, 137, 16);
		lblExamples.setIcon(new ImageIcon(MockUI0.class.getResource("/javagui/resources/icon-book.png")));
		listModel.addElement("Add New Example...");
		int counter = controller.getAllinDB().size();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 35, 139, 234);
		
		textField = new JTextField();
		textField.setBounds(15, 272, 113, 20);
		textField.setToolTipText("Search (enter keyword)");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(127, 270, 27, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(MockUI0.class.getResource("/javagui/resources/search-icon.png")));
		scrollPane.setViewportView(listEx);
		contentPane.setLayout(null);
		contentPane.add(lblExamples);
		contentPane.add(scrollPane);
		contentPane.add(textField);
		contentPane.add(btnNewButton);
		
		final JInternalFrame internalFrame = new JInternalFrame("Add New Example");
		internalFrame.setBounds(480, 6, 278, 290);
		contentPane.add(internalFrame);
		internalFrame.setClosable(true);
		internalFrame.setFrameIcon(new ImageIcon(MockUI0.class.getResource("/javagui/resources/add-icon.png")));
		internalFrame.setVisible(true);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.moveToFront();
		ctxt = new JEditorPane();
				
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 144, 221, 78);
		internalFrame.getContentPane().add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(ctxt);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(50, 11, 47, 18);
		internalFrame.getContentPane().add(lblTitle);
		
		ttxt = new JTextField();
		ttxt.setBounds(86, 9, 162, 20);
		internalFrame.getContentPane().add(ttxt);
		ttxt.setColumns(10);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(30, 128, 54, 15);
		internalFrame.getContentPane().add(lblCode);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(76, 228, 84, 23);
		internalFrame.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(159, 228, 84, 23);
		internalFrame.getContentPane().add(btnReset);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setBounds(22, 33, 75, 18);
		internalFrame.getContentPane().add(lblLanguage);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(37, 56, 46, 18);
		internalFrame.getContentPane().add(lblAuthor);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setBounds(37, 80, 46, 14);
		internalFrame.getContentPane().add(lblSource);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setBounds(47, 102, 54, 18);
		internalFrame.getContentPane().add(lblTags);
		
		ltxt = new JTextField();
		ltxt.setBounds(86, 32, 162, 20);
		internalFrame.getContentPane().add(ltxt);
		ltxt.setColumns(10);
		
		atxt = new JTextField();
		atxt.setBounds(86, 55, 162, 20);
		internalFrame.getContentPane().add(atxt);
		atxt.setColumns(10);
		
		stxt = new JTextField();
		stxt.setBounds(86, 78, 162, 20);
		internalFrame.getContentPane().add(stxt);
		stxt.setColumns(10);
		
		tgtxt = new JTextField();
		tgtxt.setBounds(86, 101, 162, 20);
		internalFrame.getContentPane().add(tgtxt);
		tgtxt.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(173, 23, 289, 257);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		final JLabel lblTitle_1 = new JLabel("Title:");
		lblTitle_1.setBounds(3, 0, 90, 16);
		layeredPane.add(lblTitle_1);
		lblTitle_1.setIcon(new ImageIcon(MockUI0.class.getResource("/javagui/resources/page_code.png")));
		lblTitle_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblProperties = new JLabel("Properties:");
		lblProperties.setBounds(149, 0, 82, 16);
		layeredPane.add(lblProperties);
		lblProperties.setIcon(new ImageIcon(MockUI0.class.getResource("/javagui/resources/document-properties.png")));
		lblProperties.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 18, 142, 229);
		layeredPane.add(scrollPane_2);
		
		final JTextPane textArea = new JTextPane();
		textArea.setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
		textArea.setText("\r\n\r\n\r\n\r\n\r\n\r\n        <No Example\r\n           Selected>");
		scrollPane_2.setViewportView(textArea);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(150, 18, 137, 229);
		layeredPane.add(scrollPane_3);
		
		final JTextPane textArea_1 = new JTextPane();
		textArea_1.setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
		scrollPane_3.setViewportView(textArea_1);
		
		JButton btnEdit = new JButton("Edit...");
		btnEdit.setBounds(370, 271, 84, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(276, 271, 92, 23);
		contentPane.add(btnDelete);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ttxt.setText("");
				ltxt.setText("");
				stxt.setText("");
				atxt.setText("");
				tgtxt.setText("");
				ctxt.setText("");
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.addElement(ttxt.getText());
				controller.addBasicExample();
		}});
		
		MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 2) {
		          int index = listEx.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            //Object o = list.getModel().getElementAt(index);
		            //System.out.println("Double-clicked on: " + o.toString());
		        	List<IEntry> l = controller.getAllinDB();
		        	BasicExample bx;
		            if(index==0){
			            ttxt.requestFocus();
		            }
		            else {
		            	bx = (BasicExample) l.get(index-1);
		            	//tg1 = ((ExampleProperties) bx.getProperties()).getTags().get(0);
		            	lblTitle_1.setText("Title: "+bx.getTitle());
		            	textArea.setText("Code:\n"+bx.getCode());
		            	textArea_1.setText("Author: "+bx.getAuthors().get(0).getName()
		            			+"Language: "+bx.getProperties().getLanguage()
		            			+"Source: "+bx.getProperties().getSource());
		            	
		            	}
		          }
		        }
		      }
		    };
		
		 listEx.addMouseListener(mouseListener);
	}

	/*
	@Override
	public IHeader getHeader() {
		String title = ttxt.getText();
		if(title.length()==0)
		{
			errorBox box = new errorBox("bad title");
			box.show();
			return null;
		}
		else if ((title.length() != 0) && (ctxt.getText().length() != 0) && (atxt.getText().length()!=0)) {
			listModel.addElement(title);
			}
		if(atxt.getText().length()==0)
		{
			errorBox box = new errorBox("bad author");
			box.show();
			return null;
		}
		return new ExampleHeader(ttxt.getText(),atxt.getText());
	}
	
	@Override
	public IContent getContent() {
		if(ctxt.getText().length()==0)
		{
			errorBox box = new errorBox("bad code");
			box.show();
			return null;
		}
		return new ExampleContent(ctxt.getText());
	}
	*/

	@Override
	public String getTitle()
	{
		String title = ttxt.getText();
		if(title.length()==0)
		{
			System.out.println("Invalid title. Please try again");
		}
		return title;
	}

	@Override
	public String getAuthor()
	{
		String author = atxt.getText();
		if(author.length()==0)
		{
			System.out.println("Invalid author. Please try again");
		}
		return author;
	}

	@Override
	public String getCode()
	{
		String code = ctxt.getText();
		if(code.length()==0)
		{
			System.out.println("Invalid code. Please try again");
		}
		return code;
	}
	
	@Override
	public IProperties getProperties() {
		ExampleProperties p = new ExampleProperties();
		p.setLanguage(ltxt.getText());
		p.setSource(stxt.getText());
		//TODO: Add tag(s) and category(s) to the new entry 
		//p.addTag(tgtxt.getText());
		//clearFields();
		return p;
	}

	@Override
	public void init() 
	{
		List<String> listH = controller.getTitleList();

		for(int i=0;i<listH.size();i++)
		{
			listModel.addElement(listH.get(i));
		}
	}

	public void clearFields() 
	{
		ttxt.setText("");
		ltxt.setText("");
		stxt.setText("");
		atxt.setText("");
		tgtxt.setText("");
		ctxt.setText("");
		
	}
}

