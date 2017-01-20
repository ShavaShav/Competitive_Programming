import java.util.Scanner;

public class SumKindOfProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < p; i++){
			int k = sc.nextInt();
			int n = sc.nextInt();
			int s1 = (n * (n + 1)) / 2; // sum of 1...n
			int s2 = n * n; // sum of first n odd numbers
			int s3 = (n * n) + n; // sum of first n even numbers
			System.out.println(k + " " + s1 + " " + s2 + " " + s3);
		}
		sc.close();
	}
}
