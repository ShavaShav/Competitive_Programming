/* 
  Program created by Zach Shaver (zachshaver@gmail.com) to satistfy
  the requirements of Problem A: Counting Sheep for the Qualification
  Round of Google Code Jam 2016. This program will work on large inputs.
*/

#include <stdio.h>

// Functions
int BreakNum(unsigned int N);
int TrackDig(unsigned int dig);

int main()
{
	unsigned int T, j;	// number of tests, counter

	scanf("%d", &T);	// read number of test cases

	for (j = 0; j < T; j ++)	// loop through tests
	{
		unsigned int N, temp, i = 1;	// input num, break num counter
		
		scanf("%d", &N);	// read number

		temp = N;	// for multiply later

		if (N == 0)		// check for infinite loop case
			printf("Case #%d: INSOMNIA\n", j+1); 
		else	// process that mother
		{
			while (BreakNum(N) != 1)	// Break up digits, check if (0-9) have been read
			{
				N = temp * ++i;		// If not, multiply number by incrementing digit
			}
			
			printf("Case #%d: %d\n", j+1, N);	// print the test # with the last number broken up
		}
	}
	return 0;
}

/*
  Break a number into digits and tracks unique digits read
  I/P: Positive number, called by value
  O/P: 1 if all digits (0-9) have been read, 0 if not
*/
int BreakNum(unsigned int N)
{
//	if (DEBUG) printf("BreakNum entered with (N = %d)", N);
	while (N > 0)	// MSD is never 0, but N = 0 when all digits have been processed
	{
		int dig = N % 10;	// chop off digit for processing
		N = N / 10;			// reflect chopped digit on N
//		if (DEBUG) printf("N = %d\t dig = %d\n", N, dig);

		if (TrackDig(dig) == 1)	// track digit, check if it's the final unique digit
			return 1;	// if final unique digit (all 0 - 9 read), then return to main with sucess
	}
	return 0;	// otherwise return to main with failure to multiply N and recheck
}

/*
  Tracks digits by storing (0-9) in a 10-cell array. Counts when a unique digit is read
  I/P: Number from 0 - 9
  O/P: 1 if final digit read, 0 if not
*/
 int TrackDig(unsigned int dig)
 {
 	static int count = 0;		// tracking unique digit counter
 	static int trackDig[10] = {0};		// array for storing unique digits, preset to zeroes
	
	if (trackDig[dig]==0)	// if digit index still at preset, then set and increment counter
	{
		trackDig[dig] = 1;
		count++;
	}

	if (count > 9)	// check for final count
	{
 		size_t j;
		
		// reset counter and tracking array, leave with success
		count = 0;
		for (j = 0; j < 10; j++)
			trackDig[j] = 0;
		return 1;
	}
	else		// otherwise leave for next iteration
		return 0;
 }