package org.dedda.tools.libido;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.$_ENV;
import static org.dedda.tools.libido.$._;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Rechenoperationen {

    private Rechenoperationen $diese = this;

    public Rechenoperationen(long $ersteZahl) {
        _($diese, "$zahlBisJetzt", $ersteZahl);
        _($diese, "$rechnung", "" + $ersteZahl);
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
        _($diese, "$startZeit", System.nanoTime());
        _($diese, "$zahlBisJetzt", (int) $(_($diese, "$zahlBisJetzt") + " + " + $zweiteZahl + ";"));
        _($diese, "$rechnung", (String) $(_($diese, "$rechnung") + " + \' + \' + " + $zweiteZahl + ";"));
        _($diese, "$endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Plus\' in " + (((long) _($diese, "$endZeit") - (long) _($diese, "$startZeit")) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen minus(final long $zweiteZahl) {
        _($diese, "$startZeit", System.nanoTime());
        _($diese, "$zahlBisJetzt", (int) $(_($diese, "$zahlBisJetzt") + " - " + $zweiteZahl + ";"));
        _($diese, "$rechnung", (String) $(_($diese, "$rechnung") + " + \' - \' + " + $zweiteZahl + ";"));
        _($diese, "$endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Minus\' in " + (((long) _($diese, "$endZeit") - (long) _($diese, "$startZeit")) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen mal(final long $zweiteZahl) {
        _($diese, "$startZeit", System.nanoTime());
        _($diese, "$zahlBisJetzt", (int) $(_($diese, "$zahlBisJetzt") + " * " + $zweiteZahl + ";"));
        _($diese, "$rechnung", (String) $(_($diese, "$rechnung") + " + \' * \' + " + $zweiteZahl + ";"));
        _($diese, "$endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Mal\' in " + (((long) _($diese, "$endZeit") - (long) _($diese, "$startZeit")) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen geteiltDurch(final long $zweiteZahl) {
        _($diese, "$startZeit", System.nanoTime());
        _($diese, "$zahlBisJetzt", (int) $(_($diese, "$zahlBisJetzt") + " / " + $zweiteZahl + ";"));
        _($diese, "$rechnung", (String) $(_($diese, "$rechnung") + " + \' / \' + " + $zweiteZahl + ";"));
        _($diese, "$endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Geteilt\' in " + (((long) _($diese, "$endZeit") - (long) _($diese, "$startZeit")) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public long istGleich() {
        System.out.println(_($diese, "$rechnung") + " = " + _($diese, "$zahlBisJetzt"));
        return (int) _($diese, "$zahlBisJetzt");
    }

    public Rechenoperationen teWurzelVon(final long $zweiteZahl) {
        _( $diese, "$startZeit", System.nanoTime());
        _($diese, "$zahlBisJetzt", (int) ((double) $("Math.pow(" + $zweiteZahl + ", 1/(" + _($diese, "$zahlBisJetzt") + "));")));
        _($diese, "$rechnung", (String) $($zweiteZahl + " + \' ^ (1/(" + _($diese, "$rechnung") + "))\';"));
        _($diese, "$endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Wurzel\' in " + (((long) _($diese, "$endZeit") - (long) _($diese, "$startZeit")) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen steWurzelVon(final long $zweiteZahl) {
        return teWurzelVon($zweiteZahl);
    }
}
