package iamafind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Document {

	private Stack<String> _tags;
	private String _fn;

	public Document(String fileName) throws IOException {
		_fn = fileName;
		Tokenizer tokener = new Tokenizer(fileName);
		_tags = tokener.getTags();
		writeFile(fileName);
		writeTagToFile();
	}

	/*
	 * Finds tags in the tag file, if they exist and returns a boolean
	 */

	public String findTag(String t) {
		@SuppressWarnings("unchecked")
		Stack<String> tags = (Stack<String>) _tags.clone();
		String toJT = "";
		while (!tags.isEmpty()) {
			if (tags.peek().equals(t)) {
				toJT += "Found:" + t + " in " + _fn + " ";
				System.out.println(t + ": found tag");
				break;
			} else
				tags.pop();
		}

		return toJT;
	}

	/*
	 * Creates file representing the Tags and adds tags to them, really has no use for this program but I wanted to learn how to do it.
	 */

	private void writeFile(String fn) {
		String s = fn + "_TAG.txt";
		try {
			FileWriter fstr = new FileWriter(s);
			BufferedWriter oupt = new BufferedWriter(fstr);
			oupt.write(writeTagToFile());
			oupt.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	/*
	 * Creates a string which is filled with every Tag found in the file
	 */

	private String writeTagToFile() {
		String s = "";
		@SuppressWarnings("unchecked")
		Stack<String> tags = (Stack<String>) _tags.clone();
		while (!tags.isEmpty()) {
			s += tags.pop();
			s += " ";
		}
		return s;
	}

	public String toString() {
		return _fn;
	}
}
