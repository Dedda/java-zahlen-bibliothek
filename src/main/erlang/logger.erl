-module(logger).
-include("logger.hrl").

-export([logger/1, logger/2]).

logger([Listenkopf|Listenrest]) ->
  logger(Listenkopf),
  logger(Listenrest)
;
logger([]) -> ok;
logger(Eintrag) when is_record(Eintrag, eintrag) ->
  {Stunde, Minute, Sekunde} = time(),
  {Jahr, Monat, Tag} = date(),
  Zeit = integer_to_list(Stunde) ++ ":" ++ integer_to_list(Minute) ++ "Uhr und " ++ integer_to_list(Sekunde) ++ " Sekunden",
  Datum = integer_to_list(Tag) ++ "." ++ integer_to_list(Monat) ++ "." ++ integer_to_list(Jahr),
  Dringlichkeit = Eintrag#logeintrag.dringlichkeit,
  Nachricht = Eintrag#logeintrag.nachricht,
  Inhalt = "Um " ++ Zeit ++ " am " ++ Datum ++ " hat sich folgende Sache mit einer Dringlichkeit von " ++ integer_to_list(Dringlichkeit) ++ " ereignet: " ++ Nachricht,
  write("Nachrichten.log", Inhalt)
.

logger(Dringlichkeit, Nachricht) when is_integer(Dringlichkeit) ->
  Eintrag = #logeintrag{dringlichkeit = Dringlichkeit, nachricht = Nachricht},
  logger(Eintrag)
.

write(Datei, Inhalt) ->
  file:write_file(Datei, Inhalt ++ "\r", [append]),
  io:fwrite(Inhalt ++ "\n")
.