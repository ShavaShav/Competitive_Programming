#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int x, y, a, b;
    double k, n;

    scanf("%d %d", &x, &y);
    scanf("%d %d", &a, &b);

    //find perpendicular vector
    double ortho_a = (double) (-b);
    double ortho_b = (double) a;

    double vlen = sqrt((a*a)+(b*b));
    printf("%f\n", vlen);

    ortho_a = a/vlen;
    ortho_b = b/vlen;
    printf("%f\t%f\n", ortho_a, ortho_b);

    // find determinants
    k = ((double)(x*ortho_b) - (y*ortho_a)) / (double) ((a*ortho_b) - (b*ortho_a));
    n = ((double)(a*y) - (b*x)) / (double) ((a*ortho_b) - (b*ortho_a));

    printf("%.12f\n%.12f\n", k, -n);

    return 0;
}
