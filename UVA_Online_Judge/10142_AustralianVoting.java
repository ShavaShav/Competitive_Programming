import java.util.*;

class Main {
	public static final boolean DEBUG = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int test = 0; test < t; test++)
		{
			int n = sc.nextInt();
			String[] names = new String[n+1];
			int[][] votes = new int[1001][n];
			int[] maxIndex = new int[1001];
			int[] sumVotes = new int[n+1];
			boolean[] eliminated = new boolean[n+2];
			
			sc.nextLine();	// consume stray line
			
			// read candidates
			for (int j = 1; j <= n; j++)
			{
				names[j] = sc.nextLine();
				if (DEBUG) System.err.println(j + ":"+names[j]);
			}
			
			int numBallots = 0;
			String line;
			
			// read votes
			while (sc.hasNextLine() && !((line = sc.nextLine()).equals("")))
			{
				StringTokenizer st = new StringTokenizer(line);
				for (int k = 0; k < n; k++)
				{
					votes[numBallots][k] = Integer.parseInt(st.nextToken());
					if (DEBUG) System.err.print(votes[numBallots][k] + " ");
				}
				numBallots++;
				if (DEBUG) System.err.println("");
			}
			
			if (DEBUG) 
			{
				for (int vote = 0; vote < numBallots; vote++)
				{
					for (int place = 0; place < n; place++)
					{
						System.out.print(votes[vote][place] + " ");
					}
					System.out.println("");
				}			
			}
			
			boolean winner = false;
			for (int i = 1; i <= n; i++)
			{
				eliminated[i] = false;
			}
			
			while (!winner)
			{
				// reset vote counts
				for (int i = 0; i <= n; i++)
					sumVotes[i] = 0;
				
				// sum non-eliminated candidates
				for (int i = 0; i < numBallots; i++)
				{
					int choice = votes[i][maxIndex[i]];
					if (!eliminated[choice])
					{
						sumVotes[choice]++;
					}
				}
				
				// find min & max of sumVotes
				int min = 1000;
				int max = 0;
				
				for (int i = 1; i <= n; i++)
				{
					if (!eliminated[i] && sumVotes[i] > max)
					{
						max = sumVotes[i];
					}
					if (!eliminated[i] && sumVotes[i] < min && sumVotes[i] >= 0)
					{
						min = sumVotes[i];
					}
				}
				if (DEBUG) System.out.println(min + "\t" + max);
				
				// majority winner case
				if (max > Math.floor(numBallots/2))
				{
					for (int i = 1; i <= n; i ++)
					{
						if (sumVotes[i] == max)
						{
							System.out.println(names[i]);
							winner = true;
						}
						if (winner) break;
					}
				}
				else if (max == min)	// tie, print names of no-eliminated
				{
					for (int i = 1; i <= n; i++)
					{
						if (sumVotes[i] == 0)
						{
							eliminated[i] = true;
						}
					}
					for (int i = 1; i <=n; i++)
					{
						if (!eliminated[i])
						{
							System.out.println(names[i]);
						}
					}
					winner = true;
				}
				else	// Eliminate all candidate with min # of votes
				{
					// set booleans for eliminated if a min candidate
					for (int i = 1; i <= n; i++)
					{
						if (sumVotes[i] == min)
						{
							eliminated[i] = true;
						}
					}
					// shift max index pointer if belonging to eliminated candidate
					for (int i = 0; i < numBallots; i++)
					{
						int choice = votes[i][maxIndex[i]];
						while (eliminated[choice] == true)
						{
							maxIndex[i]++;
							choice = votes[i][maxIndex[i]];
						}
					}
				}
			}
			if (test != t-1) System.out.println("");	// print new line except for last case
		}
		sc.close();
	}
}
