import java.util.Scanner;
import java.util.StringTokenizer;

public class AlienNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int test = 1; test <= testcases; test++){
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			String srcNum = st.nextToken();
			String srcDigs = st.nextToken();
			String tarDigs = st.nextToken();
			String tarNum = "";
			int srcBase = srcDigs.length();
			int tarBase = tarDigs.length();
			int decimal = 0;
			// convert source to decimal
			for (int i = srcNum.length()-1, exp = 0; i >= 0; i--, exp++){
				int placeVal = srcDigs.indexOf(srcNum.charAt(i));
				decimal += placeVal * (Math.pow(srcBase, exp));
			}
			// convert decimal to target
			int mod;
			while (decimal > 0){
				mod = decimal % tarBase;
				decimal = decimal / tarBase;
				tarNum = tarDigs.charAt(mod) + tarNum;
			}
			System.out.println("Case #" + test + ": " + tarNum);
		}
		sc.close();
	}
}
