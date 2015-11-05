package org.dedda.tools.libido;

import com.ericsson.otp.erlang.*;

import java.io.IOException;

/**
 * Created by dedda on 9/18/15.
 *
 * @author dedda
 */
public class EreignisseVerarbeiten {

    public static boolean loggen(final int $dringlichkeit, final String $nachricht) {
        try {
            OtpSelf $kunde = new OtpSelf("client", "keks");
            OtpPeer $bediener = new OtpPeer("server@localhost");
            OtpConnection $verbindung = $kunde.connect($bediener);
            $verbindung.sendRPC("logger", "logger", new OtpErlangObject[]{
                    new OtpErlangInt($dringlichkeit),
                    new OtpErlangString($nachricht)
            });
            OtpErlangObject $antwort = $verbindung.receiveMsg().getMsg();
            $verbindung.close();
            return $antwort.toString().contains("ok");
        } catch (Exception $e) {
            $e.printStackTrace();
            return false;
        }
    }

}
