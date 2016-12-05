import java.util.*;

public class Crypto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String secret = new String("PER");
		int secretI = 0;
		
		String word = sc.nextLine();
		int changes = 0;
		for (int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			if (ch != secret.charAt(secretI))
				changes++;
			secretI++;
			if (secretI > 2) secretI = 0;
		}
		System.out.println(changes);
		sc.close();
	}

}
