import java.util.*;

public class TheDoleQueue {
	public static final boolean DEBUG = true;
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int offk = sc.nextInt();
		int offm = sc.nextInt();
		while (n != 0 && offm != 0 && offk != 0)
		{
			// start index = 1
			boolean[] elim = new boolean[n+2];
			for (int i = 1; i <= n; i++)
			{
				elim[1] = false;
			}
			
			elim[0] = true; // kick out 1st for safety
			elim[n+1] = true; // kick out after last for safety
			// pointers start outside
			int k = 0;	// 1st pointer moving right
			int m = n + 1;	// 2nd pointer moving left
			int peopleLeft = n;
			
			while (peopleLeft > 0)
			{
				// Bring K to first available spot
				while (elim[k+1])
				{
					if (k == n)
						k = 0;
					else
					{
						k++;
						if (k > n)
							k-=n;						
					}
				}
				// move forward
				int cur = 1;
				while (cur < offk)
				{
					if (elim[k])
					{
						k++;
					}
					else
					{
						cur++;
						k++;
					}
					// if over limit, bend around
					if (k > n)
						k-=n;
				}
				
				// if over limit, bend around
				if (k > n)
					k-=n;
				while (elim[k])	// move forward if eliminated
				{
					k++;
					if (k > n)
						k=1;
				}
				
				// Do the same for M
				
				while (elim[m-1])
				{
					if (m == 1)
						m = n+1;
					else
					{
						m--;
						if (m < 1)
							m+=n;						
					}
				}
				// decrement pointer by offset
				// move forward
				cur = 1;
				while (cur < offm)
				{
					if (elim[m])
					{
						m--;
					}
					else
					{
						cur++;
						m--;
					}
					if (m < 1)
						m+=n;
				}
				// if under limit, bend around
				if (m < 1)
					m+=n;
				while (elim[m])	// move backward if eliminated
				{
					m--;
					if (m < 1)
						m=n;
				}
				
				// check if at same person (president case)
				if (m == k)
				{
					elim[m] = true; // eliminate candidate
					peopleLeft--;
					if (m < 10)
						System.out.print("  " + m);
					else
						System.out.print(" " + m);
				}
				else
				{	// eliminate both candidates, for retraining
					elim[k] = true;
					elim[m] = true;
					peopleLeft-=2;
					if (k < 10)
						System.out.print("  " + k);
					else
						System.out.print(" " + k);
					
					if (m < 10)
						System.out.print("  " + m);
					else
						System.out.print(" " + m);
				}	
				if (peopleLeft > 0)
					System.out.print(",");
				else
					System.out.println("");
			}
			n = sc.nextInt();
			offk = sc.nextInt();
			offm = sc.nextInt();
		}
	}
}
