package org.dedda.tools.libido;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * Created by dedda on 9/9/15.
 *
 * @author dedda
 */
public final class $ {

    public static String[] $argv;
    public static int $argc;
    public static Map<String, Object> $_ENV;

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

    private $() {}

}
