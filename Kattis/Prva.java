
import java.util.Scanner;
import java.util.StringTokenizer;

public class Prva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		String[] crossword = new String[r];
		for (int i = 0; i < r; i++){
				crossword[i] = sc.nextLine();
		}
		String smallest = "~"; // larger than any alpha character
		for (int i = 0; i < r; i++){
			StringTokenizer st = new StringTokenizer(crossword[i], "#");
			while (st.hasMoreTokens()){
				String word = st.nextToken();
				if (word.length() > 1 && word.compareTo(smallest) < 0){
					smallest = word;
				}
			}
		}
		for (int i = 0; i < c; i++){
			String word = "";
			for (int j = 0; j < r; j++){
				char colChar = crossword[j].charAt(i);
				if (colChar == '#'){
					if (word.length() > 1 && word.compareTo(smallest) < 0){
						smallest = word;
					}
					word = "";
				} else {
					word = word + colChar;
				}
			}
			if (word.length() > 1 && word.compareTo(smallest) < 0){
				smallest = word;
			}
		}
		System.out.println(smallest);
		sc.close();
	}

}
