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
	mvn clean compile assembly:single
	make stoppeAlleErlangs
packageSkipTests:
	mvn clean compile assembly:single -DskipTests=true