package org.dedda.tools.libido;

import static org.dedda.tools.libido.$.$NIL;

/**
 * Created by dedda on 9/10/15.
 *
 * @author dedda
 */
public abstract class FabrikErzeuger{

    public static FabrikErzeuger gibMirEinenFabrikErzeuger(){
        return new FabrikErzeuger(){
            @Override
            public <$Typ> Fabrik<$Typ> erzeugeEineFabrikFürDieseKlasse(final Class<$Typ> $klasse){
                {
                    switch($klasse.getName()){
                        case "java.lang.String":{
                            return $erzeugerParameter ->{
                                String $text = "";
                                for(Object $aktuellesObjekt : $erzeugerParameter){
                                    $text += $aktuellesObjekt;
                                }
                                return($Typ)$text;
                            };}
                        case "org.dedda.tools.libido.FabrikErzeuger":{
                            return $erzeugerParameter ->($Typ)FabrikErzeuger.gibMirEinenFabrikErzeuger();
                        }
                    }
                    return(Fabrik<$Typ>)$NIL;
                }
            }
        };
    }

    private FabrikErzeuger(){}

    public abstract <$Typ> Fabrik<$Typ> erzeugeEineFabrikFürDieseKlasse(Class<$Typ> $klasse);

}
