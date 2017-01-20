import java.util.Scanner;

public class Spavanac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int totalMins = (h * 60) +  m;
		totalMins -= 45;
		if (totalMins < 0)
			totalMins += 24 * 60;
		h = totalMins / 60;
		m = totalMins % 60;
		System.out.println(h + " " + m);
		sc.close();
	}

}
