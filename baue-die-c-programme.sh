#!/usr/bin/env bash

echo 'Baue Hochgeschwindigkeitsaddition...'
gcc -m32 -o hochgeschwindigkeitsaddition ./src/main/c/hochgeschwindigkeitsaddition.c ./src/main/asm/hochgeschwindigkeitsaddition.S
echo 'OK'