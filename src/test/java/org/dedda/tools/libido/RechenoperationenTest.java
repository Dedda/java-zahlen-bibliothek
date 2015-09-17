package org.dedda.tools.libido;

import org.junit.Before;
import org.junit.Test;

import static org.dedda.tools.libido.$.$_ENV;
import static org.dedda.tools.libido.$._;
import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 9/14/15.
 *
 * @author dedda
 */
public class RechenoperationenTest {

    @Before
    public void setUp() {
        $_ENV("Entkäferer", "ausgeschaltet");
    }

    @Test
    public void testRechne() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        assertEquals(4, _($instanz, "#zahlBisJetzt"));
        assertEquals("4", _($instanz, "#rechnung"));
    }

    @Test
    public void testPlus() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        $instanz.plus(2);
        assertEquals(6, _($instanz, "#zahlBisJetzt"));
        assertEquals("4 + 2", _($instanz, "#rechnung"));
    }

    @Test
    public void testMinus() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        $instanz.minus(2);
        assertEquals(2, _($instanz, "#zahlBisJetzt"));
        assertEquals("4 - 2", _($instanz, "#rechnung"));
    }

    @Test
    public void testMal() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        $instanz.mal(2);
        assertEquals(8, _($instanz, "#zahlBisJetzt"));
        assertEquals("4 * 2", _($instanz, "#rechnung"));
    }

    @Test
    public void testGeteiltDurch() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        $instanz.geteiltDurch(2);
        assertEquals(2, _($instanz, "#zahlBisJetzt"));
        assertEquals("4 / 2", _($instanz, "#rechnung"));
    }

    @Test
    public void testIstGleich() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(4);
        assertEquals(4, $instanz.istGleich());
    }

    @Test
    public void testTeWurzelVon() throws Exception {
        Rechenoperationen $instanz = Rechenoperationen.Rechne(2);
        $instanz.teWurzelVon(9);
        assertEquals(3., _($instanz, "#zahlBisJetzt"));
    }
}