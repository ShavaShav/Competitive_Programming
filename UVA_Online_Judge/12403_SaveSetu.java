import java.util.Scanner;
import java.util.StringTokenizer;

public class SaveSetu {
	public static int total = 0;
	
	public static void donate(int amount)
	{
		total += amount;
	}
	
	public static void report()
	{
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ops = Integer.parseInt(sc.nextLine());
		String line = sc.nextLine();
		while (ops > 0)
		{
			if (line.equals("report"))
				report();
			else
			{
				StringTokenizer st = new StringTokenizer(line, " ");
				if (st.nextToken().equals("donate"))
					donate(Integer.parseInt(st.nextToken()));
			}	
			ops--;
			if (ops != 0) line = sc.nextLine();
		}
		sc.close();
	}
}
