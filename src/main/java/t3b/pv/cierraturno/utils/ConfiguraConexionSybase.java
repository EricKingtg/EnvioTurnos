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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dnn.nominae.modulobdconexion.db.utils.Conexion;

@Component("configuraConexionSybase")
public class ConfiguraConexionSybase {

	private static final Log LOG = LogFactory.getLog(ConfiguraConexionSybase.class);

	@Autowired
	@Qualifier("configuracion")
	private Config configuracion;
	
	@Autowired
	@Qualifier("configIp")
	private HostSybase configIp;

	public Connection getCnnUnicaMysql() {
		LOG.info("Creando conexion a BD");
		Conexion cnn = new Conexion();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		month = month + 1;
		
		LOG.info(configuracion.toString());

		LOG.info("Mes: " + month);
		String pass = generaPassMysql(month);
		cnn.creaConexion(configuracion.getHost(), configuracion.getUser(), pass, configuracion.getPort(),
				configuracion.getName(), configuracion.getDriv(), configuracion.getSurl());
		LOG.info("IP: " + configuracion.getHost());
		Connection conn = cnn.getConexion();
		LOG.info("Opcion 1, mes normal: " + pass);
		if (conn != null) {

			return conn;
		}
		pass = generaPassMysql(month - 1);
		cnn.creaConexion(configuracion.getHost(), configuracion.getUser(), pass, configuracion.getPort(),
				configuracion.getName(), configuracion.getDriv(), configuracion.getSurl());
		conn = cnn.getConexion();
		LOG.info("Opcion 2, mes -1:  " + pass);
		if (conn != null) {
			return conn;
		}
		pass = generaPassMysql(month + 1);
		cnn.creaConexion(configuracion.getHost(), configuracion.getUser(), pass, configuracion.getPort(),
				configuracion.getName(), configuracion.getDriv(), configuracion.getSurl());
		conn = cnn.getConexion();
		LOG.info("Opcion 3, pass +1:  " + pass);
		if (conn != null) {
			return conn;
		}
		pass = configuracion.getPass();
		cnn.creaConexion(configuracion.getHost(), configuracion.getUser(), pass, configuracion.getPort(),
				configuracion.getName(), configuracion.getDriv(), configuracion.getSurl());
		conn = cnn.getConexion();
		LOG.info("Opcion 4, pass generica:  " + pass);
		if (conn != null) {
			return conn;
		}

		LOG.info("Opcion 4, no hubo conexion");
		LOG.info("No se consigio una conexion a la BD");
		System.exit(0);
		return null;
	}

	public Connection getCnnUnica(String ip, String suc) {
		
		LOG.info("Ip Obtenida del archivo" + configIp.getHostSB());
		
		if(!configIp.getHostSB().equals("##")) {
			ip = configIp.getHostSB();
		}

		LOG.info("Obteniendo Conexion a BOT: " + ip);

		Conexion con = new Conexion();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		month = month + 1;

		LOG.info("Mes: " + month);
		String passSB = generaPass(month);
		con.creaConexion(ip, configuracion.getUserSB(), passSB, configuracion.getPortSB(), "suc" + suc,
				configuracion.getDrivSB(), configuracion.getSurlSB());
		LOG.info("IP: " + ip);
		Connection conn = con.getConexion();
		LOG.info("Opcion 1, mes normal: " + passSB);
		if (conn != null) {

			return conn;
		}
		passSB = generaPass(month - 1);
		con.creaConexion(ip, configuracion.getUserSB(), passSB, configuracion.getPortSB(), "suc" + suc,
				configuracion.getDrivSB(), configuracion.getSurlSB());
		conn = con.getConexion();
		LOG.info("Opcion 2, mes -1:  " + passSB);
		if (conn != null) {
			return conn;
		}
		passSB = "5575349";
		con.creaConexion(ip, configuracion.getUserSB(), passSB, configuracion.getPortSB(), "suc" + suc,
				configuracion.getDrivSB(), configuracion.getSurlSB());
		conn = con.getConexion();
		LOG.info("Opcion 3, pass generica:  " + passSB);
		if (conn != null) {
			return conn;
		}
		
		passSB = "202003y";
		//cnn.creaConexion(configuracion.getHost(), configuracion.getUser()  , pass  , configuracion.getPort()  ,configuracion.getName(), configuracion.getDriv(), configuracion.getSurl());
		LOG.info(ip + configuracion.getUserSB() + passSB + configuracion.getPortSB() + "suc215" + configuracion.getDrivSB() + configuracion.getSurlSB());
		con.creaConexion(               ip        , configuracion.getUserSB(), passSB, configuracion.getPortSB(), "suc215",               configuracion.getDrivSB(), configuracion.getSurlSB());
		conn = con.getConexion();
		LOG.info("Opcion 4, pass generica:  " + passSB);
		if (conn != null) {
			return conn;
		}

		LOG.info("Opcion 4, no hubo conexion");
		LOG.info("No se consigio una conexion a la BD");
		System.exit(0);
		return null;
	}

	private static String generaPassMysql(int mesActual) {
		int annio = 0;
		int mes = 0;
		String regreso = "";
		String aux = "";
		Calendar cal = Calendar.getInstance();
		mes = mesActual;
		annio = cal.get(Calendar.YEAR);
		switch (mes) {
		case 1:
			aux = "zpv01";
			break;
		case 2:
			aux = "xpv02";
			break;
		case 3:
			aux = "ypv03";
			break;
		case 4:
			aux = "opv04";
			break;
		case 5:
			aux = "mpv05";
			break;
		case 6:
			aux = "lpv06";
			break;
		case 7:
			aux = "gpv07";
			break;
		case 8:
			aux = "fpv08";
			break;
		case 9:
			aux = "epv09";
			break;
		case 10:
			aux = "dpv10";
			break;
		case 11:
			aux = "bpv11";
			break;
		case 12:
			aux = "apv12";
			break;
		}
		regreso = annio + "" + (mes < 10 ? "0" + mes : mes) + aux;
		return regreso;
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
