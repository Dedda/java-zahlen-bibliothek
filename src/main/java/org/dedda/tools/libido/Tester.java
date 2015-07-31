package org.dedda.tools.libido;

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
 * Created by dedda on 7/31/15.
 */
public class Tester {

    public static void main(String[] args) {
        Rechne(Eins).plus(Fünf).geteiltDurch(Drei).istGleich();
        Rechne(Eins).plus(Zwei).teWurzelVon(Siebenundzwanzig).istGleich();
        Rechne(Ers).teWurzelVon(Vier).istGleich();
        Rechne(Einundzwanzig).steWurzelVon(Neunzehn).istGleich();
    }

}
