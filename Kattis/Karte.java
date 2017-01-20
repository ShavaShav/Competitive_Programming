import java.util.HashMap;
import java.util.Scanner;

public class Karte {
	public static void main (String argv[]){
		Scanner sc = new Scanner(System.in);
		HashMap<Character, boolean[]> deck = new HashMap<Character, boolean[]>();
		char[] suits = {'P','K','H','T'};
		boolean suitCards[];
		for (char suit : suits)
			deck.put(suit, new boolean[13]);
		String line = sc.nextLine();
		for(int i = 0; i < line.length(); i+=3){
			Character suitKey = line.charAt(i);
			int number = Integer.parseInt(line.substring(i+1, i+3));
			suitCards = deck.get(suitKey);
			if (suitCards[number-1]){
				System.out.println("GRESKA"); // already exists
				sc.close();
				return;
			}
			suitCards[number-1] = true; // mark as existing
		}
		
		for (char suit : suits){
			int missing = 0;
			suitCards = deck.get(suit);
			for (boolean card : suitCards){
				if (!card) missing++;
			}
			System.out.print(missing + " ");
		}
		System.out.println();
		sc.close();
	}
}
