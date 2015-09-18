package org.dedda.tools.libido;

import com.ericsson.otp.erlang.*;

import java.io.IOException;

/**
 * Created by dedda on 9/18/15.
 *
 * @author dedda
 */
public class EreignisseVerarbeiten {

    public static boolean loggen(final int $dringlichkeit, final String $nachricht) throws IOException, OtpAuthException, OtpErlangExit, OtpErlangDecodeException {
        OtpSelf $kunde = new OtpSelf("client", "keks");
        OtpPeer $bediener = new OtpPeer("server@sgoeppentin-desktop");
        OtpConnection $verbindung = $kunde.connect($bediener);
        $verbindung.sendRPC("logger", "logger", new OtpErlangObject[] {
                new OtpErlangInt($dringlichkeit),
                new OtpErlangString($nachricht)
        });
        OtpErlangObject $antwort = $verbindung.receiveMsg().getMsg();
        return $antwort.toString().contains("ok");
    }

}
