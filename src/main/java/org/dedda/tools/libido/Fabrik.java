package org.dedda.tools.libido;

/**
 * Created by dedda on 9/10/15.
 *
 * @author dedda
 */
public interface Fabrik<T> {

    T fabriziere(Object... erzeugerParameter);

}
