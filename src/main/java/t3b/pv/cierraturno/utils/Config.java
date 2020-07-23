/**
 *

 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.cierraturno.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component("configuracion")
@ConfigurationProperties(ignoreInvalidFields = false, prefix = "prop.bd.t3b")
public class Config {

	private String host;
    private String port;
    private String pass;
    private String user;
    private String name;
    private String jdni;
    private String surl;
    private String driv;

    private String portSB;
    private String userSB;
    private String surlSB;
    private String drivSB;
    
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJdni() {
		return jdni;
	}
	public void setJdni(String jdni) {
		this.jdni = jdni;
	}
	public String getSurl() {
		return surl;
	}
	public void setSurl(String surl) {
		this.surl = surl;
	}
	public String getDriv() {
		return driv;
	}
	public void setDriv(String driv) {
		this.driv = driv;
	}
	public String getPortSB() {
		return portSB;
	}
	public void setPortSB(String portSB) {
		this.portSB = portSB;
	}
	public String getUserSB() {
		return userSB;
	}
	public void setUserSB(String userSB) {
		this.userSB = userSB;
	}
	public String getSurlSB() {
		return surlSB;
	}
	public void setSurlSB(String surlSB) {
		this.surlSB = surlSB;
	}
	public String getDrivSB() {
		return drivSB;
	}
	public void setDrivSB(String drivSB) {
		this.drivSB = drivSB;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
