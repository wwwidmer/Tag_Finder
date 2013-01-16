package iamafind;

import java.awt.GridLayout;
import java.util.Stack;

import javax.swing.*;

public class GUI {

	public GUI(Stack<Document> d) {

		JFrame frame = new JFrame("TAG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.pack();
		frame.setVisible(true);

		frame.add(amaButton());
		frame.add(lfButton());

	}

	private JComponent lfButton() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		JRadioButton butona = new JRadioButton("1");
		JRadioButton butonb = new JRadioButton("2");
		JRadioButton butonc = new JRadioButton("3");
		ButtonGroup ama = new ButtonGroup();
		ama.add(butona);
		ama.add(butonc);
		ama.add(butonb);
		p.add(butona);
		p.add(butonb);
		p.add(butonc);

		return p;
	}

	private JComponent amaButton() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		JRadioButton butona = new JRadioButton("a");
		JRadioButton butonb = new JRadioButton("b");
		JRadioButton butonc = new JRadioButton("c");
		ButtonGroup ama = new ButtonGroup();
		ama.add(butona);
		ama.add(butonc);
		ama.add(butonb);
		p.add(butona);
		p.add(butonb);
		p.add(butonc);

		return p;
	}

}
