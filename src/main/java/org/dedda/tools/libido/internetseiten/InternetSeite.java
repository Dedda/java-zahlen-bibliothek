package org.dedda.tools.libido.internetseiten;

import com.sun.net.httpserver.HttpExchange;

/**
 * Created by dedda on 11/6/15.
 *
 * @author dedda
 */
public interface InternetSeite{

    void baueDieSeite(HttpExchange $austausch);

}
