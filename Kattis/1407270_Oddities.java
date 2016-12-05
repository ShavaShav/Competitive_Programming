import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		while (numTests > 0)
		{
			int num = sc.nextInt();
			if (num % 2 == 0)
				System.out.println(num + " is even");
			else
				System.out.println(num + " is odd");
			numTests--;
		}
	}

}