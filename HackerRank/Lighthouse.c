#include <stdio.h>
#include <stdlib.h>

int main()
{
    int max_r = 0, num, i, j, m, n, r, circle = 0;

    scanf("%d", &num);

    char a[num][num];

    for (i = 0; i < num; i++)
    {
        getchar(); // eat newline
        for (j = 0; j < num; j++)
        {
            scanf("%c", &a[i][j]);
        }
    }

    puts("");

    for (i = 0; i < num; i++)
    {
        for (j = 0; j < num; j++)
        {
            if (a[i][j] == '.')
            {
                for (r = 0; r < num; r++)
                {
                    int r_square = r * r;
                    for (m = (-r); m <= r; m++)
                    {
                        int m_square = m * m;
                        for (n = (-r); n <= r; n++)
                        {
                            int n_square = n * n;
                            if ((m_square + n_square) <= r_square)
                            {
                                if (a[i+m][j+n] == '.')
                                {
                                    circle = 1;
                                }
                                else
                                {
                                    circle = 0;
                                    break;
                                }
                            }
                        }
                        if (circle == 0)
                            break;
                    }
                    if (circle == 1)
                    {
                        if (r > max_r)
                        {
                            max_r = r;
                        }
                    }
                }
            }
        }
    }

    printf("%d\n", max_r);

    return 0;
}
