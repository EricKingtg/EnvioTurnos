/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 31/10/2018
 *
 */

package t3b.pv.cierraturno.dto;


public class CierraTurnoKardex {

    public String tclave;
    public String caja;
    public String atmfecha;
    public String icb;
    public String atmdesc;
    public float total;
    public float atmcant;
    public float iva;
    public float ieps;
    public int iclave;    
    public int status;
    public int idturno; 

    @Override
    public String toString() {
        return "CierraTurnoKardex{" + "tclave=" + tclave + ", caja=" + caja + ", atmfecha=" + atmfecha + ", icb=" + icb + ", total=" + total + ", atmcant=" + atmcant + ", iclave=" + iclave + ", status=" + status + ", idturno=" + idturno + '}';
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
     * @return the icb
     */
    public String getIcb() {
        return icb;
    }

    /**
     * @param icb the icb to set
     */
    public void setIcb(String icb) {
        this.icb = icb;
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
     * @return the atmcant
     */
    public float getAtmcant() {
        return atmcant;
    }

    /**
     * @param atmcant the atmcant to set
     */
    public void setAtmcant(float atmcant) {
        this.atmcant = atmcant;
    }

    /**
     * @return the iclave
     */
    public int getIclave() {
        return iclave;
    }

    /**
     * @param iclave the iclave to set
     */
    public void setIclave(int iclave) {
        this.iclave = iclave;
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
     * @return the iva
     */
    public float getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(float iva) {
        this.iva = iva;
    }

    /**
     * @return the ieps
     */
    public float getIeps() {
        return ieps;
    }

    /**
     * @param ieps the ieps to set
     */
    public void setIeps(float ieps) {
        this.ieps = ieps;
    }
    
}
