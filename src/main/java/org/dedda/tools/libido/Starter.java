package org.dedda.tools.libido;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import static org.dedda.tools.libido.$.$_ENV;
import static org.dedda.tools.libido.$.$argc;
import static org.dedda.tools.libido.$.$argv;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Starter {

    public static void main(String[] $args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        $argv = $args;
        $argc = $args.length;
        $_ENV = new HashMap<>();
        $_ENV.put("Entkäferer", "ausgeschaltet");
        for (String $arg : $args) {
            if ($arg.equals("--entwanzen")) {
                $_ENV.put("Entkäferer", "eingeschaltet");
            }
        }
        Class $programmKlasse = Class.forName("standardPaket.Programm");
        $programmKlasse.getMethod("start").invoke($programmKlasse.getConstructor().newInstance());
    }

}
