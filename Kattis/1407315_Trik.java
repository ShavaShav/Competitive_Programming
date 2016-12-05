import java.util.Scanner;

public class Trik {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String moves = sc.nextLine();
		int currentCup = 1;
		
		for (int move = 0; move < moves.length(); move++)
		{
			switch (moves.charAt(move))
			{
				case 'A': 
					switch(currentCup)
					{
						case 1: currentCup = 2;
								break;
						case 2: currentCup = 1;
								break;		
					}
					break;
				case 'B': 
					switch(currentCup)
					{
						case 2: currentCup = 3;
								break;
						case 3: currentCup = 2;
								break;		
					}
					break;
				case 'C': 
					switch(currentCup)
					{
						case 1: currentCup = 3;
								break;
						case 3: currentCup = 1;
								break;		
					}
					break;
			}
		}		
		System.out.println(currentCup);		
		sc.close();
	}
}
