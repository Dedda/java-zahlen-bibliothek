package org.dedda.tools.libido;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;
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

    private static Map<String, Object> $_SERVER;

    private static Map<Object, Map<Object, Object>> $variablen;

    static {
        $_ENV = new HashMap<>();
        $_SERVER = new HashMap<>();
        $variablen = new HashMap<>();
    }

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

    public static Object $_ENV(final String $schlüssel) {
        if ($_ENV.containsKey($schlüssel)) {
            return $_ENV.get($schlüssel);
        }
        return null;
    }

    public static void $_ENV(final String $schlüssel, final Object $objekt) {
        $_ENV.put($schlüssel, $objekt);
    }

    public static Object $_SERVER(final String $schlüssel) {
        if ($_SERVER.containsKey($schlüssel)) {
            return $_SERVER.get($schlüssel);
        }
        return null;
    }

    public static void $_SERVER(final String $schlüssel, final Object $objekt) {
        $_SERVER.put($schlüssel, $objekt);
    }

    public static Object _(final Object $aufrufer, final Object $schlüssel) {
        if (!$variablen.containsKey($aufrufer)) {
            return null;
        }
        if (!$variablen.get($aufrufer).containsKey($schlüssel)) {
            return null;
        }
        return $variablen.get($aufrufer).get($schlüssel);
    }

    public static void _(final Object $aufrufer, final Object $schlüssel, final Object $wert) {
        if (!$variablen.containsKey($aufrufer)) {
            $variablen.put($aufrufer, new HashMap<>());
        }
        $variablen.get($aufrufer).put($schlüssel, $wert);
    }

    private $() {
    }

}
