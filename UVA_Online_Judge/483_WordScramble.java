import java.util.Scanner;
import java.util.StringTokenizer;

public class WordScramble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		StringTokenizer st;
		while (sc.hasNextLine()){
			st = new StringTokenizer(sc.nextLine());
			while (st.hasMoreTokens()){
				sb = new StringBuilder(st.nextToken());
				System.out.print(sb.reverse());
				if (st.hasMoreTokens())
					System.out.print(" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
