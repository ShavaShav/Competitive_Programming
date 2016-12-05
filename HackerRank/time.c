#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    char* time = (char *)malloc(10240 * sizeof(char));
    fgets(time, 80, stdin);
    
    int hour, min, sec;
    char ampm[3];
    
    sscanf(time, "%d:%d:%d%s", &hour, &min, &sec, ampm);
    
    if (strcmp(ampm, "PM")==0)
    {
         hour = hour + 12;
         if (hour == 24)
         {
               hour = 0;
         }
    }
    
    printf("%02d:%02d:%02d", hour, min, sec);
    return 0;
}
