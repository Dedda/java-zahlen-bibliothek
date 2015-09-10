package org.dedda.tools.libido;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public static void main(String[] $args) {
        try {
            $argv = $args;
            $argc = $args.length;
            $_ENV("Entkäferer", "ausgeschaltet");
            for (String $arg : $args) {
                if ($arg.equals("--entwanzen")) {
                    $_ENV("Entkäferer", "eingeschaltet");
                }
            }
        } catch (Exception $e) {
            System.out.println("Das war wohl ein interner Fehler!");
        }
        Class $programmKlasse = null;
        try {
            $programmKlasse = Class.forName("standardPaket.Programm");
        } catch (ClassNotFoundException $e) {
            System.out.println("Du hast wohl keine \'standardPaket.Programm\'-Klasse erstellt!");
        }
        Method $startMethode = null;
        try {
            $startMethode = $programmKlasse.getMethod("start");
        } catch (NoSuchMethodException $e) {
            System.out.println("In deiner \'standardPaket.Programm\'-Klasse gibt es wohl keine \'start()\'-Methode!");
        }
        Constructor $erschaffer = null;
        try {
             $erschaffer = $programmKlasse.getConstructor();
        } catch (NoSuchMethodException $e) {
            System.out.println("Da scheint was mit deinem Konstruktor nicht zu stimmen!");
        }
        Object $instanz = null;
        try {
            $instanz = $erschaffer.newInstance();
        } catch (Exception $e) {
            System.out.println("Fehler beim Instanziieren!");
        }
        try {
            $startMethode.invoke($instanz);
        } catch (IllegalAccessException $e) {
            System.out.println("Deine \'start()\'-Methode konnte nicht aufgerufen werden!");
        } catch (InvocationTargetException $e) {
            System.out.println("Deine \'start()\'-Methode konnte nicht aufgerufen werden!");
        } catch (Exception $e) {
            System.out.println("Du scheinst kein guter Programmierer zu sein. Ich habe einen Fehler festgestellt!");
        }
    }

}
