#!/usr/bin/env bash

echo 'Baue Hochgeschwindigkeitsrechnungen...'
gcc -m32 -o hochgeschwindigkeitsrechnungen ./src/main/c/hochgeschwindigkeitsrechnungen.c ./src/main/asm/hochgeschwindigkeitsaddition.S ./src/main/asm/hochgeschwindigkeitssubtraktion.S
echo 'OK'