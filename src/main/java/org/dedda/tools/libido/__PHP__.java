package org.dedda.tools.libido;

import java.io.*;

import static org.dedda.tools.libido.$.*;
import static org.dedda.tools.libido.Rechenoperationen.Rechne;

/**
 * Created by dedda on 9/23/15.
 *
 * @author dedda
 */
public final class __PHP__ {

    public static void __AKTUALISIERE_DIE_SYSTEM_INFORMATIONEN__() {
        String $befehl = "php src/main/php/schreibeDieSystemInformationen.php";
        try {
            Process $prozess = Runtime.getRuntime().exec($befehl);
            $prozess.waitFor();
            BufferedReader $gepufferterLeser = new BufferedReader(new InputStreamReader($prozess.getInputStream()));
            for (int $zähler = 0; $zähler < 10; $zähler++) {
                String $zeile = $gepufferterLeser.readLine();
                switch ($zähler) {
                    case 0: _("System", "Gesamter Arbeitsspeicher", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                    case 1: _("System", "Freier Arbeitsspeicher", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                    case 2: _("System", "Verfügbarer Arbeitsspeicher", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                    case 3: _("System", "Gesamter Einhandelspeicher", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                    case 4: _("System", "Freier Einhandelspeicher", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                    case 5: _("System", "Megahertze", __kz($zeile)); break;
                    case 6: _("System", "Kerne", __gz($zeile)); break;
                    case 7: _("System", "Name der zentralen Prozsessionseinheit"); break;
                    case 8: _("System", "Flaggen"); break;
                    case 9: _("System", "Käfiggröße", Rechne(__z($zeile)).mal(1024).istGleich()); break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private __PHP__() {

    }

}
