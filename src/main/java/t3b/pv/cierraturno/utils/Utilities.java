/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 19/12/2018
 *
 */
package t3b.pv.cierraturno.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utilities {

    public static String executeCommand(String command) {
        StringBuilder sb = new StringBuilder();
        String s = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
        }
        return sb.toString().trim();
    }

}
