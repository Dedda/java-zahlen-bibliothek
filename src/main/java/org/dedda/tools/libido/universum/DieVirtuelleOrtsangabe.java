package org.dedda.tools.libido.universum;

import java.util.ArrayList;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__eon;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public class DieVirtuelleOrtsangabe{

    private DieVirtuelleOrtsangabe $diese = this;

    public DieVirtuelleOrtsangabe(DasVirtuelleObjekt $giltFür){
        _($diese, "#giltFür", $giltFür);
        _($diese, "#istZentriert", false);
        _($diese, "#über", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#unter", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#linksVon", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#rechtsVon", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#vor", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#hinter", new ArrayList<DasVirtuelleObjekt>());
    }

    public boolean imZentrum(){
        return __eon(_($diese, "#istZentriert"));
    }

    public void imZentrum(final boolean $istImZentrum){
        _($diese, "#istZentriert", $istImZentrum);
    }

    public boolean istÜber(final DasVirtuelleObjekt $objekt){
        return __bekommeDieVirtuellenObjekte("#über").contains($objekt);
    }

    public void istÜber(final DasVirtuelleObjekt $objekt, final boolean $istDarüber){
        if($istDarüber){
            if(!$diese.istÜber($objekt)){
                _($diese, "#über", $diese.__fügeEinElementHinzu($diese.__bekommeDieVirtuellenObjekte("#über"), $objekt));
            }
        }else{
            if(!$diese.istÜber($objekt)){
                _($diese, "#über", $diese.__entferneEinElement($diese.__bekommeDieVirtuellenObjekte("#über"), $objekt));
            }
        }
    }

    private ArrayList<DasVirtuelleObjekt> __fügeEinElementHinzu(ArrayList<DasVirtuelleObjekt> $liste, DasVirtuelleObjekt $element){
        $liste.add($element);
        return $liste;
    }

    private ArrayList<DasVirtuelleObjekt> __entferneEinElement(ArrayList<DasVirtuelleObjekt> $liste, DasVirtuelleObjekt $element){
        $liste.remove($element);
        return $liste;
    }

    private ArrayList<DasVirtuelleObjekt> __bekommeDieVirtuellenObjekte(final String $angabe){
        return(ArrayList<DasVirtuelleObjekt>)_($diese, $angabe);
    }

}
