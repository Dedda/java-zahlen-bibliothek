package org.dedda.tools.libido;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.dedda.tools.libido.$.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/10/15.
 *
 * @author dedda
 */
public class $Test {

    @Before
    public void setUp() {
        $_ENV("Entkäferer", "ausgeschaltet");
    }

    @Test
    public void test$() throws Exception {
        String $anweisung = "1 + 1;";
        int $ergebnis = (int) $($anweisung);
        assertEquals(2, $ergebnis);
    }

    @Test
    public void test$_ENV() throws Exception {
        $_ENV("neuer Schlüssel", 123);
        int $ausgelesen = (int) $_ENV("neuer Schlüssel");
        assertEquals(123, $ausgelesen);
        Object $null = $_ENV("gibts Nicht");
        assertNull($null);
    }

    @Test
    public void test_() throws Exception {
        int $objekt1 = 1;
        int $objekt2 = 2;
        _($objekt1, 123, 123);
        _($objekt2, 321, 321);
        assertEquals(123, _($objekt1, 123));
        assertNull(_($objekt2, 123));
        assertEquals(321, _($objekt2, 321));
        assertNull(_($objekt1, 321));
    }

    @Test
    public void test__() throws Exception {
        int $objekt = 1;
        _(1, "#variable1", 1);
        _(1, "#variable2", 2);
        String $text = "#variable1 + #variable2 ;";
        String $ersetzt = __(1, $text);
        assertEquals("1 + 2 ;", $ersetzt);
        Object $objekt2 = new $test$class(3);
        _($objekt2, "#variable1", 4);
        $text = "#variable1 + #variable3 ;";
        $ersetzt = __($objekt2, $text);
        assertEquals("4 + 3 ;", $ersetzt);
    }

    @Test
    public void test__eon() throws Exception {
        Object[] $wahr = {true, 1, "1", "wahr", "#soTrue", "#trueStoryBro", new Object()};
        Object[] $falsch = {false, 0, "das wird wohl falsch sein!", $NIL};

        for (Object $wahresObjekt : $wahr) {
            assertTrue(__eon($wahresObjekt));
        }
        for (Object $falschesObjekt : $falsch) {
            assertFalse(__eon($falschesObjekt));
        }
    }

    @Test
    public void test__z() throws Exception {
        HashMap<Object, Number> $daten = new HashMap<>();
        $daten.put($NIL, 0);
        $daten.put(true, 1);
        $daten.put(false, 0);
        $daten.put(12, 12);
        $daten.put(12.3, 12.3);
        $daten.put("123", 123L);
        $daten.put("123.4", 123.4D);
        $daten.put("123,4", 0);
        $daten.put("Keine Zahl!", 0);
        $daten.put(new $Klasse$mit$nur$Ganzzahlen(), 8.);
        $daten.put(new $Klasse$mit$nur$Kommazahlen(), 8.7);
        $daten.put(new $Klasse$mit$Ganzzahlen$und$Kommazahlen(), 8.2);
        $daten.put(new $Klasse$mit$Zahlen$und$Texten$und$Wahr$und$Falsch$Werten(), 25.4);

        for (Map.Entry $eintrag : $daten.entrySet()) {
            Number $zahl = __z($eintrag.getKey());
            assertTrue(__kz($eintrag.getValue()) <= __kz($zahl) + 0.01);
            assertTrue(__kz($eintrag.getValue()) >=__kz($zahl) - 0.01);
        }
    }

    private class $test$class {

        public final int $variable3;

        private $test$class(final int $variable3) {
            this.$variable3 = $variable3;
        }
    }

    private class $Klasse$mit$nur$Ganzzahlen {
        public final Integer $zahl1 = 5;
        public final Long $zahl2 = 3L;
    }

    private class $Klasse$mit$nur$Kommazahlen {
        public final Float $zahl1 = 5.3F;
        public final Double $zahl2 = 3.4;
    }

    private class $Klasse$mit$Ganzzahlen$und$Kommazahlen {
        public final Integer $zahl1 = 5;
        public final Double $zahl2 = 3.2;
    }

    private class $Klasse$mit$Zahlen$und$Texten$und$Wahr$und$Falsch$Werten {
        public final Integer $zahl1 = 1;
        public final Integer $zahl2 = 2;
        public final String $text1 = "12.4";
        public final String $text2derAberNullErgibt = "Das ist keine Zahl";
        public final String $text3 = "#trueStoryBro";
        public final Boolean $wahr = true;
        public final $Klasse$mit$nur$Ganzzahlen $klasse$mit$nur$Ganzzahlen = new $Klasse$mit$nur$Ganzzahlen();
    }

}