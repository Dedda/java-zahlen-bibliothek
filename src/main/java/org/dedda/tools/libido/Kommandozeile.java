package org.dedda.tools.libido;

import org.dedda.tools.libido.universum.DieVirtuelleUniversumsFabrik;

import java.util.Scanner;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__t;

/**
 * Created by dedda on 11/3/15.
 *
 * @author dedda
 */
public class Kommandozeile{

    public static void starte(){
        _(Kommandozeile.class, "#universum", DieVirtuelleUniversumsFabrik.ErstelleEinUniversum().bitte());
        _(Kommandozeile.class, "#einleser", new Scanner(System.in));
        __renne();
    }

    private static void __renne(){
        _(Kommandozeile.class, "__renne#befehl", __t(((Scanner) _(Kommandozeile.class, "#einleser")).nextLine()));
        __befehl(__t(_(Kommandozeile.class, "__renne#befehl")));
    }

    private static boolean __befehl(String $befehl){
        _(Kommandozeile.class, "__befehl#befehl", $befehl);
        return !__t(_(Kommandozeile.class, "__befehl#befehl")).equals("STOP!");   // stoppe wenn befehl ist "STOP!"
    }
}
