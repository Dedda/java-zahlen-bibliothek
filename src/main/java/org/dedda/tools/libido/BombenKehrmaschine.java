package org.dedda.tools.libido;

import javax.swing.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__eon;
import static org.dedda.tools.libido.$.__gz;
import static org.dedda.tools.libido.Rechenoperationen.Rechne;

/**
 * Created by dedda on 10/5/15.
 *
 * @author dedda
 */
public final class BombenKehrmaschine extends JFrame {

    private BombenKehrmaschine $diese = this;

    public BombenKehrmaschine() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if (!(__gz(_(BombenKehrmaschine.class, "knopfGröße")) > 0)) {
            _(BombenKehrmaschine.class, "#knopfGröße", 20);
        }
        if (__gz(_(BombenKehrmaschine.class, "#höhe")) > 0) {
            _($diese, "#höhe", __gz(_(BombenKehrmaschine.class, "#höhe")));
        } else {
            _($diese, "#höhe", 10);
        }
        if (__gz(_(BombenKehrmaschine.class, "#breite")) > 0) {
            _($diese, "#breite", __gz(_(BombenKehrmaschine.class, "#breite")));
        } else {
            _($diese, "#breite", 20);
        }
        setVisible(true);
        _($diese, "#fensterHöhe", Rechne(_($diese, "#höhe")).mal(_(BombenKehrmaschine.class, "#knopfGröße")).plus(getInsets().top).plus(getInsets().bottom).istGleich());
        _($diese, "#fensterBreite", Rechne(_($diese, "#breite")).mal(_(BombenKehrmaschine.class, "#knopfGröße")).plus(getInsets().left).plus(getInsets().right).istGleich());
        setSize((int) __gz(_($diese, "#fensterBreite")), (int) __gz(_($diese, "#fensterHöhe")));
    }

    private void erstelleDasVirtuelleSpielfeld() {

    }

    private void erstelleDieKnöpfe() {

    }

    private class SpielfeldKnopf extends JButton {

        private SpielfeldKnopf $dieser = this;

        private SpielfeldKnopf(final int $x, final int $y, final DasVirtuelleSpielfeld $spielfeld) {

        }

    }

    private class DasVirtuelleSpielfeld {

        private DasVirtuelleSpielfeld $dieses = this;

        private DasVirtuelleSpielfeld(final int $höhe, final int $breite) {

        }

    }

}
