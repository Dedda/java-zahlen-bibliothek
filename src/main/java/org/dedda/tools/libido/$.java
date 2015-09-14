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
            String $alsText = (String) $objekt;
            return $alsText.equals("1") || $alsText.equals("wahr") || $alsText.equals("#soTrue") || $alsText.equals("#trueStoryBro");
        }
        return true;
    }

    public static Number __z(final Object $objekt) {
        if ($objekt == $NIL) {
            return 0;
        }
        if ($objekt instanceof Number) {
            return (Number) $objekt;
        }
        if ($objekt instanceof String) {
            if (((String) $objekt).contains(".")) {
                try {
                    return Double.parseDouble((String) $objekt);
                } catch (Exception $e) {
                    return 0;
                }
            }
            try {
                return Long.parseLong((String) $objekt);
            } catch (Exception $e) {
                return 0;
            }
        }
        return 0;
    }

    public static long __gz(final Object $objekt) {
        return (long) __z($objekt);
    }

    public static double __kz(final Object $objekt) {
        return (double) __z($objekt);
    }

    private static Number ___$umme(final Object $objekt) {
        double $zahlMitKomma = 0;
        long $zahlOhneKomma = 0;
        boolean $zahlHatKomma = false;
        Field[] $felder = $objekt.getClass().getFields();
        for (Field $feld : $felder) {
            if (Number.class.isAssignableFrom($feld.getType())) {
                try {
                    Object $wert = $feld.get($objekt);
                    if ($wert instanceof Double || $wert instanceof Float) {
                        $zahlHatKomma = true;
                        $zahlMitKomma += (Double) ((Number) $wert);
                    } else {
                        if (!$zahlHatKomma) {
                            $zahlOhneKomma += (Long) ((Number) $wert);
                        }
                        $zahlMitKomma += (Long) ((Number) $wert);
                    }
                } catch (Exception $e) {}
            } else if (String.class.isAssignableFrom($feld.getType())) {
                try {
                    String $text = (String) $feld.get($objekt);
                    Number $zahl = __z($text);
                    if ($zahl instanceof Double || $zahl instanceof Float) {
                        $zahlHatKomma = true;
                        $zahlMitKomma += (Double) ((Number) $zahl);
                    } else {
                        if (!$zahlHatKomma) {
                            $zahlOhneKomma += (Long) ((Number) $zahl);
                        }
                        $zahlMitKomma += (Long) ((Number) $zahl);
                    }
                } catch (IllegalAccessException $e) {}
            } else if (Boolean.class.isAssignableFrom($feld.getType())) {
                try {
                    if (!$zahlHatKomma) {
                        $zahlMitKomma += (Boolean) $feld.get($objekt) ? 1 : 0;
                    }
                    $zahlOhneKomma += (Boolean) $feld.get($objekt) ? 1 : 0;
                } catch (IllegalAccessException $e) {}
            }
        }
        return $zahlHatKomma ? $zahlMitKomma : $zahlOhneKomma;
    }

    private $() {
    }

}
