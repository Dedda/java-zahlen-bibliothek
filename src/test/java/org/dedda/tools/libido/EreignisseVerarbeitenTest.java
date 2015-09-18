package org.dedda.tools.libido;

import org.junit.Test;

import static org.dedda.tools.libido.EreignisseVerarbeiten.loggen;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/18/15.
 */
public class EreignisseVerarbeitenTest {

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