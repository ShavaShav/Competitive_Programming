
import java.util.*;

class Main {
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		// looking purely at numbers, so input is easy
		while (sc.hasNext())
		{
			// numbers could reach up to 3*(1,000,000)+1
			// so regular ints will fail
			long i = sc.nextLong();
			long j = sc.nextLong();
			
			// UVA asks to display input
			System.out.print(i + " " + j + " ");
			
			// switch so i is less than j if needed
			if (i > j)
			{
				long temp = j;
				j = i;
				i = temp;	
			}
			
			int maxCycles = 1;
			
			// count the cycles produced by algorithm between the values
			while (i <= j)
			{
				long n = i;
				int cycles = 1;
				while(n != 1)	// stops at 1
				{
					if (n % 2 == 0)	// even
					{
						n = n/2;	// divide by two
						cycles++;	// count the cycle
					}
					else 
					{
						// 3*(odd #)+1 always produces even number
						// like odd+1 = even
						n = (3*n)+1;	
						n = n/2;	// so can skip a comparison here
						cycles+=2;	// and just do the divide
					}
				}
				// compare to previous maximum number of cycles
				if (cycles > maxCycles)
				{
					maxCycles = cycles;
				}
				i++;
			}
			System.out.println(maxCycles);

		}
		sc.close();
	}
}
