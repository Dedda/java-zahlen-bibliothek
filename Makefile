baueErlang:
	./baue-die-erlang-programme.sh
starteErlangServer:
	./starte-den-erlang-bediener.sh
stoppeAlleErlangs:
	killall -9 beam.smp
baueC:
	./baue-die-c-programme.sh
test:
	make baueC
	make baueErlang
	./baue-die-erlang-programme.sh
	make starteErlangServer
	mvn clean test
	make stoppeAlleErlangs
	make clean
package:
	make baueC
	make baueErlang
	make starteErlangServer
	mvn clean test compile assembly:single
	make stoppeAlleErlangs
	make clean
packageSkipTests:
	make baueC
	mvn clean compile assembly:single -DskipTests=true
	make clean
install:
	make package
	cp ./src/main/python/*.py ./
clean:
	rm AUSGABE.html Nachrichten.log DATEN.json *.py -rf target logger.beam erl_crash.dump hochgeschwindigkeitsrechnungen