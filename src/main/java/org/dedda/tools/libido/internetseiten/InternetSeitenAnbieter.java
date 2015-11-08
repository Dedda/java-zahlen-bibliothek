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
import static org.dedda.tools.libido.$.__t;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public class InternetSeitenAnbieter implements HttpHandler {

    static {
        _(InternetSeitenAnbieter.class, "#INTERNETSEITE", new File("AUSGABE.html"));
    }

    public static void starte() {
        try {
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
        _(this, "handle#austausch", httpExchange);
        if (((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE")).exists()) {
            ((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE")).delete();
        }
        _(this, "handle#dateiName", ((HttpExchange) _(this, "handle#austausch")).getRequestURI().toString());
        if (__t(_(this, "handle#dateiName")).endsWith("stoppe.das.programm")) {
            System.exit(0);
        }
        if (__t(_(this, "handle#dateiName")).endsWith("stoppe.die.internetseite")) {
            ((HttpServer) _(InternetSeitenAnbieter.class, "#anbieter")).stop(0);
        }
        if (__t(_(this, "handle#dateiName")).endsWith("prozess.seite")) {
            _(this, "handle#behandler", new ProzessSeite());
        }
        ((InternetSeite) _(this, "handle#behandler")).baueDieSeite(httpExchange);
        _(this, "handle#inhalt", "");
        _(this, "handle#leser", new BufferedReader(new FileReader(((File) _(InternetSeitenAnbieter.class, "#INTERNETSEITE")))));
        String $zeile;
        while (($zeile = ((BufferedReader) _(this, "handle#leser")).readLine()) != null) {
            _(this, "handle#inhalt", __t(_(this, "handle#inhalt")) + '\n' + $zeile);
        }
        ((BufferedReader) _(this, "handle#leser")).close();
        ((HttpExchange) _(this, "handle#austausch")).getResponseHeaders().set("Content-Type", "text/html");
        ((HttpExchange) _(this, "handle#austausch")).sendResponseHeaders(200, __t(_(this, "handle#inhalt")).length());
        ((HttpExchange) _(this, "handle#austausch")).getResponseBody().write(__t(_(this, "handle#inhalt")).getBytes());
        ((HttpExchange) _(this, "handle#austausch")).getRequestBody().close();
    }

}
