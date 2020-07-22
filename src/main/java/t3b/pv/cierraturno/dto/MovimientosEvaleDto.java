/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class MovimientosEvaleDto {

    public int atmseq;
    public String tclave;
    public int num_ticket;
    public int iclave;
    public String icb;
    public String caja;
    public int pclave;
    public String fechax;
    public String atmdesc;
    public float atmcant;
    public float atmcosto;
    public float atmventa;
    public int userid;
    public int iv_clave;
    public int ie_clave;
    public String gclave;
    public String lclave;
    public String fechay;
    public float porcentaje;
    public int idturno;

    @Override
    public String toString() {
        return "MovimientosEvaleDto{" + "atmseq=" + atmseq + ", tclave=" + tclave + ", num_ticket=" + num_ticket + ", iclave=" + iclave + ", icb=" + icb + ", caja=" + caja + ", pclave=" + pclave + ", fechax=" + fechax + ", atmdesc=" + atmdesc + ", atmcant=" + atmcant + ", atmcosto=" + atmcosto + ", atmventa=" + atmventa + ", userid=" + userid + ", iv_clave=" + iv_clave + ", ie_clave=" + ie_clave + ", gclave=" + gclave + ", lclave=" + lclave + ", fechay=" + fechay + ", porcentaje=" + porcentaje + ", idturno=" + idturno + '}';
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
     * @return the pclave
     */
    public int getPclave() {
        return pclave;
    }

    /**
     * @param pclave the pclave to set
     */
    public void setPclave(int pclave) {
        this.pclave = pclave;
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
     * @return the atmcosto
     */
    public float getAtmcosto() {
        return atmcosto;
    }

    /**
     * @param atmcosto the atmcosto to set
     */
    public void setAtmcosto(float atmcosto) {
        this.atmcosto = atmcosto;
    }

    /**
     * @return the atmventa
     */
    public float getAtmventa() {
        return atmventa;
    }

    /**
     * @param atmventa the atmventa to set
     */
    public void setAtmventa(float atmventa) {
        this.atmventa = atmventa;
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
     * @return the iv_clave
     */
    public int getIv_clave() {
        return iv_clave;
    }

    /**
     * @param iv_clave the iv_clave to set
     */
    public void setIv_clave(int iv_clave) {
        this.iv_clave = iv_clave;
    }

    /**
     * @return the ie_clave
     */
    public int getIe_clave() {
        return ie_clave;
    }

    /**
     * @param ie_clave the ie_clave to set
     */
    public void setIe_clave(int ie_clave) {
        this.ie_clave = ie_clave;
    }

    /**
     * @return the gclave
     */
    public String getGclave() {
        return gclave;
    }

    /**
     * @param gclave the gclave to set
     */
    public void setGclave(String gclave) {
        this.gclave = gclave;
    }

    /**
     * @return the lclave
     */
    public String getLclave() {
        return lclave;
    }

    /**
     * @param lclave the lclave to set
     */
    public void setLclave(String lclave) {
        this.lclave = lclave;
    }

    /**
     * @return the fechay
     */
    public String getFechay() {
        return fechay;
    }

    /**
     * @param fechay the fechay to set
     */
    public void setFechay(String fechay) {
        this.fechay = fechay;
    }

    /**
     * @return the porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
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
