/* 
  Program created by Zach Shaver (zachshaver@gmail.com) to satistfy the 
  requirements of Problem B: Revenge of the Pancakes for the Qualification
  Round of Google Code Jam 2016. This program will work on large inputs and # of tests
*/

#include <stdio.h>

#define DEBUG 0	// 1 for Testing, 0 for production

//Globals
char pancakes[101];		// array for storing up to 100 pancakes' mood per test, 1 extra happy to stop process
unsigned int stacksize;		// storing the number of pancakes per test
unsigned int flipcount;		// storing number of flips per test

// Functions
void RefreshPlate();	// must call before each new test, to reset globals.
void ReadPancakes();
void ProcessPancakes();
int CheckHappiness(unsigned int size);
void Flip(unsigned int size);
void ServePlate();

int main()
{
	unsigned int T, j;	// number of tests, counter

	scanf("%d", &T);	// read number of test cases
	getchar();	// consume stray newline from scanf

	for (j = 0; j < T; j ++)	// loop through tests
	{
		RefreshPlate();
		ReadPancakes();
		ProcessPancakes();

		if (DEBUG)
		{
			int i;
			puts("Flipped Stack: ");
			ServePlate();
		}

		printf("Case #%d: %d\n", j+1, flipcount);
	}
	return 0;
}

void RefreshPlate()
{
	size_t j;
	for (j = 0; j < 101; j++)	// reset stack to happy default
		pancakes[j] = '+';			
	
	stacksize = 0;	// reset stack size		
	flipcount = 0;	// reset flip counter
}

void ReadPancakes()
{
	char p; 			// initialize first pancake
	p = getchar();
	while (p == '+' || p == '-')	// will read to end of .in, tokenizing at newlines or whitespace	
	{
		pancakes[stacksize] = p;
		stacksize++;

		p = getchar(); // read next pancake
	}	// finish when newline entered
}

// Since array preset to happy, we take advantage. Will exit once last is happy.
// to make all sad, simply preset array to sad.
void ProcessPancakes()
{
	unsigned int j;

	for (j = 0; j < stacksize; j++) //go through stack
	{
		if (pancakes[j] == '+' && pancakes[j+1] == '-')	// if current happy, next sad
		{
			Flip(j+1);	// flip up to current
			j = 0; // go back to beginning of stack
		}
		if (pancakes[j] == '-' && pancakes[j+1] == '+')	// If current sad, next happy
		{
			Flip(j+1);	// flip up to current
			j = 0; // go back to beginning of stack
		}
	}
}

void Flip(unsigned int size)
{
	unsigned int p, end = size-1;	// for use in exhanging first and last pancakes
	char secondplate[101];	

	// copy pancakes to second plate
	for (p = 0; p < 101; p ++)		
		secondplate[p] = pancakes[p];

	// Flip the stack up to input size
	for (p = 0; p < size; p ++, end --)
	{
		if (secondplate[end] == '-')	// exhange first and last pancake while changing mood
			pancakes[p] = '+';			// effectively flipping the stack
		else
			pancakes[p] = '-';
	}
	flipcount++;

	if (DEBUG)
	{
		printf("Flip #%d\n", flipcount);
		ServePlate();
	}
}

void ServePlate()
{
	unsigned int i;
	for (i = 0; i < stacksize; i++)
		printf("%c", pancakes[i]);
}

//Checks if there are more sad than happy pancakes in the stack
// If true, returns 1. else returns 0 or -1
// FUNCTION WORKS, BUT ULTIMATELY NOT USEFUL FOR OPTIMIZING FLIPS
int CheckHappiness(unsigned int size)
{
	unsigned int j, sadknt = 0, happyknt = 0;

	for (j = 0; j < stacksize; j++)
	{
		if (pancakes[j] == '-')	// count sad
			sadknt++;
		else
			happyknt++;
	}
	if (DEBUG) printf("sad = %d, happy = %d", sadknt, happyknt);
	// compare counts
	if (sadknt > happyknt)
		return 1;
	else if (happyknt > sadknt)
		return 0;
	else if (happyknt == sadknt)
		return -1;
}
