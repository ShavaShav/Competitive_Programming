#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define DEBUG 0	// 1 for Testing, 0 for production

int main()
{
	int t;	// test cases
	scanf("%d", &t);
	getchar();

	int i;
	// loop through test cases
	for (i = 0 ; i < t; i++)
	{
	    if (i>0) puts("");
        char s1 = getchar();
        if (DEBUG) printf("s1 = \"%c\"\n", s1);

	    long int delete = 0;         //track number of deletions
	    while (s1 == 'A' || s1 == 'B')
        {
            char s2 = s1;    // move last scanned item to second slot
            if (DEBUG) printf("s2 = \"%c\"\t", s2);

            s1 = getchar(); // scan item to first slot
            if (DEBUG) printf("s1 = \"%c\"\n", s1);
            if (s1 == s2)
            {
                delete++;

            }
        }
        printf("%ld", delete);
	}
	return 0;
}
