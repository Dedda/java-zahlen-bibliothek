package org.dedda.tools.libido.internetseiten;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static org.dedda.tools.libido.$._;
import static org.dedda.tools.libido.$.__gz;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public class ProzessSeite implements InternetSeite {

    static {
        _(ProzessSeite.class, "#PYTHON_DATEINAME", "male-die-prozess-seite.py");
        _(ProzessSeite.class, "#DATEN_DATEINAME", "DATEN.json");
    }

    @Override
    public void baueDieSeite(HttpExchange $austausch) {
        _(this, "baueDieSeite#DATENKARTE", new HashMap<String, String>());
        _(this, "baueDieSeite#belegterspeicher", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        ((HashMap<String, String>) _(this, "baueDieSeite#DATENKARTE")).put("speicherbelegt", __gz(_(this, "baueDieSeite#belegterspeicher")) + " Byte");
        _(this, "baueDieSeite#INHALT", new Gson().toJson(_(this, "baueDieSeite#DATENKARTE")));
        try {
            if (!new File((String) _(ProzessSeite.class, "#DATEN_DATEINAME")).exists()) {
                new File((String) _(ProzessSeite.class, "#DATEN_DATEINAME")).createNewFile();
            }
            BufferedWriter $schreiber = new BufferedWriter(new FileWriter(new File((String) _(ProzessSeite.class, "#DATEN_DATEINAME"))));
            $schreiber.write((String) _(this, "baueDieSeite#INHALT"));
            $schreiber.flush();
            $schreiber.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("python " + _(ProzessSeite.class, "#PYTHON_DATEINAME")).waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
