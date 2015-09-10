package org.dedda.tools.libido;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.$_ENV;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Rechenoperationen {

    private long $zahlBisJetzt;
    private String $rechnung;
    private Rechenoperationen $diese = this;

    public Rechenoperationen(long $ersteZahl) {
        this.$zahlBisJetzt = $ersteZahl;
        $rechnung = "" + $ersteZahl;
    }

    /**
     * Leitet den Anfang einer Rechnung ein.
     *
     * @param $ersteZahl erster Operand für die erste Rechenoperation
     * @return Rechnung, die weitergeführt oder mit #istGleich ausgewertet werden kann
     *
     * @see #istGleich()
     */
    public static Rechenoperationen Rechne(final long $ersteZahl) {
        return new Rechenoperationen($ersteZahl);
    }

    public Rechenoperationen plus(final long $zweiteZahl) {
        long $startZeit = System.nanoTime();
        $diese.$zahlBisJetzt = (int) $($diese.$zahlBisJetzt + " + " + $zweiteZahl + ";");
        $diese.$rechnung = (String) $($diese.$rechnung + " + \' + \' + " + $zweiteZahl + ";");
        long $endZeit = System.nanoTime();
        if ($_ENV.get("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Plus\' in " + (($endZeit - $startZeit) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen minus(final long $zweiteZahl) {
        long $startZeit = System.nanoTime();
        $diese.$zahlBisJetzt = (int) $($diese.$zahlBisJetzt + " - " + $zweiteZahl + ";");
        $diese.$rechnung = (String) $($diese.$rechnung + " + \' - \' + " + $zweiteZahl + ";");
        long $endZeit = System.nanoTime();
        if ($_ENV.get("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Minus\' in " + (($endZeit - $startZeit) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen mal(final long $zweiteZahl) {
        long $startZeit = System.nanoTime();
        $diese.$zahlBisJetzt = (int) $($diese.$zahlBisJetzt + " * " + $zweiteZahl + ";");
        $diese.$rechnung = (String) $($diese.$rechnung + " + \' * \' + " + $zweiteZahl + ";");
        long $endZeit = System.nanoTime();
        if ($_ENV.get("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Mal\' in " + (($endZeit - $startZeit) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen geteiltDurch(final long $zweiteZahl) {
        long $startZeit = System.nanoTime();
        $diese.$zahlBisJetzt = (int) $($diese.$zahlBisJetzt + " / " + $zweiteZahl + ";");
        $diese.$rechnung = (String) $($diese.$rechnung + " + \' / \' + " + $zweiteZahl + ";");
        long $endZeit = System.nanoTime();
        if ($_ENV.get("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Geteilt\' in " + (($endZeit - $startZeit) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public long istGleich() {
        System.out.println($diese.$rechnung + " = " + $diese.$zahlBisJetzt);
        return $diese.$zahlBisJetzt;
    }

    public Rechenoperationen teWurzelVon(final long $zweiteZahl) {
        long $startZeit = System.nanoTime();
        $diese.$zahlBisJetzt = (int) ((double) $("Math.pow(" + $zweiteZahl + ", 1/(" + $diese.$zahlBisJetzt + "));"));
        $diese.$rechnung = (String) $($zweiteZahl + " + \' ^ (1/(" + $diese.$rechnung + "))\';");
        long $endZeit = System.nanoTime();
        if ($_ENV.get("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Wurzel\' in " + (($endZeit - $startZeit) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen steWurzelVon(final long $zweiteZahl) {
        return teWurzelVon($zweiteZahl);
    }
}
