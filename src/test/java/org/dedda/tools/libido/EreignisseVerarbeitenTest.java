package org.dedda.tools.libido;

import org.junit.Ignore;
import org.junit.Test;

import static org.dedda.tools.libido.EreignisseVerarbeiten.loggen;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/18/15.
 *
 * @author dedda
 */
public class EreignisseVerarbeitenTest {

//    @Ignore("Kann nicht funktionieren, wenn kein erlang auf dem Rechner installiert ist. Der Build würde also fehlschlagen und das will ich nicht.")
    @Test
    public void testLoggen() throws Exception {
        try{
            assertTrue(loggen(15, "Nachricht!"));
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}