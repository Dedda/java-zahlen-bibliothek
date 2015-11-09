#!/usr/bin/env bash

echo 'Baue Hochgeschwindigkeitsrechnungen...'
gcc -m32 -o hochgeschwindigkeitsrechnungen ./src/main/c/hochgeschwindigkeitsrechnungen.c ./src/main/asm/hochgeschwindigkeitsaddition.S ./src/main/asm/hochgeschwindigkeitssubtraktion.S ./src/main/asm/hochgeschwindigkeitsmultiplikation.S ./src/main/asm/hochgeschwindigkeitsdivision.S ./src/main/asm/fibonacci.S
echo 'OK'