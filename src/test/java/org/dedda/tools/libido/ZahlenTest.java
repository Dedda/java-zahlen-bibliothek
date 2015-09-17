package org.dedda.tools.libido;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.__kz;
import static org.dedda.tools.libido.Zahlen.____;
import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 9/14/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class ZahlenTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> $objektListe = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            $objektListe.add(new Object[]{i});
        }
        return $objektListe;
    }

    @Parameter
    public int $zahl;

    @Test
    public void testZahlen() throws Exception {
        assertEquals((double) $zahl, __kz($(____("" + $zahl))), 0.01f);
    }

}