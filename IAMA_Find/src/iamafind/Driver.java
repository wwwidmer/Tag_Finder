package iamafind;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Driver {

	/**
	 * Program that uses input to search for specific document contents
	 * 
	 * 
	 * Everything can @throw an IOException
	 */

	public static void main(String[] args) throws IOException {
		new GUI(documenter());
	}

	/*
	 * This method takes all the documents in a folder and adds them to a stack
	 * to allow easy access for them later.
	 */
	public static Stack<Document> documenter() throws IOException {
		File folder = new File("src/documents");
		Stack<Document> dFolder = new Stack<Document>();

		for (File f : folder.listFiles()) {
			System.out.println(f.getName());
			if (f.isFile()) {
				dFolder.push(new Document(f.getName()));
			}

		}
		return dFolder;
	}

}
