/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class IngresoVentasDto {

    public String tclave;
    public String fech;
    public String caja;
    public int userid;
    public String mov;
    public float venta;
    public float total_anula;
    public int idturno;

    @Override
    public String toString() {
        return "IngresoVentasDto{" + "tclave=" + tclave + ", fech=" + fech + ", caja=" + caja + ", userid=" + userid + ", mov=" + mov + ", venta=" + venta + ", total_anula=" + total_anula + ", idturno=" + idturno + '}';
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
     * @return the fech
     */
    public String getFech() {
        return fech;
    }

    /**
     * @param fech the fech to set
     */
    public void setFech(String fech) {
        this.fech = fech;
    }

    /**
     * @return the caja
     */
    public String getCaja() {
        return caja;
    }

    /**
     * @param caja the caja to set
     */
    public void setCaja(String caja) {
        this.caja = caja;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the mov
     */
    public String getMov() {
        return mov;
    }

    /**
     * @param mov the mov to set
     */
    public void setMov(String mov) {
        this.mov = mov;
    }

    /**
     * @return the venta
     */
    public float getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(float venta) {
        this.venta = venta;
    }

    /**
     * @return the total_anula
     */
    public float getTotal_anula() {
        return total_anula;
    }

    /**
     * @param total_anula the total_anula to set
     */
    public void setTotal_anula(float total_anula) {
        this.total_anula = total_anula;
    }

    /**
     * @return the idturno
     */
    public int getIdturno() {
        return idturno;
    }

    /**
     * @param idturno the idturno to set
     */
    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }
}
