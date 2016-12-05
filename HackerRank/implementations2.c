#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

#define DEBUG 0	// 1 for Testing, 0 for production

int main()
{
	int t;	// test cases
	if (DEBUG) puts("Number of test cases:");
	//scan number of test cases
	scanf("%d", &t);

	// loop through test cases
	int i;
	for (i = 0 ; i < t; i++)
	{
		long int n;	// number input
		if (DEBUG) puts("Enter number:");
		scanf("%ld", &n);

        long int knt = 5;
        n = n - 5;
        while (n > 0 && n%3 != 0)
        {
            n = n - 5;
            knt = knt + 5;
        }
        if (n < 0)
            puts ("-1");
        else if (n%3 == 0)
        {
            int j, k;
            for (j = 0; j < n; j++)
                printf("%d", 5);
            for (k = 0; k < knt; k++)
                printf("%d", 3);
            puts("");
        }
	}
	return 0;
}
