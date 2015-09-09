package org.dedda.tools.libido;

import standardPaket.Programm;

import java.lang.reflect.InvocationTargetException;

import static org.dedda.tools.libido.$.$argv;
import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.*;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Tester {

    public static void main(String[] $args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Tester.class.getMethod("__main").invoke(new Tester());
        $argv = $args;
        new Programm().start();
    }

    public void __main(){

    }
}
