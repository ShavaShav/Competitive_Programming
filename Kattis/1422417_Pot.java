import java.util.*;

public class Pot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = 0;
		while (n > 0)
		{
			int num = sc.nextInt();
			int power = num % 10;
			num /= 10;
			x += (Math.pow(num, power));
			n--;
		}
		System.out.println(x);
		sc.close();
	}

}
