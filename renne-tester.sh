#!/usr/bin/env bash

#mvn clean install
#
#echo ""
#echo ""
#echo ""
#echo ""
#echo ""
#echo ""
make package
./starte-den-erlang-bediener.sh
java -jar ./target/lib-ido-1.0-SNAPSHOT-jar-with-dependencies.jar --entwanzen
killall -9 beam.smp