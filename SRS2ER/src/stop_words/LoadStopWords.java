package stop_words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LoadStopWords {

	String[] arr = new String[2000];
	String s;
	FileReader fr;
	BufferedReader br ;
	static public List<String> stopWord = new ArrayList<String>();

	public LoadStopWords() {
		
		try {
			fr = new FileReader("stopWords.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br= new BufferedReader(fr);

		// Storing list of Stop Words  from file in array
		try {
			while ((s = br.readLine()) != null) {
				arr = s.split(",");

				for (int i = 0; i < arr.length; i++) {
					arr[i] = arr[i].trim();

					stopWord.add(arr[i]);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
