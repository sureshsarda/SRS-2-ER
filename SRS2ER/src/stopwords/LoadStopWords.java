package stopwords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LoadStopWords - Methods to load stop words into memory
 * @author Pooja Mantri (Edited by Suresh Sarda)
 *
 */

public class LoadStopWords {
	/**
	 * List of stop words 
	 */
	public static List<String> stopWord;

	/**
	 * Default constructor
	 * When no parameter is passed, it tries to load stopwords form file "stopWords.csv".
	 * @exception
	 */
	public LoadStopWords() {
		this("stopwords.csv");
	}
	public LoadStopWords(String filename) {
		
		stopWord = new ArrayList<String>();
		
		try {
			Load(filename);	
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: File containing stopwords was not found. Continueing without.");
		}
		catch (IOException e) {
			System.err.println("Error: Unknown error occured while reading stop words. Continuing without.");
			System.err.println("More Detials:");
			e.printStackTrace();
		}
		
	}

	/**
	 * Loads stopwords from a file. The file should be in Comma Separted Value(CSV) format
	 * @param filename the name of file from where to load stop words
	 * @throws IOException 
	 * @see FileNotFoundException
	 */
	private void Load(String filename) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = new String();
		
		while ((line = br.readLine()) != null) {
			List<String> words = new ArrayList<String>();
			words = Arrays.asList(line.split(","));
			stopWord.addAll(words);
		}
		br.close();
	}

}
