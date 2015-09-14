package org.dedda.tools.libido;

import static org.dedda.tools.libido.$.*;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Rechenoperationen {

    private Rechenoperationen $diese = this;

    public Rechenoperationen(Number $ersteZahl) {
        _($diese, "#zahlBisJetzt", $ersteZahl);
        _($diese, "#rechnung", "" + $ersteZahl);
    }

    /**
     * Leitet den Anfang einer Rechnung ein.
     *
     * @param $ersteZahl erster Operand für die erste Rechenoperation
     * @return Rechnung, die weitergeführt oder mit #istGleich ausgewertet werden kann
     *
     * @see #istGleich()
     */
    public static Rechenoperationen Rechne(final Object $ersteZahl) {
        return new Rechenoperationen(__z($ersteZahl));
    }

    public Rechenoperationen plus(final Object $zweiteZahl) {
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt + #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' + \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Plus\' in " + ((__gz(_($diese, "#endZeit")) - __gz(_($diese, "#startZeit"))) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen minus(final Object $zweiteZahl) {
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt - #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' - \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Minus\' in " + ((__gz(_($diese, "#endZeit")) - __gz(_($diese, "#startZeit"))) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen mal(final Object $zweiteZahl) {
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt * #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' * \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Mal\' in " + ((__gz(_($diese, "#endZeit")) - __gz(_($diese, "#startZeit"))) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen geteiltDurch(final Object $zweiteZahl) {
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt / #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' / \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Geteilt\' in " + ((__gz(_($diese, "#endZeit")) - __gz(_($diese, "#startZeit"))) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Number istGleich() {
        System.out.println(_($diese, "#rechnung") + " = " + _($diese, "#zahlBisJetzt"));
        return (int) _($diese, "#zahlBisJetzt");
    }

    public Rechenoperationen teWurzelVon(final Object $zweiteZahl) {
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "Math.pow(#zweiteZahl , 1/(#zahlBisJetzt ));"))));
        _($diese, "#rechnung", __t($(__($diese, "#zweiteZahl + \' ^ (1/(#rechnung ))\';"))));
        _($diese, "#endZeit", System.nanoTime());
        if ($_ENV("Entkäferer").equals("eingeschaltet")) {
            System.out.println("\'Wurzel\' in " + ((__gz(_($diese, "#endZeit")) - __gz(_($diese, "#startZeit"))) / 1000000) + "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen steWurzelVon(final Object $zweiteZahl) {
        return teWurzelVon($zweiteZahl);
    }
}
