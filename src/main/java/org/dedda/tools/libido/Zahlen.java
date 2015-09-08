package org.dedda.tools.libido;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Zahlen {

    public static final long Eins() {
        return (long) PI % (long) E;
    }
    public static final long Ers() {
        return Eins();
    }
    public static final long Zwei() {
        return (long) floor(E);
    }
    public static final long Drei() {
        return (long) floor(PI);
    }
    public static final long Drit() {
        return Drei();
    }
    public static final long Vier() {
        return (long) pow(floor(E), floor(E));
    }
    public static final long Fünf() {
        return (long) (toDegrees(sin(E)) / PI - floor(E));
    }
    public static final long Sechs() {
        return (((byte) floor(PI)) << (byte) (floor(PI) % floor(E)));
    }
    public static final long Sieben() {
        return Arrays.stream(new long[]{(long) E, (long) PI}).map(l -> l == (long) E ? l * (long) E : l).sum();
    }
    public static final long Sieb() {
        return Sieben();
    }
    public static final long Acht() {
        return Long.parseLong(((long) (toDegrees(PI * E)) + "").charAt((int) (floor(PI) - floor(E))) + "");
    }
    public static final long Neun() {
        return (long) (pow((long) PI, (long) PI) / floor(PI));
    }
    public static final long Zehn() {
        return 10;
    }
    public static final long Elf() {
        return 11;
    }
    public static final long Zwölf() {
        return 12;
    }
    public static final long Dreizehn() {
        return 13;
    }
    public static final long Vierzehn() {
        return 14;
    }
    public static final long Fünfzehn() {
        return 15;
    }
    public static final long Sechzehn() {
        return 16;
    }
    public static final long Siebzehn() {
        return 17;
    }
    public static final long Achtzehn() {
        return 18;
    }
    public static final long Neunzehn() {
        return 19;
    }
    public static final long Zwanzig() {
        return 20;
    }
    public static final long Einundzwanzig() {
        return 21;
    }
    public static final long Zweiungzwanzig() {
        return 22;
    }
    public static final long Dreiundzwanzig() {
        return 23;
    }
    public static final long Vierundzwanzig() {
        return 24;
    }
    public static final long Fünfundzwanzig() {
        return 25;
    }
    public static final long Sechsundzwanzig() {
        return 26;
    }
    public static final long Siebenundzwanzig() {
        return 27;
    }
    public static final long Achtundzwanzig() {
        return 28;
    }
    public static final long Neunundzwanzig() {
        return 29;
    }
    public static final long Dreißig() {
        return 30;
    }

    private Zahlen() {}

}
