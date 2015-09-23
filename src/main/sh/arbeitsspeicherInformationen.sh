#!/usr/bin/env bash

if [ "$1" = "" ]; then
    exit;
fi
if [ "$1" = "gesamt" ]; then
    cat /proc/meminfo | grep MemTotal
    exit
fi
if [ "$1" = "frei" ]; then
    cat /proc/meminfo | grep MemFree
    exit
fi
if [ "$1" = "verfügbar" ]; then
    cat /proc/meminfo | grep MemAvailable
    exit
fi
if [ "$1" = "einhandeln" ]; then
    if [ "$2" = "gesamt" ]; then
        cat /proc/meminfo | grep SwapTotal
        exit
    fi
    if [ "$2" = "frei" ]; then
        cat /proc/meminfo | grep SwapFree
        exit
    fi
    exit
fi
