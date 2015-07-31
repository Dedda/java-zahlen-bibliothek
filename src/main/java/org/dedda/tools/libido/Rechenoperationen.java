package org.dedda.tools.libido;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Rechenoperationen {

    private long zahlBisJetzt;

    public Rechenoperationen(long ersteZahl) {
        this.zahlBisJetzt = ersteZahl;
    }

    public static Rechenoperationen Rechne(final long ersteZahl) {
        return new Rechenoperationen(ersteZahl);
    }

    public Rechenoperationen plus(final long zweiteZahl) {
        this.zahlBisJetzt += zweiteZahl;
        return this;
    }

    public Rechenoperationen minus(final long zweiteZahl) {
        this.zahlBisJetzt -= zweiteZahl;
        return this;
    }

    public Rechenoperationen mal(final long zweiteZahl) {
        this.zahlBisJetzt *= zweiteZahl;
        return this;
    }

    public Rechenoperationen geteiltDurch(final long zweiteZahl) {
        this.zahlBisJetzt /= zweiteZahl;
        return this;
    }

    public long istGleich() {
        return zahlBisJetzt;
    }
}
