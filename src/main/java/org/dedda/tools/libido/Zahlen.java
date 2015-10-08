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

    public static Number Eins() {
        return __z($(____("1")));
    }
    public static Number Ers() {
        return Eins();
    }
    public static Number Zwei() {
        return __z($(____("2")));
    }
    public static Number Drei() {
        return __z($(____("3")));
    }
    public static Number Drit() {
        return Drei();
    }
    public static Number Vier() {
        return __z($(____("4")));
    }
    public static Number Fünf() {
        return __z($(____("5")));
    }
    public static Number Sechs() {
        return __z($(____("6")));
    }
    public static Number Sieben() {
        return __z($(____("7")));
    }
    public static Number Sieb() {
        return Sieben();
    }
    public static Number Acht() {
        return __z($(____("8")));
    }
    public static Number Neun() {
        return __z($(____("9")));
    }
    public static Number Zehn() {
        return __z($(____("10")));
    }
    public static Number Elf() {
        return __z($(____("11")));
    }
    public static Number Zwölf() {
        return __z($(____("12")));
    }
    public static Number Dreizehn() {
        return __z($(____("13")));
    }
    public static Number Vierzehn() {
        return __z($(____("14")));
    }
    public static Number Fünfzehn() {
        return __z($(____("15")));
    }
    public static Number Sechzehn() {
        return __z($(____("16")));
    }
    public static Number Siebzehn() {
        return __z($(____("17")));
    }
    public static Number Achtzehn() {
        return __z($(____("18")));
    }
    public static Number Neunzehn() {
        return __z($(____("19")));
    }
    public static Number Zwanzig() {
        return __z($(____("20")));
    }
    public static Number Einundzwanzig() {
        return __z($(____("21")));
    }
    public static Number Zweiungzwanzig() {
        return __z($(____("22")));
    }
    public static Number Dreiundzwanzig() {
        return __z($(____("23")));
    }
    public static Number Vierundzwanzig() {
        return __z($(____("24")));
    }
    public static Number Fünfundzwanzig() {
        return __z($(____("25")));
    }
    public static Number Sechsundzwanzig() {
        return __z($(____("26")));
    }
    public static Number Siebenundzwanzig() {
        return __z($(____("27")));
    }
    public static Number Achtundzwanzig() {
        return __z($(____("28")));
    }
    public static Number Neunundzwanzig() {
        return __z($(____("29")));
    }
    public static Number Dreißig() {
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

    private Zahlen() {

    }

}
