test:
	./baue-die-erlang-programme.sh
	./starte-den-erlang-bediener.sh
	mvn clean test
	killall -9 beam.smp
package:
	./baue-die-erlang-programme.sh
	./starte-den-erlang-bediener.sh
	mvn clean package
	killall -9 beam.smp