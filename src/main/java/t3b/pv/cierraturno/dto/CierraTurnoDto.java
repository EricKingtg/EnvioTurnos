/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 31/10/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class CierraTurnoDto {

    public String tclave;
    public String caja;
    public String atmfecha;
    public int fp_clave;
    public float total;
    public int status;
    public int idturno;

    @Override
    public String toString() {
        return "CierraTurnoDto{" + "tclave=" + tclave + ", caja=" + caja + ", atmfecha=" + atmfecha + ", fp_clave=" + fp_clave + ", total=" + total + ", status=" + status + ", idturno=" + idturno + '}';
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
     * @return the fp_clave
     */
    public int getFp_clave() {
        return fp_clave;
    }

    /**
     * @param fp_clave the fp_clave to set
     */
    public void setFp_clave(int fp_clave) {
        this.fp_clave = fp_clave;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
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
