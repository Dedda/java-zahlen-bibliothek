package org.dedda.tools.libido;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import static org.dedda.tools.libido.Hilfsmittel.echo;

/**
 * Created by dedda on 9/4/15.
 *
 * @author dedda
 */
public class QuellTextÜbersetzer {

    public static final Map<String, String> $wörterbuch;

    static {
        $wörterbuch = new HashMap<>();
        $wörterbuch.put("importiere", "import");
        $wörterbuch.put("Importiere", "import");
        $wörterbuch.put("Paket", "package");
        $wörterbuch.put("öffentlich", "public");
        $wörterbuch.put("Öffentlich", "public");
        $wörterbuch.put("statisch", "static");
        $wörterbuch.put("Statisch", "static");
        $wörterbuch.put("endgültig", "final");
        $wörterbuch.put("Endgültig", "final");
        $wörterbuch.put("abstrakt", "abstract");
        $wörterbuch.put("Abstrakt", "abstract");
        $wörterbuch.put("Klasse", "class");
        $wörterbuch.put("Schnittstelle", "interface");
        $wörterbuch.put("Aufzählung", "enum");
        $wörterbuch.put("wahr", "true");
        $wörterbuch.put("Wahr", "true");
        $wörterbuch.put("falsch", "false");
        $wörterbuch.put("Falsch", "false");
        $wörterbuch.put("für", "for");
        $wörterbuch.put("Für", "for");
        $wörterbuch.put("neu", "new");
        $wörterbuch.put("Neu", "new");
        $wörterbuch.put("fortfahren", "continue");
        $wörterbuch.put("Fortfahren", "continue");
        $wörterbuch.put("solange", "while");
        $wörterbuch.put("Solange", "while");
        $wörterbuch.put("falls", "if");
        $wörterbuch.put("Falls", "if");
        $wörterbuch.put("wenn", "if");
        $wörterbuch.put("Wenn", "if");
        $wörterbuch.put("ansonsten", "else");
        $wörterbuch.put("Ansonsten", "else");
        $wörterbuch.put("sonst", "else");
        $wörterbuch.put("Sonst", "else");
        $wörterbuch.put("zurückgeben", "return");
        $wörterbuch.put("Zurückgeben", "return");
        $wörterbuch.put("flüchtig", "volatile");
        $wörterbuch.put("Flüchtig", "volatile");;
        $wörterbuch.put("dies", "this");
        $wörterbuch.put("Dies", "this");
        $wörterbuch.put("über", "super");
        $wörterbuch.put("Über", "super");
        $wörterbuch.put("ungültig", "void");
        $wörterbuch.put("Ungültig", "void");
    }

    public static void main(String[] $argumente) throws Exception {
        File[] $dateien = new File[$argumente.length];
        int i = 0;
        for (String $arg : $argumente) {
            File $datei = new File($arg);
            if (!$datei.exists()) {
                echo("Datei " + $arg + " existiert nicht!");
                System.exit(1);
            }
            $dateien[i++] = $datei;
        }
        for (File $datei : $dateien) {
            String $neueDatei = $datei.getAbsolutePath().substring(0, $datei.getAbsolutePath().lastIndexOf(".")) + ".java";
            echo("Übersetze in java-datei: " + $neueDatei);
            byte[] $dateiInhaltAlsBytes = new byte[(int) $datei.length()];
            new FileInputStream($datei).read($dateiInhaltAlsBytes);
            String $dateiInhalt = new String($dateiInhaltAlsBytes);
            String $neuerInhalt = new QuellTextÜbersetzer().übersetze($dateiInhalt);
            FileWriter $schreiber = new FileWriter($neueDatei);
            $schreiber.write($neuerInhalt);
            $schreiber.flush();
            $schreiber.close();
        }
    }

    public String übersetze(final String $deutsch) {
        String $englisch = $deutsch;
        for (String $wort : $wörterbuch.keySet()) {
            $englisch = übersetzeWort($englisch, $wort, $wörterbuch.get($wort));
        }
        return $englisch;
    }

    public String übersetzeWort(final String $deutsch, final String $wort, final String $übersetzt) {
        String $englisch = $deutsch;
        int $position = $englisch.indexOf($wort);
        while($position >= 0) {
            if (mussErsetztWerden($englisch, $position)) {
                $englisch = $englisch.substring(0, $position) + $übersetzt + $englisch.substring($position + $wort.length());
            }
            $position = $englisch.indexOf($wort, $position+1);
        }
        return $englisch;
    }

    public boolean mussErsetztWerden(final String $heuhaufen, final int $position) {
        boolean $inEinemBlockKommentar = false;
        boolean $inEinemZeilenKommentar = false;
        boolean $inEinemString = false;
        boolean $inEinemCharakter = false;
        int $zeilenNummer = 0;
        String[] $zeilen = $heuhaufen.split("\n");
        for (int i = 0; i < $position; i++) {
            if ($heuhaufen.charAt(i) == '\n') {
                $zeilenNummer++;
                $inEinemZeilenKommentar = false;
                continue;
            }
            if ($zeilen[$zeilenNummer].trim().startsWith("//")) {
                $inEinemZeilenKommentar = true;
                continue;
            }
            if (!$inEinemString) {
                if ($heuhaufen.charAt(i) == '/' && $heuhaufen.charAt(i+1) == '*') {
                    $inEinemBlockKommentar = true;
                } else if ($heuhaufen.charAt(i) == '*' && $heuhaufen.charAt(i+1) == '/') {
                    $inEinemBlockKommentar = false;
                }
            }
            if (!$inEinemString && !$inEinemBlockKommentar && !$inEinemZeilenKommentar) {
                if (!$inEinemCharakter) {
                    if ($heuhaufen.charAt(i) != '\\' && $heuhaufen.charAt(i+1) == '\'') {
                        $inEinemCharakter = !$inEinemCharakter;
                    }
                } else {
                    if ($heuhaufen.charAt(i-1) != '\\' && $heuhaufen.charAt(i) == '\'') {
                        $inEinemCharakter = !$inEinemCharakter;
                    }
                }
            }
            if (!$inEinemCharakter && !$inEinemBlockKommentar && !$inEinemZeilenKommentar) {
                if (!$inEinemString) {
                    if ($heuhaufen.charAt(i) != '\\' && $heuhaufen.charAt(i+1) == '"') {
                        $inEinemString = !$inEinemString;
                    }
                } else {
                    if ($heuhaufen.charAt(i) != '\\' && $heuhaufen.charAt(i+1) == '"') {
                        $inEinemString = !$inEinemString;
                    }
                }
            }
        }
        return !$inEinemString && !$inEinemBlockKommentar && !$inEinemZeilenKommentar && !$inEinemCharakter;
    }
}
