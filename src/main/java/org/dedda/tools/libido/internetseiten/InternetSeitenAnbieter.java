package org.dedda.tools.libido.internetseiten;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;

import static org.dedda.tools.libido.$._;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public class InternetSeitenAnbieter implements HttpHandler {

//    private static HttpServer $anbieter;
//    private static File INTERNETSEITE;

    static {
        _(InternetSeitenAnbieter.class, "#INTERNETSEITE", new File("AUSGABE.html"));
    }

    public static void starte() {
//        INTERNETSEITE = new File("AUSGABE.html");
        try {
//            $anbieter = HttpServer.create(new InetSocketAddress(2468), 0);
            _(InternetSeitenAnbieter.class, "#anbieter", HttpServer.create(new InetSocketAddress(2468), 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((HttpServer) _(InternetSeitenAnbieter.class, "#anbieter")).createContext("/", new InternetSeitenAnbieter());
        ((HttpServer) _(InternetSeitenAnbieter.class, "#anbieter")).setExecutor(null);
        ((HttpServer) _(InternetSeitenAnbieter.class, "#anbieter")).start();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE")).exists()) {
            ((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE")).delete();
        }
        InternetSeite $behandler = null;
        String $dateiName = httpExchange.getRequestURI().toString();
        if ($dateiName.endsWith("stoppe.das.programm")) {
            System.exit(0);
        }
        if ($dateiName.endsWith("stoppe.die.internetseite")) {
            ((HttpServer) _(InternetSeitenAnbieter.class, "#anbieter")).stop(0);
        }
        if ($dateiName.endsWith("prozess.seite")) {
            $behandler = new ProzessSeite();
        }
        $behandler.baueDieSeite(httpExchange);
        String $inhalt = "";
        BufferedReader $leser = new BufferedReader(new FileReader(((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE"))));
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
