/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 13/11/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class CancelacionesDto {

    public int idturno;
    public int userid;
    public int cantidad;
    public int status;
    public String tclave;
    public String caja;
    public String atmfecha;
    public String atmdesc;
    public float importe;
    public String fecha;

    @Override
    public String toString() {
        return "CancelacionesDto{" + "idturno=" + idturno + ", userid=" + userid + ", cantidad=" + cantidad + ", status=" + status + ", tclave=" + tclave + ", caja=" + caja + ", atmfecha=" + atmfecha + ", atmdesc=" + atmdesc + ", importe=" + importe + ", fecha=" + fecha + '}';
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
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
     * @return the atmfecha
     */
    public String getAtmfecha() {
        return atmfecha;
    }

    /**
     * @param atmfecha the atmfecha to set
     */
    public void setAtmfecha(String atmfecha) {
        this.atmfecha = atmfecha;
    }

    /**
     * @return the atmdesc
     */
    public String getAtmdesc() {
        return atmdesc;
    }

    /**
     * @param atmdesc the atmdesc to set
     */
    public void setAtmdesc(String atmdesc) {
        this.atmdesc = atmdesc;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
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

}
