import java.util.*;

public class Cetvrta {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		
		int pairs = 3;
		
		while (pairs > 0)
		{
			Integer xIn = sc.nextInt();
			Integer yIn = sc.nextInt();
			
			if (x.contains(xIn))
				x.remove(xIn);
			else
				x.add(xIn);
			
			if (y.contains(yIn))
				y.remove(yIn);
			else
				y.add(yIn);
			
			pairs--;
		}
		
		System.out.println(x.get(0) + " " + y.get(0));
		
		sc.close();
	}

}
