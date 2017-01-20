import java.util.Scanner;

public class QuickEstimates {
	// length of number can be up to 10 ^ 100, so will
	// input could be up to 100 characters
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while (n > 0){
			System.out.println(sc.nextLine().length());
			n--;
		}
		sc.close();
	}
}
