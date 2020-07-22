/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class PagosVentasDto {

    public int atmseq;
    public String tclave;
    public int num_ticket;
    public String caja;
    public String fec;
    public int fp_clave;
    public float importe_rec;
    public float importe_cambio;
    public int estatus;
    public String referencia;
    public int idturno;

    @Override
    public String toString() {
        return "PagosVentasDto{" + "atmseq=" + atmseq + ", tclave=" + tclave + ", num_ticket=" + num_ticket + ", caja=" + caja + ", fec=" + fec + ", fp_clave=" + fp_clave + ", importe_rec=" + importe_rec + ", importe_cambio=" + importe_cambio + ", estatus=" + estatus + ", referencia=" + referencia + ", idturno=" + idturno + '}';
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
     * @return the num_ticket
     */
    public int getNum_ticket() {
        return num_ticket;
    }

    /**
     * @param num_ticket the num_ticket to set
     */
    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
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
     * @return the fec
     */
    public String getFec() {
        return fec;
    }

    /**
     * @param fec the fec to set
     */
    public void setFec(String fec) {
        this.fec = fec;
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
     * @return the importe_rec
     */
    public float getImporte_rec() {
        return importe_rec;
    }

    /**
     * @param importe_rec the importe_rec to set
     */
    public void setImporte_rec(float importe_rec) {
        this.importe_rec = importe_rec;
    }

    /**
     * @return the importe_cambio
     */
    public float getImporte_cambio() {
        return importe_cambio;
    }

    /**
     * @param importe_cambio the importe_cambio to set
     */
    public void setImporte_cambio(float importe_cambio) {
        this.importe_cambio = importe_cambio;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
