import java.util.Scanner;

public class Bijele {

	public static void main(String[] args) {
		int[] set = new int[]{1,1,2,2,2,8};
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 6; i++)
			set[i] = set[i] - sc.nextInt();

		for (int piece : set)
			System.out.print(piece + " ");
		
		sc.close();
	}

}
