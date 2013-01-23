package iamafind;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Stack;
import javax.swing.*;

/*
 * Graphical User Interface made using Java Swing
 */

public class GUI {

	private Stack<Document> _d;
	private JTextArea _jt;

	public GUI(Stack<Document> d) {
		_d = d;

		JFrame frame = new JFrame("TAG");
		JPanel empt = new JPanel();

		empt.setPreferredSize(new Dimension(400, 400));
		empt.add(amaButton());

		_jt = new JTextArea("");
		_jt.setFont(new Font("Courier New", Font.PLAIN, 10));

		empt.add(_jt);

		frame.getContentPane().add(empt, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	/*
	 * Radio button to determine a,b,c tags
	 */

	private JComponent amaButton() {
		JPanel p = new JPanel(new GridLayout(0, 1));

		JRadioButton butona = new JRadioButton("a");
		butona.addActionListener(new aListener(this));
		JRadioButton butonb = new JRadioButton("b");
		butonb.addActionListener(new bListener(this));
		JRadioButton butonc = new JRadioButton("c");
		butonc.addActionListener(new cListener(this));

		ButtonGroup ama = new ButtonGroup();

		ama.add(butona);
		ama.add(butonc);
		ama.add(butonb);
		p.add(butona);
		p.add(butonb);
		p.add(butonc);

		return p;
	}

	/*
	 * Changes what tag is being searched for, accessed and used by button
	 * Listeners
	 */

	public void changeSearch(String s) {
		_jt.setText("");
		searchForTag(s);
	}

	/*
	 * Accesses documents inside the stack and searches through them for a
	 * specific tag
	 */

	@SuppressWarnings("unchecked")
	private void searchForTag(String s) { 
		Stack<Document> d = (Stack<Document>) _d.clone();
		String jT = "";
		while (!d.isEmpty()) {
			System.out.println("searching for " + s + " in " + d.peek());
			jT += d.peek().findTag(s);
			jT += System.getProperty("line.separator");
			d.pop();
		}
		_jt.append(jT);
	}
}
