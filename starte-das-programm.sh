#!/usr/bin/env bash
make install
make starteErlangServer
java -jar ./target/lib-ido-1.0-SNAPSHOT-jar-with-dependencies.jar
make stoppeAlleErlangs
make clean