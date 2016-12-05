import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IfWeWereChildAgain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine())
		{
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			
			BigInteger x = new BigInteger(st.nextToken());
			String op = st.nextToken();
			BigInteger y = new BigInteger(st.nextToken());
			
			switch (op)
			{
				case "/": x = x.divide(y);
					break;
				case "%": x = x.mod(y);
					break;  
				default: break;
			}
			
			System.out.println(x);
		}
		sc.close();
	}
}
