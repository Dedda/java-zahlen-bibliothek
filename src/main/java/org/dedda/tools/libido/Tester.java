package org.dedda.tools.libido;

import java.lang.reflect.InvocationTargetException;

import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.*;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Tester {

    public static void main(String[] $args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Tester.class.getMethod("__main").invoke(new Tester());
    }

    public void __main(){
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
