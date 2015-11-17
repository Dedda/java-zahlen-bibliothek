package org.dedda.tools.libido.universum;

import java.util.ArrayList;

import static org.dedda.tools.libido.$._;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public final class DasVirtuelleUniversum{

    private DasVirtuelleUniversum $dieses = this;

    protected DasVirtuelleUniversum(ArrayList<DasVirtuelleObjekt> $objekte){
        _($dieses, "#objekte", $objekte);
    }

    public ArrayList<DasVirtuelleObjekt> bekommeDieVirtuellenObjekte(){
        return (ArrayList<DasVirtuelleObjekt>)_($dieses, "#objekte");
    }

}
