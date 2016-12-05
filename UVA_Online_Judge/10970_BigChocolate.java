package cuts;

import java.util.*;

public class Cuts {
	
	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext())
		{
			m = sc.nextInt();
			n = sc.nextInt();
			
			System.out.println((m*n)-1);
		}
		
		sc.close();
	}

}
