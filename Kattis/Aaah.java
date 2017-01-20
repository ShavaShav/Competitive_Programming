import java.util.Scanner;

public class Aaah {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String myAh = sc.nextLine();
		String drAh = sc.nextLine();
		if (myAh.length() < drAh.length())
			System.out.println("no");
		else
			System.out.println("go");
		sc.close();
	}

}
