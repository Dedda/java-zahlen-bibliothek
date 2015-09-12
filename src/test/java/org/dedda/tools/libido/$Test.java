package org.dedda.tools.libido;

import org.junit.Test;

import java.io.File;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.$_ENV;
import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/10/15.
 *
 * @author dedda
 */
public class $Test {

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

    private class $test$class {

        public final int $variable3;

        private $test$class(final int $variable3) {
            this.$variable3 = $variable3;
        }
    }

}