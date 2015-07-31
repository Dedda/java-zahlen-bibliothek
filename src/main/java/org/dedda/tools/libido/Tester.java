package org.dedda.tools.libido;

import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.Drei;
import static org.dedda.tools.libido.Zahlen.Eins;
import static org.dedda.tools.libido.Zahlen.Fünf;
import static org.dedda.tools.libido.Zahlen.Vier;
import static org.dedda.tools.libido.Zahlen.Zwei;

/**
 * Created by dedda on 7/31/15.
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println(Eins);
        System.out.println(Zwei);
        System.out.println(Drei);
        System.out.println(Vier);
        System.out.println(Fünf);
        System.out.println(Rechne(Eins).plus(Fünf).geteiltDurch(Drei).istGleich());
    }

}
