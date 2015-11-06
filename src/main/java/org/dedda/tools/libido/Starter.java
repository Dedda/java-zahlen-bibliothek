package org.dedda.tools.libido;

import org.dedda.tools.libido.internetseiten.InternetSeitenAnbieter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.dedda.tools.libido.$.*;
import static org.dedda.tools.libido.Hilfsmittel.echo;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public class Starter {

    public static void main(String[] $args) {
        InternetSeitenAnbieter.starte();
        try {
            Thread.sleep(999999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
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
            echo("Das war wohl ein interner Fehler!");
        }
        __PHP__.__AKTUALISIERE_DIE_SYSTEM_INFORMATIONEN__();
        Class $programmKlasse = null;
        try {
            $programmKlasse = Class.forName("standardPaket.Programm");
        } catch (ClassNotFoundException $e) {
            echo("Du hast wohl keine \'standardPaket.Programm\'-Klasse erstellt!");
        }
        Method $startMethode = null;
        try {
            $startMethode = $programmKlasse.getMethod("start");
        } catch (NoSuchMethodException $e) {
            echo("In deiner \'standardPaket.Programm\'-Klasse gibt es wohl keine \'start()\'-Methode!");
        }
        Constructor $erschaffer = null;
        try {
             $erschaffer = $programmKlasse.getConstructor();
        } catch (NoSuchMethodException $e) {
            echo("Da scheint was mit deinem Konstruktor nicht zu stimmen!");
        }
        Object $instanz = null;
        try {
            $instanz = $erschaffer.newInstance();
        } catch (Exception $e) {
            echo("Fehler beim Instanziieren!");
        }
        try {
            $startMethode.invoke($instanz);
        } catch (IllegalAccessException $e) {
            $e.printStackTrace();
            echo("Deine \'start()\'-Methode konnte nicht aufgerufen werden!");
        } catch (InvocationTargetException $e) {
            $e.printStackTrace();
            echo("Deine \'start()\'-Methode konnte nicht aufgerufen werden!");
        } catch (Exception $e) {
            echo("Du scheinst kein guter Programmierer zu sein. Ich habe einen Fehler festgestellt!");
        }
        /**/
    }

}
