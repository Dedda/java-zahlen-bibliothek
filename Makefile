test:
	./baue-die-erlang-programme.sh
	./starte-den-erlang-bediener.sh
	mvn clean test
	killall -9 beam.smp
package:
	./baue-die-erlang-programme.sh
	./starte-den-erlang-bediener.sh
	mvn clean compile assembly:single
	killall -9 beam.smp
packageSkipTests:
	mvn clean compile assembly:single -DskipTests=true