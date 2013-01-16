package iamafind;

import java.io.IOException;

//import java.util.Scanner;

public class Driver {

	/**
	 * Program that uses input to search for specific document contents and
	 * returns those documents. Driver class to decide which document to read.
	 * 
	 * Ultimately the documents will be chosen by a series of tags within them.
	 * Different tags are identified in the tokenizer class and written to a
	 * file. The document class is the originals document being read. For
	 * example an HTML "Document" will exist as a document object and will be
	 * linked to "Document_TAG.text".
	 * 
	 * Everything can @throw an IOException
	 */

	public static void main(String[] args) throws IOException {
		Document d = new Document("src/documents/Document1.txt");
		d.findTag("div");
		System.gc();
		System.exit(0);
	}
	
	public static Document[] documenter(){
		Document[] folder = null;
		
		
		
		
		return folder;		
	}

}
