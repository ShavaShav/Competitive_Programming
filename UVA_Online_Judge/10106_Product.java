import java.math.BigInteger;
import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine())
		{
			BigInteger x = new BigInteger(sc.nextLine());
			BigInteger y = new BigInteger(sc.nextLine());			
			System.out.println(x.multiply(y));
		}
		sc.close();
	}
}
