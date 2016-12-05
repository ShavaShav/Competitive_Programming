import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coldDays = 0;
		int numDays = sc.nextInt();
		while (numDays > 0)
		{
			int temp = sc.nextInt();
			if (temp < 0)
				coldDays++;
			numDays--;
		}
		System.out.println(coldDays);
		sc.close();
	}

}