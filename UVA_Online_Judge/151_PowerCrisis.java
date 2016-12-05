import java.util.Arrays;
import java.util.Scanner;

public class PowerCrisis_151 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n;
		while ((n = sc.nextInt()) != 0){
			// n's upper limit is 100, so a brute force
			// 0(n^2) solution will work
			for (int m = 1; m <= Integer.MAX_VALUE; m++){ // for each possible m
				boolean[] regions = new boolean[n+1];
				int numOff = n, curr = 1; // start at region 1
				while (numOff > 0){ // while regions unselected
					regions[curr] = true; // turn off power
					numOff--;	// turned off a station
					if (curr == 13) break; // turned off power station
					int toMove = m;
					while (toMove > 0){
						curr++; // move forward one spot
						if (curr > n)
							curr = 1;
						while (regions[curr]){ // if already selected, move on
							curr++;
							if (curr > n)
								curr = 1;
						}
						toMove--;
					}
					
					if (curr > n)
						curr -= n; // wrap around if needed
				}
				// check if power station turned off last
				if (curr == 13 && numOff == 0){
					System.out.println(m);
					break;
				}
			}
		}
		sc.close();
	}
}
