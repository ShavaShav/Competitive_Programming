#include <stdio.h>

// Iterative solution O(n) - Completed test in 0.520 seconds
long long int getNumSlices(long long int numCuts)
{
    long long int numSlices = 1, currentCut = 1;
    while (currentCut <= numCuts){
        numSlices = numSlices + currentCut;
        currentCut++;
    }
    return numSlices;
}

// Optimized solution O(1) from sum of series - 0.000 seconds
long long int numSlicesSeries(long long int n)
{
    return ((n + 1) + ((n * (n - 1)) / 2) );
}

int main()
{
    long long int n;
    scanf("%lli", &n);
    while (n >= 0)
    {
        printf("%lli\n", getNumSlices(n));
        scanf("%lli", &n);
    }
    return 0;
}
