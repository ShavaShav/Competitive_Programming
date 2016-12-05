import java.util.*;

public class SpeedLimit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int trips;
		while ((trips = sc.nextInt()) != -1)
		{
			int prevHours=0, totalMiles = 0;
			for (int i = 0; i < trips; i++)
			{
				int distance = sc.nextInt();
				int totHours = sc.nextInt();
				int hours = totHours - prevHours;
				totalMiles += distance * hours;
				prevHours = totHours;
			}
			System.out.println(totalMiles + " miles");
		}				
		sc.close();
	}
}
