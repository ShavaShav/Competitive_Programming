import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DominantStrings {

	public static void main(String[] args) {
	//	ArrayList<String[]> wordMap = new ArrayList<String[]>();
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<char[]> sortedWords = new ArrayList<char[]>();
		Scanner sc = new Scanner(System.in);
		// read words, sort and add both to map, add sorted to list
		while (sc.hasNext())
		{
			String word = sc.nextLine();
			words.add(word);
			char[] sorted = word.toCharArray();
			Arrays.sort(sorted);
			sortedWords.add(sorted);
		}
		// true if word in position has been dominated
		int listSize = sortedWords.size();
		boolean dominated[] = new boolean[listSize];
		
		// start dominating some strings baby! go through each string
		for (int domI = 0; domI < listSize; domI++)
		{
			if (!dominated[domI]) // only examine if not dominated yet
			{
				// examine rest of strings to dominate
				for (int subI = 0; subI < listSize; subI++)
				{
					// only look at strings undominated and different originals
					if (!dominated[subI] && domI != subI)
					{
						char[] domString = sortedWords.get(domI);
						char[] subString = sortedWords.get(subI);
						// if same words when sorted, then they dominate eachother
						if (Arrays.equals(domString, subString))
						{
							dominated[subI] = true;
							dominated[domI] = true;							
						}
						else
						{
							// compare character by character of sorted words
							int domChar = 0, subChar = 0;
							while (domChar < domString.length)
							{
								if (domString[domChar] == subString[subChar])
								{
									subChar++;
									if (subChar == subString.length)
									{
										// last character in subordinate string matched
										dominated[subI] = true;
										break;
									}
								}
								domChar++;
							}	
						}
					}
				}
			}
		}
		ArrayList<String> dominantStrings = new ArrayList<String>();
		for (int i = 0; i < dominated.length; i++)
		{
			if (!dominated[i])
			{
				dominantStrings.add(words.get(i));
			}
		}
		
		String[] sortedDominant = dominantStrings.toArray(new String[dominantStrings.size()]);
		Arrays.sort(sortedDominant);
		for (String word : sortedDominant)
		{
			System.out.println(word);
		}
		sc.close();
	}

}
