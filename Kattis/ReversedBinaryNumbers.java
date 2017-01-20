import java.util.Scanner;

public class ReversedBinaryNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
		sb.reverse();
		System.out.println(Integer.parseInt(sb.toString(), 2));
		sc.close();
	}

}
