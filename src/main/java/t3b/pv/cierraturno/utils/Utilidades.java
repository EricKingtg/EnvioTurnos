/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.cierraturno.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component("utilidades")
public class Utilidades {

	private static final Log log = LogFactory.getLog(Utilidades.class);

    public String obtieneIp(String tienda) {

        log.info("Utilidades.obtieneIp");
        
        String ip = "10.";
        int numAux = 0;

        switch (tienda.length()) {
            case 4:
                numAux = Integer.parseInt(tienda.substring(0, 2));
                ip = ip + numAux + ".";
                numAux = Integer.parseInt(tienda.substring(2));
                ip = ip + numAux + ".10";
                break;
            case 3:
                numAux = Integer.parseInt(tienda.substring(0, 1));
                ip = ip + numAux + ".";
                numAux = Integer.parseInt(tienda.substring(1));
                ip = ip + numAux + ".10";
                break;
            case 2:
                ip = ip + "0.";
                numAux = Integer.parseInt(tienda);
                ip = ip + numAux + ".10";
                break;
            case 1:
                ip = ip + "0.";
                numAux = Integer.parseInt(tienda);
                ip = ip + numAux + ".10";
                break;    
            case 5:
                //Aun no hay con 5
                break;
            default:
                //No hagas nada
                break;
        }
        
        //Comentar la siguiente linea cuando sea produccion
        //ip ="192.200.1.238";
        
        return ip;
    }

}
