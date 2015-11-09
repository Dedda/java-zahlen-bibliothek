#include <stdio.h>
#include <stdlib.h>

extern int hochgeschwindigkeitsaddition(int a, int b);

int main(int argc, char *argv[]) {
    int a;
    sscanf(argv[1], "%d", &a);
    int b;
    sscanf(argv[2], "%d", &b);
    int c = hochgeschwindigkeitsaddition(a, b);
    printf("%d\n", c);
}