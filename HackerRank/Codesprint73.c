#include<stdio.h>

int main()
{
    long int n, m, k;
    scanf("%ld %ld %ld", &n, &m, &k);
    int land[n][m];
    long long landSize = n*m;
    long long trackSize = 0;
    long int i, col;
    for (i = 0; i < k; i++)
    {
        long int r, c1, c2;
        scanf("%ld %ld %ld", &r, &c1, &c2);
        for (col = c1; col <= c2; col++)
        {
            if (land[r][col] != 1)
            {
                land[r][col] = 1;
                trackSize++;
            }
        }
    }
    printf("%llu\n", (landSize - trackSize));
    return 0;
}
