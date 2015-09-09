package org.dedda.tools.libido;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.dedda.tools.libido.$.$argv;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Starter {

    public static void main(String[] $args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        $argv = $args;
        Class $programmKlasse = Class.forName("standardPaket.Programm");
        $programmKlasse.getMethod("start").invoke($programmKlasse.getConstructor().newInstance());
    }

}
