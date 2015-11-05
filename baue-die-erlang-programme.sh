#!/usr/bin/env bash
PFAD=$(pwd)
cd ./src/main/erlang
rm *.beam
erl -make
cd $PFAD
mv ./src/main/erlang/*.beam .