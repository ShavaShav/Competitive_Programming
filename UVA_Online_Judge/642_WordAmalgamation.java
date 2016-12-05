import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WordAmalgamation642 {
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] array;
		while (!line.equals("XXXXXX")){
			array = line.toCharArray();
			Arrays.sort(array);
			String sorted = new String(array);
			// using sorted word as key, add original word
			ArrayList<String> words = map.get(sorted);
			if (words == null)
				words = new ArrayList<String>();
			words.add(line);
			map.put(sorted, words);
			line = sc.nextLine();
		}
		line = sc.nextLine();
		while (!line.equals("XXXXXX")){
			array = line.toCharArray();
			Arrays.sort(array);
			String sorted = new String(array);
			ArrayList<String> wordList = map.get(sorted);
			if (wordList == null)
				System.out.println("NOT A VALID WORD");
			else{
				wordList.sort(null);
				for (String word : wordList){
					System.out.println(word);
				}				
			}
			System.out.println("******");
			line = sc.nextLine();
		}
		sc.close();
	}
}
