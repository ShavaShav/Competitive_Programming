import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LineThemUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> names = new ArrayList<String>(n);

		while (n > 0){
			names.add(sc.nextLine());
			n--;
		}
		ArrayList<String> sorted = new ArrayList<String>(names);
		// decreasing
		sorted.sort(new Comparator<String>(){
			public int compare(String s1, String s2) {
				return -(s1.compareTo(s2));
			}
		});
		if (names.equals(sorted)){
			System.out.println("DECREASING");
			sc.close();
			return;
		}
		// increasing
		sorted.sort(new Comparator<String>(){
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});

		if (names.equals(sorted)){
			System.out.println("INCREASING");
			sc.close();
			return;
		}
		System.out.println("NEITHER");
		sc.close();
		return;
	}

}
