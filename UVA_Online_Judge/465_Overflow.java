import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Overflow {

	public static boolean overflowsMaxInt(BigInteger num)
	{
		BigInteger maxInt = new BigInteger("2147483647");
		if (num.compareTo(maxInt) > 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		while (sc.hasNextLine())
		{
			s = sc.nextLine();
			System.out.println(s);
			StringTokenizer st = new StringTokenizer(s);
			
			BigInteger x = new BigInteger(st.nextToken());
			String op = st.nextToken();
			BigInteger y = new BigInteger(st.nextToken());

			if (overflowsMaxInt(x))
				System.out.println("first number too big");
			if (overflowsMaxInt(y))
				System.out.println("second number too big");
			
			switch (op)
			{
				case "+": x = x.add(y);
					break;
				case "*": x = x.multiply(y);
					break;  
				default: break;
			}
			
			if (overflowsMaxInt(x))
				System.out.println("result too big");
		}
		sc.close();
	}
}
