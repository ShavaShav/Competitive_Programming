import java.util.Scanner;

public class TwoStones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if ((sc.nextInt()%2) == 0)
			System.out.println("Bob");
		else
			System.out.println("Alice");
		sc.close();
	}
}
