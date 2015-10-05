package org.dedda.tools.libido.universum;

import org.junit.Before;
import org.junit.Test;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__eon;
import static org.dedda.tools.libido.universum.DieVirtuelleUniversumsFabrik.ErstelleEinUniversum;
import static org.junit.Assert.*;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public class DieVirtuelleUniversumsFabrikTest {

    @Before
    public void setUp() {
        _(this, "#instanz", ErstelleEinUniversum());
    }

    @Test
    public void testeKorrektesUniversum() {
        DasVirtuelleObjekt $objekt1 = new DasVirtuelleObjekt("Objekt 1");
        DasVirtuelleObjekt $objekt2 = new DasVirtuelleObjekt("Objekt 2");
        DasVirtuelleObjekt $objekt3 = new DasVirtuelleObjekt("Objekt 3");
        DasVirtuelleUniversum $universum = ((DieVirtuelleUniversumsFabrik)_(this, "#instanz")).mit($objekt1).und().mit($objekt2).und($objekt3).bitte();
        assertTrue($universum.bekommeDieVirtuellenObjekte().contains($objekt1));
        assertTrue($universum.bekommeDieVirtuellenObjekte().contains($objekt2));
        assertTrue($universum.bekommeDieVirtuellenObjekte().contains($objekt3));
        assertEquals(3, $universum.bekommeDieVirtuellenObjekte().size());
    }

    @Test
    public void testeLeeresUniversum() {
        DasVirtuelleUniversum $universum = ((DieVirtuelleUniversumsFabrik)_(this, "#instanz")).bitte();
        assertEquals(0, $universum.bekommeDieVirtuellenObjekte().size());
    }

    @Test
    public void testeFehler() {
        DasVirtuelleObjekt $objekt1 = new DasVirtuelleObjekt("Objekt 1");
        _(this, "#instanz", ErstelleEinUniversum());
        _(this, "#ersterFehler", false);
        try {
            ((DieVirtuelleUniversumsFabrik)_(this, "#instanz")).mit($objekt1).mit($objekt1).bitte();
        } catch (RuntimeException $e) {
            _(this, "#ersterFehler", true);
        }
        assertTrue("Es ist kein Fehler aufgetreten!", __eon(_(this, "#ersterFehler")));
    }

}