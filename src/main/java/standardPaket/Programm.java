package standardPaket;

import org.dedda.tools.libido.QuellTextÜbersetzer;

import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.Drei;
import static org.dedda.tools.libido.Zahlen.Eins;
import static org.dedda.tools.libido.Zahlen.Einundzwanzig;
import static org.dedda.tools.libido.Zahlen.Ers;
import static org.dedda.tools.libido.Zahlen.Fünf;
import static org.dedda.tools.libido.Zahlen.Neunzehn;
import static org.dedda.tools.libido.Zahlen.Siebenundzwanzig;
import static org.dedda.tools.libido.Zahlen.Vier;
import static org.dedda.tools.libido.Zahlen.Zwei;

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
        System.out.println($actual);
        if (!$expected.equals($actual)) {
            System.out.println("FAAAALSCH");
        }
    }

}
