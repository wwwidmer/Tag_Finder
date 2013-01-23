package iamafind;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tokenizer {

	private Stack<String> _tags;
	final static Charset ENCODING = StandardCharsets.UTF_8;

	/*
	 * Constructor for Tokenizer. A class which takes a filename and reads
	 * through it searching for specific tags. Tags will be used to help
	 * distinguish different documents (web pages) so that they can be used.
	 */

	public Tokenizer(String aFileName) throws IOException {
		String ss = "src/documents/";
		aFileName = ss + aFileName;
		System.out.println("File Path: " + aFileName);
		Stack<String> tags = new Stack<String>();
		_tags = tags;
		TagScanner(aFileName);
	}

	public Stack<String> getTags() {
		return _tags;

	}

	/*
	 * Method to view all tags. Copies the Strings found in the Tokenizer tag
	 * stack and prints them out in reverse chronological order.
	 */

	public void tagToConsole() {
		Stack<String> tags = _tags;
		System.out.println("Tags found: ");
		while (!tags.isEmpty()) {
			System.out.println(tags.pop());
		}
	}

	/*
	 * The tag scanner - Takes a file path and scans the file looking for tokens
	 * which begin with '#' Takes those Tags and pushs them to the top of a
	 * stack where they can be analyzed.
	 */

	private void TagScanner(String aFileName) throws IOException {

		Path path = Paths.get(aFileName);

		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			StringTokenizer parser;
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				parser = new StringTokenizer(s);
				while (parser.hasMoreTokens()) {
					String pnt = parser.nextToken();
					if (pnt.charAt(0) == '#') {
						if (pnt.length() > 1 && !(pnt.charAt(1) == '#')) {
							pnt = pnt.substring(1);

							_tags.push(pnt);
						}
					}
				}
				// logger(s);
			}
		}

	}

	/*
	 * For debugging, prints out to console what is being read. private static
	 * void logger(Object aMsg) { System.out.println(String.valueOf(aMsg)); }
	 */

}
