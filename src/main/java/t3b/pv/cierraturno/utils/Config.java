/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.cierraturno.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Config {

    private final static Logger log = Logger.getLogger(Config.class);

    public static String rutaBase = System.getProperty("user.dir") + File.separator;
    public static String rutaConf = rutaBase + "config" + File.separator;
    public static String archivoprops = "CierraTurno.properties";

    public static String host = "";
    public static String port = "";
    public static String user = "";
    public static String pass = "";
    public static String name = "";
    public static String jdni = "";
    public static String surl = "";
    public static String driv = "";
    public static boolean estaCargadaMysql = false;

    public static String hostSB = "";
    public static String portSB = "";
    public static String userSB = "";
    public static String passSB = "";
    public static String nameSB = "";
    public static String jdniSB = "";
    public static String surlSB = "";
    public static String drivSB = "";
    public static boolean estaCargadaSB = false;

    public static void cargaConfigMysql() {
        estaCargadaMysql = false;
        try {

            log.info("Ruta Base: " + rutaConf + archivoprops);
            File arch = new File(rutaConf + archivoprops);
            if (arch.exists()) {
                Properties props = new Properties();
                props.load(new FileInputStream(rutaConf + archivoprops));

                host = props.getProperty("host");
                port = props.getProperty("port");
//                user = props.getProperty("user");
//                pass = props.getProperty("pass");
                user = "usuariopos";
                pass = "usuariopos1234";
                name = props.getProperty("name");
                jdni = props.getProperty("jdni");
                surl = props.getProperty("surl");
                driv = props.getProperty("driv");

                estaCargadaMysql = true;
            }

        } catch (IOException ex) {
            log.info("Excepcion al cargar la configuracion: " + ex.toString());
            estaCargadaMysql = false;
        }
    }

    public static void cargaConfigSybase(String host, String suc) {
        estaCargadaSB = false;
        try {

            log.info("Ruta Base: " + rutaConf + archivoprops);
            File arch = new File(rutaConf + archivoprops);
            if (arch.exists()) {
                Properties props = new Properties();
                props.load(new FileInputStream(rutaConf + archivoprops));

                hostSB = props.getProperty("hostSB");
                if (hostSB.equals("##")) {
                    hostSB = host;
                }
                portSB = props.getProperty("portSB");
                userSB = props.getProperty("userSB");

                nameSB = "suc" + suc;
                surlSB = props.getProperty("surlSB");
                drivSB = props.getProperty("drivSB");
                estaCargadaSB = true;
            }
        } catch (IOException ex) {
            log.info("Excepcion al cargar la configuracion: " + ex.toString());
            estaCargadaSB = false;
        }
    }
}
