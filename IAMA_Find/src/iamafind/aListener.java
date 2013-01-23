package iamafind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aListener implements ActionListener {

	private GUI _g;
	
	public aListener(GUI g){
		_g=g;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_g.changeSearch("a");

	}

}
