package org.dedda.tools.libido;

import static java.lang.Math.pow;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Rechenoperationen {

    private long zahlBisJetzt;
    private String rechnung;

    public Rechenoperationen(long ersteZahl) {
        this.zahlBisJetzt = ersteZahl;
        rechnung = "" + ersteZahl;
    }

    /**
     * Leitet den Anfang einer Rechnung ein.
     *
     * @param ersteZahl erster Operand für die erste Rechenoperation
     * @return Rechnung, die weitergeführt oder mit #istGleich ausgewertet werden kann
     *
     * @see #istGleich()
     */
    public static Rechenoperationen Rechne(final long ersteZahl) {
        return new Rechenoperationen(ersteZahl);
    }

    public Rechenoperationen plus(final long zweiteZahl) {
        this.zahlBisJetzt += zweiteZahl;
        rechnung += " + " + zweiteZahl;
        return this;
    }

    public Rechenoperationen minus(final long zweiteZahl) {
        this.zahlBisJetzt -= zweiteZahl;
        rechnung += " - " + zweiteZahl;
        return this;
    }

    public Rechenoperationen mal(final long zweiteZahl) {
        this.zahlBisJetzt *= zweiteZahl;
        rechnung += " * " + zweiteZahl;
        return this;
    }

    public Rechenoperationen geteiltDurch(final long zweiteZahl) {
        this.zahlBisJetzt /= zweiteZahl;
        rechnung += " / " + zweiteZahl;
        return this;
    }

    public long istGleich() {
        System.out.println(rechnung + " = " + zahlBisJetzt);
        return zahlBisJetzt;
    }

    public Rechenoperationen teWurzelVon(final long zweiteZahl) {
        zahlBisJetzt = (long)pow(zweiteZahl, 1.0/zahlBisJetzt);
        rechnung = zweiteZahl + " ^ (1/(" + rechnung + "))";
        return this;
    }

    public Rechenoperationen steWurzelVon(final long zweiteZahl) {
        return teWurzelVon(zweiteZahl);
    }
}
