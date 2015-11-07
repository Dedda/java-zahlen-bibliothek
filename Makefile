baueErlang:
	./baue-die-erlang-programme.sh
starteErlangServer:
	./starte-den-erlang-bediener.sh
stoppeAlleErlangs:
	killall -9 beam.smp
test:
	make baueErlang
	./baue-die-erlang-programme.sh
	make starteErlangServer
	mvn clean test
	make stoppeAlleErlangs
package:
	make baueErlang
	make starteErlangServer
	mvn clean test compile assembly:single
	make stoppeAlleErlangs
packageSkipTests:
	mvn clean compile assembly:single -DskipTests=true
install:
	make package
	cp ./src/main/python/*.py ./
clean:
	rm AUSGABE.html Nachrichten.log DATEN.json *.py -rf target logger.beam