import java.util.Scanner;

public class EasiestProblem {

	public static int sumDigits(int n)
	{
		int sum = 0;
		while (n != 0)
		{
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while ((n = sc.nextInt()) != 0)
		{
			int sumOfN = sumDigits(n);
			int multiplier = 11;
			while (sumOfN != sumDigits(n*multiplier))
				multiplier++;
			System.out.println(multiplier);
		}
		sc.close();
	}
}
