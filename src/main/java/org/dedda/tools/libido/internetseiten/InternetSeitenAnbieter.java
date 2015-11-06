package org.dedda.tools.libido.internetseiten;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public class InternetSeitenAnbieter implements HttpHandler{

    private static HttpServer $anbieter;
    private static File INTERNETSEITE;

    public static void starte() {
        INTERNETSEITE = new File("AUSGABE.html");
        try {
            $anbieter = HttpServer.create(new InetSocketAddress(2468), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        $anbieter.createContext("/", new InternetSeitenAnbieter());
        $anbieter.setExecutor(null);
        $anbieter.start();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (INTERNETSEITE.exists()) {
            INTERNETSEITE.delete();
        }
        InternetSeite $behandler = null;
        String $dateiName = httpExchange.getRequestURI().toString();
        if ($dateiName.endsWith("prozess.seite")) {
            $behandler = new ProzessSeite();
        }
        $behandler.baueDieSeite(httpExchange);
        String $inhalt = "";
        BufferedReader $leser = new BufferedReader(new FileReader(INTERNETSEITE));
        String $zeile;
        while (($zeile = $leser.readLine()) != null) {
            $inhalt += '\n' + $zeile;
        }
        $leser.close();
        httpExchange.getResponseHeaders().set("Content-Type", "text/html");
        httpExchange.sendResponseHeaders(200, $inhalt.length());
        httpExchange.getResponseBody().write($inhalt.getBytes());
        httpExchange.getRequestBody().close();
    }
}
