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
public class Zahlen {

    public static final long Eins = (long)PI%(long)E;
    public static final long Ers = Eins;
    public static final long Zwei = (long)floor(E);
    public static final long Drei = (long)floor(PI);
    public static final long Drit = Drei;
    public static final long Vier = (long)pow(floor(E),floor(E));
    public static final long Fünf = (long)(toDegrees(sin(E))/PI-floor(E));
    public static final long Sechs = (((byte)floor(PI))<<(byte)(floor(PI)%floor(E)));
    public static final long Sieben = Arrays.stream(new long[]{(long)E,(long)PI}).map(l -> l == (long) E ? l * (long) E : l).sum();
    public static final long Sieb = Sieben;
    public static final long Acht = Long.parseLong(((long)(toDegrees(PI*E))+"").charAt((int)(floor(PI)-floor(E)))+"");
    public static final long Neun = (long)(pow((long)PI,(long)PI)/floor(PI));
    public static final long Zehn = 10;
    public static final long Elf = 11;
    public static final long Zwölf = 12;
    public static final long Dreizehn = 13;
    public static final long Vierzehn = 14;
    public static final long Fünfzehn = 15;
    public static final long Sechzehn = 16;
    public static final long Siebzehn = 17;
    public static final long Achtzehn = 18;
    public static final long Neunzehn = 19;
    public static final long Zwanzig = 20;
    public static final long Einundzwanzig = 21;
    public static final long Zweiungzwanzig = 22;
    public static final long Dreiundzwanzig = 23;
    public static final long Vierundzwanzig = 24;
    public static final long Fünfundzwanzig = 25;
    public static final long Sechsundzwanzig = 26;
    public static final long Siebenundzwanzig = 27;
    public static final long Achtundzwanzig = 28;
    public static final long Neunundzwanzig = 29;
    public static final long Dreißig = 30;

}
