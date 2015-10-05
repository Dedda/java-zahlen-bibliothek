package org.dedda.tools.libido.universum;

import java.util.ArrayList;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__eon;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public final class DieVirtuelleUniversumsFabrik {

    private DieVirtuelleUniversumsFabrik $diese = this;

    private DieVirtuelleUniversumsFabrik() {
        _($diese, "#objekte", new ArrayList<DasVirtuelleObjekt>());
        _($diese, "#kannMit", true);
    }

    public static DieVirtuelleUniversumsFabrik ErstelleEinUniversum() {
        return new DieVirtuelleUniversumsFabrik();
    }

    public DieVirtuelleUniversumsFabrik mit(final DasVirtuelleObjekt $objekt) {
        if (__eon(_($diese, "#kannMit"))) {
            ArrayList<DasVirtuelleObjekt> $objekte = (ArrayList<DasVirtuelleObjekt>) _($diese, "#objekte");
            $objekte.add($objekt);
            _($diese, "#objekte", $objekte);
            _($diese, "#kannMit", false);
        } else {
            throw new RuntimeException("Nicht bereit für eine \"Mit\"-Verknüpfung");
        }
        return $diese;
    }

    public DieVirtuelleUniversumsFabrik und() {
        _($diese, "#kannMit", true);
        return $diese;
    }

    public DieVirtuelleUniversumsFabrik und(final DasVirtuelleObjekt $objekt) {
        ArrayList<DasVirtuelleObjekt> $objekte = (ArrayList<DasVirtuelleObjekt>) _($diese, "#objekte");
        $objekte.add($objekt);
        _($diese, "#objekte", $objekte);
        return $diese.und();
    }

    public DasVirtuelleUniversum bitte() {
        return new DasVirtuelleUniversum((ArrayList<DasVirtuelleObjekt>) _($diese, "#objekte"));
    }

}