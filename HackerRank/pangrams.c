#include <math.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

#define DEBUG 0	// 1 for Testing, 0 for production
#define MAX 3000

int CheckPangram(char *s);
int CheckChar(char c, char *buffer);


int main()
{
	char s[MAX];
	fgets(s, MAX, stdin);

	if (DEBUG) puts("string read");

	if (CheckPangram(s))
		puts("pangram");
	else
		puts("not pangram");

	return 0;
}

// return 1 if pangram, 0 if not
int CheckPangram(char *s)
{
	char buffer[27]="";	// buffer for storing chars
	unsigned int knt = 0;
	char *ptr_s = s;
	if (DEBUG) printf("*ptr_s: %c \ts: %s\n", *ptr_s, s);
	while (*ptr_s != '\0')
	{
		if (DEBUG) printf("%c\n", *ptr_s);
		if (CheckChar(*ptr_s, buffer)) knt++;
		ptr_s++;
	}
	if (DEBUG) printf("Unique letters: %d\n", knt);
	if (knt == 26)
		return 1;
	else
		return 0;
}

// return 1 if unique character, 0 if not
int CheckChar(char c, char *buffer)
{
	c = toupper(c);	// make uppercase
	if ((c >= 'A' && c <= 'Z') || c != ' ' || c != '\0')
	{
		char *ptr_buffer = buffer;	// pointer to buffer
		if (DEBUG) printf("ptr_buffer=\"%s\"\n", ptr_buffer);
		if (*ptr_buffer == '\0')
		{
			*ptr_buffer = c;
			*(ptr_buffer+1) = '\0';
			return 1;			
		}
		while (*ptr_buffer != '\0')
		{
			if (*ptr_buffer == c)
			{
				return 0;
			}
			ptr_buffer++;
		}
		if (c >= 'A' && c <= 'Z')
		{
			*ptr_buffer = c;
			*(ptr_buffer+1) = '\0';
			return 1;		
		}
	}
	return 0;
}