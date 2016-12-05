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
	getchar();	//consume spare \n

	// loop through test cases
	for (int i = 0 ; i < t; i++)
	{
		char s[100001];	//string capable of storing 10^5 characters
		if (DEBUG) puts("Enter string:");
		fgets(s, 100001, stdin);
		long int test = 0;
		char *ptr_s = s;
		long int delete = 0;
		while (*ptr_s != '\0')
		{
			if (*ptr_s == *(ptr_s+1))	// if two ajacent characters same, "delete"
				delete++;

			test++;
			ptr_s++;
		}
		printf("%ld of %ld deleted.\n", delete, test);
		
	}
	return 0;
}