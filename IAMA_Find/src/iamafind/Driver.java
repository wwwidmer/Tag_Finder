package iamafind;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Driver {

	/**
	 * Program that uses input to search for specific document contents and
	 * returns those documents. Driver class to decide which document to read.
	 * 
	 *
	 * 
	 * Everything can @throw an IOException
	 */

	public static void main(String[] args) throws IOException {		
		new GUI(documenter());
	}

	public static Stack<Document> documenter() throws IOException {
		final File folder = new File("/src/documents/");
		Stack<Document> dFolder = new Stack<Document>();
	
		
		for (final File fileEntry : folder.listFiles()) {
			System.out.println(fileEntry.getName());
			if (fileEntry.isFile()) {
				dFolder.push(new Document(fileEntry.getName()));
			}

		}

		return dFolder;
	}

}
