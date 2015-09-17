package standardPaket;

import org.dedda.tools.libido.Fabrik;
import org.dedda.tools.libido.FabrikErzeuger;
import org.dedda.tools.libido.QuellTextÜbersetzer;

import static org.dedda.tools.libido.$.*;
import static org.dedda.tools.libido.Hilfsmittel.echo;
import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.*;

/**
 * Created by dedda on 9/9/15.
 *
 * @author dedda
 */
public class Programm {

    public void start() {
        Rechne(Eins()).plus(Fünf()).geteiltDurch(Drei()).istGleich();
        Rechne(Eins()).plus(Zwei()).teWurzelVon(Siebenundzwanzig()).istGleich();
        Rechne(Ers()).teWurzelVon(Vier()).istGleich();
        Rechne(Einundzwanzig()).steWurzelVon(Neunzehn()).istGleich();

        String $text = "Hallo Ich bin \"Hallo\"\n  //Hallo \nHallo/*dasfgHallo*/\n";
        String $expected = "Penis Ich bin \"Hallo\"\n  //Hallo \nPenis/*dasfgHallo*/\n";
        String $actual = new QuellTextÜbersetzer().übersetzeWort($text, "Hallo", "Penis");
        echo($actual);
        if (!$expected.equals($actual)) {
            echo("FAAAALSCH");
        }
        Fabrik $textFabrik = FabrikErzeuger.gibMirEinenFabrikErzeuger().erzeugeEineFabrikFürDieseKlasse(String.class);
        echo($textFabrik.fabriziere(1, "af", $argv));
        Fabrik<FabrikErzeuger> $fabrikErzeugerFabrik = FabrikErzeuger.gibMirEinenFabrikErzeuger().erzeugeEineFabrikFürDieseKlasse(FabrikErzeuger.class);
        FabrikErzeuger $fabrikErzeuger = $fabrikErzeugerFabrik.fabriziere();
        $textFabrik = $fabrikErzeuger.erzeugeEineFabrikFürDieseKlasse(String.class);
        echo($textFabrik.fabriziere("Hello", ' ', "World!"));
        int $objekt = 1;
        _($objekt, "$pimmel", 123);
        _($objekt, "$penis", 321);
        String $anweisung = "$pimmel + $penis ;";
        String $aufgelöst = __($objekt, $anweisung);
        echo($aufgelöst);
    }

}
