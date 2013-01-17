package iamafind;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

/*
 * Graphical User Interface made using Java Swing
 */

public class GUI implements ActionListener{

	private Stack<Document> _d;
	private String _wbc;

	public GUI(Stack<Document> d) {
		_d = d;
		_wbc="";

		JFrame frame = new JFrame("TAG");
		JPanel empty = new JPanel();

		empty.setPreferredSize(new Dimension(400, 400));
		
		
		empty.add(amaButton());		
		
		JTextArea lk = stackShow();
	
		empty.add(lk);
		
		frame.getContentPane().add(empty, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
	
	/*
	 * 
	 */
	
	private JTextArea stackShow() {
		String look = "Documents being queried ";
		return new JTextArea(look);
	}

	/*
	 * Radio button to determine a,b,c tags
	 */

	private JComponent amaButton() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		JRadioButton butona = new JRadioButton("a");
		butona.addActionListener(this);
		JRadioButton butonb = new JRadioButton("b");
		butonb.addActionListener(this);
		JRadioButton butonc = new JRadioButton("c");
		butonc.addActionListener(this);
		ButtonGroup ama = new ButtonGroup();
		
		ama.add(butona);
		ama.add(butonc);
		ama.add(butonb);
		p.add(butona);
		p.add(butonb);
		p.add(butonc);

		return p;
	}

	private void searchForTag(String s){
		Stack<Document> d = _d;
		
		while(!d.isEmpty()){
			System.out.println("searching for "+ s + " in " + d.peek());
			d.peek().findTag(s);
			d.pop();
		}
		
		
	}
	
	// Listener to find out which radio buttons are pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		searchForTag("a");		
	}	

}
