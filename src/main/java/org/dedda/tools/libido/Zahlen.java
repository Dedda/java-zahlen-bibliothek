package org.dedda.tools.libido;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 *
 *
 */
public class Zahlen {

    public static final long Eins = (long)PI%(long)E;
    public static final long Zwei = (long)floor(E);
    public static final long Drei = (long)floor(PI);
    public static final long Vier = (long)pow(floor(E),floor(E));
    public static final long Fünf = (long)(toDegrees(sin(E))/PI-floor(E));

}
