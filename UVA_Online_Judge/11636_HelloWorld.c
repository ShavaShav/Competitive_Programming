#include <stdio.h>
#include <math.h>

int main()
{
	int n = 0, t = 1;
	while (1)
	{
		
		scanf("%d", &n);
		if (n < 0) break; 
		printf("Case %d: %d\n", t++, (int) ceil(log2(n)));
	}
	return 0;
}
