package org.dedda.tools.libido.universum;

import org.dedda.tools.libido.Objekt;

import static org.dedda.tools.libido.$._;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public class DasVirtuelleObjekt extends Objekt {

    private DasVirtuelleObjekt $dieses = this;

    public DasVirtuelleObjekt(final String $name) {
        super();
        _($dieses, "#name", $name);
    }

}
