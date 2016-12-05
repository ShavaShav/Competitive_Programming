import java.util.*;

public class Ananagrams {

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> sortedWords = new ArrayList<String>();
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		// scan words into array list
		while (!line.equals("#"))
		{
			StringTokenizer st = new StringTokenizer(line, " ");
			while (st.hasMoreTokens())
			{
				String word = st.nextToken();
				words.add(word);
				char[] sortedWord = word.toLowerCase().toCharArray();
				Arrays.sort(sortedWord);
				sortedWords.add(String.valueOf(sortedWord));
			}
			line = sc.nextLine();
		}
		for (String word : sortedWords){
			if (countMap.containsKey(word)){
				int count = countMap.remove(word);
				countMap.put(word, count+1);
			} else {
				countMap.put(word, 0);
			}
		}
		PriorityQueue<String> results = new PriorityQueue<String>();
		for (int i = 0; i < sortedWords.size(); i++){
			if (countMap.get(sortedWords.get(i)) == 0)
				results.add(words.get(i));
		}
		while (!results.isEmpty())
		{
			System.out.println(results.poll());			
		}
		sc.close();
	}
}
