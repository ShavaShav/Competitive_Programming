#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n, q;
    scanf("%d", &n);
    char a[n][21];
    getchar();
    
    for (int i = 0; i < n; i++)
    {
        fgets(a[i], sizeof(a[i]), stdin);
    }
    
    scanf("%d", &q);
    getchar();

    char qa[q][21];

    for (int i = 0; i < q; i++)
        fgets(qa[i], sizeof(qa[i]), stdin);
    
    for (int i = 0; i < q; i++)
    {
        int count = 0;
        for (int j = 0; j < n; j++)
        {
            if (strcmp(qa[i], a[j]) == 0)
                count++;
        }
        printf("%d\n", count);
    }
    
    return 0;
}
