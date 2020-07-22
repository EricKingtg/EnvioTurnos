/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class TrnTxDetDto {

    public String tclave;
    public String caja;
    public int idturno;
    public String fecha;
    public int ttrans_clave;
    public String ttrans_desc;
    public float timporte;
    public int ttrans;

    @Override
    public String toString() {
        return "TrnTxDetDto{" + "tclave=" + tclave + ", caja=" + caja + ", idturno=" + idturno + ", fecha=" + fecha + ", ttrans_clave=" + ttrans_clave + ", ttrans_desc=" + ttrans_desc + ", timporte=" + timporte + ", ttrans=" + ttrans + '}';
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

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the ttrans_clave
     */
    public int getTtrans_clave() {
        return ttrans_clave;
    }

    /**
     * @param ttrans_clave the ttrans_clave to set
     */
    public void setTtrans_clave(int ttrans_clave) {
        this.ttrans_clave = ttrans_clave;
    }

    /**
     * @return the ttrans_desc
     */
    public String getTtrans_desc() {
        return ttrans_desc;
    }

    /**
     * @param ttrans_desc the ttrans_desc to set
     */
    public void setTtrans_desc(String ttrans_desc) {
        this.ttrans_desc = ttrans_desc;
    }

    /**
     * @return the timporte
     */
    public float getTimporte() {
        return timporte;
    }

    /**
     * @param timporte the timporte to set
     */
    public void setTimporte(float timporte) {
        this.timporte = timporte;
    }

    /**
     * @return the ttrans
     */
    public int getTtrans() {
        return ttrans;
    }

    /**
     * @param ttrans the ttrans to set
     */
    public void setTtrans(int ttrans) {
        this.ttrans = ttrans;
    }

}
