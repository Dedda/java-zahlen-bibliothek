package org.dedda.tools.libido.universum;

import org.dedda.tools.libido.Objekt;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$._$;

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
        _($dieses, "#orte", new ArrayList<DieVirtuelleOrtsangabe>());
    }

    public void addOrt(final DieVirtuelleOrtsangabe $dieVirtuelleOrtsangabe) {
        ((ArrayList<DieVirtuelleOrtsangabe>) _($dieses, "#orte")).add($dieVirtuelleOrtsangabe);
    }

    public void removeOrt(final DieVirtuelleOrtsangabe $dieVirtuelleOrtsangabe) {
        ((ArrayList<DieVirtuelleOrtsangabe>) _($dieses, "#orte")).remove($dieVirtuelleOrtsangabe);
    }

}
