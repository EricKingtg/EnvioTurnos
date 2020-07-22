/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 2/01/2019
 *
 */
package t3b.pv.cierraturno.utils;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dnn.nominae.modulobdconexion.db.utils.Conexion;

public class ConfiguraConexionSybase {

    private final static Log log = LogFactory.getLog(ConfiguraConexionSybase.class);

    public Connection getCnnUnica(String ip, String suc) {
        
        log.info("Obteniendo Conexion a BOT: " + ip );

        Conexion con = new Conexion();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;

        log.info("Mes: " + month);
        String passSB = generaPass(month);
        if (!Config.estaCargadaSB) {
            Config.cargaConfigSybase(ip, suc);
        }
        con.creaConexion(Config.hostSB, Config.userSB, passSB, Config.portSB, Config.nameSB, Config.drivSB, Config.surlSB);
        log.info("IP: " + Config.hostSB);
        Connection conn = con.getConexion();
        log.info("Opcion 1, mes normal: " + passSB);
        if (conn != null) {

            return conn;
        }
        passSB = generaPass(month - 1);
        con.creaConexion(Config.hostSB, Config.userSB, passSB, Config.portSB, Config.nameSB, Config.drivSB, Config.surlSB);
        conn = con.getConexion();
        log.info("Opcion 2, mes -1:  " + passSB);
        if (conn != null) {
            return conn;
        }
        passSB = "5575349";
        con.creaConexion(Config.hostSB, Config.userSB, passSB, Config.portSB, Config.nameSB, Config.drivSB, Config.surlSB);
        conn = con.getConexion();
        log.info("Opcion 3, pass generica:  " + passSB);
        if (conn != null) {
            return conn;
        }

        log.info("Opcion 4, no hubo conexion");
        log.info("No se consigio una conexion a la BD");
        System.exit(0);
        return null;
    }

    private static String generaPass(int mesActual) {
        int annio = 0;
        int mes = 0;
        String regreso = "";
        String aux = "";
        Calendar cal = Calendar.getInstance();
        mes = mesActual;
        annio = cal.get(Calendar.YEAR);
        switch (mes) {
            case 1:
                aux = "z";
                break;
            case 2:
                aux = "x";
                break;
            case 3:
                aux = "y";
                break;
            case 4:
                aux = "o";
                break;
            case 5:
                aux = "m";
                break;
            case 6:
                aux = "l";
                break;
            case 7:
                aux = "g";
                break;
            case 8:
                aux = "f";
                break;
            case 9:
                aux = "e";
                break;
            case 10:
                aux = "d";
                break;
            case 11:
                aux = "b";
                break;
            case 12:
                aux = "a";
                break;
        }
        regreso = annio + "" + (mes < 10 ? "0" + mes : mes) + aux;
        return regreso;
    }

}
