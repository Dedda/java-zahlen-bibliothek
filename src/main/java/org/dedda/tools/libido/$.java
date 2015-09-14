package org.dedda.tools.libido;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by dedda on 9/9/15.
 *
 * @author dedda
 */
public final class $ {

    public static final Object $NUL = null;
    public static final Object $NIL = null;

    public static String[] $argv;
    public static int $argc;
    private static Map<String, Object> $_ENV;

    private static Map<Object, Map<Object, Object>> $variablen;

    static {
        $_ENV = new HashMap<>();
        $variablen = new HashMap<>();
    }

    /**
     * Java-Skript ausführen.
     *
     * @param $befehl
     * @return
     */
    public static Object $(final String $befehl) {
        ScriptEngine $motor = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            $motor.eval("load(\"nashorn:mozilla_compat.js\");");
            return $motor.eval($befehl);
        } catch (ScriptException $e) {
            $e.printStackTrace();
            throw new RuntimeException("Das geht so nicht!");
        }
    }

    /**
     * Umgebungsvariable auslesen.
     *
     * @param $schlüssel
     * @return
     */
    public static Object $_ENV(final String $schlüssel) {
        if ($_ENV.containsKey($schlüssel)) {
            return $_ENV.get($schlüssel);
        }
        return null;
    }

    /**
     * Umgebungsvariable setzen.
     *
     * @param $schlüssel
     * @param $objekt
     */
    public static void $_ENV(final String $schlüssel, final Object $objekt) {
        $_ENV.put($schlüssel, $objekt);
    }

    /**
     * Variable eines Objekts auslesen.
     *
     * @param $aufrufer
     * @param $schlüssel
     * @return
     */
    public static Object _(final Object $aufrufer, final Object $schlüssel) {
        if (!$variablen.containsKey($aufrufer)) {
            return null;
        }
        if (!$variablen.get($aufrufer).containsKey($schlüssel)) {
            return null;
        }
        return $variablen.get($aufrufer).get($schlüssel);
    }

    /**
     * Variable eines Objekts setzen.
     *
     * @param $aufrufer
     * @param $schlüssel
     * @param $wert
     */
    public static void _(final Object $aufrufer, final Object $schlüssel, final Object $wert) {
        if (!$variablen.containsKey($aufrufer)) {
            $variablen.put($aufrufer, new HashMap<>());
        }
        $variablen.get($aufrufer).put($schlüssel, $wert);
    }

    /**
     * Variablennamen in einem Text ersetzen.
     *
     * @param $aufrufer
     * @param $text
     * @return
     */
    public static String __(final Object $aufrufer, String $text) {
        if (!$variablen.containsKey($aufrufer)) {
            return null;
        }
        Map<Object, Object> $aufruferVariablen = $variablen.get($aufrufer);
        Map<String, Object> $aufruferVariablenMitTextAlsId = new HashMap<>();
        for (Object $variablenName : $aufruferVariablen.keySet()) {
            if ($variablenName instanceof String) {
                $aufruferVariablenMitTextAlsId.put((String) $variablenName, $aufruferVariablen.get($variablenName));
            }
        }
        int $position = 0;

        while (($position = $text.indexOf('#', $position)) != -1) {
            String $ersterTeil = $text.substring(0, $position);
            int $endeVomWort = $text.indexOf(' ', $position);
            String $letzterTeil = $text.substring($endeVomWort);
            String $wort = $text.substring($position, $endeVomWort);
            boolean $wortExistiertAlsVariable = $aufruferVariablenMitTextAlsId.containsKey($wort);
            if ($wortExistiertAlsVariable) {
                $text = $ersterTeil + $aufruferVariablenMitTextAlsId.get($wort) + $letzterTeil;
                continue;
            }
            Class $klasse = $aufrufer.getClass();
            Field $felder[] = $klasse.getFields();
            for (Field $feld : $felder) {
                if ($feld.getName().equals('$' + $wort.substring(1))) {
                    $wortExistiertAlsVariable = true;
                }
            }
            if ($wortExistiertAlsVariable) {
                try {
                    Field $feld = $klasse.getField('$' + $wort.substring(1));
                    $text = $ersterTeil + $feld.get($aufrufer) + $letzterTeil;
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return $text;
    }

    /**
     * Eins oder Null
     * @param $objekt
     * @return
     */
    public static boolean __eon(final Object $objekt) {
        if ($objekt == $NIL) {
            return false;
        }
        if ($objekt instanceof Boolean) {
            return (boolean) $objekt;
        }
        if ($objekt instanceof Number) {
            return $objekt != (Number) 0;
        }
        if ($objekt instanceof String) {
            String $alsText = __t($objekt);
            return $alsText.equals("1") || $alsText.equals("wahr") || $alsText.equals("#soTrue") || $alsText.equals("#trueStoryBro");
        }
        return true;
    }

    /**
     * Zahl
     * @param $objekt
     * @return
     */
    public static Number __z(final Object $objekt) {
        if ($objekt == $NIL) {
            return 0;
        }
        if ($objekt instanceof Number) {
            return (Number) $objekt;
        }
        if ($objekt instanceof String) {
            if (__t($objekt).contains(".")) {
                try {
                    return Double.parseDouble(__t($objekt));
                } catch (Exception $e) {
                    return 0;
                }
            }
            try {
                return Long.parseLong(__t($objekt));
            } catch (Exception $e) {
                return __eon($objekt) ? 1 : 0;
            }
        }
        if ($objekt instanceof Boolean) {
            return (Boolean) $objekt ? 1 : 0;
        }
        return ___$umme($objekt);
    }

    /**
     * Ganzzahl
     * @param $objekt
     * @return
     */
    public static long __gz(final Object $objekt) {
        return __z($objekt).longValue();
    }

    /**
     * Kommazahl
     * @param $objekt
     * @return
     */
    public static double __kz(final Object $objekt) {
        return __z($objekt).doubleValue();
    }

    /**
     * Text
     * @param $objekt
     * @return
     */
    public static String __t(final Object $objekt) {
        if ($objekt instanceof String) {
            return (String) $objekt;
        }
        try {
            String $text = (String) $objekt;
            return $text;
        } catch (Exception $e) {}
        return $objekt.toString();
    }

    private static Number ___$umme(final Object $objekt) {
        double $zahl = 0;
        Field[] $felder = $objekt.getClass().getFields();
        for (Field $feld : $felder) {
            if (Number.class.isAssignableFrom($feld.getType())) {
                try {
                    Object $wert = $feld.get($objekt);
                    double $neueZahl = __kz(Rechenoperationen.Rechne($zahl).plus(__kz($wert)).istGleich());
                    $zahl = $neueZahl;
                } catch (Exception $e) {}
            } else if (String.class.isAssignableFrom($feld.getType())) {
                try {
                    String $text = __t($feld.get($objekt));
                    $zahl = __kz(Rechenoperationen.Rechne($zahl).plus(__kz($text)).istGleich());
                } catch (IllegalAccessException $e) {}
            } else if (Boolean.class.isAssignableFrom($feld.getType())) {
                try {
                    Boolean $wert = (Boolean) $feld.get($objekt);
                    $zahl = __kz(Rechenoperationen.Rechne($zahl).plus(__gz($wert)).istGleich());
                } catch (IllegalAccessException $e) {}
            } else {
                try {
                    $zahl = __kz(Rechenoperationen.Rechne($zahl).plus(__kz($feld.get($objekt))).istGleich());
                } catch (IllegalAccessException e) {}
            }
        }
        return $zahl;
    }

    private $() {
    }

}
