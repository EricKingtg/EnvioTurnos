/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class TiendaDto {

    public String tclave;
    public String tnombre;
    public String tdir;

    @Override
    public String toString() {
        return "TiendaDto{" + "tclave=" + tclave + ", tnombre=" + tnombre + ", tdir=" + tdir + '}';
    }

    /**
     * @return the tclave
     */
    public String getTclave() {
        return tclave;
    }

    /**
     * @param tclave the tclave to set
     */
    public void setTclave(String tclave) {
        this.tclave = tclave;
    }

    /**
     * @return the tnombre
     */
    public String getTnombre() {
        return tnombre;
    }

    /**
     * @param tnombre the tnombre to set
     */
    public void setTnombre(String tnombre) {
        this.tnombre = tnombre;
    }

    /**
     * @return the tdir
     */
    public String getTdir() {
        return tdir;
    }

    /**
     * @param tdir the tdir to set
     */
    public void setTdir(String tdir) {
        this.tdir = tdir;
    }

}
