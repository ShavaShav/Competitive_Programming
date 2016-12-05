#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int t;
    scanf("%d",&t);
    int a0;
    for(a0 = 0; a0 < t; a0++){
        char* s = (char *)malloc(10240 * sizeof(char));
        scanf("%s",s);
        char *ptr_s = s;
        bool balanced = true;
        int curlyStack = 0, squareStack = 0, roundStack = 0;
        int knt;
        for (knt = 0; knt < strlen(s); knt++)
        {
            switch (*ptr_s)
            {
                case '[': squareStack++; break;
                case ']': squareStack--; break;
                case '(': roundStack++; break;
                case ')': roundStack--; break;
                case '{': curlyStack++; break;
                case '}': curlyStack--; break;
            }
            if (squareStack < 0 || roundStack < 0 || curlyStack < 0)
                balanced = false;

            ptr_s++;
        }
        if (balanced && squareStack == 0 && roundStack == 0 && curlyStack == 0)
            puts("YES");
        else
            puts ("NO");
    }
    return 0;
}


