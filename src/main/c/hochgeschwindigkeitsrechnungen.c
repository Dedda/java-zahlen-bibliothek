#include <stdio.h>
#include <stdlib.h>

extern int hochgeschwindigkeitsaddition(int a, int b);
extern int hochgeschwindigkeitssubtraktion(int a, int b);

int main(int argc, char *argv[]) {
    int a;
    sscanf(argv[2], "%d", &a);
    int b;
    sscanf(argv[3], "%d", &b);
    int c = 0;
    if (strcmp(argv[1], "addieren") == 0) {
        c = hochgeschwindigkeitsaddition(a, b);
    } else if (strcmp(argv[1], "subtrahieren") == 0) {
        c = hochgeschwindigkeitssubtraktion(a, b);
    } else if (strcmp(argv[1], "multiplizieren") == 0) {
        c = a * b;
    } else if (strcmp(argv[1], "dividieren") == 0) {
        c = a / b;
    }
    printf("%d\n", c);
}