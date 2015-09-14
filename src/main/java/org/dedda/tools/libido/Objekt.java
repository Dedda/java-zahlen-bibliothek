package org.dedda.tools.libido;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.dedda.tools.libido.$.__gz;
import static org.dedda.tools.libido.Rechenoperationen.Rechne;
import static org.dedda.tools.libido.Zahlen.Eins;

/**
 * Created by dedda on 9/11/15.
 *
 * @author dedda
 */
public class Objekt {

    public final UUID $uuid;
    public final long $id;

    private static Map<UUID, Map<Long, Objekt>> $objekte;
    private static Map<UUID, Long> $idZähler;

    static {
        $objekte = new HashMap<>();
        $idZähler = new HashMap<>();
    }

    public Objekt() {
        this.$uuid = randomUUID();
        if ($objekte.containsKey($uuid)) {
            long $id = $idZähler.get($uuid);
            this.$id = __gz(Rechne($id).plus(Eins()).istGleich());
            $objekte.get($uuid).put($id, this);
        } else {
            long $id = 1;
            this.$id = $id;
            $objekte.put($uuid, new HashMap<>());
            $objekte.get($uuid).put($id, this);
        }
    }

}
