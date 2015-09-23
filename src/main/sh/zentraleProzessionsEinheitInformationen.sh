#!/usr/bin/env bash

if [ "$1" = "" ]; then
    exit
fi
if [ "$1" = "megahertze" ]; then
    cat /proc/cpuinfo | grep 'cpu MHz'
    exit
fi
if [ "$1" = "kerne" ]; then
    cat /proc/cpuinfo | grep 'core id'
    exit
fi
if [ "$1" = "name" ]; then
    cat /proc/cpuinfo | grep 'model name'
    exit
fi
if [ "$1" = "flaggen" ]; then
    cat /proc/cpuinfo | grep flags
    exit
fi
if [ "$1" = "käfig" ]; then
    cat /proc/cpuinfo | grep 'cache size'
    exit
fi