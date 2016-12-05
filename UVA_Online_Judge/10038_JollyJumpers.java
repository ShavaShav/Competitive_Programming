import java.util.*;

public class Solution {
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s;
		int loops = 0;
		while(sc.hasNextLine())
		{
			boolean jolly = true;
			int n;
			int a[] = new int[3001];
			boolean absolutes[] = new boolean[3001];
			s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s);
			int count = 0;

			n = Integer.parseInt(st.nextToken());	
			
			while (st.hasMoreTokens())
			{
				a[count++] =  Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < n; i++)
				absolutes[i] = false;
			
			for (int i = 0; i < n-1; i++)
			{
				int diff = Math.abs(a[i]-a[i+1]);

				if (diff <= 3000) absolutes[diff] = true;
			}
			
			for (int i = 1; i < n; i++)
			{
				if (absolutes[i] == false)
				{
					jolly = false;
				}

			}

			if (jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
	}
}
