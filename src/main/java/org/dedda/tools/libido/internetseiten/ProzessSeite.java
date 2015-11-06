package org.dedda.tools.libido.internetseiten;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public class ProzessSeite implements InternetSeite {

    private String PYTHON_DATEINAME = "male-die-prozess-seite.py";
    private final String DATEN_DATEINAME = "DATEN.json";

    @Override
    public void baueDieSeite(HttpExchange $austausch) {
        Map<String, String> DATENKARTE = new HashMap<>();
        DATENKARTE.put("speicherbelegt", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " Byte");
        String INHALT = new Gson().toJson(DATENKARTE);
        try {
            if (!new File(DATEN_DATEINAME).exists()) {
                new File(DATEN_DATEINAME).createNewFile();
            }
            BufferedWriter $schreiber = new BufferedWriter(new FileWriter(new File(DATEN_DATEINAME)));
            $schreiber.write(INHALT);
            $schreiber.flush();
            $schreiber.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("python " + PYTHON_DATEINAME).waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
