import java.util.Scanner;

public class FunnyEncryption {

	// returns number of 1's in binary interpretation of decimal
	public static int countOnes(int dec)
	{
		int count = 0;
		while (dec > 0)
		{
			if (dec % 2 == 1)
				count++;
			dec = dec >> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0)
		{
			int n = sc.nextInt();
			// count 1's in decimal representation
			int b1 = countOnes(n);
			// count 1's in hexadecimal representation
			int b2 = 0;
			while (n > 0)
			{
				b2 += countOnes(n%10);
				n = n / 10;
			}
			
			System.out.println(b1 + " " + b2);
			
			t--;
		}
		sc.close();
	}
}
