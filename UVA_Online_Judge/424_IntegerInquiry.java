import java.math.BigInteger;
import java.util.Scanner;

public class IntegerInquiry {

	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		Scanner sc = new Scanner(System.in);
		String input;
		while (!(input = sc.nextLine()).equals("0"))
		{
			sum = sum.add(new BigInteger(input));
		}
		System.out.println(sum);
		sc.close();
	}

}
