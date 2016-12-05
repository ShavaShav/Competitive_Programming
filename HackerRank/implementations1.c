#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

#define DEBUG 1	// 1 for Testing, 0 for production

int main()
{
	int t;	// test cases
	if (DEBUG) puts("Number of cases:");
	//scan number of test cases
	scanf("%d", &t);

	// loop through test cases
	for (int i = 0 ; i < t; i++)
	{
		//scan first line
		int n, k; //number of students, cancellation threshold
		if (DEBUG) puts("Number of students and cancellation threshold:");
		scanf("%d %d", &n, &k);

		//scan second line
		int a;
		int ontime = 0; // track number of on time students
		for (int i = 0; i < n; i++)
		{
			if (DEBUG) printf("TimeOffset for Student %d\n", i+1);
			scanf("%d", &a);
			if (a <= 0)
			{
				ontime++;	// if on time, increment counter
			}
		}
		// comapre ontime students to threshold, print cancellation notice.
		if (ontime < k)
			puts("YES");
		else
			puts("NO");
	}
	return 0;
}