package org.dedda.tools.libido;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.dedda.tools.libido.$.$;
import static org.dedda.tools.libido.$.__z;

/**
 * Created by dedda on 7/31/15.
 *
 * @author dedda
 */
public final class Zahlen {

    public static final Number Eins() {
        return __z($(____("1")));
    }
    public static final Number Ers() {
        return Eins();
    }
    public static final Number Zwei() {
        return __z($(____("2")));
    }
    public static final Number Drei() {
        return __z($(____("3")));
    }
    public static final Number Drit() {
        return Drei();
    }
    public static final Number Vier() {
        return __z($(____("4")));
    }
    public static final Number Fünf() {
        return __z($(____("5")));
    }
    public static final Number Sechs() {
        return __z($(____("6")));
    }
    public static final Number Sieben() {
        return __z($(____("7")));
    }
    public static final Number Sieb() {
        return Sieben();
    }
    public static final Number Acht() {
        return __z($(____("8")));
    }
    public static final Number Neun() {
        return __z($(____("9")));
    }
    public static final Number Zehn() {
        return __z($(____("10")));
    }
    public static final Number Elf() {
        return __z($(____("11")));
    }
    public static final Number Zwölf() {
        return __z($(____("12")));
    }
    public static final Number Dreizehn() {
        return __z($(____("13")));
    }
    public static final Number Vierzehn() {
        return __z($(____("14")));
    }
    public static final Number Fünfzehn() {
        return __z($(____("15")));
    }
    public static final Number Sechzehn() {
        return __z($(____("16")));
    }
    public static final Number Siebzehn() {
        return __z($(____("17")));
    }
    public static final Number Achtzehn() {
        return __z($(____("18")));
    }
    public static final Number Neunzehn() {
        return __z($(____("19")));
    }
    public static final Number Zwanzig() {
        return __z($(____("20")));
    }
    public static final Number Einundzwanzig() {
        return __z($(____("21")));
    }
    public static final Number Zweiungzwanzig() {
        return __z($(____("22")));
    }
    public static final Number Dreiundzwanzig() {
        return __z($(____("23")));
    }
    public static final Number Vierundzwanzig() {
        return __z($(____("24")));
    }
    public static final Number Fünfundzwanzig() {
        return __z($(____("25")));
    }
    public static final Number Sechsundzwanzig() {
        return __z($(____("26")));
    }
    public static final Number Siebenundzwanzig() {
        return __z($(____("27")));
    }
    public static final Number Achtundzwanzig() {
        return __z($(____("28")));
    }
    public static final Number Neunundzwanzig() {
        return __z($(____("29")));
    }
    public static final Number Dreißig() {
        return __z($(____("30")));
    }

    public static String ____(final String $zahlAlsText) {
        try {
            JsonReader $leser = Json.createReader(new FileInputStream(new File("zahlen.json")));
            JsonObject $wurzel = $leser.readObject();
            String $zahl = $wurzel.getString($zahlAlsText);
            return $zahl + ";";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "0;";
    }

    private Zahlen() {}

}
