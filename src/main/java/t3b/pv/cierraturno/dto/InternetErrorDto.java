/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class InternetErrorDto {

    public int atmseq;
    public String tclave;
    public String caja;
    public String fechax;
    public int internet;
    public int idturno;

    @Override
    public String toString() {
        return "InternetErrorDto{" + "atmseq=" + atmseq + ", tclave=" + tclave + ", caja=" + caja + ", fechax=" + fechax + ", internet=" + internet + ", idturno=" + idturno + '}';
    }

    /**
     * @return the atmseq
     */
    public int getAtmseq() {
        return atmseq;
    }

    /**
     * @param atmseq the atmseq to set
     */
    public void setAtmseq(int atmseq) {
        this.atmseq = atmseq;
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
     * @return the fechax
     */
    public String getFechax() {
        return fechax;
    }

    /**
     * @param fechax the fechax to set
     */
    public void setFechax(String fechax) {
        this.fechax = fechax;
    }

    /**
     * @return the internet
     */
    public int getInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(int internet) {
        this.internet = internet;
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
