package org.dedda.tools.libido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.*;
import static org.dedda.tools.libido.Hilfsmittel.echo;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Rechenoperationen{

    private Rechenoperationen $diese = this;

    public Rechenoperationen(Number $ersteZahl){
        _($diese, "#zahlBisJetzt", $ersteZahl);
        _($diese, "#rechnung", "" + $ersteZahl);
    }

    public Rechenoperationen(Number $ersteZahl, boolean schnell){
        _($diese, "#zahlBisJetzt", $ersteZahl);
        _($diese, "#rechnung", "" + $ersteZahl);
        _($diese, "#schnell", schnell);
    }

    /**
     * Leitet den Anfang einer Rechnung ein.
     *
     * @param $ersteZahl erster Operand für die erste Rechenoperation
     * @return Rechnung, die weitergeführt oder mit #istGleich ausgewertet werden kann
     *
     * @see #istGleich()
     */
    public static Rechenoperationen Rechne(final Object $ersteZahl){
        return new Rechenoperationen(__z($ersteZahl));
    }

    public static Rechenoperationen RechneSchnell(final Object $ersteZahl){
        return new Rechenoperationen(__z($ersteZahl), true);
    }

    public Rechenoperationen plus(final Object $zweiteZahl){
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        if(__eon(_($diese, "#schnell"))){
            try{
                Process prozess = Runtime.getRuntime().exec("./hochgeschwindigkeitsrechnungen addieren " + _($diese, "#zahlBisJetzt")+ " " + _($diese, "#zweiteZahl"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(prozess.getInputStream()));
                _($diese, "#zahlBisJetzt", __z(bufferedReader.readLine()));
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt + #zweiteZahl ;"))));
        }
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' + \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if($_ENV("Entkäferer").equals("eingeschaltet")){
            echo("\'Plus\' in " +((__gz(_($diese, "#endZeit"))- __gz(_($diese, "#startZeit")))/ 1000000)+ "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen minus(final Object $zweiteZahl){
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        if(__eon(_($diese, "#schnell"))){
            try{
                Process prozess = Runtime.getRuntime().exec("./hochgeschwindigkeitsrechnungen subtrahieren " + _($diese, "#zahlBisJetzt")+ " " + _($diese, "#zweiteZahl"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(prozess.getInputStream()));
                _($diese, "#zahlBisJetzt", __z(bufferedReader.readLine()));
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt - #zweiteZahl ;"))));
        }
//        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt - #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' - \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if($_ENV("Entkäferer").equals("eingeschaltet")){
            echo("\'Minus\' in " +((__gz(_($diese, "#endZeit"))- __gz(_($diese, "#startZeit")))/ 1000000)+ "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen mal(final Object $zweiteZahl){
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        if(__eon(_($diese, "#schnell"))){
            try{
                Process prozess = Runtime.getRuntime().exec("./hochgeschwindigkeitsrechnungen multiplizieren " + _($diese, "#zahlBisJetzt")+ " " + _($diese, "#zweiteZahl"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(prozess.getInputStream()));
                _($diese, "#zahlBisJetzt", __z(bufferedReader.readLine()));
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt * #zweiteZahl ;"))));
        }
//        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt * #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' * \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if($_ENV("Entkäferer").equals("eingeschaltet")){
            echo("\'Mal\' in " +((__gz(_($diese, "#endZeit"))- __gz(_($diese, "#startZeit")))/ 1000000)+ "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen geteiltDurch(final Object $zweiteZahl){
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        if(__eon(_($diese, "#schnell"))){
            try{
                Process prozess = Runtime.getRuntime().exec("./hochgeschwindigkeitsrechnungen dividieren " + _($diese, "#zahlBisJetzt")+ " " + _($diese, "#zweiteZahl"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(prozess.getInputStream()));
                _($diese, "#zahlBisJetzt", __z(bufferedReader.readLine()));
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt / #zweiteZahl ;"))));
        }
//        _($diese, "#zahlBisJetzt", __z($(__($diese, "#zahlBisJetzt / #zweiteZahl ;"))));
        _($diese, "#rechnung", __t($(__($diese, "#rechnung + \' / \' + #zweiteZahl ;"))));
        _($diese, "#endZeit", System.nanoTime());
        if($_ENV("Entkäferer").equals("eingeschaltet")){
            echo("\'Geteilt\' in " +((__gz(_($diese, "#endZeit"))- __gz(_($diese, "#startZeit")))/ 1000000)+ "ms ausgeführt");
        }
        return $diese;
    }

    public Number istGleich(){
        echo(_($diese, "#rechnung")+ " = " + _($diese, "#zahlBisJetzt"));
        return __z(_($diese, "#zahlBisJetzt"));
    }

    public Rechenoperationen teWurzelVon(final Object $zweiteZahl){
        _($diese, "#startZeit", System.nanoTime());
        _($diese, "#zweiteZahl", __z($zweiteZahl));
        _($diese, "#zahlBisJetzt", __z($(__($diese, "Math.pow(#zweiteZahl , 1/(#zahlBisJetzt ));"))));
        _($diese, "#rechnung", __t($(__($diese, "#zweiteZahl + \' ^(1/(#rechnung ))\';"))));
        _($diese, "#endZeit", System.nanoTime());
        if($_ENV("Entkäferer").equals("eingeschaltet")){
            echo("\'Wurzel\' in " +((__gz(_($diese, "#endZeit"))- __gz(_($diese, "#startZeit")))/ 1000000)+ "ms ausgeführt");
        }
        return $diese;
    }

    public Rechenoperationen steWurzelVon(final Object $zweiteZahl){
        return teWurzelVon($zweiteZahl);
    }
}
