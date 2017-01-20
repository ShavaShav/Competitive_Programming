import java.util.HashSet;
import java.util.Scanner;

public class Modulo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> distinct = new HashSet<Integer>();
		while (sc.hasNext()){
			int mod = sc.nextInt() % 42;
			if (!distinct.contains(mod))
				distinct.add(mod);
		}
		System.out.println(distinct.size());
		sc.close();
	}
}
